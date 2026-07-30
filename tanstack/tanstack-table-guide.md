# TanStack Table (React Table v8) — Complete Guide (Beginner → Advance)

> TanStack Table is **headless** — it gives you state & logic only.
> You always write your own JSX/markup and styling (Tailwind, MUI, plain CSS, etc.)

## Table of Contents

**Beginner**
1. [Installation](#1-installation)
2. [Core Concepts](#2-core-concepts)
3. [useReactTable — Basic Syntax](#3-usereacttable--basic-syntax)
4. [Defining Columns](#4-defining-columns)
5. [Full Basic Table Example](#5-full-basic-table-example)
6. [Custom Cell Rendering](#6-custom-cell-rendering)

**Intermediate**
7. [Sorting](#7-sorting)
8. [Column Filtering](#8-column-filtering)
9. [Global Search Filter](#9-global-search-filter)
10. [Pagination](#10-pagination)
11. [Column Visibility Toggle](#11-column-visibility-toggle)

**Advance**
12. [Row Selection (Checkboxes)](#12-row-selection-checkboxes)
13. [Expanding Rows / Nested Data](#13-expanding-rows--nested-data)
14. [Grouping & Aggregation](#14-grouping--aggregation)
15. [Column Reordering (Drag & Drop)](#15-column-reordering-drag--drop)
16. [Column Resizing](#16-column-resizing)
17. [Faceted Filters (Unique Values Dropdown)](#17-faceted-filters-unique-values-dropdown)
18. [Row Virtualization (Huge Datasets)](#18-row-virtualization-huge-datasets)
19. [Server-Side (Manual) Pagination & Sorting](#19-server-side-manual-pagination--sorting)
20. [Best Practices Checklist](#20-best-practices-checklist)

---

# BEGINNER

## 1. Installation

```bash
npm install @tanstack/react-table
```

TypeScript types are built-in, no extra `@types` package needed.

---

## 2. Core Concepts

| Concept | Meaning |
|---|---|
| `data` | Your array of row objects |
| `columns` | Array of `ColumnDef` describing each column |
| `table` instance | Object returned by `useReactTable`, holds all state + getters |
| Row Models | Plugins that transform rows — core, sorted, filtered, paginated, grouped, expanded |
| Headless | Table gives you data/state, you render the actual `<table>` HTML |

---

## 3. useReactTable — Basic Syntax

```tsx
import { useReactTable, getCoreRowModel } from '@tanstack/react-table';

const table = useReactTable({
  data,
  columns,
  getCoreRowModel: getCoreRowModel(), // required — base row model
});
```

`getCoreRowModel()` is mandatory in every table — it's the foundation all
other row models (sorting, filtering, pagination) build on top of.

---

## 4. Defining Columns

```tsx
import { ColumnDef } from '@tanstack/react-table';

interface Person {
  id: number;
  name: string;
  age: number;
  email: string;
}

const columns: ColumnDef<Person>[] = [
  {
    accessorKey: 'name',       // maps to person.name
    header: 'Full Name',
  },
  {
    accessorKey: 'age',
    header: 'Age',
  },
  {
    accessorFn: (row) => row.email.toLowerCase(), // computed accessor
    id: 'email',                                   // required when using accessorFn
    header: 'Email',
  },
];
```

---

## 5. Full Basic Table Example

```tsx
import {
  useReactTable,
  getCoreRowModel,
  flexRender,
  ColumnDef,
} from '@tanstack/react-table';

interface Person {
  id: number;
  name: string;
  age: number;
}

const data: Person[] = [
  { id: 1, name: 'Aman', age: 24 },
  { id: 2, name: 'Priya', age: 28 },
];

const columns: ColumnDef<Person>[] = [
  { accessorKey: 'name', header: 'Name' },
  { accessorKey: 'age', header: 'Age' },
];

function BasicTable() {
  const table = useReactTable({
    data,
    columns,
    getCoreRowModel: getCoreRowModel(),
  });

  return (
    <table>
      <thead>
        {table.getHeaderGroups().map((headerGroup) => (
          <tr key={headerGroup.id}>
            {headerGroup.headers.map((header) => (
              <th key={header.id}>
                {flexRender(header.column.columnDef.header, header.getContext())}
              </th>
            ))}
          </tr>
        ))}
      </thead>
      <tbody>
        {table.getRowModel().rows.map((row) => (
          <tr key={row.id}>
            {row.getVisibleCells().map((cell) => (
              <td key={cell.id}>
                {flexRender(cell.column.columnDef.cell, cell.getContext())}
              </td>
            ))}
          </tr>
        ))}
      </tbody>
    </table>
  );
}

export default BasicTable;
```

`flexRender` is used instead of directly calling functions — it safely
handles strings, JSX, and render functions the same way.

---

## 6. Custom Cell Rendering

```tsx
const columns: ColumnDef<Person>[] = [
  { accessorKey: 'name', header: 'Name' },
  {
    accessorKey: 'age',
    header: 'Age',
    cell: (info) => <b>{info.getValue<number>()} yrs</b>, // custom JSX per cell
  },
  {
    id: 'actions',
    header: 'Actions',
    cell: ({ row }) => (
      <button onClick={() => console.log(row.original)}>Edit</button>
    ),
  },
];
```

---

# INTERMEDIATE

## 7. Sorting

```tsx
import { useState } from 'react';
import {
  useReactTable,
  getCoreRowModel,
  getSortedRowModel,
  SortingState,
} from '@tanstack/react-table';

function SortableTable() {
  const [sorting, setSorting] = useState<SortingState>([]);

  const table = useReactTable({
    data,
    columns,
    state: { sorting },
    onSortingChange: setSorting,
    getCoreRowModel: getCoreRowModel(),
    getSortedRowModel: getSortedRowModel(),
  });

  return (
    <thead>
      {table.getHeaderGroups().map((hg) => (
        <tr key={hg.id}>
          {hg.headers.map((header) => (
            <th
              key={header.id}
              onClick={header.column.getToggleSortingHandler()}
              style={{ cursor: 'pointer' }}
            >
              {flexRender(header.column.columnDef.header, header.getContext())}
              {{ asc: ' 🔼', desc: ' 🔽' }[header.column.getIsSorted() as string] ?? ''}
            </th>
          ))}
        </tr>
      ))}
    </thead>
  );
}
```

---

## 8. Column Filtering

```tsx
import { getFilteredRowModel, ColumnFiltersState } from '@tanstack/react-table';

const [columnFilters, setColumnFilters] = useState<ColumnFiltersState>([]);

const table = useReactTable({
  data,
  columns,
  state: { columnFilters },
  onColumnFiltersChange: setColumnFilters,
  getCoreRowModel: getCoreRowModel(),
  getFilteredRowModel: getFilteredRowModel(),
});

// Filter input for a specific column:
<input
  value={(table.getColumn('name')?.getFilterValue() as string) ?? ''}
  onChange={(e) => table.getColumn('name')?.setFilterValue(e.target.value)}
  placeholder="Filter by name..."
/>
```

---

## 9. Global Search Filter

```tsx
const [globalFilter, setGlobalFilter] = useState('');

const table = useReactTable({
  data,
  columns,
  state: { globalFilter },
  onGlobalFilterChange: setGlobalFilter,
  getCoreRowModel: getCoreRowModel(),
  getFilteredRowModel: getFilteredRowModel(),
});

<input
  value={globalFilter}
  onChange={(e) => setGlobalFilter(e.target.value)}
  placeholder="Search all columns..."
/>
```

---

## 10. Pagination

```tsx
import { getPaginationRowModel } from '@tanstack/react-table';

const table = useReactTable({
  data,
  columns,
  getCoreRowModel: getCoreRowModel(),
  getPaginationRowModel: getPaginationRowModel(),
  initialState: { pagination: { pageSize: 10 } },
});

<div>
  <button onClick={() => table.previousPage()} disabled={!table.getCanPreviousPage()}>
    Prev
  </button>
  <span>
    Page {table.getState().pagination.pageIndex + 1} of {table.getPageCount()}
  </span>
  <button onClick={() => table.nextPage()} disabled={!table.getCanNextPage()}>
    Next
  </button>
</div>
```

---

## 11. Column Visibility Toggle

```tsx
import { VisibilityState } from '@tanstack/react-table';

const [columnVisibility, setColumnVisibility] = useState<VisibilityState>({});

const table = useReactTable({
  data,
  columns,
  state: { columnVisibility },
  onColumnVisibilityChange: setColumnVisibility,
  getCoreRowModel: getCoreRowModel(),
});

{table.getAllLeafColumns().map((column) => (
  <label key={column.id}>
    <input
      type="checkbox"
      checked={column.getIsVisible()}
      onChange={column.getToggleVisibilityHandler()}
    />
    {column.id}
  </label>
))}
```

---

# ADVANCE

## 12. Row Selection (Checkboxes)

```tsx
import { RowSelectionState } from '@tanstack/react-table';

const [rowSelection, setRowSelection] = useState<RowSelectionState>({});

const columns: ColumnDef<Person>[] = [
  {
    id: 'select',
    header: ({ table }) => (
      <input
        type="checkbox"
        checked={table.getIsAllRowsSelected()}
        onChange={table.getToggleAllRowsSelectedHandler()}
      />
    ),
    cell: ({ row }) => (
      <input
        type="checkbox"
        checked={row.getIsSelected()}
        onChange={row.getToggleSelectedHandler()}
      />
    ),
  },
  // ...other columns
];

const table = useReactTable({
  data,
  columns,
  state: { rowSelection },
  onRowSelectionChange: setRowSelection,
  getCoreRowModel: getCoreRowModel(),
});

// Access selected rows:
const selectedRows = table.getSelectedRowModel().rows;
```

---

## 13. Expanding Rows / Nested Data

```tsx
import { getExpandedRowModel, ExpandedState } from '@tanstack/react-table';

interface Person {
  id: number;
  name: string;
  subRows?: Person[];
}

const [expanded, setExpanded] = useState<ExpandedState>({});

const table = useReactTable({
  data,
  columns,
  state: { expanded },
  onExpandedChange: setExpanded,
  getSubRows: (row) => row.subRows,
  getCoreRowModel: getCoreRowModel(),
  getExpandedRowModel: getExpandedRowModel(),
});

// In a cell:
{row.getCanExpand() && (
  <button onClick={row.getToggleExpandedHandler()}>
    {row.getIsExpanded() ? '👇' : '👉'}
  </button>
)}
```

---

## 14. Grouping & Aggregation

```tsx
import { getGroupedRowModel, GroupingState } from '@tanstack/react-table';

const [grouping, setGrouping] = useState<GroupingState>([]);

const table = useReactTable({
  data,
  columns,
  state: { grouping },
  onGroupingChange: setGrouping,
  getCoreRowModel: getCoreRowModel(),
  getGroupedRowModel: getGroupedRowModel(),
});

// Column with aggregation:
{
  accessorKey: 'salary',
  header: 'Salary',
  aggregationFn: 'sum',
  aggregatedCell: ({ getValue }) => `Total: ${getValue()}`,
}
```

---

## 15. Column Reordering (Drag & Drop)

```tsx
import { ColumnOrderState } from '@tanstack/react-table';

const [columnOrder, setColumnOrder] = useState<ColumnOrderState>(
  columns.map((c) => c.id as string)
);

const table = useReactTable({
  data,
  columns,
  state: { columnOrder },
  onColumnOrderChange: setColumnOrder,
  getCoreRowModel: getCoreRowModel(),
});

// Combine with a DnD library (e.g. @dnd-kit/core) to update columnOrder on drop
```

---

## 16. Column Resizing

```tsx
const table = useReactTable({
  data,
  columns,
  columnResizeMode: 'onChange', // or 'onEnd'
  getCoreRowModel: getCoreRowModel(),
});

<th style={{ width: header.getSize() }}>
  {flexRender(header.column.columnDef.header, header.getContext())}
  <div
    onMouseDown={header.getResizeHandler()}
    onTouchStart={header.getResizeHandler()}
    className="resizer"
  />
</th>
```

---

## 17. Faceted Filters (Unique Values Dropdown)

```tsx
import { getFacetedRowModel, getFacetedUniqueValues } from '@tanstack/react-table';

const table = useReactTable({
  data,
  columns,
  getCoreRowModel: getCoreRowModel(),
  getFilteredRowModel: getFilteredRowModel(),
  getFacetedRowModel: getFacetedRowModel(),
  getFacetedUniqueValues: getFacetedUniqueValues(),
});

// Get unique values for a dropdown filter:
const uniqueValues = Array.from(table.getColumn('role')?.getFacetedUniqueValues().keys() ?? []);
```

---

## 18. Row Virtualization (Huge Datasets)

For thousands of rows, render only visible ones using `@tanstack/react-virtual`:

```bash
npm install @tanstack/react-virtual
```

```tsx
import { useVirtualizer } from '@tanstack/react-virtual';
import { useRef } from 'react';

function VirtualTable() {
  const parentRef = useRef<HTMLDivElement>(null);
  const rows = table.getRowModel().rows;

  const rowVirtualizer = useVirtualizer({
    count: rows.length,
    getScrollElement: () => parentRef.current,
    estimateSize: () => 35, // row height in px
  });

  return (
    <div ref={parentRef} style={{ height: '500px', overflow: 'auto' }}>
      <div style={{ height: rowVirtualizer.getTotalSize(), position: 'relative' }}>
        {rowVirtualizer.getVirtualItems().map((virtualRow) => {
          const row = rows[virtualRow.index];
          return (
            <div
              key={row.id}
              style={{
                position: 'absolute',
                top: 0,
                transform: `translateY(${virtualRow.start}px)`,
                height: `${virtualRow.size}px`,
              }}
            >
              {row.getVisibleCells().map((cell) => flexRender(cell.column.columnDef.cell, cell.getContext()))}
            </div>
          );
        })}
      </div>
    </div>
  );
}
```

---

## 19. Server-Side (Manual) Pagination & Sorting

When your API (Spring Boot backend, in your case) does the sorting/filtering/pagination:

```tsx
const [{ pageIndex, pageSize }, setPagination] = useState({ pageIndex: 0, pageSize: 10 });
const [sorting, setSorting] = useState<SortingState>([]);

// Fetch from backend using pageIndex, pageSize, sorting (e.g. via TanStack Query)
const { data } = useQuery({
  queryKey: ['people', pageIndex, pageSize, sorting],
  queryFn: () => fetchPeople({ page: pageIndex, size: pageSize, sort: sorting }),
});

const table = useReactTable({
  data: data?.items ?? [],
  columns,
  pageCount: data?.totalPages ?? -1,
  state: { pagination: { pageIndex, pageSize }, sorting },
  onPaginationChange: setPagination,
  onSortingChange: setSorting,
  manualPagination: true,   // tell TanStack Table: don't paginate client-side
  manualSorting: true,      // tell TanStack Table: don't sort client-side
  getCoreRowModel: getCoreRowModel(),
});
```

This is the pattern you'll use most in real apps — pairs perfectly with
`useQuery` from TanStack Query for server-driven tables.

---

## 20. Best Practices Checklist

- ✅ Always start with `getCoreRowModel()` — every other row model builds on it
- ✅ Define `columns` and `data` **outside the component** or memoize them
  (`useMemo`) — recreating them every render breaks table state
- ✅ Use `manualPagination` / `manualSorting` / `manualFiltering` for large,
  server-backed datasets instead of loading everything client-side
- ✅ Combine with TanStack Query: `useQuery` fetches data → `useReactTable`
  renders/sorts/paginates it
- ✅ Use `@tanstack/react-virtual` once row count crosses a few hundred
- ✅ Style is 100% your responsibility — headless means no default CSS at all
