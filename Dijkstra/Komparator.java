import java.util.Comparator;

public class Komparator implements Comparator<Edge> {

    @Override
    public int compare(Edge o1, Edge o2) {
        return Integer.compare(o1.getKoszt(), o2.getKoszt());
    }
}
