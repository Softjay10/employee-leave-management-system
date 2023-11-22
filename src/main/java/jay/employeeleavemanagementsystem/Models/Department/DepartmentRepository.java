package jay.employeeleavemanagementsystem.Models.Department;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    @Query(value = "SELECT * FROM Department d WHERE d.id like %:keyword% OR d.departmentName like %:keyword%", nativeQuery = true)
    List<Department> findByKeyword(@Param("keyword") String keyword);
}
