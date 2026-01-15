package aaBusinessLogic.aaEntities;
import aaBusinessLogic.aaInterfaces.IaaIngestaNativa;
import aaBusinessLogic.aaEntities.aaAlimento.aaAlimento;
import aaBusinessLogic.aaEntities.aaSexos.aaX;
import aaBusinessLogic.aaEntities.aaSexos.aaXX;
import aaBusinessLogic.aaEntities.aaSexos.aaXY;

import java.util.Random;


public abstract class aaEtGenetista extends aaEntomologo {

    @Override
    public aaAlimento preparar(aaAlimento alimento) {

        aaGenoAlimento genoma = generarGenoAleatorio();

        if (alimento instanceof IaaIngestaNativa) {
            ((IaaIngestaNativa) alimento).aainyectar(genoma);
        }

        System.out.println("[Preparado]---< tipo: "
                + alimento.getTipo() + " + " + genoma.getTipo() + " >");

        return alimento;
    }

    private aaGenoAlimento generarGenoAleatorio() {
        Random rand = new Random();
        int opcion = rand.nextInt(3);

        switch (opcion) {
            case 0:
                return new aaX();
            case 1:
                return new aaXX();
            default:
                return new aaXY();
        }
    }
}