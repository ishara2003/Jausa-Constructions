package lk.sankalpa.dao.Custom;

import lk.sankalpa.dao.CrudDao;
import lk.sankalpa.entity.Payment;

import java.sql.ResultSet;
import java.util.List;

public interface PaymentDao extends CrudDao<Payment,String> {

    List<Payment> getPayments(ResultSet resultSet);

}
