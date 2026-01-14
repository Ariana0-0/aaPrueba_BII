package App.aaConsoleApp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import aaBusinessLogic.aaEntities.aaCoordenadaUK;

public class aaSistemaRuso {

    public List<aaCoordenadaUK> readCoord(String fileNamePath) throws IOException {
        List<aaCoordenadaUK> lstCoord = new java.util.ArrayList<>();
        List<String> allLines = Files.readAllLines(Paths.get(fileNamePath));
        for (String line : allLines) {
            System.out.println(line);
            String[] coord = line.split(",");
            aaCoordenadaUK coordenada = new aaCoordenadaUK( coord[0], coord[6], false);
            lstCoord.add(coordenada);
            //System.out.println( coordenada.toString() );
        }
        return lstCoord;
    }
}
