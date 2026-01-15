package aaBusinessLogic.aaEntities;
import aaBusinessLogic.aaInterfaces.IaaEntomologo;
import aaBusinessLogic.aaEntities.aaAlimento;
import aaBusinessLogic.aaEntities.aaGenoAlimento;

public abstract class aaEntomologo implements IaaEntomologo {
    public aaAlimento preparar(aaAlimento alimento){

        System.out.println("[Preparado]---< tipo: " + alimento.getTipo() + ">");
        return alimento;
    }
}
