package com.endava.projectservice.controllers;

import com.endava.projectservice.model.Project;
import com.endava.projectservice.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping("/project/{id}")
    public Project getProject(@PathVariable int id) {
        return projectService.getProject(id);
    }
}
