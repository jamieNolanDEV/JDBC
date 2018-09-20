package Part1;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@SequenceGenerator(name = "sId_seq", initialValue = 1, allocationSize = 1)
@Table(name = "Store")

@SuppressWarnings("SerializableClass")

public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sId_seq")
    @Column(name = "STOREID")
    private int addId;
    @Column(name = "STORENAME")
    private String addStoreName;
    @Column(name = "STORELOCATION")
    private String addStoreLocation;

    @ManyToMany(mappedBy = "sList", cascade = CascadeType.PERSIST)
    private List<Employee> eList = new ArrayList<>();

    public Store() {
    }

    public Store(String addStoreName, String addStoreLocation) {

        this.addStoreName = addStoreName;
        this.addStoreLocation = addStoreLocation;
    }

    public List<Employee> geteList() {
        return eList;
    }

    public void seteList(List<Employee> eList) {
        this.eList = eList;
    }

    public int getAddId() {
        return addId;
    }

    public void setAddId(int addId) {
        this.addId = addId;
    }

    public String getAddStoreName() {
        return addStoreName;
    }

    public void setAddStoreName(String addStoreName) {
        this.addStoreName = addStoreName;
    }

    public String getAddStoreLocation() {
        return addStoreLocation;
    }

    public void setAddStoreLocation(String addStoreLocation) {
        this.addStoreLocation = addStoreLocation;
    }

    public void removeEmployee(Employee e) {
        eList.remove(e);
        e.getsList().remove(this);
    }

    public void addEmployee(Employee e) {
        eList.add(e);
        e.getsList().add(this);
    }

    public void remove() {
        ArrayList<Employee> temp = new ArrayList<>(eList);
        for (int i = 0; i < temp.size(); i++) {
            removeEmployee(temp.get(i));
        }
    }

    @Override
    public String toString() {
        return "Store{" + "Store Id=" + addId + ", addStoreName=" + addStoreName + ", addStoreLocation=" + addStoreLocation + ", eList=" + eList + '}';
    }

}
