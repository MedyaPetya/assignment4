import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class Search<V> {

    protected Vertex<V> source;
    protected Set<Vertex<V>> visited;
    protected Map<Vertex<V>, Vertex<V>> parent;

    public Search(Vertex<V> source) {
        this.source = source;
        this.visited = new HashSet<>();
        this.parent = new HashMap<>();
    }

    protected abstract void search(Vertex<V> start);

    public boolean hasPathTo(Vertex<V> destination) {
        return visited.contains(destination);
    }

    public List<Vertex<V>> pathTo(Vertex<V> destination) {
        if (!hasPathTo(destination)) {
            return null;
        }

        List<Vertex<V>> path = new ArrayList<>();
        for (Vertex<V> v = destination; v != null; v = parent.get(v)) {
            path.add(v);
        }
        Collections.reverse(path);
        return path;
    }
}
