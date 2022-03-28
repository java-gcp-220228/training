# Week 4 Study Guide

Topics
- GCP Compute Engine
- GCP Persistent Disk
- GCP VPC
- GCP Firewall
- Environment Variables
- DevOps
- CI/CD
- Load Balancing
- IaaS/PaaS/SaaS
- Gradle Builds
- Jenkins
- Docker
- SonarCloud

## Intro to DevOps
- [NOTES](https://github.com/java-gcp-220228/training/blob/main/week-4/ci-cd.md)
    - [Continuous Integration](https://github.com/java-gcp-220228/training/blob/main/week-4/ci-cd.md#continuous-integration)
    - [Continuous Delivery](https://github.com/java-gcp-220228/training/blob/main/week-4/ci-cd.md#continuous-delivery)
    - [Continuous Deployment](https://github.com/java-gcp-220228/training/blob/main/week-4/ci-cd.md#continuous-deployment)
    - [Example Tools](https://github.com/java-gcp-220228/training/blob/main/week-4/ci-cd.md#example-tools)
- [Github Actions CI workflow](https://github.com/java-gcp-220228/gradify-backend/blob/main/.github/workflows/gradle.yml)
- Jenkins Pipeline Configuration
    - [Setting up Source Code Management](./images/jenkins-source-code.png)
    - [Setting up Build steps](./images/jenkins-build-steps.PNG)

## Gradle
- [Configuring `jar` task for generating executable .jar file](https://github.com/java-gcp-220228/gradify-backend/blob/main/build.gradle#L41-L53)

## SonarCloud
- [Gradify Backend SonarCloud report example](https://sonarcloud.io/summary/overall?id=java-gcp-220228_gradify-backend)
- Configuring SonarCloud Code Scanning
    - [SonarCloud Github Actions Workflow](https://github.com/java-gcp-220228/gradify-backend/blob/main/.github/workflows/sonarcloud.yml)
    - [sonarqube plugin](https://github.com/java-gcp-220228/gradify-backend/blob/main/build.gradle#L3)
    - [sonarqube gradle task configuration](https://github.com/java-gcp-220228/gradify-backend/blob/main/build.gradle#L30-L39)
- Configuring Code Coverage
    - [jacoco plugin](https://github.com/java-gcp-220228/gradify-backend/blob/main/build.gradle#L4)
    - [jacoco plugin configuration](https://github.com/java-gcp-220228/gradify-backend/blob/main/build.gradle#L14-L17)
    - [test task configuration](https://github.com/java-gcp-220228/gradify-backend/blob/main/build.gradle#L19-L21)
    - [jacocoTestReport task configuration](https://github.com/java-gcp-220228/gradify-backend/blob/main/build.gradle#L23-L28)

## Intro to Cloud Computing
- [NOTES](https://github.com/java-gcp-220228/training/blob/main/week-4/cloud-computing.md)
    - [Advantages](https://github.com/java-gcp-220228/training/blob/main/week-4/cloud-computing.md#advantages-of-cloud-computing)
    - [IaaS/PaaS/SaaS](https://github.com/java-gcp-220228/training/blob/main/week-4/cloud-computing.md#3-models-of-cloud-computing)
    - [GCP Cloud SQL v. GCP Compute Engine v. GCP Cloud Storage](https://github.com/java-gcp-220228/training/blob/main/week-4/cloud-computing.md#google-cloud-platform)
    - [Horizontal v. Vertical Scaling](https://github.com/java-gcp-220228/training/blob/main/week-4/cloud-computing.md#horizontal-v-vertical-scaling)
- [GCP Load Balancer demo](./images/gcp-load-balancer.JPG)

## Docker
- [container](./images/containers.JPG)
- [docker image](./images/docker-image.JPG)
- [docker common commands](./images/docker-common-commands.JPG)
- [docker port mapping](./images/docker-port-mapping.JPG)
- [Dockerfile](./images/dockerfile.JPG)
- [docker compose](./images/docker-compose-diagram.JPG)
- [docker-compose.yml](./images/docker-compose-yml.png)
- [docker volumes](./images/docker-volumes.JPG)

# Questions
- What is GCP Compute Engine?
    - What is persistent disk?
    - Why do we need to configure firewall rules when we try to send requests to our compute engine instances?
    - What is the .bashrc file? How do we configure environment variables inside of this file?
- What is GCP VPC?
- What is GCP Cloud SQL?
- What is GCP Cloud Storage?
    - What are the 4 tiers of GCP Cloud Storage?
    - What is the tradeoff between each tier in terms of storage cost / access cost?
- What are some basic commonly used Linux commands?
- What is vim?
    - How do we start typing text into a file with vim?
    - How do we save a file and quit vim?
- Describe IaaS v. PaaS v. SaaS
    - What are the intended users for each type of cloud computing service?
- What is the difference between horizontal and vertical scaling?
- If we have multiple instances and a load balancer that distributes user traffic between these instances, is this horizontal or vertical scaling?
- What is DevOps?
    - Why is DevOps important in modern development?
- What are the three parts of CI/CD?
    - What is continuous integration?
    - What is continuous delivery?
    - What is continuous deployment?
- Besides being a tool to manage a Java project's dependencies, Gradle is also known as a build tool. What does this mean?
- What happens when we run `gradle build`?
- What is a gradle task?
- In what file do we configure gradle tasks?
- What is Jenkins?
    - What is the purpose of a Jenkins pipeline?
- What is Docker?
    - What is the purpose of containerization?
    - How are docker containers different than virtual machines?
    - What is the advantage of docker containers v. VMs?
    - What are docker images?
    - What is a Dockerfile?
    - What are some common commands used with Docker?
    - What two commands is the `docker run` command made of?
    - What is the purpose of Docker port mapping?
    - What is Docker compose?
    - What is the purpose of Docker volumes?
- What is SonarCloud?
    - What are code smells?
    - Bugs?
    - Security vulnerabilities?
    - What plugin do we configure alongside SonarCloud to have code coverage reporting?