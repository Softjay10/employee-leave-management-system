package jay.employeeleavemanagementsystem.Models.LeaveType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeaveTypeRepository extends JpaRepository<LeaveType, Long> {

    @Query(value = "select count(l.id) from LeaveType l")
    long countById();

    @Query(value = "select l from LeaveType l where l.status = 'Approved' or l.status = 'Not Approved' or l.status = 'Pending'")
    List<LeaveType> getLeaveType();

    @Query(value = "select l from LeaveType l where l.status = 'Pending'")
    List<LeaveType> getPendingLeave();

    @Query(value = "select l from LeaveType l where l.status = 'Approved'")
    List<LeaveType> getApproveLeave();

    @Query(value = "select l from LeaveType l where l.status = 'Not Approved'")
    List<LeaveType> getNotApprove();

    @Query(value = "select count(l.status) from LeaveType l where l.status ='Approved'")
    long countByApproved();

    @Query(value = "select count(l.status) from LeaveType l where l.status ='Not Approved'")
    long countByNotApproved();

    @Query(value = "select count(l.status) from LeaveType l where l.status ='Pending'")
    long countByPending();

}
