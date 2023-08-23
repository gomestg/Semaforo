package complex;

import java.util.HashMap;
import java.util.Map;

public enum Lights {
    RED("Red", 0, "Stop", 5000),
    GREEN("Green", 1, "Go", 4000),
    YELLOW("Yellow", 2, "Attention", 2000);

    private static final Map<Integer, Lights> BY_INDEX = new HashMap<>();

    static {
        for (Lights e : values()) {
            BY_INDEX.put(e.index, e);
        }
    }

    public final String color;
    public final int index;
    public final String message;
    public final int duration;

    Lights(String color, int index, String message, int duration) {
        this.color = color;
        this.index = index;
        this.message = message;
        this.duration = duration;
    }

    public static Lights valueOfIndex(int index){
        return BY_INDEX.get(index);
    }

}
