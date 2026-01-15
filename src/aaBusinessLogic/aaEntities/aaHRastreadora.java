package aaBusinessLogic.aaEntities;

public class aaHRastreadora  extends aaHormiga {
    @Override
    public Boolean aacomer(aaAlimento alimento) {
        if (alimento == null) {
            morir();
            return false;
        }
        if (alimento instanceof aaInsectivoro) {
            return true;
        } else {
            morir();
            return false;
        }
    }
    @Override
    public String toString() {
        return "HRastreadora {}";
    }
}
