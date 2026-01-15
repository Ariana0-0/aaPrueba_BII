package aaBusinessLogic;

import java.io.*;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;

public class aaLector {

    // Limpia y normaliza cada token
    private static String limpiar(String raw) {
        return Normalizer.normalize(raw, Normalizer.Form.NFD)
                .replaceAll("\\p{InCombiningDiacriticalMarks}+", "") // quita acentos
                .replace("-", "")
                .replace(",", "")
                .trim()
                .toUpperCase();
    }

    // Lee archivo de hormigas
    public static List<String> leerHormigas(String ruta) {
        List<String> hormigas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] tokens = linea.split("\\s+"); // separa por espacios
                for (String t : tokens) {
                    String limpio = limpiar(t);
                    if (!limpio.isEmpty()) hormigas.add(limpio);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hormigas;
    }

    // Lee archivo de alimentos
    public static List<String> leerAlimentos(String ruta) {
        List<String> alimentos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] tokens = linea.split("\\s+|-"); // separa por espacios y guiones
                for (String t : tokens) {
                    String limpio = limpiar(t);
                    // Solo agrega si es un alimento válido
                    if (!limpio.isEmpty() &&
                        (limpio.contains("NECTARIVORO") || limpio.contains("OMNIVORO") ||
                         limpio.contains("CARNIVORO") || limpio.contains("HERBIVORO") ||
                         limpio.contains("INSECTIVORO"))) {
                        alimentos.add(limpio);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return alimentos;
    }
}
