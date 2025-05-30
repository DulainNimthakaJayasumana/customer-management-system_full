import React from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Header from "./components/Header";
import Home from "./pages/Home";

export default function App() {
    return (
        <Router>
            <Header />
            <main className="container">
                <Routes>
                    <Route path="/" element={<Home />} />
                    {/* add more routes here */}
                </Routes>
            </main>
        </Router>
    );
}
