package com.khushidemo.customproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private Map<Long, Employee> emp = new HashMap<>();

    @GetMapping("/custom-greet")
    public String customGreet() {
        return "Hello Khushi, it's custom RESTful service is running!";
    }

    @GetMapping
    public List<Employee> getAll(){
        return new ArrayList<>(emp.values());
    }


    @GetMapping("/id/{id}")
    public Employee getEmployeeById(@PathVariable Long id){
        return emp.get(id);

    }

    @PostMapping
    public boolean createEntry(@RequestBody Employee empl){
        emp.put(empl.getId(), empl);
        return true;
    }

    @PutMapping("/id/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee newEmployee){
        return emp.put(id,newEmployee);
    }

    @DeleteMapping("/id/{id}")
    public Employee deleteEmployee(@PathVariable Long id){
        return emp.remove(id);
    }
}
