package lk.sankalpa.service.custome;

import lk.sankalpa.dto.ProjectDTO;
import lk.sankalpa.service.SuperService;

import java.util.List;

public interface ProjectService extends SuperService {

    ProjectDTO AddProject(ProjectDTO projectDTO);
    ProjectDTO searchProject(String  projectId);
    List<ProjectDTO> allProjects();
    ProjectDTO updateProject(ProjectDTO projectDTO);
    ProjectDTO editProject(ProjectDTO projectDTO);
    void deleteProject(String projectId);




}
