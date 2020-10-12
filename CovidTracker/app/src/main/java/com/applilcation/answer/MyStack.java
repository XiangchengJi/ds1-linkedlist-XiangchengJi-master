package com.applilcation.answer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MyStack<E> {
    private List<E> list;

    public MyStack() {
        list = new ArrayList<E>();
    }

    
    public boolean isEmpty() {
        return list.size() == 0;
    }

   
    public int size() {
        return list.size();
    }

    
    public void push(E e) {
        list.add(e);
    }

    public E pop() {
        if (list.size() > 0) {
            return list.remove(list.size() - 1);
        }
        return null;
    }

    @Override
    public String toString() {
        return Arrays.toString(list.toArray());
    }

    public E get(int position) {
        return list.get(position);
    }
}