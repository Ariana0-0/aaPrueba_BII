package aaBusinessLogic.aaEntities.aaHormigas;
//import aaBusinessLogic.aaFactoryBL;
//import aaDataAccess.aaDAOs.HormigaDAO;
//import aaDataAccess.aaDTOs.HormigaDTO;
import aaBusinessLogic.aaInterfaces.IaaHormiga;

public abstract class aaHormiga implements IaaHormiga {
    protected boolean viva = true;
    public boolean estaViva() {
        return viva;
    }

    protected void morir() {
        this.viva = false;
    }
    
    @Override
    public Boolean aasupervolar() {
        return false; // solo algunas hormigas luego
    }

    //protected aaFactoryBL<HormigaDTO> aafactory = new aaFactoryBL<>(HormigaDAO.class);
    //public HormigaDTO data = new HormigaDTO();

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
