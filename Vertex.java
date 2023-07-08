import java.util.*;

public class Vertex {
    int value;
    int visited;
    String locName;
    ArrayList<Vertex> neighbours;

    public Vertex(int value, String locName){
        this.value = value;
        this.locName = locName;
        this.neighbours = new ArrayList<Vertex>(); //initilaizing an array list to store the adjacent nodes to the node
    }

    void setName (String name){
        this.locName = name;
    }

    void setVisited (int visited){
        this.visited = visited;
    }

    int getVisited(){
        return this.visited;
    }

    String getName(){
        return this.locName;
    }

    int getValue(){
        return this.value;
    }

    //add adjacent node
    void addNeighbour (Vertex neighbour){
        this.neighbours.add(neighbour);
    }

    //display neighbours
    ArrayList<Vertex> displayNeighbours(){
        return this.neighbours;
    }


} 
