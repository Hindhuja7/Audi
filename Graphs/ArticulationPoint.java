package Graphs;

import java.util.*;

public class ArticulationPoint {

    int V;
    ArrayList<ArrayList<Integer>> adj;
    int time = 0;

    // Constructor
    ArticulationPoint(int V) {
        this.V = V;
        adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    // Add edge (undirected)
    void addEdge(int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    // DFS function
    void dfs(int u, boolean[] visited, int[] disc, int[] low,
             int[] parent, boolean[] isAP) {

        visited[u] = true;
        disc[u] = low[u] = ++time;
        int children = 0;

        for (int v : adj.get(u)) {

            if (!visited[v]) {
                children++;
                parent[v] = u;

                dfs(v, visited, disc, low, parent, isAP);

                // update low value
                low[u] = Math.min(low[u], low[v]);

                // Case 2: Non-root node
                if (parent[u] != -1 && low[v] >= disc[u]) {
                    isAP[u] = true;
                }
            }

            // Back edge
            else if (v != parent[u]) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }

        // Case 1: Root node
        if (parent[u] == -1 && children > 1) {
            isAP[u] = true;
        }
    }

    // Function to find articulation points
    void findAP() {
        boolean[] visited = new boolean[V];
        int[] disc = new int[V];
        int[] low = new int[V];
        int[] parent = new int[V];
        boolean[] isAP = new boolean[V];

        Arrays.fill(parent, -1);

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, visited, disc, low, parent, isAP);
            }
        }

        System.out.println("Articulation Points:");
        for (int i = 0; i < V; i++) {
            if (isAP[i]) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    // Main function
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();

        System.out.print("Enter number of edges: ");
        int E = sc.nextInt();

        ArticulationPoint g = new ArticulationPoint(V);

        System.out.println("Enter edges:");
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            g.addEdge(u, v);
        }

        g.findAP();
    }
}