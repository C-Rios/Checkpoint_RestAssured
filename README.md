# **Rest Assured**
### *Checkpoint*

## **Instructions**

**0.** *Setup*

  * Set up a Java project using your preferred IDE and add include the RestAssured library as a dependency in your project.
    
  * You can clone/download this repository that I created for this checkpoint. It contains a basic java project with the necessary dependencies added. It shouldn't give you any problems, but if not, don't waste time trying to fix it; just create a new project yourselves (it
    will be faster that way).


**1.** [*Task 1 - Making Requests*](./src/test/java/Tests/Task_1.java)

  * Using a fake API service - suggestion: [DummyJSON](dummyjson.com)

  * Make at least three different types of requests (GET, POST, PUT, DELETE) to the API endpoints.


**2.** [*Task 2 - Assertions*](./src/test/java/Tests/Task_2.java)

  * For each request made in Task 1, write assertions to verify key aspects of the response:
    
    - Status code
    - Response time
    - Headers
    - Specific data fields


**3.** [*Task 3 - Schema Validation*](./src/test/java/Tests/Task_3.java)

  * Choose one of the responses from Task 1.
  * Define a JSON schema. Suggestion: use an online tool to generate the schema based on the expected json response; e.g.: [JSONschema](jsonschema.net).
  * Implement schema validation on the chosen response to ensure that it matches the defined schema.
