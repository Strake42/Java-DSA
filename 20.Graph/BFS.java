import java.util.*;

public class BFS {

    static class Edge{
        int src;
        int dest;

        Edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
    }

    public static void creatGraph(ArrayList<Edge> graph[]){
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<Edge>();
        }

        //Vertex 0
        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));
        
        //Vertex 1
        graph[1].add(new Edge(1,3));
        graph[1].add(new Edge(1,0));

        //Vertex 2
        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,4));

        //Vertex 3
        graph[3].add(new Edge(3,1));
        graph[3].add(new Edge(3,4));
        graph[3].add(new Edge(3,5));

        //Vertex 4
        graph[4].add(new Edge(4,2));
        graph[4].add(new Edge(4,3));
        graph[4].add(new Edge(4,5));

        //Vertex 5
        graph[5].add(new Edge(5,3));
        graph[5].add(new Edge(5,4));
        graph[5].add(new Edge(5,6));

        //Vertex 6
        graph[6].add(new Edge(6,5));

    }

    static void bfs(ArrayList<Edge> graph[], boolean vis[], int start){
        Queue<Integer> q = new LinkedList<>();
        
        q.add(start);

        while(!q.isEmpty()){
            int curr = q.remove();

            if(!vis[curr]){
                System.out.print(curr+" ");
                vis[curr] = true;

                for(int i=0; i<graph[curr].size(); i++){
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }


    public static void main(String[] args) {
        int v = 7;
        ArrayList<Edge> graph[] = new ArrayList[v];
        creatGraph(graph);

        boolean vis[] = new boolean[graph.length];
        for(int i=0; i<graph.length; i++){
            if(vis[i]==false){
                  bfs(graph,vis,i);
            }
          
        }
        
    }
    
}
