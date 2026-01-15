package aaBusinessLogic.aaEntities;
import aaBusinessLogic.aaEntities.aaAlimento.*;
import aaBusinessLogic.aaEntities.aaHormigas.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// Tefactorización

public class aaAlimentarHormiga {

    private Random random = new Random();

    public void alimentarHormigas(List<aaHormiga> hormigas, List<aaAlimento> alimentos) {

        List<aaHormiga> vivas = new ArrayList<>();
        List<aaHormiga> muertas = new ArrayList<>();

        System.out.println("[INFO] Total de alimentos encontrados en archivo: " + alimentos.size());

        for (aaHormiga h : hormigas) {
            if (!h.estaViva()) continue;

            aaAlimento alimentoElegido = buscarAlimentoValido(h, alimentos);

            if (alimentoElegido == null) {
                h.aacomer(null); // muere
                System.out.println("[MUERE] " + h + " no encontró alimento válido.");
                muertas.add(h);
                continue;
            }

            if (alimentoElegido instanceof aaOmnivoro) {
                String sexo = generarSexoAleatorio();
                System.out.println("[INFO] Omnívoro modificado, sexo: " + sexo);

                if (sexo.equals("XX")) {
                    activarSuperVolar(h);
                }
            }

            boolean comio = h.aacomer(alimentoElegido);

            if (comio) {
                System.out.println("[COMIO] " + h + " consumió " + alimentoElegido.getTipo());
                vivas.add(h);
            } else {
                System.out.println("[MUERE] " + h + " comió alimento incorrecto: " + alimentoElegido.getTipo());
                muertas.add(h);
            }
        }

        System.out.println("\n===== RESUMEN =====");
        System.out.println("Hormigas vivas: " + vivas.size());
        System.out.println("Hormigas muertas: " + muertas.size());
        System.out.println("===================");
    }

    private aaAlimento buscarAlimentoValido(aaHormiga hormiga, List<aaAlimento> alimentos) {
        for (aaAlimento a : alimentos) {
            if (hormiga.aacomer(a)) {
                return a;
            }
        }
        return null;
    }

    private String generarSexoAleatorio() {
         String[] sexos = {"X", "XX", "XY"}; // agregamos "X"
         int index = (int)(Math.random() * sexos.length);
         return sexos[index];
    }

    private void activarSuperVolar(aaHormiga h) {
        System.out.println("[SUPER HABILIDAD ACTIVADA] " + h + " puede volar!");
    }
}
