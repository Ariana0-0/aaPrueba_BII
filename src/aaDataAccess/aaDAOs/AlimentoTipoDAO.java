package aaDataAccess.aaDAOs;

import aaDataAccess.aaDTOs.AlimentoTipoDTO;
import aaDataAccess.aaHelpers.DataHelperSQLiteDAO;
import aaInfrastructure.AppException;

public class AlimentoTipoDAO extends DataHelperSQLiteDAO<AlimentoTipoDTO>{
    public AlimentoTipoDAO() throws AppException {
        super(AlimentoTipoDTO.class, "AlimentoTipo", "IdAlimentoTipo");
    }
}
