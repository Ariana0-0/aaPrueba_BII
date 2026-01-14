package App;
import java.util.Scanner;
import App.aaConsoleApp.aaUsuario;

public class aacontollerUsuario {
    private static final int aaIntentos = 3;
    public boolean validarUsuario() {
        aaUsuario user = new aaUsuario("patmic", "123");
        Scanner sc = new Scanner(System.in);
        int intentos = aaIntentos;
        while (intentos > 0) {
            System.out.print("Ingrese usuario: ");
            String usuarioInput = sc.nextLine();
            System.out.print("Ingrese clave: ");
            String claveInput = sc.nextLine();
            if (user.getUsuario().equals(usuarioInput) && user.getClave().equals(claveInput)) {
                System.out.println("Acceso concedido. ¡Bienvenido  !");
            
                System.out.println("Nombres: Ariana  Alomoto"+
                                "\n          Josue Astudillo");
                System.out.println("Cédula : 1726965542"+
                                "\n          1751455096");
                return true;
            } else {
                intentos--;
                System.out.println("Credenciales incorrectas. Le quedan " + intentos + " intentos.");
            }
        }
        System.out.println("Ha excedido el número de intentos. Acceso denegado.");
        return false;
    }
}
    
    
