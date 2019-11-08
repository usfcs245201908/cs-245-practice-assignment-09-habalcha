import java.util.*;
public class BinaryHeap{
    int[] data= new int[10];
    int size = 0;

    void add(int priority){
        if(size >= data.length){
            growArray();
        }
        data[size++] = priority; // add priority into data
        int child = size - 1;
        int parent = (child)/2; // data set up with parent inserted before child
        while(parent >= 0 && data[parent] > data[child]){
            swap(data, parent, child);
            child = parent;
            parent = (child - 1) / 2;
        }

    }


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
        if(child < size && parent < size && data[parent] > data [child]){
            swap(data, parent, child); //fine
            siftdown(child);
        }
    }


    void growArray(){
        int[] newData = Arrays.copyOf(data, data.length*2);
        data = newData;
    }

    void printData(){
        System.out.print("\n");
        for (int i = 0; i < data.length; i++){
            System.out.print(data[i] + " ");
        }
        System.out.print("\n\n");
    }
}