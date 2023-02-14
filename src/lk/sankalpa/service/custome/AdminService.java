package lk.sankalpa.service.custome;

import lk.sankalpa.dto.AdminDTO;
import lk.sankalpa.service.SuperService;

public interface AdminService extends SuperService {

AdminDTO saveAdmin(AdminDTO adminDTO)throws NullPointerException;
AdminDTO updateAdmin(AdminDTO adminDTO);
AdminDTO searchAdmin(String nic);
AdminDTO logIn(String username);

}
