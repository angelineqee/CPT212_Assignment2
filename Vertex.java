import java.util.*;

//Each vertex is a location on the map
public class Vertex {
    private int value; //act as the key of each vertex/ location number
    private int visited; //a value to indicate whether the vertex is visited, 0 - not visited
    private String locName; //name of the vertex/ location
    ArrayList<Vertex> neighbours; //Each vertex has its adjacency list to store its neighbours

    //Constructor to initialize the vertex
    public Vertex(int value, String locName)
    {
        this.value = value;
        this.locName = locName;
        this.neighbours = new ArrayList<Vertex>(); //initilaizing an array list to store the adjacent nodes to the node
    }

    //To change the name of the vertex
    void setName (String name)
    {
        this.locName = name;
    }

    //To set the value of variable 'visited'
    void setVisited (int visited)
    {
        this.visited = visited;
    }

    //To get the value of the variable 'visited'
    int getVisited()
    {
        return this.visited;
    }

    //To get the name of the vertex/ location
    String getName()
    {
        return this.locName;
    }

    //To get the key of the vertex/ location number
    int getValue()
    {
        return this.value;
    }

    //add adjacent node
    void addNeighbour (Vertex neighbour)
    {
        this.neighbours.add(neighbour);
    }

    //display neighbours
    void displayNeighbours()
    {
        for(int i=0; i<this.neighbours.size(); i++){
            System.out.println(this.neighbours.get(i).getName());
        }
    }
} 
