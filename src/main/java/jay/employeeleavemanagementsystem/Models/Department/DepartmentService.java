package jay.employeeleavemanagementsystem.Models.Department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Department> findDepartmentList() {
        return departmentRepository.findAll();
    }

    public Department getById(long id){
        return departmentRepository.findById(id).get();
    }

    public void create(Department department) {
        departmentRepository.save(department);
    }

    public void delete(long id){
        departmentRepository.deleteById(id);
    }
}
