package lesson11;

import java.util.List;

public class Solution {

    public static boolean canFinish(List<int[]> input) {
        DGraph dGraph = build(input);

        return !dGraph.foundCycle();
    }

    private static DGraph build(List<int[]> input) {
        if (input == null) {
            return null;
        }

        DGraph dGraph = new DGraph();

        for (int[] edge : input) {
            dGraph.addVertex(edge[0]);
            dGraph.addVertex(edge[1]);
            dGraph.addEdge(edge[0], edge[1]);
        }

        return dGraph;
    }
}
