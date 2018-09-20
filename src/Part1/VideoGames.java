/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Part1;

import javax.persistence.*;

@Entity
@SequenceGenerator(name = "vId_seq", initialValue = 1, allocationSize = 1)
@Table(name = "VIDEOGAMES")

@SuppressWarnings("SerializableClass")

public class VideoGames {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "eId_seq")
    @Column(name = "GAMEID")
    private int addId;

    @ManyToOne()
    @JoinColumn(name = "pidd")
    private Purchases purchase;

 

    @Column(name = "GAMENAME")
    private String addGameName;

    @Column(name = "PRICE")
    private double price;

    


    public VideoGames() {
    }

    public VideoGames(String addGameName, double price) {

        this.addGameName = addGameName;
        this.price = price;
    }

    

    public int getAddId() {
        return addId;
    }

    public Purchases getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchases purchase) {
        this.purchase = purchase;
    }

    public void setAddId(int addId) {
        this.addId = addId;
    }

    public String getAddGameName() {
        return addGameName;
    }

    public void setAddGameName(String addGameName) {
        this.addGameName = addGameName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "VideoGames{" + "addId=" + addId + ", addGameName=" + addGameName + ", price=" + price + '}';
    }

   

}
