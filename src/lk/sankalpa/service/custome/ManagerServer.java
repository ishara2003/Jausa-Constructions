package lk.sankalpa.service.custome;

import lk.sankalpa.dto.ManagerDTO;
import lk.sankalpa.service.SuperService;

public interface ManagerServer extends SuperService {

    ManagerDTO saveManager(ManagerDTO managerDTO)throws NullPointerException;
    ManagerDTO updateManager(ManagerDTO managerDTO);
    ManagerDTO searchManager(String nic);

    ManagerDTO login(String username);


}
