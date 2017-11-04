package stack_and_queues;

/**
 * Created by starsea on 17-10-11.
 */
public class LinkedStackOfString {
    private Node first = null;

    private class Node{
        String item;
        Node next;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public void push(String item){
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
    }

    public String pop(){
        String item = first.item;
        first = first.next;
        return item;
    }
}


