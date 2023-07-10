import java.util.*;

public class FindPathDFS{
    int i;
    ArrayList<Edge> edges = new ArrayList<Edge>();
    Vertex source = null;
    Vertex destination = null;
    String path = "";

    public void addEdge(Vertex source, Vertex destination) {
            edges.add(new Edge(source, destination));
        
    }

    public void printPath() {
        path = "";
        System.out.println("adding path");
        int temp = 0;
        for(int n=0; n<edges.size(); n++){
            if (edges.get(n).source.equals(source)){
                temp = n;
            }
        }

        for(int k=temp;k<edges.size(); k++){
            // //if backtrack to the same location, ignore the reversed path
            // if (edges.get(k).source.getName().equals(edges.get(k+1).source.getName()))
            // {
            //     continue;                                                                                                                                                           
            // }
            // else
            // {
                path += edges.get(k).source.getName();
                path += " -> ";
                path += edges.get(k).destination.getName();
                path += ", ";
            // }       
        }
    }

    public String getPath(){
        return path;
    }

    public void FindPath (Vertex v, Vertex d, Vertex[] vertices){
        System.out.println("Finding path");
        source = v;
        destination = d;
        for (int x=0; x<vertices.length; x++){
            System.out.println("heyyyyy");
            vertices[x].setVisited(0);
        }
        edges.clear();
        i=0;
        
        if(v.getVisited()==0)
        {
            DFS(v,d);
        }

    }

    public boolean DFS (Vertex v, Vertex d){
        System.out.print("Running DFS");
        v.setVisited(i++);
        for (int j=0; j<v.neighbours.size(); j++)
        {
            Vertex neighbor = v.neighbours.get(j);

            if (neighbor.getVisited() == 0 && v.getValue() != d.getValue())
            {
                addEdge(v,neighbor);
                DFS(neighbor, d);
            }    
            
            if (v.getValue() == d.getValue())
            {
                printPath();
                return true;
            }
        }
        return false;
    }

}