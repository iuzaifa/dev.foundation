type TableSkeletonProps = {
  columns?: number;
  rows?: number;
};

export function TableSkeleton({
  columns = 6,
  rows = 5,
}: TableSkeletonProps) {
  return (
    <div className="w-full overflow-x-auto rounded-lg border shadow">
      <table className="min-w-full">
        <thead>
          <tr>
            {Array.from({ length: columns }).map((_, index) => (
              <th key={index} className="px-4 py-3">
                <div className="h-5 w-24 animate-pulse rounded bg-slate-300" />
              </th>
            ))}
          </tr>
        </thead>

        <tbody>
          {Array.from({ length: rows }).map((_, row) => (
            <tr key={row}>
              {Array.from({ length: columns }).map((_, col) => (
                <td key={col} className="px-4 py-3">
                  <div className="h-4 w-full animate-pulse rounded bg-slate-200" />
                </td>
              ))}
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}