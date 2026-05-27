export default function Card({ title, value }: { title: string; value: any }) {
  return (
    <div className="p-4 bg-white shadow rounded">
      <div className="text-gray-500 text-sm">{title}</div>
      <div className="text-2xl font-bold">{value}</div>
    </div>
  );
}
