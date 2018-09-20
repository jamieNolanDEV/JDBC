/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Part1;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.*;

@Entity
@SequenceGenerator(name = "eId_seq", initialValue = 1, allocationSize = 1)
@Table(name = "EMPLOYEE")

@SuppressWarnings("SerializableClass")

public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "eId_seq")
    @Column(name = "EMPID")
    private int addEmployeeId;
    @Column(name = "EMPFNAME")
    private String addFName;
    @Column(name = "EMPLNAME")
    private String addLname;

    @Column(name = "startdate")
    @Temporal(TemporalType.DATE)
    private Calendar startdate;
    
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "EMPSTORE",
            joinColumns = @JoinColumn(name = "eid"),
              inverseJoinColumns = @JoinColumn(name = "SID"))
     private List<Store> sList = new ArrayList<>();

    public Employee() {
    }

    public Employee(String addFName, String addLname, Calendar startdate) {
        this.addFName = addFName;
        this.addLname = addLname;
        this.startdate = startdate;
    }

    public int getAddEmployeeId() {
        return addEmployeeId;
    }

    public void setAddEmployeeId(int addEmployeeId) {
        this.addEmployeeId = addEmployeeId;
    }

  
    public Calendar getStartdate() {
        return startdate;
    }

    public void setStartdate(Calendar startdate) {
        this.startdate = startdate;
    }

    

    public void setEmployeeId(int empID) {
        this.addEmployeeId = empID;
    }

    public String getAddFName() {
        return addFName;
    }

    public void setAddFName(String addFName) {
        this.addFName = addFName;
    }

    public String getAddLname() {
        return addLname;
    }

    public void setAddLname(String addLname) {
        this.addLname = addLname;
    }

    public List<Store> getsList() {
        return sList;
    }

    public void setsList(List<Store> sList) {
        this.sList = sList;
    }

    
    
    
    @Override
    public String toString() {
        String d = String.format("%1$s %2$tB %2$td, %2$tY",
                " Start date: ", startdate);
     
        return "Employee{" + "addEmployeeId=" + addEmployeeId + ", addFName=" + addFName + ", addLname=" + addLname +  d;
    }

    public void removeEmployee(Store s) {
       sList.remove(s);
        s.geteList().remove(this);
    }

    


  
}
