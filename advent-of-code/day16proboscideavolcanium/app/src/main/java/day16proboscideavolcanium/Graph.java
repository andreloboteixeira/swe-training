package day16proboscideavolcanium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Collectors;

public class Graph {
    private List<String> vertexesLabels;
    private Map<String, Integer> vertexesFlow;
    private Map<String, Boolean> vertexesOpen;

    private List<List<Integer>> adjMatrix;
    private Map<Vertex, List<Vertex>> adjList;

    Graph() {
        this.vertexesLabels = new ArrayList<>();
        this.vertexesFlow = new HashMap<String, Integer>();

        this.vertexesOpen = new HashMap<String, Boolean>();

        this.adjMatrix = new ArrayList<>();
        this.adjList = new HashMap<Vertex, List<Vertex>>();

    }

    void addVertex(String label, Integer flowRate) {
        Vertex vertex = new Vertex(label);
//        vertex.setFlowRate(flowRate);

        this.vertexesLabels.add(label);

        adjList.putIfAbsent(vertex, new ArrayList<>());
        adjMatrix.add(new ArrayList<>());

        vertexesFlow.put(label, flowRate);
        vertexesOpen.put(label, false);
    }

    void addEdge(String label1, String label2) {
        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);

        // update adj list
        adjList.get(v1).add(v2);
//        adjList.get(v2).add(v1);

        // update adj matrix
        Integer v1Index = this.vertexesLabels.indexOf(label1);
        Integer v2Index = this.vertexesLabels.indexOf(label2);
        adjMatrix.get(v1Index).add(v2Index);
//        adjMatrix.get(v2Index).add(v1Index);

    }

    public List<List<Integer>> getAdjMatrix(){
        return this.adjMatrix;
    }

    // function to print the shortest distance and path
    // between source vertex and destination vertex
    public List<String> findShortestPath(int s, int dest)
    {
        int v = this.vertexesLabels.size();
        // predecessor[i] array stores predecessor of
        // i and distance array stores distance of i
        // from s
        int pred[] = new int[v];
        int dist[] = new int[v];

        if (BFS(this.adjMatrix, s, dest, v, pred, dist) == false) {
            System.out.println("Given source and destination" +
                    "are not connected");
            return new ArrayList<>();
        }

        // List to store path
        List<Integer> path = new ArrayList<Integer>();
        int crawl = dest;
        path.add(crawl);
        while (pred[crawl] != -1) {
            path.add(pred[crawl]);
            crawl = pred[crawl];
        }

        // Print distance
        System.out.println("Shortest path length is: " + dist[dest]);

        // Print path
        System.out.println("Path is ::");
        for (int i = 0; i < path.size(); i++) {
            System.out.println(path.get(i) + " ");
        }

        Collections.reverse(path);

        return path.stream().filter(index -> index != 0).map(index -> this.vertexesLabels.get(index)).collect(Collectors.toList());
    }

    // a modified version of BFS that stores predecessor
    // of each vertex in array pred
    // and its distance from source in array dist
    private boolean BFS(List<List<Integer>> adj, int src,
                               int dest, int v, int pred[], int dist[])
    {
        // a queue to maintain queue of vertices whose
        // adjacency list is to be scanned as per normal
        // BFS algorithm using LinkedList of Integer type
        LinkedList<Integer> queue = new LinkedList<Integer>();

        // boolean array visited[] which stores the
        // information whether ith vertex is reached
        // at least once in the Breadth first search
        boolean visited[] = new boolean[v];

        // initially all vertices are unvisited
        // so v[i] for all i is false
        // and as no path is yet constructed
        // dist[i] for all i set to infinity
        for (int i = 0; i < v; i++) {
            visited[i] = false;
            dist[i] = Integer.MAX_VALUE;
            pred[i] = -1;
        }

        // now source is first to be visited and
        // distance from source to itself should be 0
        visited[src] = true;
        dist[src] = 0;
        queue.add(src);

        // bfs Algorithm
        while (!queue.isEmpty()) {
            int u = queue.remove();
            for (int i = 0; i < adj.get(u).size(); i++) {
                if (visited[adj.get(u).get(i)] == false) {
                    visited[adj.get(u).get(i)] = true;
                    dist[adj.get(u).get(i)] = dist[u] + 1;
                    pred[adj.get(u).get(i)] = u;
                    queue.add(adj.get(u).get(i));

                    // stopping condition (when we find
                    // our destination)
                    if (adj.get(u).get(i) == dest)
                        return true;
                }
            }
        }
        return false;
    }

    public List<String> getVertexesLabels(){
        return this.vertexesLabels;
    }

    public Integer getVertexFlowRate(String label){
        return vertexesFlow.get(label);
    }

    public void setVertexFlowRate(String label, Integer newFlowRate){
        if(newFlowRate == 0){
            vertexesOpen.put(label, true);
        }

        vertexesFlow.put(label, newFlowRate);
    }

    public Boolean getVertexIsOpen(String label){
        return vertexesOpen.get(label);
    }

    public Boolean setVertexIsOpen(String label, Boolean open){
        return vertexesOpen.put(label, open);
    }


    List<Vertex> getAdjVertices(String label) {
        return adjList.get(new Vertex(label));
    }


    class Vertex {
        String label;

        Vertex(String label) {
            this.label = label;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + getOuterType().hashCode();
            result = prime * result + ((label == null) ? 0 : label.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Vertex other = (Vertex) obj;
            if (!getOuterType().equals(other.getOuterType()))
                return false;
            if (label == null) {
                if (other.label != null)
                    return false;
            } else if (!label.equals(other.label))
                return false;
            return true;
        }

        @Override
        public String toString() {
            return label;
        }


        private Graph getOuterType() {
            return Graph.this;
        }
    }

    String printGraph() {
        StringBuffer sb = new StringBuffer();
        for(Vertex v : adjList.keySet()) {
            sb.append(v.label);
            sb.append(" -> ");

            adjList.get(v).stream().forEach(edge -> sb.append(edge.label + " "));
            sb.append("\n");
        }
        return sb.toString();
    }
}