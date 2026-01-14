package aaDataAccess.aaDAOs;

import aaDataAccess.aaDTOs.SexoDTO;
import aaDataAccess.aaHelpers.DataHelperSQLiteDAO;
import aaInfrastructure.AppException;

public class SexoDAO extends DataHelperSQLiteDAO<SexoDTO>{
    public SexoDAO() throws AppException {
        super(SexoDTO.class, "Sexo", "IdSexo");
    }
}
