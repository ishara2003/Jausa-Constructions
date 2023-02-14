package lk.sankalpa.dao.Custom;

import lk.sankalpa.dao.CrudDao;
import lk.sankalpa.entity.Projects;

import java.sql.ResultSet;
import java.util.List;

public interface ProjectDao extends CrudDao<Projects,String > {

    List<Projects> getProjects(ResultSet set);



}
