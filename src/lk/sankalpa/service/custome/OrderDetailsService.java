package lk.sankalpa.service.custome;

import lk.sankalpa.dto.OrderDetailsDTO;
import lk.sankalpa.service.SuperService;

public interface OrderDetailsService extends SuperService {

    OrderDetailsDTO saveDetails(OrderDetailsDTO detailsDTO);
    OrderDetailsDTO searchDetails(String Id);



}
