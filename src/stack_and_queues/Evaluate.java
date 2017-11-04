package stack_and_queues;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by starsea on 17-10-16.
 */
public class Evaluate {
    public static void main(String[] args){
        Stack<String> ops = new Stack<String>();
        Stack<Double> vals = new Stack<Double>();
        StdOut.println("请输入公式:");
        while(!StdIn.isEmpty()){  /* Ctrl + D */
            String s = StdIn.readString();
            if(s.equals("(")){
                /* Do Nothing */
            }
            else if(s.equals("+")){
                ops.push(s);
            }else if(s.equals("*")){
                ops.push(s);
            }else if(s.equals(")")){
                String op = ops.pop();
                if(op.equals("+")){
                    vals.push(vals.pop()+vals.pop());
                }else if(op.equals("*")){
                    vals.push(vals.pop()*vals.pop());
                }
            }else{
                vals.push(Double.parseDouble(s));
            }
        }
        StdOut.println(vals.pop());
    }
}
