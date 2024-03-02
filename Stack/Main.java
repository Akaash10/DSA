package Stack;

import java.util.*;

class MyException extends Exception {
    MyException(String message) {
        super(message);
    }
}

class Stack {
    private int arr[];
    private static final int size = 10;
    private static int ptr = -1;

    Stack() {
        this(size);
    }

    Stack(int size) {
        this.arr = new int[size];
    }

    private boolean isFull() {
        return ptr == arr.length;
    }

    private boolean isEmpty() {
        return ptr == -1;
    }

    void push(int value) throws MyException {
        if (isFull()) {
            throw new MyException("Stack is full");
        }
        ++ptr;
        arr[ptr] = value;
    }

    int pop() throws MyException {
        if (isEmpty()) {
            throw new MyException("Cannot pop from an empty stack");
        }
        return arr[ptr--];
    }

    int peek() throws MyException {
        if (isEmpty()) {
            throw new MyException("Cannot peek from an empty stack");
        }
        return arr[ptr];
    }

    int search(int value) throws MyException {
        int position = -1;
        for (int i = 0; i <= ptr; i++) {
            if (arr[i] == value) {
                return ptr - i;
            }
        }
        return position;
    }

    void display() throws MyException {
        if (isEmpty()) {
            throw new MyException("Cannot display an empty stack");
        }
        for (int i = ptr; i >= 0; i--) {
            System.out.print(arr[i] + "->");
        }
        System.out.print("END");
    }
}

public class Main {
    public static void main(String[] args) throws MyException {
        Stack s = new Stack(3);
        s.push(10);
        s.push(20);
        s.push(30);
        System.out.println("Pop: " + s.pop());
        System.out.println("Peek: " + s.peek());
        System.out.println("Index: " + s.search(10));
        s.display();
    }
}