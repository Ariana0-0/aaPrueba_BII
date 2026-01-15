package aaBusinessLogic.aaEntities;

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
