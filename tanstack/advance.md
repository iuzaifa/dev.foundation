# TanStack Query (React Query) — Advanced Guide

## Table of Contents
1. [useInfiniteQuery — Syntax](#1-useinfinitequery--syntax)
2. [Full Infinite Scroll Example](#2-full-infinite-scroll-example)
3. [Query Cancellation with AbortSignal](#3-query-cancellation-with-abortsignal)
4. [Prefetching Data](#4-prefetching-data)
5. [SSR / Next.js Integration (App Router)](#5-ssr--nextjs-integration-app-router)
6. [Advanced Optimistic Updates (Typed)](#6-advanced-optimistic-updates-typed)
7. [Global Error & Loading Handling](#7-global-error--loading-handling)
8. [Persisting Cache (localStorage)](#8-persisting-cache-localstorage)
9. [Suspense Mode](#9-suspense-mode)
10. [Query Cancellation on Unmount / Race Conditions](#10-query-cancellation-on-unmount--race-conditions)
11. [Structural Sharing & Performance](#11-structural-sharing--performance)
12. [Testing Queries](#12-testing-queries)
13. [Best Practices / Architecture Checklist](#13-best-practices--architecture-checklist)

---

## 1. useInfiniteQuery — Syntax

```tsx
import { useInfiniteQuery } from '@tanstack/react-query';

const {
  data,
  fetchNextPage,
  hasNextPage,
  isFetchingNextPage,
} = useInfiniteQuery({
  queryKey: ['projects'],
  queryFn: ({ pageParam }) => fetchProjects(pageParam),
  initialPageParam: 0,
  getNextPageParam: (lastPage, allPages) => lastPage.nextCursor ?? undefined,
});
```

`data.pages` is an array of pages, each page being whatever your `queryFn` returned.

---

## 2. Full Infinite Scroll Example

```tsx
import { useInfiniteQuery } from '@tanstack/react-query';

interface Page {
  items: { id: number; title: string }[];
  nextCursor: number | null;
}

async function fetchProjects(cursor: number): Promise<Page> {
  const res = await fetch(`/api/projects?cursor=${cursor}`);
  return res.json();
}

function InfiniteProjectList() {
  const {
    data,
    fetchNextPage,
    hasNextPage,
    isFetchingNextPage,
    status,
  } = useInfiniteQuery({
    queryKey: ['projects'],
    queryFn: ({ pageParam }) => fetchProjects(pageParam),
    initialPageParam: 0,
    getNextPageParam: (lastPage) => lastPage.nextCursor,
  });

  if (status === 'pending') return <p>Loading...</p>;
  if (status === 'error') return <p>Something went wrong</p>;

  return (
    <div>
      {data.pages.map((page, i) => (
        <div key={i}>
          {page.items.map((item) => (
            <p key={item.id}>{item.title}</p>
          ))}
        </div>
      ))}

      <button
        onClick={() => fetchNextPage()}
        disabled={!hasNextPage || isFetchingNextPage}
      >
        {isFetchingNextPage ? 'Loading more...' : hasNextPage ? 'Load More' : 'No more items'}
      </button>
    </div>
  );
}
```

---

## 3. Query Cancellation with AbortSignal

TanStack Query auto-provides an `AbortSignal` to your `queryFn` — wire it into `fetch`:

```tsx
const fetchTodos = async ({ signal }: { signal: AbortSignal }) => {
  const res = await fetch('/api/todos', { signal });
  return res.json();
};

useQuery({
  queryKey: ['todos'],
  queryFn: fetchTodos, // signal auto-injected
});
```

If the component unmounts or the query key changes mid-flight, the old
request is aborted automatically — prevents race conditions.

---

## 4. Prefetching Data

Useful on hover, route transitions, or before navigation:

```tsx
const queryClient = useQueryClient();

const prefetchTodo = (id: number) => {
  queryClient.prefetchQuery({
    queryKey: ['todo', id],
    queryFn: () => fetchTodo(id),
    staleTime: 1000 * 60,
  });
};

<Link onMouseEnter={() => prefetchTodo(5)} to="/todos/5">
  View Todo
</Link>
```

---

## 5. SSR / Next.js Integration (App Router)

```tsx
// app/todos/page.tsx (Server Component)
import {
  dehydrate,
  HydrationBoundary,
  QueryClient,
} from '@tanstack/react-query';
import TodoList from './TodoList';

export default async function TodosPage() {
  const queryClient = new QueryClient();

  await queryClient.prefetchQuery({
    queryKey: ['todos'],
    queryFn: fetchTodos,
  });

  return (
    <HydrationBoundary state={dehydrate(queryClient)}>
      <TodoList /> {/* client component using useQuery(['todos']) */}
    </HydrationBoundary>
  );
}
```

```tsx
// TodoList.tsx (Client Component)
'use client';
import { useQuery } from '@tanstack/react-query';

export default function TodoList() {
  const { data } = useQuery({ queryKey: ['todos'], queryFn: fetchTodos });
  // instantly hydrated with server-fetched data, no loading flash
  return <ul>{data.map((t: Todo) => <li key={t.id}>{t.title}</li>)}</ul>;
}
```

---

## 6. Advanced Optimistic Updates (Typed)

```tsx
interface Todo {
  id: number;
  title: string;
  completed: boolean;
}

interface MutationContext {
  previousTodos: Todo[] | undefined;
}

const queryClient = useQueryClient();

const mutation = useMutation<Todo, Error, Todo, MutationContext>({
  mutationFn: updateTodo,

  onMutate: async (newTodo): Promise<MutationContext> => {
    await queryClient.cancelQueries({ queryKey: ['todos'] });

    const previousTodos = queryClient.getQueryData<Todo[]>(['todos']);

    queryClient.setQueryData<Todo[]>(['todos'], (old = []) =>
      old.map((t) => (t.id === newTodo.id ? { ...t, ...newTodo } : t))
    );

    return { previousTodos };
  },

  onError: (_err, _newTodo, context) => {
    if (context?.previousTodos) {
      queryClient.setQueryData(['todos'], context.previousTodos);
    }
  },

  onSettled: () => {
    queryClient.invalidateQueries({ queryKey: ['todos'] });
  },
});
```

Fully typed: `useMutation<TData, TError, TVariables, TContext>`.

---

## 7. Global Error & Loading Handling

Instead of handling errors per-query, hook into the global `QueryCache`:

```tsx
import { QueryClient, QueryCache, MutationCache } from '@tanstack/react-query';
import toast from 'react-hot-toast';

const queryClient = new QueryClient({
  queryCache: new QueryCache({
    onError: (error, query) => {
      toast.error(`Query failed: ${(error as Error).message}`);
    },
  }),
  mutationCache: new MutationCache({
    onError: (error) => {
      toast.error(`Action failed: ${(error as Error).message}`);
    },
  }),
  defaultOptions: {
    queries: {
      retry: 2,
      staleTime: 1000 * 60,
    },
  },
});
```

---

## 8. Persisting Cache (localStorage)

Keep cache across page refreshes / offline scenarios:

```bash
npm install @tanstack/react-query-persist-client @tanstack/query-sync-storage-persister
```

```tsx
import { PersistQueryClientProvider } from '@tanstack/react-query-persist-client';
import { createSyncStoragePersister } from '@tanstack/query-sync-storage-persister';
import { QueryClient } from '@tanstack/react-query';

const queryClient = new QueryClient();

const persister = createSyncStoragePersister({
  storage: window.localStorage,
});

function App() {
  return (
    <PersistQueryClientProvider
      client={queryClient}
      persistOptions={{ persister }}
    >
      <YourApp />
    </PersistQueryClientProvider>
  );
}
```

---

## 9. Suspense Mode

Let React's `<Suspense>` handle loading states instead of `isPending` checks:

```tsx
import { useSuspenseQuery } from '@tanstack/react-query';
import { Suspense } from 'react';

function Todos() {
  const { data } = useSuspenseQuery({
    queryKey: ['todos'],
    queryFn: fetchTodos,
  }); // data is NEVER undefined here — TypeScript knows this

  return <ul>{data.map((t) => <li key={t.id}>{t.title}</li>)}</ul>;
}

function Page() {
  return (
    <Suspense fallback={<p>Loading todos...</p>}>
      <Todos />
    </Suspense>
  );
}
```

Pair with an `<ErrorBoundary>` (e.g. `react-error-boundary`) for error states.

---

## 10. Query Cancellation on Unmount / Race Conditions

TanStack Query handles this internally via query keys + AbortSignal, but for
manual fetch logic outside `queryFn`, always respect the signal:

```tsx
useQuery({
  queryKey: ['search', searchTerm],
  queryFn: async ({ signal }) => {
    const res = await fetch(`/api/search?q=${searchTerm}`, { signal });
    return res.json();
  },
  enabled: searchTerm.length > 2,
});
```

Typing fast → old requests for stale `searchTerm` values are cancelled
automatically when the key changes.

---

## 11. Structural Sharing & Performance

TanStack Query does **structural sharing** by default: if a refetch returns
data that's deeply equal to the old data, the object reference doesn't
change → no unnecessary re-renders downstream. You rarely need to think
about this, but it's why `select` (see intermediate.md) is safe to use for
performance optimization without manual memoization.

For expensive `select` transforms, memoize the selector itself:

```tsx
import { useCallback } from 'react';

const selectTitles = useCallback((data: Todo[]) => data.map((t) => t.title), []);

useQuery({ queryKey: ['todos'], queryFn: fetchTodos, select: selectTitles });
```

---

## 12. Testing Queries

```tsx
import { render, screen, waitFor } from '@testing-library/react';
import { QueryClient, QueryClientProvider } from '@tanstack/react-query';
import TodoList from './TodoList';

function renderWithClient(ui: React.ReactElement) {
  const testQueryClient = new QueryClient({
    defaultOptions: { queries: { retry: false } }, // no retries in tests
  });
  return render(
    <QueryClientProvider client={testQueryClient}>{ui}</QueryClientProvider>
  );
}

test('renders todos after fetch', async () => {
  renderWithClient(<TodoList />);
  await waitFor(() => expect(screen.getByText(/todo title/i)).toBeInTheDocument());
});
```

---

## 13. Best Practices / Architecture Checklist

- ✅ Always wrap queries/mutations in **custom hooks** (`useTodos`, `useAddTodo`)
- ✅ Keep query keys **consistent and factory-based**:
  ```tsx
  export const todoKeys = {
    all: ['todos'] as const,
    detail: (id: number) => ['todos', id] as const,
  };
  ```
- ✅ Set sensible `staleTime` per data type (e.g. user profile: 5 min, live prices: 0)
- ✅ Use `invalidateQueries` after every mutation that changes server state
- ✅ Use `select` to avoid re-renders on unrelated data changes
- ✅ Use Suspense + ErrorBoundary for cleaner component code in mature apps
- ✅ Never store server data in `useState`/Redux — let TanStack Query own it
- ✅ Use DevTools throughout development, not just when debugging

---

### Roadmap Recap (A → Z)
`beginner.md` → `intermediate.md` → `advance.md` covers the full path:
setup → useQuery → useMutation → cache invalidation → pagination →
dependent/parallel queries → infinite queries → SSR → optimistic updates →
persistence → Suspense → testing → architecture patterns.
