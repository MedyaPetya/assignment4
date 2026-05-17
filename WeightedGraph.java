import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeightedGraph<V> {

    private Map<Vertex<V>, List<Vertex<V>>> map = new HashMap<>();

    public void addVertex(Vertex<V> vertex) {
        map.put(vertex, new ArrayList<>());
    }

    public void addEdge(Vertex<V> source, Vertex<V> dest, double weight) {
        source.addAdjacentVertex(dest, weight);
        dest.addAdjacentVertex(source, weight);
        map.get(source).add(dest);
        map.get(dest).add(source);
    }

    public List<Vertex<V>> getNeighbors(Vertex<V> vertex) {
        return map.getOrDefault(vertex, new ArrayList<>());
    }
}
