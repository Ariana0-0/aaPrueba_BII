package App;

import java.util.List;
import java.util.Scanner;

import App.aaConsoleApp.aaUsuario;
import aaBusinessLogic.aaEntities.aaAlimentarHormiga;
import aaBusinessLogic.aaEntities.aaAlimento.*;
import aaBusinessLogic.aaEntities.aaHormigas.*;

//Refactorización se agrego esta clase

public class aaControllerUsuario {

    private static final int aaMaxIntentos = 3;

    public boolean validarUsuario(aaUsuario user) {
        Scanner sc = new Scanner(System.in);
        int aaintentos = aaMaxIntentos;

        while (aaintentos > 0) {
            System.out.print("Ingrese usuario: ");
            String usuarioInput = sc.nextLine();

            System.out.print("Ingrese clave: ");
            String claveInput = sc.nextLine();

            if (user.getUsuario().equals(usuarioInput) && user.getClave().equals(claveInput)) {
                System.out.println("Acceso concedido. ¡Bienvenido!");
                System.out.println("Nombres: Ariana  Alomoto\n          Josue Astudillo");
                System.out.println("Cédula : 1726965542\n          1751455096");
                String base = System.getProperty("user.dir");

                String rutaHormigas = base + "\\storage\\aaDataFiles\\AntNest.txt";
                String rutaAlimentos = base + "\\storage\\aaDataFiles\\AntFood.txt";
                
                aaETLProcesador etl = new aaETLProcesador();
                
                List<aaHormiga> hormigas = etl.extraerHormigas(rutaHormigas);
                List<aaAlimento> alimentos = etl.extraerAlimentos(rutaAlimentos);
                aaAlimentarHormiga gestor = new aaAlimentarHormiga();
                gestor.alimentarHormigas(hormigas, alimentos);


                return true;
            } else {
                aaintentos--;
                System.out.println("Credenciales incorrectas. Le quedan " + aaintentos + " intentos.");
            }
        }

        System.out.println("Ha excedido el número de intentos. Acceso denegado.");
        return false;
    }
}
