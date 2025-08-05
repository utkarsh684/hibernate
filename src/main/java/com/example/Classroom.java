package com.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Classroom {

    static class Edge{
        int src;
        int des;
       // int wt;

        public Edge(int s,int d){
            this.src=s;
            this.des=d;
            //this.wt=w;
        }
    }

//    public static void createGraph(ArrayList<Edge> graph[]){
//        for(int i=0;i<graph.length;i++){
//            graph[i]=new ArrayList<Edge>();
//        }
//
//        graph[0].add(new Edge(0,1,2));
//        graph[0].add(new Edge(0,2,2));
//
//        graph[1].add(new Edge(1,0,10));
//        graph[1].add(new Edge(1,3,0));
//
//        graph[2].add(new Edge(2,0,2));
//        graph[2].add(new Edge(2,4,10));
//
//        graph[3].add(new Edge(3,1,0));
//        graph[3].add(new Edge(3,4,-1));
//        graph[3].add(new Edge(3,5,-1));
//
//        graph[4].add(new Edge(4,2,-1));
//        graph[4].add(new Edge(4,3,-1));
//        graph[4].add(new Edge(4,5,-1));
//
//        graph[5].add(new Edge(5,3,-1));
//        graph[5].add(new Edge(5,4,-1));
//        graph[5].add(new Edge(5,6,-1));
//
//        graph[6].add(new Edge(6,5,-1));
//    }

    public static void createGraph2(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0,2));
        graph[1].add(new Edge(1,0));
        graph[2].add(new Edge(2,3));
        graph[3].add(new Edge(3,0));


    }

    public static boolean checkDirectedCycle(ArrayList<Edge> graph[],boolean[] vis,boolean[] recur,int curr){

        vis[curr]=true;
        recur[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(recur[e.des]){
                return true;
            }
            if(!vis[curr]){
                 if(checkDirectedCycle(graph,vis,recur,e.des)){
                     return true;
                 }
            }
        }
        recur[curr]=false;
        return false;
    }

    public static void bfs(ArrayList<Edge> graph[],int v,boolean[] vis,int start){
        Queue<Integer> q=new LinkedList<>();

        q.add(start);
        while(!q.isEmpty()){
            int curr=q.remove();
            if(!vis[curr]){
                System.out.print(curr+" ");
                vis[curr]=true;
                for(int i=0;i<graph[curr].size();i++){
                    Edge e=graph[curr].get(i);
                    q.add(e.des);
                }
            }
        }
    }

    public static void dfs(ArrayList<Edge> graph[], int curr,boolean[] vis){
        System.out.print(curr+" ");
        vis[curr]=true;

        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(!vis[e.des]) dfs(graph,e.des,vis);
        }
    }

    public static void printAllPaths(ArrayList<Edge> graph[], int curr,int tar,boolean[] vis,String path){
        if(curr==tar){
            System.out.println(path);
            return;
        }
        vis[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(vis[e.des]==false){

                printAllPaths(graph,e.des,tar,vis,path+e.des);

            }
        }
        vis[curr]=false;
    }

    public static void main(String args[]){
        int v=7;
        ArrayList<Edge> graph[] =new ArrayList[v];

        //createGraph(graph);

        // for disconnected graphs
        boolean vis[]=new boolean[v];
        boolean recur[] = new boolean[v];
//        for(int i=0;i<vis.length;i++){
//            if(!vis[i]){
//                bfs(graph,v,vis,i);
//            }
//        }
        System.out.println();
//        for(int i=0;i<vis.length;i++){
//            if(!vis[i]){
//                dfs(graph,i,vis);
//            }
//        }

        createGraph2(graph);
        System.out.println(checkDirectedCycle(graph,vis,recur,0));

        //printAllPaths(graph,0,5,vis,"0");




//        for(int i=0;i<graph[2].size();i++){
//            Edge e=graph[2].get(i);
//            System.out.println(e.des+","+e.wt);
//        }
    }

}
