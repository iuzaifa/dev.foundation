export type Column<T> = {
  header: string;
  accessor?: keyof T;
  render?: (row: T) => React.ReactNode;
};

type TableProps<T> = {
  columns: Column<T>[];
  data: T[];
  actions?: (row: T) => React.ReactNode;
};

export function Table<T>({ columns, data , actions}: TableProps<T>) {
  return (
    <>
        <div className="w-full overflow-x-auto">
        <table className="w-full min-[400px]: border-collapse hover:cursor-pointer ">
          <thead>
            <tr className="py-2text-md text-center border border-gray-900 bg-slate-300">
              {columns.map((column) => (
                <th className="border px-2 text-nowrap border-gray-900" key={column.header}>
                  {column.header}
                </th>
              ))}
              {actions && <th>Actions</th>}
            </tr>
          </thead>

          <tbody>
            {data.map((row, index) => (
              <tr
                className="py-2 text-sm text-center border border-gray-900 odd:bg-slate-100/50 even:bg-slate-100"
                key={index}
              >
                {columns.map((column) => (
                  <td className="border px-2 text-nowrap border-gray-900" key={column.header}>
                    {column.render ? column.render(row) : String(row[column.accessor!])}
                  </td>
                ))}

                {actions && <td>{actions(row)}</td>}
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </>
  );
}
