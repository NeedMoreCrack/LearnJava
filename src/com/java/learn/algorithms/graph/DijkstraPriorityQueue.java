package com.java.learn.algorithms.graph;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstraPriorityQueue {
    public static void main(String[] args) {
        Vertex v1 = new Vertex("v1");
        Vertex v2 = new Vertex("v2");
        Vertex v3 = new Vertex("v3");
        Vertex v4 = new Vertex("v4");
        Vertex v5 = new Vertex("v5");
        Vertex v6 = new Vertex("v6");

        v1.edges = List.of(
                new Edge(v3,9),
                new Edge(v2,7),
                new Edge(v6,14)
        );
        v2.edges = List.of(new Edge(v4,15));
        v3.edges = List.of(
                new Edge(v4,11),
                new Edge(v6,2)
        );
        v4.edges = List.of(new Edge(v5,6));
        v5.edges = List.of();
        v6.edges = List.of(new Edge(v5,9));

        List<Vertex> graph = List.of(v1, v2, v3, v4, v5, v6);

        dijkstra(graph,v1);
    }

    public static void dijkstra(List<Vertex> graph,Vertex start) {
        PriorityQueue<Vertex> pq = new PriorityQueue<>(Comparator.comparingInt(v -> v.dist));
        start.dist = 0;
        for (Vertex v : graph) {
            pq.offer(v);
        }
        while (!pq.isEmpty()) {
            Vertex curr = pq.peek();
            updateNeighboursDist(curr,pq);
            pq.poll();
            curr.visited = true;
        }
        for (Vertex v : graph) {
            System.out.println(v.name+" "+v.dist+" "+(v.prev != null ? v.prev.name : "null"));
        }
    }

    public static void updateNeighboursDist(Vertex curr, PriorityQueue<Vertex> pq) {
        for (Edge edge : curr.edges) {
            Vertex linked = edge.linked;
            if(!linked.visited) {
                int dist = curr.dist + edge.weight;
                if(dist < linked.dist) {
                    linked.dist = dist;
                    linked.prev = curr;
                    pq.offer(linked);
                }
            }
        }
    }
}
