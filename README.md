---

# E-commerce Platform API

This project implements an e-commerce platform REST API using Spring Boot 3 and JDK 17. Swagger OpenAPI is utilized for API documentation.

## Technologies Used
- Spring Boot 3
- JDK 17
- Swagger OpenAPI

## Endpoints

### 1. Create Product

- **Method:** POST
- **URL:** `/products`
- **Description:** Create a new product.
- **Request Body:**
  ```json
  {
      "name": "Sample Product",
      "description": "This is a sample product",
      "price": 50.99,
      "quantityAvailable": 100
  }
  ```
- **Response:**
  - Status Code: 201 Created
  - Body (JSON):
    ```json
    {
        "productId": 1,
        "name": "Sample Product",
        "description": "This is a sample product",
        "price": 50.99,
        "quantityAvailable": 100
    }
    ```

### 2. Get Product by ID

- **Method:** GET
- **URL:** `/products/{productId}`
- **Description:** Retrieve a product by its ID.
- **Response:**
  - Status Code: 200 OK
  - Body (JSON):
    ```json
    {
        "productId": 1,
        "name": "Sample Product",
        "description": "This is a sample product",
        "price": 50.99,
        "quantityAvailable": 100
    }
    ```
  - Status Code: 404 Not Found
  - Body:
    ```
    Product not found
    ```

### 3. Get All Products

- **Method:** GET
- **URL:** `/products`
- **Description:** Retrieve all products.
- **Response:**
  - Status Code: 200 OK
  - Body (JSON):
    ```json
    [
        {
            "productId": 1,
            "name": "Sample Product 1",
            "description": "This is sample product 1",
            "price": 50.99,
            "quantityAvailable": 100
        },
        {
            "productId": 2,
            "name": "Sample Product 2",
            "description": "This is sample product 2",
            "price": 60.99,
            "quantityAvailable": 150
        }
    ]
    ```

### 4. Update Product

- **Method:** PUT
- **URL:** `/products/{productId}`
- **Description:** Update a product by its ID.
- **Request Body:**
  ```json
  {
      "name": "Updated Product Name",
      "description": "This is an updated product description",
      "price": 59.99,
      "quantityAvailable": 90
  }
  ```
- **Response:**
  - Status Code: 200 OK
  - Body:
    ```
    Product updated successfully
    ```
  - Status Code: 404 Not Found
  - Body:
    ```
    Product not found
    ```

### 5. Delete Product

- **Method:** DELETE
- **URL:** `/products/{productId}`
- **Description:** Delete a product by its ID.
- **Response:**
  - Status Code: 200 OK
  - Body:
    ```
    Product deleted successfully
    ```
  - Status Code: 404 Not Found
  - Body:
    ```
    Product not found
    ```

### 6. Apply Discount or Tax

- **Method:** PUT
- **URL:** `/products/{productId}/apply?isDiscount=true&value=10`
- **Description:** Apply a discount or tax to a product by its ID.
- **Query Parameters:**
  - `isDiscount`: Boolean (true or false) indicating whether to apply a discount or tax.
  - `value`: Double value representing the percentage of discount or tax rate.
- **Response:**
  - Status Code: 200 OK
  - Body (JSON):
    ```json
    {
        "productId": 1,
        "name": "Sample Product",
        "description": "This is a sample product",
        "price": 45.89,
        "quantityAvailable": 100
    }
    ```
  - Status Code: 404 Not Found
  - Body:
    ```
    Product not found
    ```

## Screenshots
![Swagger OpenAPI Documentation](swagger.png)

---
