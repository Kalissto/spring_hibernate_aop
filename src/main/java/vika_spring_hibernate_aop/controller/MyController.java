package vika_spring_hibernate_aop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vika_spring_hibernate_aop.entity.Employe;
import vika_spring_hibernate_aop.service.EmployeService;

import java.util.List;

@Controller
public class MyController {
    @Autowired
    private EmployeService employeService;
    @RequestMapping("/")
    public String showAllEmployes(Model model){
       List<Employe> allUsers = employeService.getAllEmployes();
       model.addAttribute("allEmps", allUsers);
return "all-employes";
    }
    @RequestMapping("/addNewEmployee")
    public String addNewEmploye(Model model){
        Employe employe =new Employe();
        model.addAttribute("employe", employe);
return "employe-info";
    }
    @RequestMapping("/saveEmploye")
    public String saveEmploye(@ModelAttribute("employe") Employe employe){
        employeService.saveEmploye(employe);
        return "redirect:/";
    }
    @RequestMapping("/updateInfo")
    public String updateEmploye(@RequestParam("empId") int id,Model model){
        Employe employe =employeService.getEmploye(id);
        model.addAttribute("employe", employe);
return "employe-info" ;
    }
    @RequestMapping("/deleteEmploye")
    public String deleteEmploye(@RequestParam("empId")int id,Model model){
        employeService.deleteEmploye(id);
return "redirect:/";
    }
}
