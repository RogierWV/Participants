import java.util.ArrayList;

public class Storage {
    private static Storage instance;
    private ArrayList<Participation> list;
    private Storage() {
        list = new ArrayList<>();
    }

    public boolean add(Participation participation) {
        return list.add(participation);
    }

    public static Storage getInstance() {
        if(instance == null) instance = new Storage();
        return instance;
    }

    public Participation[] toArray() {
        return (Participation[]) list.toArray();
    }
}
