package aaBusinessLogic.aaEntities.aaHormigas;

import aaBusinessLogic.aaEntities.aaAlimento.aaAlimento;
import aaBusinessLogic.aaEntities.aaAlimento.aaOmnivoro;

public class aaHZangano  extends aaHormiga {
    @Override
    public Boolean aacomer(aaAlimento alimento) {
        if (alimento == null) {
            morir();
            return false;
        }
        if (alimento instanceof aaOmnivoro) {
            return true;
        } else {
            morir();
            return false;
        }
    }
    @Override
    public String toString() {
        return "HZangano";
    }
}
