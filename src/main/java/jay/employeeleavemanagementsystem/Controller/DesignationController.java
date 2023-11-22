package jay.employeeleavemanagementsystem.Controller;

import jay.employeeleavemanagementsystem.Models.Department.Department;
import jay.employeeleavemanagementsystem.Models.Designation.Designation;
import jay.employeeleavemanagementsystem.Models.Designation.DesignationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DesignationController {

    @Autowired
    private DesignationService designationService;

    @GetMapping(value = "/designation")
    public String getDesignationList(Model model) {
        model.addAttribute("designations", designationService.findDesignationList());
        return "views/backend/designation/index";
    }

    @GetMapping(value = "/add-designation")
    public String getDesignationForm(Model model, Designation designation) {
        model.addAttribute("designations", designation);
        return "views/backend/designation/create";
    }

    @PostMapping(value = "/save-designation")
    public String createDesignation(Designation designation) {
        designationService.create(designation);
        return "redirect:/designation";
    }

    @RequestMapping(value = "/delete-designation/{id}")
    public String deleteDesignation(@PathVariable(name = "id") Long id) {
        designationService.delete(id);
        return "redirect:/designation";
    }

    @GetMapping(value = "/edit-designation/{id}")
    public String updateDesignation(@PathVariable(value = "id") Long id, Model model) {
        Designation designation = designationService.getById(id);
        model.addAttribute("designations", designation);
        return "views/backend/designation/update";
    }
}
