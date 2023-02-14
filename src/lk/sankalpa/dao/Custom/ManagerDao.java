package lk.sankalpa.dao.Custom;

import lk.sankalpa.dao.CrudDao;
import lk.sankalpa.entity.Manager;

public interface ManagerDao extends CrudDao<Manager,String> {

    Manager login(String nic);

}
