package com.booleans.calendar.FRQ.Vihan.Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Sorts {

    public static Integer[] defau = {5, 3, 33312, 82394, 367, 1, 327, 812};


    public static <T extends Comparable> List<T> bubbleSort(List<T> array) {
        if (array.size() == 0 || array.size() == 1) {
            return array;
        } else {
            for (int i = 0; i < array.size(); i++) {
                for (int j = 0; j < array.size() - 1; j++) {
                    T current = array.get(j);
                    T next = array.get(j + 1);
                    if (current.compareTo(next) > 0 || current.compareTo(next) == 0) {
                        array.set(j, next);
                        array.set(j + 1, current);
                    }
                }
            }

            return array;

        }
    }


    public static <T extends Comparable> List<T> selectionSort(List<T> array) {
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

                T temp = array.get(i);
                array.set(i, array.get(minimum_index));
                array.set(minimum_index, temp);
            }
            ;
            return array;
        }
    }

    public static <T extends Comparable> List<T> insertionSort(List<T> array) {


        if (array.size()==0||array.size()==1) {
            return array;
        } else {
            for (int i = 1; i < array.size(); i++) {
                T current = array.get(i);
                for (int j = i; j >= 1; j--) {
                    T next = array.get(j-1);
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
