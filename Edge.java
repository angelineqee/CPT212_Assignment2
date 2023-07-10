//An edge is a connection between two vertices

public class Edge {
    //endpoints of the edge 
    Vertex source; 
    Vertex destination;

    Edge(Vertex source, Vertex destination)
    {
        this.source = source;
        this.destination = destination;
    }       
}

