import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class DijkstraSearch<V> extends Search<V> {

    private Map<Vertex<V>, Double> distances = new HashMap<>();

    public DijkstraSearch(Vertex<V> source) {
        super(source);
        search(source);
    }

    @Override
    protected void search(Vertex<V> start) {
        distances.put(start, 0.0);
        parent.put(start, null);

        PriorityQueue<Vertex<V>> pq = new PriorityQueue<>(
            Comparator.comparingDouble(v -> distances.getOrDefault(v, Double.MAX_VALUE))
        );
        pq.add(start);

        while (!pq.isEmpty()) {
            Vertex<V> current = pq.poll();

            if (visited.contains(current)) continue;
            visited.add(current);

            double currentDist = distances.getOrDefault(current, Double.MAX_VALUE);

            for (Map.Entry<Vertex<V>, Double> entry : current.getAdjacentVertices().entrySet()) {
                Vertex<V> neighbor = entry.getKey();
                double newDist = currentDist + entry.getValue();

                if (newDist < distances.getOrDefault(neighbor, Double.MAX_VALUE)) {
                    distances.put(neighbor, newDist);
                    parent.put(neighbor, current);
                    pq.add(neighbor);
                }
            }
        }
    }

    public double getDistanceTo(Vertex<V> destination) {
        return distances.getOrDefault(destination, Double.MAX_VALUE);
    }
}
