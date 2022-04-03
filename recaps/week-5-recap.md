# Week 5 Recap

## Single Page Application
- [image](./images/spa.JPG)
    - definition
    - advantages
    - disadvantages
- [SPA frameworks/libraries](./images/spa-frameworks-libraries.JPG)
    - Angular framework
    - React library

# Angular
- [versions](./images/angular-versions.JPG)
    - AngularJS (OLD and no longer supported)
    - Angular 2+ (Complete rewrite of Angular)
        - Any tutorials you find online should be Angular 2+, not AngularJS (NOT the same framework!!!)
- [creating a project w/ Angular CLI](./images/angular-cli.JPG)
    - `ng new <project name>`
    - Creates a project
        - git repository automatically created
        - Important project folders/files
            - src folder
            - node_modules folder
            - package.json
                - scripts
                - dependencies
                - devDependencies
            - package-lock.json
- Angular Components
    - [notes](./images/angular-components-notes.png)
    - [component files](./images/angular-component-files.png)
        - app.component.css
        - app.component.html
        - app.component.ts
        - app.component.spec.ts
    - [@Component decorator](./images/angular-component-decorator.png)
        - selector
        - templateUrl
        - styleUrls
    - [Generating a component](./images/angular-generate-component.png)
        - `ng generate component <component name>`
    - [Component lifecycle](./images/angular-component-lifecycle.png)
- Angular Modules
    - [notes](./images/angular-modules.png)
    - [@NgModule decorator](./images/angular-module-decorator.png)
        - declarations
        - imports
        - exports
        - providers
        - bootstrap (AppModule only)
- Databinding
    - [notes](./images/angular-databinding.png)
    - One-way databinding
        - string interpolation {{ }}
        - property binding []
        - event binding ()
    - Two-way databinding
        - for `<input>` elements
        - [(ngModel)]=""
- Angular Pipes
    - [notes](./images/angular-pipes.png)
    - [Creating a custom pipe](./images/angular-custom-pipe.png)
- Angular Directives
    - [notes](./images/angular-directives.png)
    - Structural
        - *ngIf
        - ngSwitch
            - *ngSwitchCase
        - *ngFor
    - Attribute
        - ngStyle
        - ngClass
        - [syntax example](./images/attribute-directive-syntax.png)
- Angular Inter-component communication
    - @Input
        - Parent-to-child
            - Uses property binding to pass info into child
        - [diagram](./images/angular-parent-to-child.png)
    - @Output
        - Child-to-parent
            - Uses event emitters and event binding to pass information into parent
        - [diagram](./images/angular-child-to-parent.png)
- Angular Services
    - [notes](./images/angular-services.png)
- Angular HttpClient
    - [notes](./images/angular-http-client.png)
- Lazy Loading v. Eager Loading
    - [images](./images/lazy-loading-eager-loading.png)

# Publisher / subscriber pattern Model
- Pub/sub model
    - [images](./images/pub-sub.png)

# SDLC
- [Phases of SDLC](./images/sdlc-phases.png)
- Philosophies
    - [Waterfall](./images/waterfall.png)
        - [diagram](./images/waterfall-diagram.png)
    - [Agile](./images/agile.png)
        - [diagram](./images/agile.png)
- Frameworks
    - Kanban
    - Scrum

# Scrum
- [diagram](./images/scrum-diagram.png)
- "A lightweight framework that helps people, teams, and organizations generate value through adaptive solutions for complex problems"
- [Sprint](./images/scrum-sprint.png)
- [Scrum artifacts](./images/scrum-artifacts.png)
    - Product backlog
    - Sprint backlog
    - Potentially Shippable Increment
- [Scrum roles](./images/scrum-roles.png)
    - Scrum Master
    - Product Owner
    - Development Team
- [Scrum meetings](./images/scrum-meetings.png)

# TypeScript
- TypeScript
    - [notes](./images/typescript-notes.png)

# Questions
* What are single page applications?
* What are some advantages of SPAs?
* What are some disadvantages of SPAs?
* What is the difference between a framework and a library?
* What versions of Angular are there? Why is this important to know?
* What is Angular CLI? How do we install it? What do we need to install first in order to install Angular CLI?
* What is the purpose of the src folder, node_modules folder, package.json, and package-lock.json?
* Which of those 4 folders/files should be ignored inside of the .gitignore file?
* If that folder/file is ignored, how would another developer obtain the necessary dependencies?
* What command is used to run a script listed in the scripts section of the package.json file?
* What is the difference between dependencies listed in the "dependencies" section v. the "devDependencies" section?