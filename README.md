Overview
Synchronous: The service retrieves employee data sequentially, meaning it waits for each piece of information to be retrieved before moving to the next.
Asynchronous: The service retrieves employee data concurrently using CompletableFuture, allowing for non-blocking operations and parallel data retrieval.

Features
Employee Service: Retrieves employee name, address, and phone asynchronously or synchronously.
Controller: Exposes endpoints to test both async and sync services.

Usage
Test the API with Postman or your preferred HTTP client:

Async API: GET /api/testAsync/employee
Sync API: GET /api/testSync/employee
