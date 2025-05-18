import axios from 'axios';

export const api = axios.create({
    baseURL: '/api',          // proxied to 8080
    headers: { 'Content-Type': 'application/json' }
});
