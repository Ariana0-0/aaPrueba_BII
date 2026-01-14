package aaBusinessLogic.aaEntities;

import aaBusinessLogic.aaFactoryBL;
import aaDataAccess.aaDAOs.HormigaDAO;
import aaDataAccess.aaDTOs.HormigaDTO;

public abstract class aaHormiga {
    protected aaFactoryBL<HormigaDTO> aafactory = new aaFactoryBL<>(HormigaDAO.class);
    public HormigaDTO data = new HormigaDTO();

    // protected HormigaDAO hormigaDAO;
    // protected Hormiga() throws AppException  {
    //     this.hormigaDAO = new HormigaDAO();
    // }

    // public FactoryBL<HormigaDTO> factory = new FactoryBL<>(() -> {
    //     try {
    //         return new HormigaDAO();
    //     } catch (Exception e) {
    //         new RuntimeException();
    //     }
    // });
}
