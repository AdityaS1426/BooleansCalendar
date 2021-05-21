package com.booleans.calendar.controllers.ListComparisonDataClasses;

import com.booleans.calendar.FRQ.Vihan.ListComparison.ListComparison;
import com.booleans.calendar.FRQ.Vihan.ListComparison.ListComparisonCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ListRestController {

    private final ListRepository repository;



    ListRestController(ListRepository repository) {
        this.repository = repository;
    }




    @GetMapping("/labs/Vihan/ListComparison/{id}")
    public ListEntity getList(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ListEntityException(id));


}
    @PostMapping("/labs/Vihan/ListComparison/createList")
    public ListEntity createList(@RequestBody ListEntity list) {
        return repository.save(list);
    }
    @PutMapping("/labs/Vihan/ListComparison/{id}")
    public ListEntity replaceList(@RequestBody ListEntity listEntity, @PathVariable Long id)  {
        return repository.findById(id)
                .map(list -> {
                        list.setList(listEntity.getList());

                        return repository.save(list);
                })
                .orElseGet(() -> {
                    listEntity.setId(id);
                    return repository.save(listEntity);
                });
    }

    @DeleteMapping("/labs/Vihan/ListComparison/{id}")
    public void deleteList(@PathVariable Long id) {
        repository.deleteById(id);
    }



}




