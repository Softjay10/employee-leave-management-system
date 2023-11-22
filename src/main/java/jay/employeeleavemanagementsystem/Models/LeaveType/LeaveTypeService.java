package jay.employeeleavemanagementsystem.Models.LeaveType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaveTypeService {

    @Autowired
    private LeaveTypeRepository leaveTypeRepository;

    public List<LeaveType> findAllLeaveType() {
        return leaveTypeRepository.findAll();
    }

    public LeaveType getById(Long id) {
        return leaveTypeRepository.findById(id).get();
    }

    public void create(LeaveType leaveType) {
        leaveTypeRepository.save(leaveType);
    }

    public void delete(long id){
        leaveTypeRepository.deleteById(id);
    }

    /*All Leave Type*/
    public List<LeaveType> findAllLeaveTypes() {
        return leaveTypeRepository.getLeaveType();
    }

    /*Pending*/
    public List<LeaveType> findAllPendingLeave(){
        return leaveTypeRepository.getPendingLeave();
    }

    /*Approved*/
    public List<LeaveType> findAllApproved() {
        return leaveTypeRepository.getApproveLeave();
    }

    public List<LeaveType> findAllNotApproved() {
        return leaveTypeRepository.getNotApprove();
    }
}
