package com.booleans.calendar.FRQ.Neil.Sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class Sorts {
    long start;
    public long elapsedTime;
    public boolean arraysMatch = false;
    public ArrayList<Comparable> array;
    public ArrayList<Comparable> sortedarray;

    public Sorts() {
        this(new ArrayList<Comparable>(Arrays.asList(75, 67, 596, 777, 913021, 1, 4507, 81236)),"Integer");


    }
    public Sorts(ArrayList<Comparable> arr, String sortMethod) {
        array = (ArrayList<Comparable>) arr.clone();
        if (sortMethod.compareTo("Insertion")==0) {
            start = System.nanoTime();
            sortedarray = insertionSort(arr);
            elapsedTime = System.nanoTime()-start;

        } else if (sortMethod.compareTo("Selection")==0) {
            start = System.nanoTime();
            sortedarray = selectionSort(arr);
            elapsedTime = System.nanoTime()-start;
        } else if (sortMethod.compareTo("Bubble")==0) {
            //Bubble Sort
            start = System.nanoTime();
            sortedarray = bubbleSort(arr);
            elapsedTime = System.nanoTime()-start;
        }
    }

    public ArrayList<Comparable> bubbleSort(ArrayList<Comparable> array) {
        if (array.size() == 0 || array.size() == 1) {
            return array;
        } else {

            for (int i = 0; i < array.size(); i++) {
                for (int j = 0; j < array.size() - 1; j++) {
                    Comparable current = array.get(j);
                    Comparable next = array.get(j + 1);
                    if (current.compareTo(next) > 0 || current.compareTo(next) == 0) {
                        array.set(j, next);
                        array.set(j + 1, current);
                    }
                }
            }
            ;
            return array;

        }
    }

    public ArrayList<Comparable> selectionSort(ArrayList<Comparable> array) {
        if (array.size() == 0 || array.size() == 1) {
            return array;
        } else {

            for (int i = 0; i < array.size() - 1; i++) {
                int minimum_index = i;
                for (int j = i; j < array.size(); j++) {
                    Comparable current = array.get(j);
                    if (current.compareTo(array.get(minimum_index)) < 0) {

                        minimum_index = j;
                    }
                }

                Comparable temp = array.get(i);
                array.set(i, array.get(minimum_index));
                array.set(minimum_index, temp);
            }
            ;
            return array;
        }
    }

    public ArrayList<Comparable> insertionSort(ArrayList<Comparable> array) {


        if (array.size()==0||array.size()==1) {
            return array;
        } else {
            for (int i = 1; i < array.size(); i++) {
                Comparable current = array.get(i);
                for (int j = i; j >= 1; j--) {
                    Comparable next = array.get(j-1);
                    if (current.compareTo(next)==0||current.compareTo(next)<0) {
                        array.remove(j);
                        array.add(j-1, current);
                    }
                }

            };
            return array;
        }
    }
}
