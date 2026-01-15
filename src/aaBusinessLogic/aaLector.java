package aaBusinessLogic;

import java.io.*;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;

//Refactorizacion se creo esta clase y ya no se hace en la interfaz directamente

public class aaLector {

    private static String limpiar(String raw) {
        return Normalizer.normalize(raw, Normalizer.Form.NFD)
                .replaceAll("\\p{InCombiningDiacriticalMarks}+", "")
                .replaceAll("[^A-Za-z]", "")
                .trim()
                .toUpperCase();
    }

    public static List<String> leerHormigas(String ruta) {
        List<String> hormigas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream(ruta), "UTF-8"))) {

            String linea;
            while ((linea = br.readLine()) != null) {
                String[] tokens = linea.split("[-\\s]+");
                for (String t : tokens) {
                    if (t == null || t.trim().isEmpty()) continue;
                    String limpio = limpiar(t);
                    if (!limpio.isEmpty()) {
                        hormigas.add(limpio);
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return hormigas;
    }

    public static List<String> leerAlimentos(String ruta) {
        List<String> alimentos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream(ruta), "UTF-8"))) {

            String linea;
            while ((linea = br.readLine()) != null) {
                // separa por guiones o espacios
                String[] tokens = linea.split("[-\\s]+");
                for (String t : tokens) {
                    if (t == null || t.trim().isEmpty()) continue;

                    String limpio = limpiar(t);

                    if (!limpio.isEmpty() &&
                        (limpio.contains("NECTARIVORO") || limpio.contains("OMNIVORO") ||
                         limpio.contains("CARNIVORO") || limpio.contains("HERBIVORO") ||
                         limpio.contains("INSECTIVORO"))) {

                        alimentos.add(limpio);
                    } else {
                        System.out.println("\u001B[31m[ALIMENTO NO VALIDO] " + t + "\u001B[0m");
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return alimentos;
    }
}
