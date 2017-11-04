package stack_and_queues;

/**
 * Created by starsea on 17-10-15.
 */
public class ResizingArrayQueueOfStrings {
    private String[] S;
    private int first = 0;
    private int last = 0;

    public ResizingArrayQueueOfStrings(){
        S = new String[1];
    }
    public boolean isEmpty(){
        return first == last;
    }

    public void enqueue(String item){
        if(first == S.length)
            resize(2*S.length);
        S[first++] = item;
    }

    public String dequeue(){
        String item = S[last++];
        return item;
    }
    private void resize(int capcity){
        String[] copy = new String[capcity];
        for (int i=0; i<capcity; i++){
            copy[i] = S[i];
        }
        S = copy;
    }
}
