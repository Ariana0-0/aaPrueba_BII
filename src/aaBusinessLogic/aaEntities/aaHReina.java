package aaBusinessLogic.aaEntities;

public class aaHReina  extends aaHormiga {
    @Override
    public Boolean aacomer(aaAlimento alimento) {
        if (alimento == null) {
            morir();
            return false;
        }
        if (alimento instanceof aaNectarivoros) {
            return true;
        } else {
            morir();
            return false;
        }
    }
    @Override
    public String toString() {
        return "HReina {}";
    }
}
