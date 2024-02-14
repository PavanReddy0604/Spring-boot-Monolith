package com.app.controller;

import com.app.dto.ProjectDTO;
import com.app.service.impl.ProjectServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/project")
public class ProjectController {

    private ProjectServiceImpl projectService;
    public ProjectController(ProjectServiceImpl projectService){
        this.projectService=projectService;
    }


    public ResponseEntity<ProjectDTO> saveProject(@RequestBody()  ProjectDTO projectDTO){

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
