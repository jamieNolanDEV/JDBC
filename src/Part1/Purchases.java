/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Part1;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@SequenceGenerator(name = "pId_seq", initialValue = 1, allocationSize = 1)
@Table(name = "PURCHASES")

@SuppressWarnings("SerializableClass")

public class Purchases {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pId_seq")
    @Column(name = "PURCHASEID")
    private int addId;

    @OneToMany(mappedBy = "purchase", cascade = CascadeType.ALL)
    private List<VideoGames> vList = new ArrayList<>();

    public Purchases() {
    }

    public Purchases(int addId) {
        this.addId = addId;
    }

    public int getAddId() {
        return addId;
    }

    public void setAddId(int addId) {
        this.addId = addId;
    }

    public List<VideoGames> getvList() {
        return vList;
    }

    public void setvList(List<VideoGames> vList) {
        this.vList = vList;
    }

    public void addVG(VideoGames vg) {
        vList.add(vg);
        vg.setPurchase(this);
    }

    @Override
    public String toString() {
        return "Purchases{" + "addId=" + addId + ", vList=" + vList + '}';
    }

}
