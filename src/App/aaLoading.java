package App;

public class aaLoading {
private char[] spin = {'|', '/', '-', '\\'};    
private int velocidad; // en milisegundos

    public aaLoading(int velocidad) {
        this.velocidad = velocidad; // por ejemplo 50
    }

    public void mostrar() {
        int j = 0;
        try {
            // mini-loading de 10 pasos
            for (int i = 0; i < 10; i++) {
                if (j == 3) j = 0;
                System.out.print(spin[j] + "\r"); // solo la letra
                j++;
                Thread.sleep(velocidad);
            }
            System.out.print("o  \r"); // deja la 'o' al final
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    
}
