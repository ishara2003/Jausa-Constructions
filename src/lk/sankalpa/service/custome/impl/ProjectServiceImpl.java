package lk.sankalpa.service.custome.impl;

import lk.sankalpa.connection.DBConnection;
import lk.sankalpa.dao.Custom.ProjectDao;
import lk.sankalpa.dao.DaoFactory;
import lk.sankalpa.dao.DaoType;
import lk.sankalpa.dto.ProjectDTO;
import lk.sankalpa.entity.Projects;
import lk.sankalpa.service.Converter;
import lk.sankalpa.service.custome.ProjectService;

import java.sql.Connection;
import java.util.List;
import java.util.stream.Collectors;

public class ProjectServiceImpl implements ProjectService {

    private Connection connection;
    private Converter converter;
    private ProjectDao projectDao;

    public ProjectServiceImpl() {
        connection= DBConnection.getInstance().getConnection();
        converter=new Converter();
        projectDao= DaoFactory.getInstance().getDAO(connection, DaoType.PROJECTS);
    }

    @Override
    public ProjectDTO AddProject(ProjectDTO projectDTO) {

        projectDao.save(converter.toProjects(projectDTO));
        return projectDTO;

    }

    @Override
    public ProjectDTO searchProject(String projectId) {

        Projects search = projectDao.search(projectId);

       return converter.fromProject(search);

    }

    @Override
    public List<ProjectDTO> allProjects() {

        return projectDao.allData().stream().map(projects -> converter.fromProject(projects)).collect(Collectors.toList());

    }

    @Override
    public ProjectDTO updateProject(ProjectDTO projectDTO) {

        projectDao.update(converter.toProjects(projectDTO));

        return projectDTO;

    }

    @Override
    public ProjectDTO editProject(ProjectDTO projectDTO) {

        projectDao.update(converter.toProjects(projectDTO));
        return projectDTO;

    }

    @Override
    public void deleteProject(String projectId) {

        projectDao.delete(projectId);

    }
}
