package com.endava.projectservice.services;

import com.endava.projectservice.model.Project;
import com.endava.projectservice.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    // Nu stiu daca e corecta logicaaaa!!! :D
    public Project getProject(int id) {
        if (projectRepository.getOne(id) != null) {
            return projectRepository.getOne(id);
        } else {
            return null;
        }
    }
}
