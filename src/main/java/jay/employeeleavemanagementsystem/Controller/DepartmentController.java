package jay.employeeleavemanagementsystem.Controller;

import jay.employeeleavemanagementsystem.Models.Department.Department;
import jay.employeeleavemanagementsystem.Models.Department.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping(value = "/departments")
    public String getDepartmentList(Model model) {
        model.addAttribute("department", departmentService.findDepartmentList());
        return "views/backend/department/index";
    }

    @GetMapping(value = "/add-department")
    public String getDepartmentForm(Model model, Department department) {
        model.addAttribute("department", department);
        return "views/backend/department/create";
    }

    @PostMapping(value = "/save")
    public String createDepartment(Department department) {
        departmentService.create(department);
        return "redirect:/departments";
    }

    @RequestMapping(value = "/delete-department/{id}")
    public String deleteDepartment(@PathVariable(name = "id") Long id) {
        departmentService.delete(id);
        return "redirect:/departments";
    }

    @GetMapping(value = "/edit-department/{id}")
    public String updateArtist(@PathVariable(value = "id") Long id, Model model) {
        Department department = departmentService.getById(id);
        model.addAttribute("department", department);
        return "views/backend/department/update";
    }
}
