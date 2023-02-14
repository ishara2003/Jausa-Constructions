package lk.sankalpa.service.custome;

import lk.sankalpa.dto.P_OwnerDTO;
import lk.sankalpa.service.SuperService;

import java.util.List;

public interface ProjectOwnerService extends SuperService {

    P_OwnerDTO AddProject(P_OwnerDTO p_ownerDTO);
    void deleteP_Owner(String nic);
    P_OwnerDTO searchOwnerByNIC(String nic);
    P_OwnerDTO editOwner(P_OwnerDTO p_ownerDTO);
    List<P_OwnerDTO>allP_Owners();

}
