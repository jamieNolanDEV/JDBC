/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

/**
 *
 * @author Josh
 */
import JPAservice.JPA;
import Part1.*;
import java.util.Calendar;
import java.util.Scanner;

public class Test {

    static JPA jpa = new JPA();

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.println("Please press 1 to view all employees");
            System.out.println("Please press 2 to view all videogames");
            System.out.println("Please press 3 to view all purchases");
            System.out.println("Please press 4 to view stores");
            System.out.println("Please press 5 to add a new Video Game");
            System.out.println("Please press 6 to add a new  employee");
            System.out.println("Please press 7 to add a new store");
            System.out.println("Please press 8 to change the price of a video game");
            System.out.println("Please press 9 to remove an employee from a Store");
            System.out.println("Please press 10 to assign a employee to a store");
            System.out.println("Please press 11 to make a purchase of a video game");
            System.out.println("Preass 12 to see the which employees are assigned to which stores");
            System.out.println("Please press 13 to delete an employee");
            System.out.println("Press 14 to quit");

            int choice = in.nextInt();
            in.nextLine();

            switch (choice) {

                case 1:
                    jpa.viewEmployees();
                    break;

                case 2:
                    jpa.viewVideoGames();
                    break;
                case 3:
                    jpa.viewPurchases();
                    break;
                case 4:
                    jpa.viewStores();
                    break;

                case 5:
                    System.out.println("Please enter  the name of the Game you wish to add: ");
                    String addGameName = in.nextLine();
                    System.out.println("Please enter the price of the game you wish to add: ");
                    double price = in.nextDouble();
                    VideoGames vg = new VideoGames(addGameName, price);
                    jpa.addVideoGame(vg);

                    break;

                case 6:
                    System.out.println("Please enter the first name of the employee you wish to add: ");
                    String addFName = in.nextLine();
                    System.out.println("Please enter the last name of the employee you wish to add: ");
                    String addLName = in.nextLine();
                    System.out.println("Please enter the start year of the employee: ");
                    int year = in.nextInt();
                    in.nextLine();
                    System.out.println("Please enter the start month of the employee: ");
                    int month = in.nextInt();
                    in.nextLine();
                    System.out.println("Please enter the start day of the employee: ");
                    int day = in.nextInt();
                    in.nextLine();
                    Calendar startDate = Calendar.getInstance();
                    startDate.set(year, month, day);
                    Employee e = new Employee(addFName, addLName, startDate);
                    jpa.addEmployee(e);

                    break;
                case 7:
                    System.out.println("Please eneter the name of the store: ");
                    String addStoreName = in.nextLine();
                    System.out.println("Please enter the location of the store: ");
                    String addStoreLoacation = in.nextLine();

                    jpa.addStore(new Store(addStoreName, addStoreLoacation));
                    break;
                case 8:
                    System.out.println("please enter the id of the video game you wish to change the price of: ");
                    int vid = in.nextInt();
                    in.nextLine();
                    System.out.println("please enter the new price: ");
                    double Vprice = in.nextDouble();
                    jpa.changeGamePrice(vid, Vprice);
                    break;

                case 9:
                    System.out.println("Please enter the id of the Store you wish to remove an employee from: ");
                    int sid = in.nextInt();
                    System.out.println("Please enter the id of the employee you wish to remove from the Store: ");
                    int eid = in.nextInt();
                    jpa.removeEmpStore(eid, sid);
                    break;
                case 10:
                    System.out.println("Please enter the employee id in order to assign a Store: ");
                    eid = in.nextInt();
                    in.nextLine();
                    System.out.println("Please enter the id of the store you wish to assign to employee: " + eid);
                    sid = in.nextInt();
                    jpa.assignStore(eid, sid);
                    break;

                case 11:
                    Purchases puu = new Purchases();
                    int piid = 1;
                    if (choice == 11) {
                        piid++;
                        System.out.println("Please enter the video game id you wish to purchase");
                        vid = in.nextInt();
                        in.nextLine();
                      

                        jpa.addGamePurchase(vid, puu.getAddId());

                        break;
                    } else {
                    }
                case 12:
                    System.out.println("Please enter the Store id in order to view the employees that are assigned to the store: ");
                    int ssid = in.nextInt();
                    in.nextLine();
                    jpa.viewStoreEmp(ssid);
                    break;
                case 13:
                    System.out.println("Please enter the id of the employee you wish to delete: ");
                    eid = in.nextInt();
                    jpa.removeEmployee(eid);
                    break;
                case 14:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Option entered");
                    break;
            }

        }
    }
}
