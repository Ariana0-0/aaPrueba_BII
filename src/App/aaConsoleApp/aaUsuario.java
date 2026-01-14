package App.aaConsoleApp;

public class aaUsuario {
    private String usuario;
    private String clave;

    public aaUsuario() {
    }
    public aaUsuario(String usuario, String clave) {
        this.usuario = usuario;
        this.clave = clave;
    }
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

}
