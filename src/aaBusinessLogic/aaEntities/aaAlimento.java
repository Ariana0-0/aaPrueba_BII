package aaBusinessLogic.aaEntities;

public abstract class aaAlimento {
    private String tipo;

    public aaAlimento(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
}
