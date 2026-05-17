import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch<V> extends Search<V> {

    public BreadthFirstSearch(Vertex<V> source) {
        super(source);
        search(source);
    }

    @Override
    protected void search(Vertex<V> start) {
        Queue<Vertex<V>> queue = new LinkedList<>();
        visited.add(start);
        parent.put(start, null);
        queue.add(start);

        while (!queue.isEmpty()) {
            Vertex<V> current = queue.poll();
            for (Vertex<V> neighbor : current.getAdjacentVertices().keySet()) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    parent.put(neighbor, current);
                    queue.add(neighbor);
                }
            }
        }
    }
}
