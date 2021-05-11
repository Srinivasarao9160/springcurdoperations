package com.myapp.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myapp.dao.DeptRepo;
import com.myapp.department.Department;

@Controller
public class DeptController {
    @Autowired
    private DeptRepo depts;
    @RequestMapping("/adddept")
    public String addDept(ModelMap model) {
        Department d = new Department();
        model.addAttribute("depts",d);
        return "add_dept";
    }
    @RequestMapping(value = "/adddept",method = RequestMethod.POST)
    public String addDept(@Valid Department d,Errors error,ModelMap model) {
        try {
            if(error.getErrorCount()>0) throw new RuntimeException(error.toString());
            
            if(depts.findById(d.getId()).isPresent()) throw new RuntimeException("Dept Id exits");
            depts.save(d);
            return "redirect:/deptlist";
        }
        catch(Exception ex){
            model.addAttribute("depts",d);
            model.addAttribute("message", ex.getMessage());
            return "add_dept";
        }
    }
    @RequestMapping("/deptlist")
    public String getDeptList(ModelMap model) {
        model.addAttribute("depts",depts.findAll());
        return "deptlist";
    }

    @RequestMapping("/deletedept/{id}")
    public String deleteDept(@PathVariable("id") int id,ModelMap model) {
    	Optional<Department> dept = depts.findById(id);
    	if(dept.isPresent()) {
    		depts.delete(dept.get());
    		return "redirect:/deptlist";
    	}
    	else {
    		 model.addAttribute("error","dept not found");
    		 return "deptlist";
		}
    }
      
       
    }
    