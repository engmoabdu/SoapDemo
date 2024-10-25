# Demo SOAP Project

This is a Spring Boot 3 application that demonstrates how to perform CRUD (Create, Read, Update, Delete) operations for a `Product` using SOAP web services. The project utilizes XSD files for defining the structure of the SOAP messages.

## Project Structure

The project is organized as follows:

```
demo-soap
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── learn
│   │   │           └── soap
│   │   │               └── demo
│   │   │                   ├── config          # Configuration files
│   │   │                   ├── endpoint        # SOAP Controllers
│   │   │                   ├── entity          # Product model/entity
│   │   │                   ├── repository      # Repository interfaces
│   │   │                   └── service         # Service layer
│   │   │                   └── utils           # utils layer
│   │   └── resources
│   │       ├── application.properties          # Application configuration
│   │       └── xsd
│   │           └── products.xsd                # XSD schema file
└── pom.xml                                      # Maven configuration file
```

### Directory Descriptions

- **src/main/java/com/learn/soap/demo/config**: Contains configuration files for the Spring Boot application, including service configurations and SOAP settings.

- **src/main/java/com/learn/soap/demo/controller**: Contains the SOAP controllers that handle incoming SOAP requests and route them to the appropriate service methods.

- **src/main/java/com/learn/soap/demo/model**: Contains the `Product` entity class that represents the structure of the productEntity data.

- **src/main/java/com/learn/soap/demo/repository**: Contains repository interfaces for accessing the database, providing methods for CRUD operations.

- **src/main/java/com/learn/soap/demo/service**: Contains the service layer, which includes business logic related to products and interacts with the repository layer.

- **src/main/resources/application.properties**: Contains application configuration properties such as database connection settings and other Spring Boot settings.

- **src/main/resources/xsd/products.xsd**: Contains the XSD schema file that defines the structure of the SOAP requests and responses related to `Product`.

- **pom.xml**: The Maven configuration file that manages project dependencies and build configurations.

## Getting Started

To get a local copy of this project up and running, follow these steps:

### 1. Clone the repository

```bash
git clone https://github.com/yourusername/demo-soap.git
cd demo-soap
```

### 2. Install dependencies

Use Maven to install the required dependencies:

```bash
mvn clean install
```

### 3. Configure application properties

Open the `src/main/resources/application.properties` file and configure the necessary properties such as database URL, username, and password if you are using a database.

### 4. Run the application

You can run the application using the following command:

```bash
mvn spring-boot:run
```

### 5. Access the WSDL

Once the application is running, you can access the WSDL for the SOAP web service at the following URL:

```
http://localhost:8080/ws/products.wsdl
```

## API Endpoints

### Create a Product

- **Endpoint:** `POST /ws/products`
- **Request Body:** SOAP request with productEntity details (refer to `products.xsd` for structure).
- **Response:** SOAP response with the created productEntity details.

### Get a Product by ID

- **Endpoint:** `GET /ws/products/{id}`
- **Request:** SOAP request specifying the productEntity ID.
- **Response:** SOAP response with the productEntity details.

### Update a Product

- **Endpoint:** `PUT /ws/products`
- **Request Body:** SOAP request with updated productEntity details.
- **Response:** SOAP response indicating success or failure.

### Delete a Product

- **Endpoint:** `DELETE /ws/products/{id}`
- **Request:** SOAP request specifying the productEntity ID to delete.
- **Response:** SOAP response indicating success or failure.

## Example SOAP Request

Here’s an example of a SOAP request to create a productEntity:

```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:prod="http://www.learn.com/soapDemo/gen">
   <soapenv:Header/>
   <soapenv:Body>
      <prod:createProduct>
         <prod:productEntity>
            <prod:id>1</prod:id>
            <prod:name>Sample Product</prod:name>
            <prod:price>29.99</prod:price>
         </prod:productEntity>
      </prod:createProduct>
   </soapenv:Body>
</soapenv:Envelope>
```

## Contributing

Contributions are welcome! Please read the [CONTRIBUTING.md](CONTRIBUTING.md) for details on our code of conduct, and the process for submitting pull requests to us.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details.

## Contact

For any inquiries, please reach out to:

- **Name:** Mohammed Abdu
- **Email:** eng.mo.abdu@gmail.com
