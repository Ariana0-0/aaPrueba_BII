package aaBusinessLogic.aaEntities;

import aaDataAccess.aaDTOs.HormigaDTO;
import aaInfrastructure.AppException;
import java.util.List;

public class aaHLarva extends aaHormiga {

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