package aaBusinessLogic.aaEntities.aaAlimento;

import aaBusinessLogic.aaEntities.aaGenoAlimento;
import aaBusinessLogic.aaInterfaces.IaaIngestaNativa;

public class aaCarnivoro extends aaAlimento implements IaaIngestaNativa {

    private aaGenoAlimento genoma;

    public aaCarnivoro() {
        super("carne");
    }

    @Override
    public void aainyectar(aaGenoAlimento genoma) {
        this.genoma = genoma;
    }

    public aaGenoAlimento getGenoma() {
        return genoma;
    }
}
