<<<<<<< HEAD
# **Git Fundamentals**
### *Checkpoint*

## **Steps**

1. Create a new repository 

2. Create a README file 

    - Create a new file called `README.md` and write your name in it. 

    - Create another called `main-code.js` and add some small piece of code (a hello-world or something like that) 

    - Save the changes and commit it to your main branch 

3. Create a new branch: 

    - Create a new branch named `feature-branch`. 

    - Switch to the newly created branch 

4. Make changes and commit: 

    - Open the `main-code.js` file and make a small change (change a variable name or a value). 

    - Save the changes and commit them to the `feature-branch`. 

5. Switch back to the main branch: 

    - Switch back to the `main` branch 

    - Open the `main-code.js` file again and make a small change. 

    - Save the changes but don't commit them. 

6. Stash some changes 

    - Stash the changes. 

    - Using `git stash list` copy the output and save it in the `README.md` file 

    - Unstash your stashed changes. 

6. Merge conflict resolution: 

    - Still on your main branch 

    - Merge the `feature-branch` into the `main` branch 

    - Resolve the merge conflict that arises in the `main-code.js` file. Copy the conflict part and add it to `README.md`. 

7. Finalize and submit: 

    - Push your changes to your remote repository
  
***Optional:*** *Add any issues your ran into or any comments you want into `README.md` and how you fixed them.*

## **Results**

### *Stash List*

`stash@{0}: WIP on master: a1dc1fc Sample code created!`

### *Conflicts*
```
<<<<<<< HEAD
console.log("Hello! This is a small change in master")
=======
console.log("Hello! This is a change for the feature-branch")
>>>>>>> feature-branch
```

### *Optional:Issues*
* Credentials configuration: I used the following commands to extend my github credentials
    - `git config --global user.name <<Your_Username>>`
    - `git config --global user.email <<Your_Email>>`
=======
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

>>>>>>> 41eeeafccb795c9985508e3336c01c02469a2021
