// components/CustomerList.jsx
import { useEffect, useState } from 'react';
import { api } from '../api/index.js';
import CustomerTableRow from './CustomerTableRow.jsx';
import CustomerForm from './CustomerForm.jsx';

export default function CustomerList() {
    const [customers, setCustomers] = useState([]);
    const [editing, setEditing] = useState(null);

    const load = () => api.get('/customers').then(r => setCustomers(r.data));
    useEffect(load, []);

    const save = async (data) => {
        if (data.id) await api.put(`/customers/${data.id}`, data);
        else await api.post('/customers', data);
        setEditing(null);
        load();
    };

    const remove = async (id) => {
        if (confirm('Delete customer?')) {
            await api.delete(`/customers/${id}`);
            load();
        }
    };

    return (
        <>
            <div className="text-right mb-2">
                <button className="btn-primary" onClick={() => setEditing({})}>
                    ➕ New Customer
                </button>
            </div>

            <table className="w-full text-sm">
                <thead className="bg-gray-100">
                <tr>
                    <th className="p-2">ID</th><th>Name</th><th>Email</th><th>Phone</th><th></th>
                </tr>
                </thead>
                <tbody>
                {customers.map(c => (
                    <CustomerTableRow key={c.id} c={c} onEdit={setEditing} onDelete={remove}/>
                ))}
                {!customers.length && (
                    <tr><td colSpan="5" className="text-center p-4">No data</td></tr>
                )}
                </tbody>
            </table>

            {editing !== null && (
                <CustomerForm initial={editing} onClose={() => setEditing(null)} onSave={save}/>
            )}
        </>
    );
}
