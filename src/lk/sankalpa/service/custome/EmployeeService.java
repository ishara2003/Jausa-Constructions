package lk.sankalpa.service.custome;

import lk.sankalpa.dto.EmployeeDTO;
import lk.sankalpa.service.SuperService;

import java.util.List;

public interface EmployeeService extends SuperService {

    EmployeeDTO SaveEmployee(EmployeeDTO employeeDTO);

    List<EmployeeDTO>allEmployees();

    EmployeeDTO searchEmployee(String Nic);

    void deleteemployee(String Nic);

    EmployeeDTO editemployeeDetails(EmployeeDTO employeeDTO);

}
