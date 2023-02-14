package lk.sankalpa.service.custome;

import lk.sankalpa.dto.IncomeDTO;
import lk.sankalpa.service.SuperService;

import java.util.List;

public interface IncomeService extends SuperService {

    IncomeDTO AddIncome(IncomeDTO incomeDTO);

    List<IncomeDTO>allIncomes();

}
