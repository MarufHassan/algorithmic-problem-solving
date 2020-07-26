import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static class MyQueue<T> {
        Stack<T> stack = new Stack<T>();
        Stack<T> aux = new Stack<T>();
        T front;

        public void enqueue(T value) { // Push onto newest stack
            if (stack.empty())
                front = value;
            stack.push(value);
        }

        public T peek() {
            if (!aux.empty())
                return aux.peek();
            return front;
        }

        public T dequeue() {
            if (aux.empty()) {
                while (!stack.empty())
                    aux.push(stack.pop());
            }
            return aux.pop();
        }
    }

    
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();
        
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        
        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
        scan.close();
    }
}