// components/CustomerTableRow.jsx
export default function CustomerTableRow({ c, onEdit, onDelete }) {
    return (
        <tr className="border-b">
            <td className="p-2">{c.id}</td>
            <td className="p-2">{c.name}</td>
            <td className="p-2">{c.email}</td>
            <td className="p-2">{c.phone}</td>
            <td className="p-2 text-right space-x-2">
                <button className="btn" onClick={() => onEdit(c)}>✏️</button>
                <button className="btn text-red-600" onClick={() => onDelete(c.id)}>🗑️</button>
            </td>
        </tr>
    );
}
