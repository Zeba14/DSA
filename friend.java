import java.io.*;
import java.util.*;
public class friend {
 static class Edge{
     int src;
     int nbr;
     Edge(int src , int nbr)
     {
         this.src = src;
         this.nbr= nbr;

     }
 }  
 public static void main(String[] args)throws Exception{
     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     int vertices = Integer.parseInt(br.readLine());
     int edge = Integer.parseInt(br.readLine());
      ArrayList<Edge>[] graph = new ArrayList[vertices];
      for(int i =0;i<vertices;i++)
      {
         graph[i] = new ArrayList<>();

      }
      for(int j =0;j<edge;j++)
      {
          String line = br.readLine();
          String[] part = line.split(" ");
          int v1 = Integer.parseInt(part[0]);
          int v2 = Integer.parseInt(part[1]);
           graph[v1].add(new Edge(v1,v2));
           graph[v2].add(new Edge(v2,v1));
      }
      boolean visited[] = new boolean[vertices];
      ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
      
      for(int i = 0;i< vertices;i++)
      {
          if(visited[i] == false)
          { ArrayList<Integer> comp = new ArrayList<>();
             gcc(graph,i,visited,comp);
             comps.add(comp);
          }
      }
      int count =0;
      for(int i = 0 ;i< comps.size();i++)
      {
          for(int j =i+1;j<comps.size();j++)
          {
              count += comps.get(i).size() * comps.get(j).size();
          }
      }
      System.out.print(count);
 }
 public static void gcc(ArrayList<Edge> graph[] , int src, boolean visited[] ,ArrayList<Integer> comp )
 {   comp.add(src);
     visited[src] = true;

     for(Edge e : graph[src])
     {   if(visited[e.nbr] ==  false)
          gcc(graph,e.nbr,visited,comp);
     }
 }  
}
