package aaBusinessLogic.aaInterfaces;

import aaBusinessLogic.aaEntities.aaAlimento.aaAlimento;
import aaBusinessLogic.aaEntities.aaHormigas.aaHormiga;

import java.util.List;

public interface IaaEntomologo {
    public List<aaHormiga> etlAntNest();
    public List<aaAlimento> etlAntFood();
    public aaHormiga atlAlimentarAnt(aaHormiga hormiga, aaAlimento alimento);

    
}