package JPAservice;

import Part1.Employee;
import Part1.Purchases;
import Part1.Store;
import Part1.VideoGames;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

public class JPA {

    EntityManagerFactory emf;
    EntityManager em;

    public JPA() {
        emf = Persistence.createEntityManagerFactory("persistence");
        em = emf.createEntityManager();
    }

    public void addEmployee(Employee e) {
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
    }

    public void viewEmployees() {
        em.getTransaction().begin();
        TypedQuery<Employee> q = em.createQuery("select e from Employee e", Employee.class);
        List<Employee> results = q.getResultList();
        if (results.isEmpty()) {
            System.out.println("No employees found");
        } else {
            System.out.println("Employee List");
            results.forEach((e) -> {
                System.out.println(e);
            });
        }
        em.getTransaction().commit();
    }

    public void addVideoGame(VideoGames vg) {
        em.getTransaction().begin();
        em.persist(vg);
        em.getTransaction().commit();
    }

    public void viewVideoGames() {
        em.getTransaction().begin();
        TypedQuery<VideoGames> q = em.createQuery("select vg from VideoGames vg", VideoGames.class);
        List<VideoGames> results = q.getResultList();
        if (results.isEmpty()) {
            System.out.println("No video games found");
        } else {
            System.out.println("video game for sale List");
            results.forEach((vg) -> {
                System.out.println(vg);
            });
        }
        em.getTransaction().commit();
    }

    public void addPurchase(Purchases p) {
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
    }

    public void viewPurchases() {
        em.getTransaction().begin();
        TypedQuery<Purchases> q = em.createQuery("select p from Purchases p", Purchases.class);
        List<Purchases> results = q.getResultList();
        if (results.isEmpty()) {
            System.out.println("No purchases found");
        } else {
            System.out.println("purchases made List");
            results.forEach((p) -> {
                System.out.println(p);
            });
        }
        em.getTransaction().commit();
    }

    public void addStore(Store s) {
        em.getTransaction().begin();
        em.persist(s);
        em.getTransaction().commit();
    }

    public void viewStores() {
        em.getTransaction().begin();
        TypedQuery<Store> q = em.createQuery("select s from Store s", Store.class);
        List<Store> results = q.getResultList();
        if (results.isEmpty()) {
            System.out.println("No Stores found");
        } else {
            System.out.println("store List");
            results.forEach((s) -> {
                System.out.println(s);
            });
        }
        em.getTransaction().commit();
    }

    public void assignStore(int eid, int sid) {
        em.getTransaction().begin();
        Employee e = em.find(Employee.class, eid);
        Store s = em.find(Store.class, sid);
        s.addEmployee(e);
        em.getTransaction().commit();
    }

    public void removeEmpStore(int eid, int sid) {
        em.getTransaction().begin();
        Employee e = em.find(Employee.class, eid);
        Store s = em.find(Store.class, sid);
        s.removeEmployee(e);
        em.getTransaction().commit();
    }

    public void changeGamePrice(int vid, double price) {
        em.getTransaction().begin();
        VideoGames v = em.find(VideoGames.class, vid);
        v.setPrice(price);
        em.getTransaction().commit();
    }

    public void addGamePurchase(int vid, int pid) {
        em.getTransaction().begin();
        VideoGames vg = em.find(VideoGames.class, vid);
        Purchases p = em.find(Purchases.class, pid);
        p.addVG(vg);
        em.getTransaction().commit();
    }

    public void removeEmployee(int eid) {
        em.getTransaction().begin();
        Employee e = em.find(Employee.class, eid);
        List<Store> results = e.getsList();
        List<Store> temp = new ArrayList<>(results);
        for (int i = 0; i < temp.size(); i++) {
            Store s = temp.get(i);
            e.removeEmployee(s);
        }

        em.remove(e);
        em.getTransaction().commit();
    }

    public void viewStoreEmp(int sid) {
        em.getTransaction().begin();
        Store s = em.find(Store.class, sid);
        List<Employee> results = s.geteList();
        if (results.isEmpty()) {
            System.out.println("No Employees found for the store: "
                    + s.getAddStoreName());
        } else {
            System.out.println("Employee List for Store: "
                    + s.getAddStoreName());
            for (int i = 0; i < results.size(); i++) {
                System.out.println(results.get(i));
            }
        }
        em.getTransaction().commit();
    }

}
