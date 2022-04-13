Feature: Login

  Scenario: Successful login as finance manager
    Given There are users in the database
    When I send a POST request to /login with valid username "bach_tran" and valid password "password12345"
    Then I should receive a response with status code 200, the appropriate User object for bach_tran, and a valid JWT "eyJhbGciOiJIUzUxMiJ9.eyJ1c2VyX2R0byI6IntcInVzZXJJZFwiOjEsXCJmaXJzdE5hbWVcIjpcIkJhY2hcIixcImxhc3ROYW1lXCI6XCJUcmFuXCIsXCJ1c2VyUm9sZVwiOlwiZmluYW5jZV9tYW5hZ2VyXCIsXCJ1c2VybmFtZVwiOlwiYmFjaF90cmFuXCIsXCJlbWFpbFwiOlwiYmFjaF90cmFuQGVtYWlsLmNvbVwifSJ9.kMn4M1si4pJgqNsqZNEF6soM2AfHmAtWiS_TmqDq5PG2sREIi8NWTW_2CWj8JJcJLaMwnXVCyFYjQoaVnmkghQ"

  Scenario: Successful login as employee
    Given There are users in the database
    When I send a POST request to /login with valid username "jane_doe" and valid password "12345"
    Then I should receive a response with status code 200, the appropriate User object for jane_doe, and a valid JWT "eyJhbGciOiJIUzUxMiJ9.eyJ1c2VyX2R0byI6IntcInVzZXJJZFwiOjIsXCJmaXJzdE5hbWVcIjpcIkphbmVcIixcImxhc3ROYW1lXCI6XCJEb2VcIixcInVzZXJSb2xlXCI6XCJlbXBsb3llZVwiLFwidXNlcm5hbWVcIjpcImphbmVfZG9lXCIsXCJlbWFpbFwiOlwiamFuZV9kb2VAZW1haWwuY29tXCJ9In0.duyS4Dv5wQjvzoTXsbOR-coXZHK0kofKFJ1uOxAZrZw1txZ87Y30NnqVKBGpvMPLAj8NAYrACO0y9mo-8YY18Q"