package lk.sankalpa.dao.Custom;

import lk.sankalpa.dao.CrudDao;
import lk.sankalpa.entity.Project_Owners;

import java.sql.ResultSet;
import java.util.List;

public interface ProjectOwnerDao extends CrudDao<Project_Owners,String> {

    List<Project_Owners>getProjectOwners(ResultSet resultSet);

}
