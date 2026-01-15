package aaBusinessLogic.aaEntities.aaHormigas;

import aaBusinessLogic.aaEntities.aaAlimento.aaAlimento;
import aaBusinessLogic.aaEntities.aaAlimento.aaCarnivoro;

public class aaHSoldado  extends aaHormiga {
    @Override
    public Boolean aacomer(aaAlimento alimento) {
        if (alimento == null) {
            morir();
            return false;
        }
        if (alimento instanceof aaCarnivoro) {
            return true;
        } else {
            morir();
            return false;
        }
    }
    @Override
    public String toString() {
        return "HSoldado {}";
    }
}
