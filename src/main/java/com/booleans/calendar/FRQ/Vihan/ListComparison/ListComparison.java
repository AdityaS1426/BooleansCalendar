package com.booleans.calendar.FRQ.Vihan.ListComparison;

import java.util.*;

import com.booleans.calendar.FRQ.Vihan.Inheritance.Computer;
import com.booleans.calendar.FRQ.Vihan.Sorting.Sorts;


public class ListComparison<T extends Comparable> {
    public Class<T> listElementClass;
    public Class<T> listType;
    public int listlength;
    Map<String,Long> arrayListTimes;
    Map<String,Long> linkedListTimes;

    private Class<T> Class;

    String[] times = {"BubbleSort","InsertionSort","SelectionSort","Insert","Delete"};

    ArrayList<T> arrayList;
    LinkedList<T> linkedList;


    public ListComparison(Class<T> c, int listlength ) {
        this.listlength = listlength;


        this.listElementClass = c;

        //generates array lists
        generateLists(listlength);

        //hashmaps to store times for each operation
        arrayListTimes = new HashMap<String,Long>();
        linkedListTimes = new HashMap<String,Long>();

        //initializes the map
        for (String i: times) {
        arrayListTimes.put(i,(long) 0);
        linkedListTimes.put(i,(long)0);
        }
    }

    public void generateLists(int listlength) {

        arrayList = new ArrayList<T>();
        linkedList = new LinkedList<T>();


        if (listElementClass.equals(String.class)) {
            for (int i = 0; i < listlength; i++) {

                String string = stringGenerator(new Random());
                arrayList.add((T)string);
                linkedList.add((T)string);
            }
        } else if(listElementClass.equals(Computer.class)) {
            Random random = new Random();
                for (int i =0; i < listlength; i++) {
                    Computer computer = new Computer((int)(128+random.nextFloat()*(2000-128)), "Computer: "+String.valueOf(i+1));

                    arrayList.add((T)computer);
                    linkedList.add((T)computer);
                }
        } else {
            Random random = new Random();
            for (int i = 0; i < listlength; i++) {

                //sets the range of numbers
                Integer integer = (int) (0+random.nextFloat()*(10-0));
                arrayList.add((T) (integer));
                linkedList.add((T) (integer));
            }

        }
    }


    public String stringGenerator(Random random) {
        return stringGenerator(10,65,90,random);
    }
    public String stringGenerator(int maxLength,int lowerASCIILimit,int upperASCIILimit,Random random) {

        int stringLength = (int) (random.nextFloat()*maxLength)+1;
        StringBuilder buffer = new StringBuilder(stringLength);
        for (int i = 0; i < stringLength; i++) {
            int randomLimitedInt = lowerASCIILimit + (int)
                    (random.nextFloat() * (upperASCIILimit - lowerASCIILimit + 1));
            buffer.append((char) randomLimitedInt);

        }

        return buffer.toString();


    }

    //inserts element and returns time taken
    public void addElementAtIndex(T element, int index) {
        long start = System.nanoTime();
        arrayList.add(index, element);
        long duration = System.nanoTime() - start;
        arrayListTimes.replace("Insert",duration);


        start = System.nanoTime();
        linkedList.add(index,element);
        duration = System.nanoTime() - start;
        linkedListTimes.replace("Insert",duration);
    }
    public void addElementAtIndex(T element) {
        long start = System.nanoTime();
        arrayList.add(element);
        long duration = System.nanoTime() - start;
        arrayListTimes.replace("Insert",duration);


        start = System.nanoTime();
        linkedList.add(element);
        duration = System.nanoTime() - start;
        linkedListTimes.replace("Insert",duration);
    }


    public void deleteElement(T element) {
        long start = System.nanoTime();
        arrayList.remove(element);
        long duration = System.nanoTime() - start;
        arrayListTimes.replace("Delete",duration);

        start = System.nanoTime();
        linkedList.remove(element);
        duration = System.nanoTime() - start;
        arrayListTimes.replace("Insert",duration);
    }
    public void deleteElement() {
        long start = System.nanoTime();
        arrayList.remove(listlength-1);
        long duration = System.nanoTime() - start;
        arrayListTimes.replace("Delete",duration);


        start = System.nanoTime();
        linkedList.remove(listlength-1);
        duration = System.nanoTime() - start;
        linkedListTimes.replace("Delete",duration);
    }

    public void deleteElement(int index) {
        long start = System.nanoTime();
        arrayList.remove(index);
        long duration = System.nanoTime()-start;
        arrayListTimes.replace("Delete",duration);



        start = System.nanoTime();
        linkedList.remove(index);
        duration = System.nanoTime() - start;
        linkedListTimes.replace("Delete",duration);
    }


    public void sortLists(String sortMethod) {
        switch (sortMethod) {
            case "Selection":
                arrayList = (ArrayList<T>) Sorts.selectionSort(arrayList);
                linkedList = (LinkedList<T>) Sorts.selectionSort(linkedList);
                break;
            case "Insertion":
                arrayList = (ArrayList<T>)Sorts.insertionSort(arrayList);
                linkedList = (LinkedList<T>)Sorts.insertionSort(linkedList);
                break;
            case "Bubble":
                arrayList = (ArrayList<T>)Sorts.bubbleSort(arrayList);
                linkedList = (LinkedList<T>)Sorts.bubbleSort(linkedList);
                break;
        }



    }


    public static void main(String[] args) {






    }


}