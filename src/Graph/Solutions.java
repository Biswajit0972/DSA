package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solutions {
    public static int[][] graph(int u, int v) {
        Scanner sc = new Scanner(System.in);

        int[][] graph = new int[u + 1][v + 1];

        for (int i = 0; i < v; i++) {
            System.out.println("Enter Node1: ");
            int node1 = sc.nextInt();
            System.out.println("Enter Node2: ");
            int node2 = sc.nextInt();
            System.out.println("Enter Weight1: ");
            int weight = sc.nextInt();
            graph[node1][node2] = weight;
            graph[node2][node1] = weight;
        }
        sc.close();
        return graph;
    }

    public static ArrayList<Integer> bfs(int[][] graph, int u) {
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] visited = new boolean[graph.length];
        Queue<Integer> queue = new LinkedList<>();
        visited[u] = true;
        ans.add(u);
        queue.add(u);

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int i = 0; i < graph[curr].length; i++) {
                if (graph[curr][i] != 0 && !visited[i]) {
                    visited[i] = true;
                    ans.add(i);
                    queue.add(i);
                }
            }
        }

        return ans;
    }

    public static ArrayList <Integer> dfs (int [][] graph , int startVertices){
        int [] visited = new int[5];
        return helper(graph, startVertices, visited, new ArrayList<>());
    }

    public static ArrayList<Integer> helper (int [] [] graph , int startVertices, int [] visited, ArrayList<Integer> ans){
        visited[startVertices] = 1;
        ans.add(startVertices);

        for (int i = 1; i < graph[startVertices].length; i++) {
            if (graph[startVertices] [i] != 0 && visited[i] == 0) {
                helper(graph, i, visited, ans);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] graph = graph(5, 5);

//        for (int i = 0; i < graph.length; i++) {
//            for (int j = 0; j < graph[i].length; j++) {
//                System.out.print(graph[i][j] + " ");
//            }
//            System.out.println();
//        }

        ArrayList<Integer> ans = dfs(graph, 1);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }
}
