package jay.employeeleavemanagementsystem.Models.Employee;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    private int employeeNumber;
    private String firstName;
    private String middleName;
    private String lastName;
    private String gender;
    private String email;
    private String contact;
    private int age;
    private String department;
    private String designation;
    private String username;
    private String password;
    private String status;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateRegister;
}
