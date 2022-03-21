package com.revature.controller;

import com.revature.dto.AddAssignmentDTO;
import com.revature.dto.ResponseAssignmentDTO;
import com.revature.service.AssignmentService;
import com.revature.service.JWTService;
import io.javalin.Javalin;
import io.javalin.http.Handler;
import io.javalin.http.UnauthorizedResponse;
import io.javalin.http.UploadedFile;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import org.apache.tika.Tika;

import javax.xml.ws.Response;
import java.io.InputStream;
import java.util.List;

public class AssignmentController implements Controller {

    private JWTService jwtService;
    private AssignmentService assignmentService;

    public AssignmentController() {
        this.assignmentService = new AssignmentService();
        this.jwtService = JWTService.getInstance();
    }

    // This endpoint should only be accessible by trainers

    // Http Requests
    // 1. Request body
    // 2. Request headers
    // 3. Path parameters (1 is the path parameter) /clients/1
    // 4. Query parameters /clients?myQueryParam=something&myOtherQueryParam=somethingelse
    private Handler getAllAssignments = (ctx) -> {
        // { "Bearer", "eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJqYW5lX2RvZSIsInVzZXJfaWQiOjIsInVzZXJfcm9sZSI6InN0dWRlbnQifQ.CzfkxW1qjmCRKU3egxb9ILYXpVlKA-dFIBt9t4Im4_FOBsahb-DkiMxGmVT_fHIC" }
        String jwt = ctx.header("Authorization").split(" ")[1];

        Jws<Claims> token = this.jwtService.parseJwt(jwt);

        if (!token.getBody().get("user_role").equals("trainer")) {
            throw new UnauthorizedResponse("You must be a trainer to access this endpoint");
        }

        List<ResponseAssignmentDTO> assignments = this.assignmentService.getAllAssignments();

        ctx.json(assignments);
    };

    // Authorization logic
    // 1. User role should be student (logged in)
    // 2. user_id should match with who is actually logged in
    private Handler addAssignment = (ctx) -> {
        String jwt = ctx.header("Authorization").split(" ")[1];

        Jws<Claims> token = this.jwtService.parseJwt(jwt);

        if (!token.getBody().get("user_role").equals("student")) {
            throw new UnauthorizedResponse("You must be a student to access this endpoint");
        }

        String userId = ctx.pathParam("user_id");
        int id = Integer.parseInt(userId);
        if (!token.getBody().get("user_id").equals(id)) {
            throw new UnauthorizedResponse("You cannot add an assignment for a student other than yourself");
        }

//        AddAssignmentDTO dto = ctx.bodyAsClass(AddAssignmentDTO.class);

        // 1. Get the assignment name from the form parameters
        String assignmentName = ctx.formParam("assignmentName");
        AddAssignmentDTO dto = new AddAssignmentDTO();
        dto.setAssignmentName(assignmentName);

        // 2. Get the image from the form parameters as well and detect the file type (MIME type)
        UploadedFile file = ctx.uploadedFile("image");
        InputStream is = file.getContent(); // This represents the bytes for the file
        dto.setImage(is);

        ResponseAssignmentDTO getDto = this.assignmentService.addAssignment(id, dto);
        ctx.status(201); // 201 Created
        ctx.json(getDto);
    };

    private Handler gradeAssignment = (ctx) -> {
        String jwt = ctx.header("Authorization").split(" ")[1];
        Jws<Claims> token = this.jwtService.parseJwt(jwt);

        if (!token.getBody().get("user_role").equals("trainer")) {
            throw new UnauthorizedResponse("You must be logged in as a trainer");
        }

        String assignmentId = ctx.pathParam("assignment_id");
        String grade = ctx.queryParam("grade");
        int userId = token.getBody().get("user_id", Integer.class);

        if (grade == null) {
            throw new IllegalArgumentException("You need to provide a grade query parameter when attempting to grade the assignment");
        }

        ResponseAssignmentDTO assignment = this.assignmentService.gradeAssignment(assignmentId, grade, userId);
        ctx.json(assignment);
    };

    private Handler getSpecificStudentAssignments = (ctx) -> {
        String jwt = ctx.header("Authorization").split(" ")[1];
        Jws<Claims> token = this.jwtService.parseJwt(jwt);

        if (!token.getBody().get("user_role").equals("student")) {
            throw new UnauthorizedResponse("You must be a student to access this endpoint");
        }

        String userId = ctx.pathParam("user_id");
        int id = Integer.parseInt(userId);
        if (!token.getBody().get("user_id").equals(id)) {
            throw new UnauthorizedResponse("You cannot obtain assignments that don't belong to yourself");
        }

        List<ResponseAssignmentDTO> dtos = this.assignmentService.getAllAssignmentsByUserId(id);
        ctx.json(dtos);
    };

    private Handler getAssignmentImage = (ctx) -> {
//        String jwt = ctx.header("Authorization").split(" ")[1];
//        Jws<Claims> token = this.jwtService.parseJwt(jwt);
//
        String userId = ctx.pathParam("user_id");
//
//        if (!(token.getBody().get("user_role").equals("student") || token.getBody().get("user_role").equals("trainer"))) {
//            throw new UnauthorizedResponse("You are not allowed to access this endpoint because you are not a student or trainer");
//        }
//
//        if (token.getBody().get("user_role").equals("student") && !("" + token.getBody().get("user_id")).equals(userId)) {
//            throw new UnauthorizedResponse("You are a student, but not accessing an assignment image that belongs to you");
//        }

        String assignmentId = ctx.pathParam("assignment_id");
        InputStream image = this.assignmentService.getAssignmentImage(assignmentId, userId);

        Tika tika = new Tika();
        String mimeType = tika.detect(image);

        ctx.header("Content-Type", mimeType); // tell the client what type of image is being sent in the response
        ctx.result(image);
    };

    @Override
    public void mapEndpoints(Javalin app) {
        app.get("/assignments", getAllAssignments); // trainers
        app.get("/users/{user_id}/assignments", getSpecificStudentAssignments); // specific student
        app.post("/users/{user_id}/assignments", addAssignment); // specific student
        app.get("/users/{user_id}/assignments/{assignment_id}/image", getAssignmentImage);
        app.patch("/assignments/{assignment_id}", gradeAssignment); // trainers
    }
}
