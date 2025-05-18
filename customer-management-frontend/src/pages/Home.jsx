import React, { useEffect, useState } from "react";
import axios from "axios";

export default function Home() {
    const [customers, setCustomers] = useState([]);

    useEffect(() => {
        axios.get("/api/customers")
            .then(res => setCustomers(res.data))
            .catch(console.error);
    }, []);

    return (
        <div>
            <h2>All Customers</h2>
            {customers.length === 0 ? (
                <p>No customers yet.</p>
            ) : (
                customers.map(c => (
                    <div key={c.id} className="card">
                        <h3>{c.firstName} {c.lastName}</h3>
                        <p>Email: {c.email}</p>
                    </div>
                ))
            )}
        </div>
    );
}
