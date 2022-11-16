package Model;

public class Node {
    public Task value;
    public Node next;
    public Node prev;

    public Node(Task value) {
        this.value = value;
    }

    public boolean hasNext(){
        return next == null;
    }

    public Node getNext(){
        return next;
    }


}
