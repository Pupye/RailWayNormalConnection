package com.sedbproj.Railways.Controllers;

import com.sedbproj.Railways.Entities.EmployeeEntity;
import com.sedbproj.Railways.Repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

//    @CrossOrigin(origins="*")
//    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
////    public List<EmployeeEntity> getEmployeeByStationId(@PathVariable("id") Integer id){
////        return
////    }
}
