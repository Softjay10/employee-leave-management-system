package jay.employeeleavemanagementsystem.Controller;

import jay.employeeleavemanagementsystem.Models.Employee.Employee;
import jay.employeeleavemanagementsystem.Models.LeaveType.LeaveType;
import jay.employeeleavemanagementsystem.Models.LeaveType.LeaveTypeRepository;
import jay.employeeleavemanagementsystem.Models.LeaveType.LeaveTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LeaveTypeController {

    @Autowired
    private LeaveTypeService leaveTypeService;

    @Autowired
    private LeaveTypeRepository leaveTypeRepository;

    @GetMapping(value = "/leaveType")
    public String getLeaveTypeList(Model model) {
        model.addAttribute("leaveType", leaveTypeService.findAllLeaveType());
        return "views/backend/leaveType/index";
    }

    @GetMapping(value = "/add-leaveType")
    public String getLeaveTypeForm(Model model, LeaveType leaveType) {
        model.addAttribute("leaveType", leaveType);
        return "views/backend/leaveType/create";
    }

    /*SAVE*/
    @PostMapping(value = "/save-leaveType")
    public String createLeaveType(LeaveType leaveType) {
        leaveTypeService.create(leaveType);
        return "redirect:/leaveType";
    }

    /*DELETE*/
    @RequestMapping(value = "/delete-leaveType/{id}")
    public String deleteLeaveType(@PathVariable(name = "id") Long id) {
        leaveTypeService.delete(id);
        return "redirect:/leaveType";
    }

    /*EDIT*/
    @GetMapping(value = "/edit-leaveType/{id}")
    public String updateLeaveType(@PathVariable(value = "id") Long id, Model model) {
        LeaveType leaveType = leaveTypeService.getById(id);
        model.addAttribute("leaveType", leaveType);
        return "views/backend/leaveType/update";
    }

    /*All Leave Type*/
    @GetMapping(value = "/allLeaveTypes")
    public String listAllLeaveType(Model model) {
        model.addAttribute("allLeaveType", leaveTypeService.findAllLeaveTypes());
        return "views/backend/allLeaveType/index";
    }

    /*Pending Leave*/
    @GetMapping(value = "/pendingLeave")
    public String listPendingLeave(Model model) {
        model.addAttribute("pendingLeave", leaveTypeService.findAllPendingLeave());
        return "views/backend/pendingLeave/index";
    }

    /*Approved*/
    @GetMapping(value = "/approvedLeave")
    public String listApproveLeave(Model model) {
        model.addAttribute("approveLeave", leaveTypeService.findAllApproved());
        return "views/backend/approvedLeave/index";
    }

    /*Not Approved*/
    @GetMapping(value = "/notApprovedLeave")
    public String listNotApprovedLeave(Model model) {
        model.addAttribute("notApproveLeave", leaveTypeService.findAllNotApproved());
        return "views/backend/notApprovedLeave/index";
    }

}
