import java.io.*;
import java.util.*;
 public class isConnected {
    static class Edge
    {
        int src;
        int nbr;
        int wt;
        Edge(int src, int nbr, int wt)
        {
            this.src = src;
            this.nbr=nbr;
            this.wt=wt;
        }
    }
    public static void main(String[] args)throws IOException
    {   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int vertices = Integer.parseInt(br.readLine());
        ArrayList<Edge> graph[] = new ArrayList[vertices];
        for(int i =0;i<vertices;i++)
        {
            graph[i] = new ArrayList<>();
        }
        int edges = Integer.parseInt(br.readLine());
        for(int i =0;i<edges;i++)
        {
            String parts[] = br.readLine().split(" ");
            int v1 = Integer.parseInt((parts[0]));
            int v2 = Integer.parseInt((parts[1]));
            int w = Integer.parseInt((parts[2]));
            graph[v1].add(new Edge(v1,v2,w));
            graph[v2].add(new Edge(v2,v1,w));
        }
        boolean visited[] = new boolean[vertices];
        ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
        for(int v =0;v<vertices;v++)
        {   ArrayList<Integer> comp = new ArrayList<>();
            if(visited[v] == false)
            {
                allComponent(graph,v,visited,comp);
                comp.add(v);
            }
        }
        System.out.print(comps.size() == 1);
    }
    public static void allComponent(ArrayList<Edge> graph [] , int src , boolean visited[], ArrayList<Integer> comp)
    {
        visited[src] = true;
        comp.add(src);
        for(Edge e : graph[src])
        {
            if(visited[e.nbr] == false)
            {
                allComponent(graph,e.nbr,visited,comp);
            }
        }
    }
}
// INPUT:
// 7
// 5
// 0 1 10
// 2 3 10
// 4 5 10
// 5 6 10
// 4 6 10