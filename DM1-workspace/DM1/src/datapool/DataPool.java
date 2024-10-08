package datapool;

import java.util.Collections;
import java.util.TreeMap;

public class DataPool<E> {
    private int capacity;
    private TreeMap<Integer, E> datapool;
    private int nextkey;

    //constructor
    public DataPool(int capacity){
        this.capacity = capacity;
        this.datapool = new TreeMap<>();
        this.nextkey = 1;
    }

    //methods
    public boolean isFull(){
        return this.datapool.size() == this.capacity;
    }

    public int add(E element){
        if (this.isFull()){
            this.remove(Collections.min(this.datapool.keySet()));
        }
        int key = this.nextkey;
        this.nextkey++;
        this.datapool.put(key, element);
        return key;
    }

    public E get(int key){
        if (this.datapool.get(key) == null){
            return null;
        }
        return this.datapool.get(key);
    }

    public void remove (int key){
        if (this.datapool.get(key) == null){
            return;
        }
        this.datapool.remove(key);
    }

    public double occupancyPercentage(){
        return (double) this.datapool.size()/this.capacity*100;
    }

    public String toString(){
        return this.datapool.toString(); 
    }
}
