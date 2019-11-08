import java.util.*;
public class BinaryHeap{
    int[] data= new int[10];
    int size = 0;

    void add(int priority){
        System.out.println(data.length);
        if(size >= data.length){
            growArray();
        }
        data[size] = priority; // add priority into data
        int child = size;
        int parent = (child)/2; // data set up with parent inserted before child
        while(parent > 0 && data[parent] > data[child]){
            swap(data, parent, child);
            child = parent;
            parent = (child - 1) / 2;
        }
        size++;
    }
   // System.out.println("Child is " + child + " Parent is " + parent);

    int remove(){
        int temp = data[0];
        data[0] = data[--size];
        siftdown(0);
        return temp;
    }

    void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    void siftdown(int parent){
        int child = parent * 2 + 1; // left child
        if(child < size && (child+1) < size && data[child+1] < data[child]){ // make sure we still have space in the data
            child += 1;
        }
        if(data[parent] > data [child]){
            swap(data, parent, child);
            siftdown(child);
        }
    }


    void growArray(){
        int[] newData = Arrays.copyOf(data, data.length*2);
        data = newData;
    }
}