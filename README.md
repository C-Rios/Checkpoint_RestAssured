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
