package jay.employeeleavemanagementsystem.Models.Designation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DesignationService {

    @Autowired
    private DesignationRepository designationRepository;

    public List<Designation> findDesignationList() {
        return designationRepository.findAll();
    }

    public Designation getById(long id) {
        return designationRepository.findById(id).get();
    }

    public void create(Designation designation) {
        designationRepository.save(designation);
    }

    public void delete(long id) {
        designationRepository.deleteById(id);
    }
}
