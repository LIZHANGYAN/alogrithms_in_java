package work2;


import java.util.Iterator;

/**
 * Created by starsea on 17-10-17.
 */
public class Deque<Item> implements Iterable<Item> {

    private Node first, last;
    private class Node{
        Item item;
        Node next;
    }

    public Deque(){
        first = null;
        last = null;
    }
    public boolean isEmpty(){
        return first == null;
    }
    public int size(){
        int len = 0;
        while(first.next != last){
            len++;
        }
        return len;
    }
    public void addFirst(Item item){
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst.next;
        oldFirst = last;
    }
    public void addLast(Item item){
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = oldLast.next;
        oldLast = last;
    }
    public Item removeFirst(){
        Item item = first.item;
        Node oldFirst = first.next;
        first = new Node();
        first = oldFirst;
        oldFirst = null;
        return item;
    }
    public Item removeLast(){
        Item item = last.item;
        Node oldLast = last;
        last = oldLast;
        oldLast = null;
        return item;
    }



    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator{
        private Node current = first;
        public boolean hasNext(){
            return current != null;
        }
        public Item next(){
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
    public static void main(String[] args){

    }
}
