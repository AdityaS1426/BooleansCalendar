package com.booleans.calendar;

import com.booleans.calendar.FRQ.Vihan.Inheritance.Computer;
import com.booleans.calendar.FRQ.Vihan.ListComparison.CheckListType;
import com.booleans.calendar.FRQ.Vihan.ListComparison.ListComparison;
import com.booleans.calendar.FRQ.Vihan.ListComparison.ListComparisonCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import com.booleans.calendar.FRQ.Neil.Inheritance;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ListController {

    ListComparisonCreator listComparisonCreator;
    ListComparison listComparison;


    //autowired annotation automatically inserts instance of ListDB into the method
    @Autowired
    public void setListComparison(ListComparisonCreator listcomparisoncreator) {
        this.listComparisonCreator = listcomparisoncreator;
    }

    @PostMapping("/labs/Vihan/ListComparison/createList")
    public ResponseEntity<?> createListComparison(@Valid @RequestBody ListCriteria input, Errors errors) {

        ListCreationResponseBody result = new ListCreationResponseBody();

        if (errors.hasErrors()) {

            result.setMsg(errors.getAllErrors()
                    .stream().map(x -> x.getDefaultMessage())
                    .collect(Collectors.joining(",")));

            return ResponseEntity.badRequest().body(result);
        }

        ListComparison listComparison = listComparisonCreator.generateListComparison(input.getlistType(), input.getlistLength());

        result.setList(listComparison.arrayList);
        result.setMsg("List successfully created");
        return ResponseEntity.ok(result);
    }

    @PostMapping("/labs/Vihan/ListComparison/modifyList")
    public ResponseEntity<?> modifyList(@Valid @RequestBody ModificationCriteria operation, Errors errors ) {

        ListModificationResponseBody result = new ListModificationResponseBody();




        if (errors.hasErrors()) {

            result.setMsg(errors.getAllErrors()
                    .stream().map(x -> x.getDefaultMessage())
                    .collect(Collectors.joining(",")));

            return ResponseEntity.badRequest().body(result);
        }






        return ResponseEntity.ok(result);

    }



    public class ModificationCriteria {


        ListOperation operation;
        String data;

    }

    public enum ListOperation {
        SORT, INSERT,DELETE
    }

    public class ListModificationResponseBody {
        String msg;
        long operationTime;
        List list;
        int listSize;


        public long getoperationTime() {
            return operationTime;
        }
        public List getlist() {
            return list;
        }
        public int getlistSize() {
            return listSize;
        }
        public String getMsg() {
            return msg;
        }

        public void setoperationTime(long time) {
            this.operationTime= time;
        }
        public void setlist(List<Comparable> list) {
            this.list=list;
        }
        public void setlistSize(int listSize) {
            this.listSize=listSize;
        }
        public void setMsg(String msg) {
            this.msg = msg;
        }


    }


    private class ListCreationResponseBody {

        String msg;
        List list;

        //getters and setters


        public String getMsg() {
            return this.msg;
        }
        public void setMsg(String msg) {
            this.msg = msg;
        }

        public List getListComparison() {
            return this.list;
        }

        public <T extends Comparable> void setList(List<T> list) {
            this.list = list;
        }
    }


    public class ListCriteria {
        @CheckListType
        String listType;

        @Min(1)
        int listLength;

        public String getlistType() {
            return this.listType;
        }


        public void setlistType(String listType) {
            this.listType = listType;
        }

        public int getlistLength() {
            return this.listLength;
        }
        public void setlistLength(int listLength) {
            this.listLength = listLength;
        }
    }



}
