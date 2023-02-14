package lk.sankalpa.service.custome.impl;

import lk.sankalpa.connection.DBConnection;
import lk.sankalpa.dao.Custom.ProjectOwnerDao;
import lk.sankalpa.dao.DaoFactory;
import lk.sankalpa.dao.DaoType;
import lk.sankalpa.dto.P_OwnerDTO;
import lk.sankalpa.entity.Project_Owners;
import lk.sankalpa.service.Converter;
import lk.sankalpa.service.custome.ProjectOwnerService;

import java.sql.Connection;
import java.util.List;
import java.util.stream.Collectors;

public class ProjectOwnerServiceImpl implements ProjectOwnerService {


    private final ProjectOwnerDao projectOwnerDao;
    private Connection connection;
    private Converter converter;

    public ProjectOwnerServiceImpl() {
        connection= DBConnection.getInstance().getConnection();
        projectOwnerDao= DaoFactory.getInstance().getDAO(connection, DaoType.PROJECT_OWNER);
        converter=new Converter();
    }

    @Override
    public P_OwnerDTO AddProject(P_OwnerDTO p_ownerDTO) {

        projectOwnerDao.save(converter.toProject_Owner(p_ownerDTO));
        return p_ownerDTO;

    }

    @Override
    public void deleteP_Owner(String nic) {
        projectOwnerDao.delete(nic);
    }

    @Override
    public P_OwnerDTO searchOwnerByNIC(String nic) {

        Project_Owners search = projectOwnerDao.search(nic);
        return converter.fromP_Owner(search);

    }

    @Override
    public P_OwnerDTO editOwner(P_OwnerDTO p_ownerDTO) {

        projectOwnerDao.update(converter.toProject_Owner(p_ownerDTO));
        return p_ownerDTO;

    }

    @Override
    public List<P_OwnerDTO> allP_Owners() {

       return projectOwnerDao.allData().stream().map(projectOwners ->
               converter.fromP_Owner(projectOwners)).collect(Collectors.toList());


    }
}
