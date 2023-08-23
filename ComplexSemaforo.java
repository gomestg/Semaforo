package complex;

import java.util.concurrent.Semaphore;

public class ComplexSemaforo {

    private Semaphore[] lights;
    private boolean running = true;

    public Semaphore[] getLights() {
        return lights;
    }

    public void setLights(Semaphore[] lights) {
        this.lights = lights;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }


    public ComplexSemaforo(int numColors) {
        lights = new Semaphore[numColors];
        for (int i = 0; i < numColors; i++) {
            lights[i] = new Semaphore(0);
        }
    }

}
