package ch.bbw.df.app.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
@NamedQuery(name = "Employee.findAll", query = "SELECT e from Employee e")
public class Employee {
    @Id
    @Column(name = "id", unique = true)
    private int id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "dept_id")
    private int departmentId;

    @Override
    public String toString() {
        return String.format("Employee: [id = %d, firstname = %s, lastname = %s, dept_id=%d]", id, firstName, lastName, departmentId);
    }

    
}