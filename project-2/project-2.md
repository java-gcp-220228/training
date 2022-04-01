# Project 2

Project 2 will be a group-based, full-stack application that you will be designing and implementing based on user stories of your own choosing.

- Backend
    - The backend should be a RESTful API
    - Spring Framework
        - Instead of utilizing Javalin for the backend, you will be using Spring Framework, which has a web module that allows for controllers to be built and mapped
        - Use Spring Web MVC to process HTTP Requests/Responses
        - Spring Boot can be used
    - Hibernate or Spring Data JPA
        - Replaces JDBC
        - Object relational mapper
        - You can choose to use Hibernate or Spring Data JPA (which builds on top of Hibernate)
    - Logback
        - Should have a logback.xml configuration file
    - JUnit tests
        - Show code coverage report using JaCoCo gradle plugin + SonarCloud together
            - Minimum of 50% overall code coverage
            - Minimum of 80% service layer code coverage
        - Use Mockito as necessary in order to mock the DAO layer, etc.
        - Unit tests AND integration tests
- Frontend
    - You should be using **Angular**
    - You must consume your RESTful API backend
    - **You must also consume a second, external REST API**
        - Please make sure the API you want to use is free and working
        - That way, you do not scramble to revise your project idea when you realize the API either does not work or costs money to use

- GCP Deployment (Frontend + Backend)
    - The frontend can be deployed on firebase or on a webserver set up on your GCP compute engine instance
    - The backend must be deployed on a GCP Compute engine instance

- DevOps Pipeline
    - You should have a Jenkins pipeline set-up for automated building and deployment of your backend
    - You can also choose to do the same for your frontend
    - The Jenkins pipeline should ideally be building your application, creating docker image(s) and running container(s) based on those images

# Steps Each Team Should Complete
As a team, you must
- Decide a project idea to design and implement
- Have a name for your project (very important for your portfolio, be creative)
- Have a team name (be creative)
- Have a description of the Project (very important for your portfolio)
    - Professionally worded and phrased
- Have several user stories in the format we have described when talking about agile/scrum
- A list of the technologies you will be using (should be utilizing all of the technologies we have learned (minus Javalin), but it is best to rearticulate this so that you can really drive in the point)

Please create a document containing all of the above information and have one person from the team email it to me. After that point, there will be time to meet me in a breakout so that I can confirm and give the all clear for your project.

The sooner the above steps are completed, the sooner you can start with the project. 

# Project Due Date
April 18th, 2022