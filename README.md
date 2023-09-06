# songr

## Getting Started

Before running this application, you need to have JDK 11 or later on your system

Follow these steps to run the application:

1. Clone the repository to your local machine:

   ```
   git https://github.com/MohamadSamara/songr.git
   cd songr
   ```

2. Build the project using Gradle :

   ```
   ./gradlew build
   ```

3. Run the Spring Boot application:

4. The application will start, and you should see output indicating that the server is running. By default, the application should be accessible at `http://localhost:8080`.

## Usage

Open a web browser and navigate to `http://localhost:8080/[NAME_OF_THE_ROUTE]`.

- Splash Page: The home page at http://localhost:8080/ welcomes you with a "Welcome To Home Page" message.
- Hello World: Access http://localhost:8080/hello to see "hello" message.
- Capitalize Text: Visit http://localhost:8080/capitalize/{text} to capitalize text and view it in uppercase.
- View Albums: Visit http://localhost:8080/albums to view the list of albums / add a new album to your collection.

## Stopping the Application

To stop the application, simply press `Ctrl + C` in the terminal where the application is running. Confirm the termination, and the server will shut down.
