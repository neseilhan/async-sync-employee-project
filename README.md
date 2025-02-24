# Employee Data Service: Async vs Sync

## Overview

### Synchronous:
The service retrieves employee data sequentially, meaning it waits for each piece of information to be retrieved before moving to the next.

### Asynchronous:
The service retrieves employee data concurrently using `CompletableFuture`, allowing for non-blocking operations and parallel data retrieval.

## Features

- **Employee Service**: Retrieves employee name, address, and phone either asynchronously or synchronously.
- **Controller**: Exposes endpoints to test both async and sync services.

## Usage

You can test the API with Postman or your preferred HTTP client.

### Async API:
- **Endpoint**: `GET /api/testAsync/employee`
- **Description**: Retrieves employee data asynchronously. Each piece of data (name, address, and phone) is fetched concurrently.

### Sync API:
- **Endpoint**: `GET /api/testSync/employee`
- **Description**: Retrieves employee data synchronously, where each piece of data (name, address, and phone) is fetched one after the other.

## Example Request with Postman

1. **Async Request**:
   - URL: `http://localhost:8080/api/testAsync/employee`
   - Method: `GET`
   - Response: Employee data retrieved concurrently.

2. **Sync Request**:
   - URL: `http://localhost:8080/api/testSync/employee`
   - Method: `GET`
   - Response: Employee data retrieved sequentially.
