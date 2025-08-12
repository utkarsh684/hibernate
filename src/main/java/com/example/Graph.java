package com.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph {

    public boolean isCycle(List<Integer>[] adj, int V){
        boolean[] vis=new boolean[V];
        for(int i=0;i<adj.length;i++){
            if(vis[i]==false){
                if(detect(i,adj,V,vis)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean detect(int src,List<Integer>[] adj,int V,boolean[] vis){
        vis[src]=true;
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{src,-1});
        while(!q.isEmpty()){
            int[] curr=q.poll();
            int node=curr[0];
            int parent=curr[1];
            for(int neighbour:adj[node]){
                if(vis[neighbour]==false){
                    q.offer(new int[]{neighbour,node});
                }
                else if(neighbour!=parent){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int V = 5;  // Number of vertices
        List<Integer>[] adj = new ArrayList[V];

        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }

        // Add undirected edges (you can change this to test other graphs)
        addEdge(adj, 0, 1);
        addEdge(adj, 1, 2);
        addEdge(adj, 2, 3);
        addEdge(adj, 3, 4);
        addEdge(adj, 4, 1);  // This edge creates a cycle

        // Create an object of Solution and check for cycle
        Graph sol = new Graph();
        boolean hasCycle = sol.isCycle(adj,V);
        System.out.println("Cycle Detected: " + hasCycle);
    }

    static void addEdge(List<Integer>[] adj, int u, int v) {
        adj[u].add(v);
        adj[v].add(u);  // Because it's an undirected graph
    }

}
