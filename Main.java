import java.util.List;

public class Main {

    public static void main(String[] args) {
        Vertex<String> almaty    = new Vertex<>("Almaty");
        Vertex<String> astana    = new Vertex<>("Astana");
        Vertex<String> shymkent  = new Vertex<>("Shymkent");
        Vertex<String> aktobe    = new Vertex<>("Aktobe");
        Vertex<String> karaganda = new Vertex<>("Karaganda");

        WeightedGraph<String> graph = new WeightedGraph<>();
        graph.addVertex(almaty);
        graph.addVertex(astana);
        graph.addVertex(shymkent);
        graph.addVertex(aktobe);
        graph.addVertex(karaganda);

        graph.addEdge(almaty,   astana,    1300);
        graph.addEdge(almaty,   shymkent,  700);
        graph.addEdge(astana,   karaganda, 200);
        graph.addEdge(astana,   aktobe,    900);
        graph.addEdge(shymkent, aktobe,    1200);
        graph.addEdge(shymkent, karaganda, 800);

        System.out.println("BFS from Almaty:");
        BreadthFirstSearch<String> bfs = new BreadthFirstSearch<>(almaty);
        System.out.println("To Astana: "    + bfs.pathTo(astana));
        System.out.println("To Aktobe: "    + bfs.pathTo(aktobe));
        System.out.println("To Karaganda: " + bfs.pathTo(karaganda));

        System.out.println("\nDijkstra from Almaty:");
        DijkstraSearch<String> dijkstra = new DijkstraSearch<>(almaty);
        System.out.println("To Astana: "    + dijkstra.pathTo(astana)    + " | " + dijkstra.getDistanceTo(astana)    + " km");
        System.out.println("To Aktobe: "    + dijkstra.pathTo(aktobe)    + " | " + dijkstra.getDistanceTo(aktobe)    + " km");
        System.out.println("To Karaganda: " + dijkstra.pathTo(karaganda) + " | " + dijkstra.getDistanceTo(karaganda) + " km");
    }
}
