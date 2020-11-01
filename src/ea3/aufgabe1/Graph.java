package ea3.aufgabe1;

import java.util.Arrays;

public class Graph {
    protected boolean[][] adjacencyMatrix;
    protected String[] nodes;

    protected int indexOf(String node) throws GraphException {
        for (int i = 0; i < nodes.length; i++) {
            if (node.equals(nodes[i])) {
                return i;
            }
        }
        throw new GraphException();
    }
    public Graph(int nodeNumber) {
        nodes = new String[nodeNumber];
        adjacencyMatrix = new boolean[nodeNumber][nodeNumber];
    }
    public Graph(String[] nodes) {
        this(nodes.length);
        for (int i = 0; i < nodes.length; i++) {
            this.nodes[i] = nodes[i];
        }
    }
    public String getNode(int index) throws GraphException {
        // ...liefert den Namen des Knotens an der
        // durch den Wert des Parameters bezeichneten Position,
        // wenn diese einen Knoten bezeichnet; sonst eine GraphException.
        try {
            return nodes[index];
        } catch (Exception e) {
            throw new GraphException();
        }
    }
    public int getNumberOfNodes() {
        // ...liefert die Anzahl der Knoten zurueck.
        return nodes.length;
    }
    public void setNodes(String[] nodes) {
        // ...weist den ersten k Elementen des Attributs nodes die
        // entsprechenden Werte des Parameters nodes zu. k ist dabei das
        // Minimum aus der Laenge des Attributs und des Parameters.
        for (int k =0; k<nodes.length; k++) {
            this.nodes[k]=nodes[k];
        }
    }
    public boolean isAdjacent(int index1, int index2) throws GraphException {
        // ...liefert "wahr", wenn die Knoten mit Index
        // index1 und index2 benachbart sind, sonst "falsch"
        return index1 - 1 == index2 || index2 - 1 == index1;
    }
    public boolean isAdjacent(String node1, String node2) throws GraphException {
        // ...liefert "wahr", wenn die Laender mit Namen
        // node1 und node2 benachbart sind, so  nst "falsch".
        return Arrays.asList(nodes).indexOf(node2) - 1 == Arrays.asList(nodes).indexOf(node1) || Arrays.asList(nodes).indexOf(node1) - 1 == Arrays.asList(nodes).indexOf(node2);
    }
    public void addEdge(int index1, int index2) throws GraphException {
        // ...fuegt Kante zwischen den Knoten mit
        // Index index1 und index2 ein, wenn diese
        // Indizes von Laendern sind; sonst eine GraphException.
        adjacencyMatrix[index1][index2] = true;
        adjacencyMatrix[index2][index1] = true;
    }
    public void addEdge(String node1, String node2) throws GraphException {
        // ...fuegt Kante zwischen den Knoten mit
        // Laendernamen node1 und node2 ein, wenn diese
        // Knoten des Graphen bezeichnen; sonst eine GraphException.
        adjacencyMatrix[Arrays.asList(nodes).indexOf(node1)][Arrays.asList(nodes).indexOf(node2)] = true;
        adjacencyMatrix[Arrays.asList(nodes).indexOf(node2)][Arrays.asList(nodes).indexOf(node1)] = true;
    }

    public static void main(String[] args) {
        String[] testGraph = {"Deutschland", "Österreich", "Schweiz"};
        Graph test = new Graph(testGraph);
        test.getNumberOfNodes();
    }
}
