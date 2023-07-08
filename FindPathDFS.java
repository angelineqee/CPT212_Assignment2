import java.util.*;

public class FindPathDFS{
    int i;
    ArrayList<Edge> edges = new ArrayList<Edge>();
    ArrayList<Vertex> vertices = new ArrayList<Vertex>();
    Vertex source = null;
    Vertex destination = null;
    String path = " ";

    public void addEdge(Vertex source, Vertex destination) {
            edges.add(new Edge(source, destination));
        
    }

    public void printPath(int source) {
        int temp = 0;
        for(int n=0; n<edges.size(); n++){
            if (edges.get(n).source.getValue()==source){
                temp = n;
            }
        }

        for(int k=temp;k<edges.size(); k++){
            path += edges.get(k).source.getName();
            path += " ";
        }
        path += destination.getName();
    }

    public void FindPath (Vertex v, Vertex d){
        source = v;
        destination = d;
        for (int x=0; x<vertices.size();x++){
            vertices.get(x).setVisited(0);
        }
        edges.clear();
        i=0;
        
        if(v.getVisited()==0)
        {
            DFS(v,d);
        }

    }

    public boolean DFS (Vertex v, Vertex d){
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
                printPath(source.getValue());
                return true;
            }
        }
        return false;
    }

    // public static void main (String[] args){
        // final int vertexNum = 13;
        // String [] locations = {"Masjid", "CS School","Fajar","Eureka","DTSP","Library","Padang Kawad","Sg. Dua Gate","Subaidah","Bukit Gambir Gate","Swimming Pool","RST","Minden Gate"};
        // Vertex [] vertices = new Vertex[vertexNum];
        // for (int i=0; i<vertexNum; i++)
        // {
        //     vertices[i] = new Vertex(i,locations[i]);
        // }

        // vertices[0].addNeighbour(vertices[1]);
        // vertices[0].addNeighbour(vertices[2]);
        // vertices[0].addNeighbour(vertices[3]);
        // vertices[0].addNeighbour(vertices[4]);
        // vertices[0].addNeighbour(vertices[5]);

        // vertices[1].addNeighbour(vertices[0]);
        // vertices[1].addNeighbour(vertices[6]);

        // vertices[2].addNeighbour(vertices[0]);
        // vertices[2].addNeighbour(vertices[6]);

        // vertices[3].addNeighbour(vertices[0]);
        // vertices[3].addNeighbour(vertices[7]);

        // vertices[4].addNeighbour(vertices[0]);
        // vertices[4].addNeighbour(vertices[8]);

        // vertices[5].addNeighbour(vertices[0]);

        // vertices[6].addNeighbour(vertices[1]);
        // vertices[6].addNeighbour(vertices[2]);
        // vertices[6].addNeighbour(vertices[9]);

        // vertices[7].addNeighbour(vertices[3]);

        // vertices[8].addNeighbour(vertices[4]);
        // vertices[8].addNeighbour(vertices[10]);

        // vertices[9].addNeighbour(vertices[6]);
        // vertices[9].addNeighbour(vertices[11]);

        // vertices[10].addNeighbour(vertices[8]);
        // vertices[10].addNeighbour(vertices[12]);

        // vertices[11].addNeighbour(vertices[9]);

        // vertices[12].addNeighbour(vertices[10]);

        // source = vertices[12];
        // destination = vertices[11];
        // FindPath(source, destination);

    // }

}