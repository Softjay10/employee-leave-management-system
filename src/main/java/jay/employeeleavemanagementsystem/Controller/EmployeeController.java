package jay.employeeleavemanagementsystem.Controller;

import jay.employeeleavemanagementsystem.Models.Department.Department;
import jay.employeeleavemanagementsystem.Models.Department.DepartmentService;
import jay.employeeleavemanagementsystem.Models.Designation.Designation;
import jay.employeeleavemanagementsystem.Models.Designation.DesignationService;
import jay.employeeleavemanagementsystem.Models.Employee.Employee;
import jay.employeeleavemanagementsystem.Models.Employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DesignationService designationService;

    @Autowired
    private DepartmentService departmentService;

    /*LIST*/
    @GetMapping(value = "/employees")
    public String getEmployeeList(Model model) {
        model.addAttribute("employees", employeeService.findAllEmployee());
        return "views/backend/employees/index";
    }

    /*FORM DATA ADD*/
    @GetMapping(value = "/add-employees")
    public String getEmployeeForm(Model model, Employee employee) {
        model.addAttribute("employees", employee);
        model.addAttribute("department", departmentService.findDepartmentList());
        model.addAttribute("designations", designationService.findDesignationList());

        return "views/backend/employees/create";
    }

    /*SAVE*/
    @PostMapping(value = "/save-employees")
    public String createEmployee(Employee employee) {
        employeeService.create(employee);
        return "redirect:/employees";
    }

    /*DELETE*/
    @RequestMapping(value = "/delete-employee/{id}")
    public String deleteEmployee(@PathVariable(name = "id") Long id) {
        employeeService.delete(id);
        return "redirect:/employees";
    }

    /*EDIT*/
    @GetMapping(value = "/edit-employee/{id}")
    public String updateEmployee(@PathVariable(value = "id") Long id, Model model) {
        Employee employee = employeeService.getById(id);
        model.addAttribute("employees", employee);
        model.addAttribute("department", departmentService.findDepartmentList());
        model.addAttribute("designations", designationService.findDesignationList());
        return "views/backend/employees/update";
    }
}
