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
        String Source, Destination, nextSource; //variable declaration

        for(int k=edges.size()-1; k>=0; k--){
            
            Source = edges.get(k).source.getName();
            Destination = edges.get(k).destination.getName();
            
            path += Source;
            path += " -> ";
            
            if (k-1==-1) //end the loop when k-1 is under 0 as the k-1 would be the index for nextSource
            {
                path += Destination;
                break;
            }
            
            nextSource = edges.get(k-1).source.getName();

            if (Destination.equals(nextSource)) //if the current destination is equal to next source, then it will only print once
            {
                path += " ";
            }
            else //if the current destination and the next source is not the same then print the current destination. 
            {
                path += Destination;
            }
        }
    }

    public String getPath()
    {
        return path;
    }

    /*A function that invoke the DFS traversal
    This function accepts the start and end vertices selected by the user from the app interface as arguments*/
    public void FindPath (Vertex v, Vertex d, Vertex [] vertices)
    {
        source = v;
        destination = d;
        for (int x=0; x<vertices.length; x++){
            vertices[x].setVisited(0); //set all vertices to not visited before traversing
        }
        edges.clear();
        i=0;
        
        DFS(v,d);
        printPath();
    }

    //Depth first search algorithm
    public boolean DFS (Vertex v, Vertex d)
    {
        v.setVisited(++i); //set the vertex to visited
        for (int j=0; j<v.neighbours.size(); j++) //traverse the adjacency list of the vertex
        {
            Vertex neighbor = v.neighbours.get(j);
            if(neighbor.getVisited()==0){ //Only go to the adjacent neighbour that is not visited to prevent cycle
                System.out.println(v.getName() + " -> " + neighbor.getName() +", "); //print the traversal path in terminal
                if(neighbor.getValue() == d.getValue()) //only store the direct path from start to end vertex
                {
                    addEdge(v, neighbor);
                    return true;
                }

                if (DFS(neighbor, d))
                {
                    addEdge(v, neighbor); 
                    return true;
                }
            }
        }
        
        return false;
    }

}