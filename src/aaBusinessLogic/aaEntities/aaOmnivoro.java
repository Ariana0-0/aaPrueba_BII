package aaBusinessLogic.aaEntities;

import aaBusinessLogic.aaInterfaces.IaaIngestaNativa;

public class aaOmnivoro extends aaAlimento implements IaaIngestaNativa {
    private aaGenoAlimento genoma;

    public aaOmnivoro() {
        super("carne y hierba");
    }
    @Override
    public void aainyectar(aaGenoAlimento genoma) {
        this.genoma = genoma;
    }

    public aaGenoAlimento getGenoma() {
        return genoma;
    }
    
}
