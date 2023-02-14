package lk.sankalpa.service.custome.impl;

import lk.sankalpa.connection.DBConnection;
import lk.sankalpa.dao.Custom.PaymentDao;
import lk.sankalpa.dao.DaoFactory;
import lk.sankalpa.dao.DaoType;
import lk.sankalpa.dto.PaymentDTO;
import lk.sankalpa.service.Converter;
import lk.sankalpa.service.custome.PaymentService;

import java.sql.Connection;
import java.util.List;
import java.util.stream.Collectors;

public class PaymentServiceImpl implements PaymentService {

    private final Connection connection;
    private final Converter converter;
    private final PaymentDao paymentDao;

    public PaymentServiceImpl() {
        this.connection = DBConnection.getInstance().getConnection();
        this.converter = new Converter();
        this.paymentDao = DaoFactory.getInstance().getDAO(connection, DaoType.PAYMENTS);
    }

    @Override
    public PaymentDTO savePayment(PaymentDTO paymentDTO) {

        paymentDao.save(converter.toPayments(paymentDTO));
        return paymentDTO;

    }

    @Override
    public List<PaymentDTO> allPayment() {

        return paymentDao.allData().stream().map(payment -> converter.fromPayment(payment)).collect(Collectors.toList());
    }


}
