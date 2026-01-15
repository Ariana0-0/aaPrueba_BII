package aaBusinessLogic.aaEntities;
import java.util.Iterator;
import java.util.List;
import aaBusinessLogic.aaInterfaces.IaaEntomologo;
import aaBusinessLogic.aaEntities.aaAlimento;
import aaBusinessLogic.aaEntities.aaGenoAlimento;

public abstract class aaEntomologo implements IaaEntomologo {
    protected List<aaHormiga> AntNest;
    protected List<aaAlimento> AntFood;

    public aaAlimento preparar(aaAlimento alimento) {
        System.out.println("[Preparado]---< tipo: " + alimento.getTipo() + " >");
        return alimento;
    }
}
