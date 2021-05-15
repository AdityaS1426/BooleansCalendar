package com.booleans.calendar.controllers.ListComparisonDataClasses;

import com.booleans.calendar.FRQ.Vihan.ListComparison.CheckListType;
import com.booleans.calendar.FRQ.Vihan.ListComparison.ListComparison;
import com.booleans.calendar.FRQ.Vihan.ListComparison.ListComparisonCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.ArrayList;
import java.util.Arrays;
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


    @RequestMapping(value = "labs/Vihan/ListComparison", method = {RequestMethod.GET})
    private String returnListComparisonPage() {
        return "labs/Vihan/ListComparison";
    }

    /*@GetMapping(value="labs/Vihan/ListComparison.js")
    private String returnListComparisonJS() {
        return "src/main/static/js/ListComparison.js";
    }*/
/*

    @RequestMapping(value="/labs/Vihan/ListComparison/createList",method=RequestMethod.POST,produces= MediaType.APPLICATION_JSON_VALUE)
    private @ResponseBody ResponseEntity<?> createListComparison(@RequestBody ListCriteria input, Errors errors) {

        System.out.println(input);

        ListResponseBody result = new ListResponseBody();

        if (errors.hasErrors()) {

            result.setMsg(errors.getAllErrors()
                    .stream().map(x -> x.getDefaultMessage())
                    .collect(Collectors.joining(",")));

            System.out.println(result.getMsg());

            return ResponseEntity.badRequest().body(result);
        }
        if (input==null) {
            ListComparison listComparison = listComparisonCreator.generateListComparison("integer", 32);
            result.setlist(listComparison.arrayList);
            result.setlistSize(listComparison.listlength);
            result.setMsg("List successfully created");
            return ResponseEntity.ok(result);


        } else {
            ListComparison listComparison = listComparisonCreator.generateListComparison(input.getlistType(), input.getlistLength());
            result.setlist(listComparison.arrayList);
            result.setlistSize(listComparison.listlength);
            result.setMsg("List successfully created");
            return ResponseEntity.ok(result);
        }




    }

    @PostMapping("/labs/Vihan/ListComparison/modifyList")
    private ResponseEntity<?> modifyList(@Valid @RequestBody ModificationCriteria operation, Errors errors) {



        ListResponseBody result = new ListResponseBody();



        if (errors.hasErrors()) {

            result.setMsg(errors.getAllErrors()
                    .stream().map(x -> x.getDefaultMessage())
                    .collect(Collectors.joining(",")));

            return ResponseEntity.badRequest().body(result);
        }
        int requested_index = Integer.parseInt(operation.index);


        if (operation.listoperation.compareTo("Insert") == 0) {
            if (requested_index >= listComparison.listlength || requested_index < 0) {
                listComparison.addElementAtIndex(operation.data);
            } else {
                listComparison.addElementAtIndex(operation.data, requested_index);
            }
            result.setOperationTimes((long) listComparison.getArrayListTimes().get("Insert"),
                    (long) listComparison.getLinkedListTimes().get("Insert"));

        } else if (operation.listoperation.compareTo("Delete") == 0) {
            if (requested_index >= listComparison.listlength || requested_index < 0) {
                listComparison.deleteElement();
            } else {
                listComparison.deleteElement(requested_index);
            }
            result.setOperationTimes((long) listComparison.getArrayListTimes().get("Delete"),
                    (long) listComparison.getLinkedListTimes().get("Delete"));
        } else {
            result.setOperationTimes((long) -1,
                    (long) -1);
        }


        result.setlist(listComparison.getList());
        result.setlistSize(listComparison.getList().size());
        result.setMsg("Modification request successful. Modification was: " + operation.listoperation);


        return ResponseEntity.ok(result);

    }

    @PostMapping("/labs/Vihan/ListComparison/sortList")
    private ResponseEntity<?> sortList(@Valid @RequestBody SortCriteria sort, Errors errors) {
        ListResponseBody result = new ListResponseBody();


        if (errors.hasErrors()) {

            result.setMsg(errors.getAllErrors()
                    .stream().map(x -> x.getDefaultMessage())
                    .collect(Collectors.joining(",")));

            return ResponseEntity.badRequest().body(result);
        }

        if (new ArrayList<String>(Arrays.asList("Selection", "Bubble", "Insertion")).contains(sort.listSortMethod)) {
            listComparison.sortLists(sort.listSortMethod);
        } else {
            System.out.println("Sort Method not found");
        }
        result.setOperationTimes((long) listComparison.getArrayListTimes().get("Sort"), (long) listComparison.getLinkedListTimes().get("Sort"));
        result.setlist(listComparison.getList());
        result.setlistSize(listComparison.getList().size());
        result.setMsg("Sort request successful");


        return ResponseEntity.ok(result);


    }*/
}





