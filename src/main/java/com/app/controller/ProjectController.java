package com.app.controller;

import com.app.dto.ProjectDTO;
import com.app.exception.BaseExcepiton;
import com.app.exception.PersonNotFoundException;
import com.app.service.impl.ProjectServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/project")
public class ProjectController {

    private static Logger logger= LoggerFactory.getLogger(ProjectController.class);
    private ProjectServiceImpl projectService;
    public ProjectController(ProjectServiceImpl projectService){
        this.projectService=projectService;
    }


    @PostMapping("/")
    public ResponseEntity<Integer> saveProject(@RequestBody()  ProjectDTO projectDTO) throws PersonNotFoundException, BaseExcepiton {
     logger.info("Request received to save project {} ",projectDTO.toString());
        return new ResponseEntity<>(projectService.saveProject(projectDTO),HttpStatus.CREATED);
    }

}
