package lk.sankalpa.service.custome;

import lk.sankalpa.dto.StockDTO;
import lk.sankalpa.service.SuperService;

import java.util.List;


public interface StockService extends SuperService {

    StockDTO AddStock(StockDTO stockDTO);

    StockDTO uppdateStock(StockDTO stockDTO);

    StockDTO searchItemById(String id);

    void deleeteItem(String id);

    List<StockDTO> allItems();


}
