# Cloud Computing

## What is Cloud Computing?
Cloud computing is the delivery of computing power, database storage, applications, and other IT resources through a cloud services platform over the internet.

Cloud computing is composed of actual physical data-centers managed by some entity, usually a corporation such as Amazon or Google. They take care of setting up the computing infrastructure and the expertise in efficiently managing allocation of computing resources to each customer.

## Advantages of Cloud Computing
1. Trade up-front capital expenses for variable expenses
    - Pay only for what you need
2. Benefit from massive economies of scale
    - Higher economies of scale = lower costs
    - GCP and AWS benefit from having a large customer base to spread usage across
3. Easily scale up and down capacity based on user demand
    - You don't need to spend more than is necessary
    - If the number of customers is increasing, just provision more resources on the fly
    - If the number of customers is decreasing, just de-provision resources on the fly
4. Eliminate overhead cost of maintaining on-premise data-centers
    - Cooling, electricity, server space, labor costs, etc. are outsourced
    - Focus on serving customers instead of worrying about infrastructure
5. Reach a global audience
    - Better latency globally can be achieved by provisioning resources around the world

# 3 Models of Cloud Computing
- Infrastructure as a Service (IaaS)
    - Servers
    - Storage
    - Networking
    - Used by
        - Infrastructure + Network architects
        - System administrators
        - Developers
    - Examples
        - GCP Compute Engine
        - GCP Persistent Disk
        - GCP Cloud Storage
        - GCP VPC
        - GCP Cloud SQL
- Platform as a Service (PaaS)
    - IaaS, and
        - OS
        - Application Stack
    - Used by
        - Developers
    - Examples
        - Heroku, Salesforce, AWS Elastic Beanstalk, GCP App Engine
- Software as a Service (SaaS)
    - PaaS, and
        - Packaged Software
    - Used by
        - End users (consumers)
    - Examples
        - Gmail, Microsoft Office 365

# Google Cloud Platform
Google cloud platform is one of the leading cloud providers along with AWS and Azure. While AWS is currently the undisputed giant in the cloud computing industry, GCP has been growing extremely quickly and gaining market share. GCP is well known for providing an easy to use interface that is intuitive to use. When it comes to technologies such as Kubernetes (which was created by Google), GCP provides solutions that are much easier to use.

Many different resources exist, such as
- GCP Cloud SQL
    - Fully managed relational database service
    - Supports database options such as MySQL and PostgreSQL
    - Scalable
    - Highly Configurable
- GCP Compute Engine
    - Actual virtual machines
    - Pre-built and ready-to-go configurations available when creating new instances
    - VMs can be launched using either standard images or custom images created by the user
- GCP Cloud Storage
    - Binary large object storage solution
    - Used to cheaply store large amounts of files
        - Images
        - Videos
        - Audio files
        - etc.
    - 4 Different storage classes
        - Tradeoff between access cost and storage cost
        - Standard storage
            - Used for frequently accessed data
            - Free access, more expensive storage
        - Nearline storage
            - Used for data accessed less than once per month
            - Low access cost, expensive storage
        - Coldline storage
            - Used for data accessed less than once a quarter
            - Medium access cost, medium storage cost
        - Archive storage
            - Used for data accessed less than once per year
            - High access cost, low storage cost

## Horizontal v. Vertical Scaling
Imagine you have an application deployed in the cloud that is rapidly growing in terms of users. Your original infrastructure used to serve all of these customers can no longer handle all of the load. You can either choose to use vertical or horizontal scaling as a strategy
- Vertical Scaling: Increasing the power of an individual instance (CPU, RAM, etc.)
    - Becomes very expensive because of diminishing returns in computing power v. price for an individual computer (2x the increase in the CPUs power, 4x)
- Horizontal Scaling: Increase the number of instances
    - Linear scaling between computing power and cost (ex. 10x the number of instances, 10x the cost)

Vertical scaling was often the traditional approach before cloud computing. The reason is that provisioning more servers and designing the architecture to support users across multiple servers was often a lot of work and more difficult. Horizontal scaling would require additional configuration, server rackspace, power, cooling, etc, but with the advent of cloud computing, horizontal scaling has become the norm.

Cloud computing providers have been able to push the leading edge of dynamically creating virtual machines and distributing these VMs efficiently across the physical host systems/machines such that these providers can maximize utilization of their computing resources. This makes it easier to have horizontal scaling through fast provisioning of new resources and fast deprovisioning of existing resources.
