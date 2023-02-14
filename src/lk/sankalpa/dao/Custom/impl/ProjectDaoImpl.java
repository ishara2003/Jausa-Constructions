package lk.sankalpa.dao.Custom.impl;

import javafx.scene.control.Alert;
import lk.sankalpa.Util.CrudUtil;
import lk.sankalpa.dao.Custom.ProjectDao;
import lk.sankalpa.dao.exception.ConstraintViolationException;
import lk.sankalpa.entity.Projects;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProjectDaoImpl implements ProjectDao {
    private final Connection connection;
    public ProjectDaoImpl(Connection connection) {
        this.connection=connection;
    }

    @Override
    public Projects save(Projects projects) {
        CrudUtil.execute("INSERT INTO projects VALUES(?,?,?,?)",

                projects.getP_Name(),
                projects.getP_id(),
                projects.getP_Cost(),
                projects.getP_O_NIC()

        );
        return projects;
    }

    @Override
    public Projects update(Projects projects) throws ConstraintViolationException {

            if(CrudUtil.execute("update projects set Name=?,P_Owner_NIC=?,Cost=? where Id=?",
                    projects.getP_Name(),
                    projects.getP_O_NIC(),
                    projects.getP_Cost(),
                    projects.getP_id())){
                return projects;
            }else {
                new Alert(null,"Mathc not found");
            }
         return null;
        }


    @Override
    public Projects search(String Id) {

        try {
            ResultSet resultSet = CrudUtil.execute("select * from projects where Id='" + Id + "'");
        if(resultSet.next()){
            return new Projects(resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getLong(3),
                    resultSet.getString(4));
        }
        } catch (SQLException e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void delete(String NIC) {
        CrudUtil.execute("DELETE FROM projects WHERE Id='"+NIC+"'");
    }

    @Override
    public List<Projects> allData() {


        ResultSet  resultSet = CrudUtil.execute("SELECT * FROM projects");

        return getProjects(resultSet);
    }

    @Override
    public List<Projects> getProjects(ResultSet set) {

        try {

            ArrayList<Projects> list= new ArrayList<>();
            while (set.next()){
                list.add(new Projects(
                        set.getString(1),
                        set.getString(2),
                        set.getLong(3),
                        set.getString(4)));
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


}
