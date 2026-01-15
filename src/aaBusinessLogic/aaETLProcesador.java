package aaBusinessLogic;

import aaBusinessLogic.aaEntities.*;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import aaBusinessLogic.aaLector;

public class aaETLProcesador {

    private static final String[] TIPOS_HORMIGA = {
        "HLARVA", "HZANGANO", "HSOLDADO", "HREINA", "HOBRERA", "HRASTREADORA"
    };

    private static final String[] TIPOS_ALIMENTO = {
        "NECTARIVORO", "OMNIVORO", "CARNIVORO", "HERBIVORO", "INSECTIVORO"
    };

    /* ================== EXTRACT ================== */

    public List<aaHormiga> extraerHormigas(String ruta) {
        List<String> lineas = aaLector.leerHormigas(ruta);
        List<aaHormiga> hormigas = new ArrayList<>();

        for (String linea : lineas) {
            String limpio = limpiar(linea);

            // Buscar coincidencias de cada tipo de hormiga
            for (String tipo : TIPOS_HORMIGA) {
                int index;
                while ((index = limpio.indexOf(tipo)) != -1) {
                    aaHormiga h = crearHormiga(tipo);
                    if (h != null) {
                        System.out.println("\u001B[34m[OK HORMIGA] " + tipo + "\u001B[0m"); // azul
                        hormigas.add(h);
                    } else {
                        System.out.println("\u001B[31m[ERROR HORMIGA] " + tipo + "\u001B[0m"); // rojo
                    }
                    limpio = limpio.substring(index + tipo.length());
                }
            }

            // Si quedó algo que no coincide, mostrar error
            if (!limpio.isEmpty()) {
                System.out.println("\u001B[31m[ERROR HORMIGA] " + limpio + "\u001B[0m");
            }
        }

        return hormigas;
    }

public List<aaAlimento> extraerAlimentos(String ruta) {

    List<String> datosCrudos = aaLector.leerAlimentos(ruta);
    List<aaAlimento> alimentos = new ArrayList<>();

    for (String linea : datosCrudos) {
        // separar por guiones, comas o espacios
        String[] tokens = linea.split("[-,\\s]+");

        for (String t : tokens) {
            if (t.isEmpty()) continue;

            String limpio = limpiar(t); // elimina acentos, trim, mayúsculas

            aaAlimento a = crearAlimento(limpio);
            if (a != null) {
                System.out.println("\u001B[34m[OK ALIMENTO] " + limpio + "\u001B[0m");
                alimentos.add(a);
            } else {
                System.out.println("\u001B[31m[ERROR ALIMENTO] " + t + "\u001B[0m");
            }
        }
    }
    return alimentos;
}


    /* ================== LOAD ================== */


  

    /* ================== FACTORY ================== */

    private aaHormiga crearHormiga(String tipo) {
        switch (tipo) {
            case "HLARVA": return new aaHLarva();
            case "HZANGANO": return new aaHZangano();
            case "HSOLDADO": return new aaHSoldado();
            case "HREINA": return new aaHReina();
            case "HOBRERA": return new aaHObrera();
            case "HRASTREADORA": return new aaHRastreadora();
            default: return null;
        }
    }

    private aaAlimento crearAlimento(String tipo) {
        switch (tipo) {
            case "NECTARIVORO": return new aaNectarivoros();
            case "OMNIVORO": return new aaOmnivoro();
            case "CARNIVORO": return new aaCarnivoro();
            case "HERBIVORO": return new aaHerbivoro();
            case "INSECTIVORO": return new aaInsectivoro();
            default: return null;
        }
    }

    /* ================== LIMPIEZA ================== */

    private String limpiar(String raw) {
        // Normaliza acentos, quita guiones y espacios extra
        return Normalizer.normalize(raw, Normalizer.Form.NFD)
                .replaceAll("\\p{InCombiningDiacriticalMarks}+", "")
                .replaceAll("[^A-Za-z]", "")
                .trim()
                .toUpperCase();
    }
}
