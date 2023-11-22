package jay.employeeleavemanagementsystem.Controller;

import jay.employeeleavemanagementsystem.Models.Employee.EmployeeRepository;
import jay.employeeleavemanagementsystem.Models.LeaveType.LeaveTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private LeaveTypeRepository leaveTypeRepository;

    @GetMapping(value = "/")
    public String goDashboard(Model model){
        model.addAttribute("employee", employeeRepository.countById());
        model.addAttribute("leaveType", leaveTypeRepository.countById());
        model.addAttribute("approved", leaveTypeRepository.countByApproved());
        model.addAttribute("notApproved", leaveTypeRepository.countByNotApproved());
        model.addAttribute("pending", leaveTypeRepository.countByPending());
        return "views/backend/dashboard/index";
    }
}
