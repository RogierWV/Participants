/**
 * Class for holding all data for participations
 */
public class Participation {
    private final String name;
    private final int h;
    private final int m;

    public Participation(String name, int h, int m) {
        this.name = name;
        this.h = h;
        this.m = m;
    }

    public String getName() {
        return name;
    }

    public int getH() {
        return h;
    }

    public int getM() {
        return m;
    }

    @Override
    public String toString() {
        return String.format("%s at %02d:%02d", name, h, m); // name at 00:00
    }
}
