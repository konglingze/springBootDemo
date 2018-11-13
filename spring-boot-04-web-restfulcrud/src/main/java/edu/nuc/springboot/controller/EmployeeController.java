package edu.nuc.springboot.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import edu.nuc.springboot.dao.DepartmentDao;
import edu.nuc.springboot.dao.EmployeeDao;
import edu.nuc.springboot.entities.Department;
import edu.nuc.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.naming.Name;
import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;

    @GetMapping("emps")
    public String list(Model model) {
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps", employees);
        return "emp/list";
    }

    @GetMapping("emp")
    public String toAddPage(Model model) {
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        return "emp/add";
    }

    @PostMapping("/emp")
    public String addEmp(@RequestParam("name") String name, Employee employee) {
        if (!name.equals("")) {
            employee.setLastName(name);
        }
        System.out.println(employee.toString());
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id, Model model) {
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp", employee);
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        return "emp/add";
    }

    @PutMapping("/emp")
    public String updatePage(@RequestParam("name") String name, Employee employee) {
        if (!name.equals("")) {
            employee.setLastName(name);
        }
        System.out.println(employee.toString());
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @DeleteMapping("/emp/{id}")
    public String toDeleteEmp(@PathVariable("id") Integer id) {
        employeeDao.delete(id);
        return "redirect:/emps";

    }
}