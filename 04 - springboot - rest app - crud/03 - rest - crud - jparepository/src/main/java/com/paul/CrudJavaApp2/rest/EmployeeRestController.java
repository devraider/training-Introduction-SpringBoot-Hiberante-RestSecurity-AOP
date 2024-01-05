package com.paul.CrudJavaApp2.rest;

//import com.paul.CrudJavaApp2.dao.EmployeeDAO;
//import com.paul.CrudJavaApp2.dao.EmployeeDAOJpaImpl;
import com.paul.CrudJavaApp2.entity.Employee;
import com.paul.CrudJavaApp2.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;



    // quick and dirty: insert employee dao (constructor injection)
    //    private EmployeeDAO employeeDAO;
    //    public EmployeeRestController(EmployeeDAO theEmployeeDAO) {
    //        employeeDAO = theEmployeeDAO;
    //    }
    public EmployeeRestController(EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }


    @GetMapping("/employees")
    public List<Employee> employees() {
        return employeeService .findAll();
    }

    @GetMapping("/employees/{id}")
    public Optional<Employee> employee(@PathVariable int id) {
        return employeeService .findById(id);
    }

    @PostMapping("/employees")
    public Employee save(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @PutMapping("/employees")
    public Employee update(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @DeleteMapping("/employees/{id}")
    public String delete(@PathVariable int id) {
        employeeService.deleteById(id);
        return "Deleted user " + id;
    }

}
