# TanStack Query (React Query) — Beginner Guide

## Table of Contents
1. [What is TanStack Query](#1-what-is-tanstack-query)
2. [Installation](#2-installation)
3. [QueryClient & QueryClientProvider](#3-queryclient--queryclientprovider)
4. [useQuery — Basic Syntax](#4-usequery--basic-syntax)
5. [Query Keys](#5-query-keys)
6. [Fetching Data — Full Example](#6-fetching-data--full-example)
7. [Loading, Error & Success States](#7-loading-error--success-states)
8. [Query Function with Axios](#8-query-function-with-axios)
9. [Passing Parameters to Queries](#9-passing-parameters-to-queries)
10. [React Query DevTools](#10-react-query-devtools)
11. [Common Options Cheat Sheet](#11-common-options-cheat-sheet)
12. [What to Learn Next](#12-what-to-learn-next)

---

## 1. What is TanStack Query

TanStack Query (formerly React Query) is a **server-state management** library.
It handles fetching, caching, syncing, and updating server data in React apps —
so you stop writing manual `useEffect + useState + loading + error` boilerplate.

Server state ≠ Client state:
- Client state → Redux, Zustand, useState (UI state, tabs, modals)
- Server state → TanStack Query (data that lives on a server, can go stale)

---

## 2. Installation

```bash
npm install @tanstack/react-query
npm install @tanstack/react-query-devtools -D
```

If using TypeScript (your stack), no extra types package needed — types are built-in.

---

## 3. QueryClient & QueryClientProvider

Every app needs ONE `QueryClient` instance, wrapped at the root using `QueryClientProvider`.

**Syntax:**
```tsx
import { QueryClient, QueryClientProvider } from '@tanstack/react-query';

const queryClient = new QueryClient();

function App() {
  return (
    <QueryClientProvider client={queryClient}>
      {/* rest of your app */}
    </QueryClientProvider>
  );
}
```

Think of `QueryClient` as the "cache brain" — it stores all query data, and
`QueryClientProvider` makes that cache available to every component via Context.

---

## 4. useQuery — Basic Syntax

```tsx
import { useQuery } from '@tanstack/react-query';

const { data, isLoading, isError, error } = useQuery({
  queryKey: ['uniqueKey'],
  queryFn: fetchFunction,
});
```

| Property     | Meaning                                              |
|--------------|-------------------------------------------------------|
| `queryKey`   | Unique identifier for this query (used for caching)   |
| `queryFn`    | Function that returns a Promise (the actual fetch)    |
| `data`       | The resolved data                                     |
| `isLoading`  | true only on the very first fetch (no cached data)    |
| `isError`    | true if queryFn threw / rejected                      |
| `error`      | the error object                                      |

---

## 5. Query Keys

Query keys are **arrays**. They uniquely identify a query in the cache.

```tsx
useQuery({ queryKey: ['todos'], queryFn: fetchTodos });          // all todos
useQuery({ queryKey: ['todo', todoId], queryFn: () => fetchTodo(todoId) }); // one todo
useQuery({ queryKey: ['todos', { status: 'done' }], queryFn: fetchDoneTodos }); // filtered
```

Rule of thumb: **think of query keys like dependency arrays in `useEffect`.**
If a value changes and should trigger a refetch, put it in the key.

---

## 6. Fetching Data — Full Example

```tsx
import { useQuery } from '@tanstack/react-query';

interface Todo {
  id: number;
  title: string;
  completed: boolean;
}

async function fetchTodos(): Promise<Todo[]> {
  const res = await fetch('https://jsonplaceholder.typicode.com/todos');
  if (!res.ok) throw new Error('Failed to fetch todos');
  return res.json();
}

function TodoList() {
  const { data, isLoading, isError, error } = useQuery({
    queryKey: ['todos'],
    queryFn: fetchTodos,
  });

  if (isLoading) return <p>Loading...</p>;
  if (isError) return <p>Error: {(error as Error).message}</p>;

  return (
    <ul>
      {data?.map((todo) => (
        <li key={todo.id}>{todo.title}</li>
      ))}
    </ul>
  );
}

export default TodoList;
```

---

## 7. Loading, Error & Success States

TanStack Query gives you multiple flags — use the right one for the right job:

```tsx
const {
  data,
  isPending,   // true when there's no data yet (v5 name; was isLoading in v4)
  isLoading,   // isPending && isFetching (first load only)
  isFetching,  // true ANY time a request is in-flight (including background refetch)
  isSuccess,
  isError,
  status,      // 'pending' | 'error' | 'success'
} = useQuery({ queryKey: ['todos'], queryFn: fetchTodos });
```

> Note: In v5, `isLoading` was renamed conceptually — `isPending` is the primary
> "no data yet" flag. `isLoading` = `isPending && isFetching`.

---

## 8. Query Function with Axios

```tsx
import axios from 'axios';
import { useQuery } from '@tanstack/react-query';

const fetchUser = async (userId: number) => {
  const { data } = await axios.get(`/api/users/${userId}`);
  return data;
};

function UserProfile({ userId }: { userId: number }) {
  const { data: user, isPending } = useQuery({
    queryKey: ['user', userId],
    queryFn: () => fetchUser(userId),
  });

  if (isPending) return <p>Loading user...</p>;

  return <h2>{user.name}</h2>;
}
```

---

## 9. Passing Parameters to Queries

```tsx
function useUser(userId: number) {
  return useQuery({
    queryKey: ['user', userId],   // userId included → cache is per-user
    queryFn: () => fetchUser(userId),
    enabled: !!userId,            // don't run query until userId exists
  });
}
```

`enabled` is a very important beginner concept — it controls whether the
query runs automatically at all.

---

## 10. React Query DevTools

```tsx
import { ReactQueryDevtools } from '@tanstack/react-query-devtools';

function App() {
  return (
    <QueryClientProvider client={queryClient}>
      <TodoList />
      <ReactQueryDevtools initialIsOpen={false} />
    </QueryClientProvider>
  );
}
```

DevTools shows every query's cache state, staleness, and refetch triggers —
extremely useful while learning.

---

## 11. Common Options Cheat Sheet

```tsx
useQuery({
  queryKey: ['todos'],
  queryFn: fetchTodos,
  enabled: true,          // run automatically or not
  retry: 3,                // retry failed requests 3 times
  staleTime: 0,            // how long data is considered "fresh" (ms)
  refetchOnWindowFocus: true, // refetch when tab regains focus
});
```

---

## 12. What to Learn Next

Move to **intermediate.md** for:
- `useMutation` (POST/PUT/DELETE)
- Cache invalidation
- `staleTime` vs `gcTime` in depth
- Dependent & parallel queries
- Pagination
