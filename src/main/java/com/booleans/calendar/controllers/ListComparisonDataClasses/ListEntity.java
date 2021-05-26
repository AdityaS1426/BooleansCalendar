package com.booleans.calendar.controllers.ListComparisonDataClasses;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;

@Entity
public class ListEntity  {


    private @Id @GeneratedValue Long id;

    @ElementCollection(fetch=FetchType.EAGER)
    private List<Integer> list = new ArrayList<Integer>(0);

    @Column(name="length")
    private int length;


    public void setId(Long id) {
        this.id = id;
    }



    public List getList() {
        return list;
    }

    public ListEntity() {
        this.list = new ArrayList(Arrays.asList(1,2,3,4));
        this.length = list.size();

    }
    public ListEntity(List<Integer> list) {
        setList(list);
    }


    public void setList(List<Integer> list) {
        this.list = list;
        this.length = list.size();
    }

    public int getLength() {
        return length;
    }

    public Long getId() {
        return id;
    }


    /*public boolean equals(Integer o) {

        if (this == o)
            return true;
        if (!(o instanceof ListEntity))
            return false;
        ListEntity listEntity = (ListEntity) o;
        return Objects.equals(this.id, listEntity.id) && Objects.equals(this.list, listEntity.list);
    }*/

    @Override
    public String toString() {
        return "List: "+ list.toString() + "\nLength: "+length;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.list);
    }





}
