package App;

//Refactorización creacion d ela clase que antes se contenia en el  Entomologo

public class aaLoading {
private char[] spin = {'|', '/', '-', '\\'};    
private int velocidad; 

    public aaLoading(int velocidad) {
        this.velocidad = velocidad; 
    }

    public void mostrar() {
        int j = 0;
        try {
            for (int i = 0; i < 10; i++) {
                if (j == 3) j = 0;
                System.out.print(spin[j] + "\r"); 
                j++;
                Thread.sleep(velocidad);
            }
            System.out.print("o  \r"); 
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    
}
