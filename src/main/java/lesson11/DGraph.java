package lesson11;

import java.util.*;

public class DGraph {

    private final Map<Vertex, List<Vertex>> adjVertices;

    public DGraph() {
        adjVertices = new HashMap<>();
    }

    @SuppressWarnings("unused")
    public List<Vertex> getAdjVertices(Vertex vertex) {
        return adjVertices.get(vertex);
    }

    public void addVertex(int n) {
        Vertex v = new Vertex(n);
        adjVertices.putIfAbsent(v, new ArrayList<>());
    }

    @SuppressWarnings("unused")
    public void removeVertex(int n) {
        Vertex v = new Vertex(n);
        adjVertices.values().forEach(e -> e.remove(v));
        adjVertices.remove(v);
    }

    public void addEdge(int n1, int n2) {
        Vertex v1 = new Vertex(n1);
        Vertex v2 = new Vertex(n2);

        adjVertices.get(v1).add(v2);
    }

    @SuppressWarnings("unused")
    public void removeEdge(int n1, int n2) {
        Vertex v1 = new Vertex(n1);
        List<Vertex> adjVert = adjVertices.get(n1);
        adjVert.remove(n2);
    }

    @Override
    public String toString() {
        return "DGraph{" +
                "adjVertices=" + adjVertices +
                '}';
    }

    public static void main(String[] args) {
        DGraph dGraph = new DGraph();
        dGraph.addVertex(0);
        dGraph.addVertex(1);
        dGraph.addEdge(0, 1);

        System.out.println(dGraph);
        System.out.println(dGraph.foundCycle());
    }

    public boolean foundCycle() {
        for (Map.Entry<Vertex, List<Vertex>> vertex : adjVertices.entrySet()) {
            Set<Vertex> visited = new HashSet<>();
            Stack<Vertex> stack = new Stack<>();
            stack.push(vertex.getKey());
            if (dfsCycle(stack, visited)) {
                return true;
            }
        }

        return false;
    }

    private boolean dfsCycle(final Stack<Vertex> stack, final Set<Vertex> visited) {
        if (stack.isEmpty()) {
            return false;
        }

        Vertex v = stack.pop();
        if (visited.contains(v)) {
            return true;
        }

        adjVertices.get(v).forEach(stack::push);
        visited.add(v);

        return dfsCycle(stack, visited);
    }
}
