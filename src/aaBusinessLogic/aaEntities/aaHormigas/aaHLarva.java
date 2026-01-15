package aaBusinessLogic.aaEntities.aaHormigas;

//import aaDataAccess.aaDTOs.HormigaDTO;
//import aaInfrastructure.AppException;

import aaBusinessLogic.aaEntities.aaAlimento.aaAlimento;
import aaBusinessLogic.aaEntities.aaAlimento.aaNectarivoros;

public class aaHLarva extends aaHormiga {

    

    @Override
    public Boolean aacomer(aaAlimento alimento) {

    if (alimento == null) {
        morir();
        return false;
    }
    if (alimento instanceof aaNectarivoros) {
        return true;
    } else {
        morir();
        return false;
    }

    }
    @Override
    public String toString() {
        return "HLarva {}";
    }
}

//public HormigaDTO getLava(int id) throws AppException{
    //    data = aafactory.getBy(id);
    //    return data;
    //}
    //
    //public List<HormigaDTO> getLarvas() throws AppException {
    //    return aafactory.getAll();
    //}
    //
    //public aaHormiga comer(String comida) {
    //    if (comida.equals("carne y vegetales")) {
    //        return new aaHSoldado();
    //    }
    //    return this;
    //}