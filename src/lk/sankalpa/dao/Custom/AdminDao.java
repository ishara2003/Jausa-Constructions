package lk.sankalpa.dao.Custom;

import lk.sankalpa.dao.CrudDao;
import lk.sankalpa.entity.Admin;

public interface AdminDao extends CrudDao<Admin,String> {


    Admin logIn(String username);

}
