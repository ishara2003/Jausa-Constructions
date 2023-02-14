package lk.sankalpa.dao.Custom.impl;

import lk.sankalpa.Util.CrudUtil;
import lk.sankalpa.dao.Custom.PaymentDao;
import lk.sankalpa.entity.Payment;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PaymentDaoImpl implements PaymentDao {
    private final Connection connection;
    public PaymentDaoImpl(Connection connection) {
        this.connection=connection;

    }

    @Override
    public Payment save(Payment payment) {
        CrudUtil.execute("insert into payments values(?,?,?,?)",

               payment.getPayment_Id(),
               payment.getPayment_Price(),
               payment.getPayment_Date(),
               payment.getPayment_Owner_NIC()
       );
        return payment;
    }

    @Override
    public Payment update(Payment entity) {
        return null;
    }

    @Override
    public Payment search(String Id) {
        return null;
    }

    @Override
    public void delete(String Id) {

    }

    @Override
    public List<Payment> allData() {

        ResultSet resultSet = CrudUtil.execute("SELECT * FROM payments");
        return getPayments(resultSet);
    }

    @Override
    public List<Payment> getPayments(ResultSet resultSet) {
        ArrayList<Payment> list= new ArrayList<>();
        while (true){
            try {
                while (resultSet.next()) {
                    list.add(new Payment(
                            resultSet.getString(1),
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
}
