import React from "react";
import { Link } from "react-router-dom";

export default function Header() {
    return (
        <header className="header">
            <h1>Customer Manager</h1>
            <nav className="nav-links">
                <Link to="/">Home</Link>
                {/* <Link to="/customers">Customers</Link> */}
            </nav>
        </header>
    );
}
