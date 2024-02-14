package com.app.dto;

import com.app.entity.Person;
import com.app.util.ProjectType;

import java.util.UUID;

public class ProjectDTO {
    private String projectDescription;

    private ProjectType projectType;
    private Person person;

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public ProjectType getProjectType() {
        return projectType;
    }

    public void setProjectType(ProjectType projectType) {
        this.projectType = projectType;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}