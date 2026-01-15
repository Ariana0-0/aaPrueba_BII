package aaBusinessLogic.aaEntities;

public abstract class aaGenoAlimento {
    private String tipo;
    
    public aaGenoAlimento(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
}
