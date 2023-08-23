package complex;

public class ComplexMain {

    static ComplexSemaforoImpl impl = new ComplexSemaforoImpl();

    public static void main(String[] args) {
        int numColors = Lights.values().length;
        ComplexSemaforo semaforo = new ComplexSemaforo(numColors);
        impl.start(semaforo);

        // Simular funcionamento por um tempo
        try {
            Thread.sleep(19000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        impl.stop(semaforo);
    }
}