import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class Graph {

    public Map<Integer, List<Integer>> map;
    public int size;
    public int[] outdegree;

    public Graph(int numOfNodes) {
        map = new HashMap<>();
        size = numOfNodes;
        outdegree = new int[size];
    }

    public void buildGraph(List<int[]> edges, boolean directed) {
        for (int[] edge : edges) {
            addEdge(edge, directed);
        }
    }

    public void addEdge(int[] edge, boolean directed) {
        if(!map.containsKey(edge[1])) {
            map.put(edge[1], new ArrayList<Integer>());
        }
        map.get(edge[1]).add(edge[0]);

        if (!directed) {
            if(!map.containsKey(edge[0])) {
                map.put(edge[0], new ArrayList<Integer>());
            }
            map.get(edge[0]).add(edge[1]);
        }
        outdegree[edge[0]]++;
    }


    public void dfs() {
        int[] visited = new int[size];
        for (int key : map.keySet()) {
            if (visited[key] == 0) {
                dfs(key, visited);
            }
        }
    }

    public void dfs(int curr, int[] visited) {
        if(visited[curr] == 1) return;
        visited[curr] = 1;
        System.out.println(curr);
        if(!map.containsKey(curr)) return;

        for(int nb : map.get(curr)) {
            dfs(nb, visited);
        }
    }

    public int connectedComp() {
        int count = 0;
        int[] visited = new int[size];
        for (int key : map.keySet()) {
            if (visited[key] == 0) {
                bfs(key, visited);
                count++;
            }
        }
        return count;
    }

    public void bfs() {
        int[] visited = new int[size];
        for (int key : map.keySet()) {
            if (visited[key] == 0) {
                bfs(key, visited);
            }
        }
    }

    public void bfs(int key, int[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(key);
        visited[key] = 1;
        while (q.size() > 0) {
            int s = q.size();
            for (int i = 0; i < s; i++) {
                int curr = q.poll();
                System.out.println(curr);
                if (!map.containsKey(curr)) continue;
                for (int nb : map.get(curr)) {
                    if (visited[nb] == 0) {
                        visited[nb] = 1;
                        q.offer(nb);
                    }

                }
            }
        }
    }

    public List<Integer> topologySort() {
        List<Integer> output = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            if (outdegree[i] == 0) {
                queue.offer(i);
            }
        }
        while (queue.size() > 0) {
            int curr = queue.poll();
            output.add(curr);
            if (!map.containsKey(curr)) {
                continue;
            }
            for (int i : map.get(curr)) {
                    outdegree[i]--;
                    if (outdegree[i] == 0) {
                        queue.offer(i);
                    }
                }
        }
        return output;
    }


    public static void main(String[] args) {
        Graph graph = new Graph(6);

        List<int[]> edges = new ArrayList<>();
        edges.add(new int[]{0, 1});
        edges.add(new int[]{0, 4});
       // edges.add(new int[]{1, 3});
        edges.add(new int[]{1, 2});
        edges.add(new int[]{0, 2});
       // edges.add(new int[]{4, 3});
        edges.add(new int[]{3, 5});
        graph.buildGraph(edges,true);
        System.out.println(graph.topologySort());
        //graph.bfs();
        //System.out.println(graph.connectedComp());
    }



}
