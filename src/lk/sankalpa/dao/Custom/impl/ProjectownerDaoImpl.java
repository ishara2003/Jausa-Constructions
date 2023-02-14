package lk.sankalpa.dao.Custom.impl;

import lk.sankalpa.Util.CrudUtil;
import lk.sankalpa.dao.Custom.ProjectOwnerDao;
import lk.sankalpa.entity.Project_Owners;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProjectownerDaoImpl implements ProjectOwnerDao {
    private final Connection connection;
    public ProjectownerDaoImpl(Connection connection) {
        this.connection=connection;

    }

    @Override
    public Project_Owners save(Project_Owners projectOwners) {
        CrudUtil.execute("INSERT INTO project_owners VALUES (?,?,?,?)",

                projectOwners.getName(),
                projectOwners.getNIC(),
                projectOwners.getAddress(),
                projectOwners.getNumber()
        );
        return projectOwners;
    }

    @Override
    public Project_Owners update(Project_Owners projectOwners) {

            if(CrudUtil.execute("update project_owners set Name=?,Address=?,Contact_Number=? where NIC=?",
                    projectOwners.getName(),
                    projectOwners.getAddress(),
                    projectOwners.getNumber(),
                    projectOwners.getNIC()
            )){
                return projectOwners;
            }
          return null;
    }

    @Override
    public Project_Owners search(String NIC) {
        ResultSet resultSet = null;
        try {
            resultSet = CrudUtil.execute("select * from project_owners where NIC='" + NIC + "'");
        if(resultSet.next()){

            return new Project_Owners(resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4));
        }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public void delete(String nic) {
        CrudUtil.execute("DELETE FROM project_owners WHERE NIC='"+nic+"'");
    }

    @Override
    public List<Project_Owners> allData() {

        ResultSet execute = CrudUtil.execute("SELECT * FROM project_owners");

        return getProjectOwners(execute);
    }

    @Override
    public List<Project_Owners> getProjectOwners(ResultSet resultSet) {

            try{
            ArrayList<Project_Owners> list= new ArrayList<>();

            while (resultSet.next()){
                list.add(new Project_Owners(resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4)));

            }

            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
