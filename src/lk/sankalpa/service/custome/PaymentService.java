package lk.sankalpa.service.custome;

import lk.sankalpa.dto.PaymentDTO;
import lk.sankalpa.service.SuperService;

import java.util.List;

public interface PaymentService extends SuperService {

    PaymentDTO savePayment(PaymentDTO paymentDTO);

    List<PaymentDTO> allPayment();

}
