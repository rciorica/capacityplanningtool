export default function Table({ columns, rows }: { columns: string[]; rows: any[][] }) {
  return (
    <table className="w-full border">
      <thead>
        <tr>
          {columns.map(c => (
            <th key={c} className="border p-2 bg-gray-100">{c}</th>
          ))}
        </tr>
      </thead>
      <tbody>
        {rows.map((r, i) => (
          <tr key={i}>
            {r.map((cell, j) => (
              <td key={j} className="border p-2">{cell}</td>
            ))}
          </tr>
        ))}
      </tbody>
    </table>
  );
}
