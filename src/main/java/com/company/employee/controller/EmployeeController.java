package com.company.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.employee.model.Employee;
import com.company.employee.service.EmployeeService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // LIST EMPLOYEES
    @GetMapping
    public String listEmployees(Model model, HttpSession session) {
        if (session.getAttribute("user") == null) {
            return "redirect:/login";
        }

        model.addAttribute("employees", employeeService.getAll());
        return "employee-list";
    }

    // SHOW ADD FORM
    @GetMapping("/add")
    public String showAddForm(Model model, HttpSession session) {
        if (session.getAttribute("user") == null) {
            return "redirect:/login";
        }

        model.addAttribute("employee", new Employee());
        return "employee-form";
    }

    // SAVE EMPLOYEE
    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute Employee employee, HttpSession session) {
        if (session.getAttribute("user") == null) {
            return "redirect:/login";
        }

        employeeService.save(employee);
        return "redirect:/employees";
    }

    // SHOW EDIT FORM
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model, HttpSession session) {
        if (session.getAttribute("user") == null) {
            return "redirect:/login";
        }

        model.addAttribute("employee", employeeService.get(id));
        return "employee-form";
    }

    // DELETE EMPLOYEE
    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id, HttpSession session) {
        if (session.getAttribute("user") == null) {
            return "redirect:/login";
        }

        employeeService.delete(id);
        return "redirect:/employees";
    }
}
