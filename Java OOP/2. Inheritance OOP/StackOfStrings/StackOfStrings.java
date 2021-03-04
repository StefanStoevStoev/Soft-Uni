package StackOfStrings;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class StackOfStrings extends ArrayList<String>{

    private ArrayList<String> item;

    public StackOfStrings(){
        this.item = new ArrayList<>();
    }
    public void push(String item){
        this.item.add(item);
    }
    public String pop(){
        if(item.isEmpty()){
            throw new IndexOutOfBoundsException();
        }
        return this.item.remove(item.size()-1);
    }
    public String peek(){
        if(item.isEmpty()){
            throw new IndexOutOfBoundsException();
        }
        return item.get(item.size()-1);
    }
    @Override
    public boolean isEmpty(){
        if(item.isEmpty()){
            return false;
        }
        return true;
    }
}
