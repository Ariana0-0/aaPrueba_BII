package aaBusinessLogic.aaEntities;

public class aaHObrera  extends aaHormiga {
    @Override
    public Boolean aacomer(aaAlimento alimento) {
        if (alimento == null) {
            morir();
            return false;
        }
        if (alimento instanceof aaHerbivoro) {
            return true;
        } else {
            morir();
            return false;
        }
    }
    @Override
    public String toString() {
        return "HObrera {}";
    }
}
