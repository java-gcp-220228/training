# DevOps

DevOps stands for development + operations. Traditionally, there was the development and operation team. Whenever the development team was done developing an application, they would then pass the application off the operations team to deploy and maintain. However, in today's modern agile environments, these have been merged together using modern practices and tools. Software development and deployment has been automated in many respects to increase agility. DevOps allows for organizations to adapt more quickly and to deliver value faster in order to compete more effectively.

DevOps utilizes the concepts of
- Continuous Integration (CI)
- Continuous Delivery (CD)
- Continuous Deployment (CD)

These are collectively known as CI/CD

## Continuous Integration
Continuous integration describes the process whereby team members integrate their work together at least once a day. This is usually done by creating feature branches and merging these branches frequently into the main branch. Every time a commit is made and pushed to a branch, an automated build consisting of compiling the code and running tests is done in order to detect any compilation issues or failed tests. This avoids the accumulation of issues that may happen if integration is put off until the end of the project. 

CI allows for errors to be detected daily and corrected early. Version control systems such as Git are commonly used along with platforms such as Github Actions that will run the builds (compile + test).

## Continuous Delivery
Continuous delivery aims to build, test, and release software with a very fast frequency. This enables for features to be delivered on a continuous basis for the customer to be able to provide fast feedback and lower risk for the business by allowing for continuous changes and adaptations to the software. Code can essentially be deployed to product with the "push of a button". Software could be released daily, weekly, biweekly, monthly, etc. Requires human intervention

## Continuous Deployment
As soon as code is committed, pushed, and those changes are able to pass every stage of the deployment pipeline, the code can be automatically deployed to production. No human intervention is involved and deployment is only prevented if a failed test occurs.

# Example Tools
- Jenkins: CI/CD tool used commonly to set up continuous delivery/continuous deployment pipelines
    - Pipeline: an automated set of tasks that need to be performed in order to build, test, and deploy an application
        - Example of deployment:
            - `git clone <repository>`
            - `cd <repository folder>`
            - `gradle build`
            - `cd build/libs`
            - `java -jar <jar file name>`
- Github Actions: CI/CD tool commonly used for CI that can automatically run builds (compile + test) to detect issues with the project
- Gradle: Build tool for compiling, running tests, and packaging our project
- Docker: OS-level virtualization solution for running an application in an isolated, self-sufficient environment
    - Docker solves the solution of "WELL, it runs on my machine"