# TanStack Query (React Query) — Intermediate Guide

## Table of Contents
1. [useMutation — Syntax](#1-usemutation--syntax)
2. [Full Mutation Example (POST)](#2-full-mutation-example-post)
3. [Cache Invalidation](#3-cache-invalidation)
4. [Updating Cache Manually (setQueryData)](#4-updating-cache-manually-setquerydata)
5. [staleTime vs gcTime (cacheTime)](#5-staletime-vs-gctime-cachetime)
6. [Dependent (Chained) Queries](#6-dependent-chained-queries)
7. [Parallel Queries with useQueries](#7-parallel-queries-with-usequeries)
8. [Pagination](#8-pagination)
9. [Polling / refetchInterval](#9-polling--refetchinterval)
10. [Custom Hooks Pattern](#10-custom-hooks-pattern)
11. [Optimistic Updates (Intro)](#11-optimistic-updates-intro)
12. [Select — Transforming Data](#12-select--transforming-data)
13. [What to Learn Next](#13-what-to-learn-next)

---

## 1. useMutation — Syntax

```tsx
import { useMutation } from '@tanstack/react-query';

const mutation = useMutation({
  mutationFn: (payload) => someApiCall(payload),
  onSuccess: (data, variables, context) => { /* ... */ },
  onError: (error, variables, context) => { /* ... */ },
  onSettled: () => { /* runs on success OR error */ },
});

// trigger it:
mutation.mutate(payload);
// or async version:
await mutation.mutateAsync(payload);
```

`useMutation` is for **writes** (POST/PUT/PATCH/DELETE) — unlike `useQuery`,
it does NOT run automatically, only when you call `.mutate()`.

---

## 2. Full Mutation Example (POST)

```tsx
import { useMutation, useQueryClient } from '@tanstack/react-query';
import axios from 'axios';

interface NewTodo {
  title: string;
}

const createTodo = async (newTodo: NewTodo) => {
  const { data } = await axios.post('/api/todos', newTodo);
  return data;
};

function AddTodo() {
  const queryClient = useQueryClient();

  const { mutate, isPending, isError } = useMutation({
    mutationFn: createTodo,
    onSuccess: () => {
      // refetch todos list after a successful add
      queryClient.invalidateQueries({ queryKey: ['todos'] });
    },
  });

  const handleSubmit = (title: string) => {
    mutate({ title });
  };

  return (
    <button disabled={isPending} onClick={() => handleSubmit('New Task')}>
      {isPending ? 'Adding...' : 'Add Todo'}
    </button>
  );
}
```

---

## 3. Cache Invalidation

Invalidation tells TanStack Query: *"this data might be stale, refetch it
next time it's needed / active."*

```tsx
const queryClient = useQueryClient();

// invalidate one specific query
queryClient.invalidateQueries({ queryKey: ['todos'] });

// invalidate all queries starting with 'todo' (partial matching)
queryClient.invalidateQueries({ queryKey: ['todo'] });

// invalidate everything
queryClient.invalidateQueries();
```

This is the #1 pattern for keeping UI in sync after a mutation.

---

## 4. Updating Cache Manually (setQueryData)

Sometimes you don't want to refetch — you want to update the cache directly
(faster, no network call):

```tsx
const queryClient = useQueryClient();

queryClient.setQueryData(['todos'], (oldTodos: Todo[] | undefined) => {
  if (!oldTodos) return [];
  return [...oldTodos, newTodo];
});
```

---

## 5. staleTime vs gcTime (cacheTime)

This trips up almost everyone — memorize this table:

| Option      | Meaning                                                                 |
|-------------|--------------------------------------------------------------------------|
| `staleTime` | How long data is considered **fresh** (no auto refetch during this time) |
| `gcTime`    | How long **unused** data stays in cache before being garbage collected (was `cacheTime` in v4) |

```tsx
useQuery({
  queryKey: ['todos'],
  queryFn: fetchTodos,
  staleTime: 1000 * 60 * 5,  // fresh for 5 minutes
  gcTime: 1000 * 60 * 10,    // kept in memory for 10 minutes after unused
});
```

- `staleTime: 0` (default) → refetches on every mount/focus.
- `staleTime: Infinity` → data never goes stale automatically.

---

## 6. Dependent (Chained) Queries

When Query B needs the result of Query A:

```tsx
function UserPosts({ email }: { email: string }) {
  const { data: user } = useQuery({
    queryKey: ['user', email],
    queryFn: () => fetchUserByEmail(email),
  });

  const userId = user?.id;

  const { data: posts } = useQuery({
    queryKey: ['posts', userId],
    queryFn: () => fetchPostsByUser(userId),
    enabled: !!userId,   // 🔑 only runs once userId is available
  });

  return <div>{posts?.length} posts found</div>;
}
```

---

## 7. Parallel Queries with useQueries

When you need to run a **dynamic** or variable number of queries at once:

```tsx
import { useQueries } from '@tanstack/react-query';

function UsersList({ userIds }: { userIds: number[] }) {
  const results = useQueries({
    queries: userIds.map((id) => ({
      queryKey: ['user', id],
      queryFn: () => fetchUser(id),
    })),
  });

  return (
    <ul>
      {results.map((result, i) => (
        <li key={userIds[i]}>
          {result.isPending ? 'Loading...' : result.data.name}
        </li>
      ))}
    </ul>
  );
}
```

---

## 8. Pagination

```tsx
import { useQuery, keepPreviousData } from '@tanstack/react-query';
import { useState } from 'react';

function PaginatedTodos() {
  const [page, setPage] = useState(1);

  const { data, isPending, isPlaceholderData } = useQuery({
    queryKey: ['todos', page],
    queryFn: () => fetchTodosPage(page),
    placeholderData: keepPreviousData, // avoids UI flicker when page changes
  });

  return (
    <div>
      {isPending ? 'Loading...' : data.items.map((t: Todo) => <p key={t.id}>{t.title}</p>)}
      <button onClick={() => setPage((p) => Math.max(p - 1, 1))}>Prev</button>
      <button
        disabled={isPlaceholderData}
        onClick={() => setPage((p) => p + 1)}
      >
        Next
      </button>
    </div>
  );
}
```

---

## 9. Polling / refetchInterval

```tsx
useQuery({
  queryKey: ['liveScore'],
  queryFn: fetchLiveScore,
  refetchInterval: 5000,          // refetch every 5 seconds
  refetchIntervalInBackground: false, // stop when tab is not focused
});
```

---

## 10. Custom Hooks Pattern

Best practice: wrap every query/mutation in a custom hook — keeps components clean.

```tsx
// hooks/useTodos.ts
import { useQuery } from '@tanstack/react-query';

export function useTodos() {
  return useQuery({
    queryKey: ['todos'],
    queryFn: fetchTodos,
    staleTime: 1000 * 60,
  });
}

// component
function TodoList() {
  const { data, isPending } = useTodos(); // clean, reusable
  // ...
}
```

---

## 11. Optimistic Updates (Intro)

Update UI *before* the server confirms — rollback if it fails:

```tsx
const queryClient = useQueryClient();

const mutation = useMutation({
  mutationFn: updateTodo,
  onMutate: async (newTodo) => {
    await queryClient.cancelQueries({ queryKey: ['todos'] });
    const previousTodos = queryClient.getQueryData(['todos']);

    queryClient.setQueryData(['todos'], (old: Todo[]) =>
      old.map((t) => (t.id === newTodo.id ? newTodo : t))
    );

    return { previousTodos }; // saved for rollback
  },
  onError: (err, newTodo, context) => {
    queryClient.setQueryData(['todos'], context?.previousTodos); // rollback
  },
  onSettled: () => {
    queryClient.invalidateQueries({ queryKey: ['todos'] });
  },
});
```

(Full rollback pattern with detailed context typing → covered in advance.md)

---

## 12. Select — Transforming Data

Avoid re-renders and shape data without touching the cache itself:

```tsx
const { data: todoTitles } = useQuery({
  queryKey: ['todos'],
  queryFn: fetchTodos,
  select: (todos) => todos.map((t) => t.title), // only titles, re-renders only if THIS changes
});
```

---

## 13. What to Learn Next

Move to **advance.md** for:
- `useInfiniteQuery`
- Advanced optimistic updates with full TS typing
- Prefetching & SSR (Next.js)
- Query cancellation with `AbortSignal`
- Persisting cache to localStorage
- Suspense mode
- Global error/loading handling with `QueryCache` / `MutationCache`
