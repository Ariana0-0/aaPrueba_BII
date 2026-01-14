package aaBusinessLogic.aaEntities;

import java.util.List;

import aaDataAccess.aaDTOs.HormigaDTO;
import aaInfrastructure.AppException;

public class aaHLarva extends aaHormiga {

    public HormigaDTO getLava(int id) throws AppException{
        data = aafactory.getBy(id);
        return data;
    }
    
    public List<HormigaDTO> getLarvas() throws AppException {
        return aafactory.getAll();
    }
    
    public aaHormiga comer(String comida) {
        if (comida.equals("carne")) {
            return new aaHSoldado();
        }
        return this;
    }

    @Override
    public String toString() {
        return "HLarva {}";
    }
}
