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
- What is the purpose of containerization?
- How are docker containers different than virtual machines?
- What is the advantage of docker containers v. VMs?
- 