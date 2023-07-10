import java.util.*;

public class FindPathDFS{
    int i; //A counter for visited vertices
    ArrayList<Edge> edges = new ArrayList<Edge>(); //To store the path/ a sequence of visted vertices
    Vertex source = null; //The start vertex chosen by the user
    Vertex destination = null; //The end vertex chosen by the user
    String path = ""; //A string to store path from start vertex to end vertex

    //Store edges traversed via DFS
    public void addEdge(Vertex source, Vertex destination) 
    {
            edges.add(new Edge(source, destination));
        
    }

    //Build a String path to be displayed
    public void printPath() 
    {
        path = "";
        System.out.println("adding path");

        //To find the specific path that connect the start vertex directly to the end vertex
        int temp = 0;
        for(int n=0; n<edges.size(); n++){
            if (edges.get(n).source.equals(source)){ 
                temp = n;
            }
        }

        for(int k=temp;k<edges.size(); k++){
                path += edges.get(k).source.getName();
                path += " -> ";
                path += edges.get(k).destination.getName();
                path += ", ";     
        }
    }

    public String getPath()
    {
        return path;
    }

    /*A function that invoke the DFS traversal
    This function accepts the start and end vertices selected by the user from the app interface as arguments*/
    public void FindPath (Vertex v, Vertex d, Vertex[] vertices)
    {
        source = v;
        destination = d;
        for (int x=0; x<vertices.length; x++){
            vertices[x].setVisited(0); //set all vertices to not visited before traversing
        }
        edges.clear();
        i=0;
        
        DFS(v,d);
    }

    //Depth first search algorithm
    public boolean DFS (Vertex v, Vertex d)
    {
        v.setVisited(i++); //set the vertex to visited
        for (int j=0; j<v.neighbours.size(); j++) //traverse the adjacency list of the vertex
        {
            Vertex neighbor = v.neighbours.get(j);

            //Only go to the adjacent neighbour that is not visited to prevent cycle
            if (neighbor.getVisited() == 0 && v.getValue() != d.getValue())
            {
                addEdge(v,neighbor);
                DFS(neighbor, d);
            }    
            
            //If the end/destination vertex is reached, discontinues DFS
            if (v.getValue() == d.getValue())
            {
                printPath();
                return true;
            }
        }
        return false;
    }

}