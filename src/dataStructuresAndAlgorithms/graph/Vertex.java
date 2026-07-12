package dataStructuresAndAlgorithms.graph;

import java.util.List;

public class Vertex {
    String name;
    List<Edge> edges;
    boolean visited;
    int dist = INFINITY;

    static final Integer INFINITY = Integer.MAX_VALUE;

    public Vertex(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
