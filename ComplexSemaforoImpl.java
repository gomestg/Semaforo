package complex;

import java.util.concurrent.Semaphore;

public class ComplexSemaforoImpl {
    public void start(ComplexSemaforo semaforo) {
        System.out.println("Traffic light started.");

        var lights = semaforo.getLights();

        Thread[] colorThreads = new Thread[lights.length];
        for (int i = 0; i < lights.length; i++) {
            int nextColorIndex = (i + 1) % lights.length;
            Semaphore currentSemaphore = lights[i];
            Semaphore nextSemaphore = lights[nextColorIndex];

            Lights light = Lights.valueOfIndex(i);
            colorThreads[i] = new Thread(() -> {
                while (semaforo.isRunning()) {
                    try {
                        currentSemaphore.acquire();
                        displayColor(light);
                        Thread.sleep(light.duration);
                        nextSemaphore.release();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            });
            colorThreads[i].start();
        }
        lights[0].release(); // Inicialmente, permitir a primeira cor
    }

    private void displayColor(Lights light) {
        System.out.println(light.color.concat(" light: ").concat(light.message));
    }

    public void stop(ComplexSemaforo semaforo) {
        semaforo.setRunning(false);
        for (Semaphore semaphore : semaforo.getLights()) {
            semaphore.release();
        }
        System.out.println("Traffic light stopped.");
    }
}
