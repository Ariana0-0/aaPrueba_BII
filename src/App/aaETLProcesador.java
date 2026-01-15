package App;

import aaBusinessLogic.aaLector;
import aaBusinessLogic.aaEntities.aaAlimento.*;
import aaBusinessLogic.aaEntities.aaHormigas.*;
//import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;

public class aaETLProcesador {
    private aaLoading spinner = new aaLoading(20);

    private static final String[] TIPOS_HORMIGA = {
        "HLARVA", "HZANGANO", "HSOLDADO", "HREINA", "HOBRERA", "HRASTREADORA"
    };

    public List<aaHormiga> extraerHormigas(String ruta) {
        List<String> lineas = aaLector.leerHormigas(ruta);
        List<aaHormiga> hormigas = new ArrayList<>();

        for (String linea : lineas) {
            boolean encontrado = false;
            for (String tipo : TIPOS_HORMIGA) {
                if (linea.contains(tipo)) {
                    aaHormiga h = crearHormiga(tipo);
                    if (h != null) {
                        spinner.mostrar();
                        System.out.println("\u001B[34m[OK HORMIGA] " + tipo + "\u001B[0m");
                        hormigas.add(h);
                        encontrado = true;
                    }
                }
            }
            if (!encontrado) {
                spinner.mostrar();
                System.out.println("\u001B[31m[ERROR HORMIGA] " + linea + "\u001B[0m");
            }
        }

        return hormigas;
    }

    public List<aaAlimento> extraerAlimentos(String ruta) {
        List<String> datosCrudos = aaLector.leerAlimentos(ruta);
        List<aaAlimento> alimentos = new ArrayList<>();

        for (String linea : datosCrudos) {
            aaAlimento a = crearAlimento(linea);
            if (a != null) {
                spinner.mostrar();
                System.out.println("\u001B[34m[OK ALIMENTO OBJETO] " + linea + "\u001B[0m");
                alimentos.add(a);
            } else {
                spinner.mostrar();
                System.out.println("\u001B[31m[ERROR CREANDO ALIMENTO] " + linea + "\u001B[0m");
            }
        }
        return alimentos;
    }

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
            case "NECTARIVOROS": return new aaNectarivoros();
            case "OMNIVORO": return new aaOmnivoro();
            case "CARNIVORO": return new aaCarnivoro();
            case "HERBIVORO": return new aaHerbivoro();
            case "INSECTIVORO": return new aaInsectivoro();
            default: return null;
        }
    }
}
