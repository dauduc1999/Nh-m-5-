/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import entity.Doctor;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;
import controller.Controller;
/**
 *
 * @author Hieu
 */
public class Main {
    public static void main(String[] args) {
        Doctor doctor = new Doctor();
        Scanner scanner = new Scanner(System.in);
        Controller con=new Controller();;
        ArrayList<Doctor> doctors = new ArrayList<>();
        doctors.add(new Doctor("1", "Trinh Minh Hieu","2-2-1999", "abc", 0, "hungvd@gmail.com", "1234567890"));
        doctors.add(new Doctor("2", "Nguyen Tan Phat", "12-03-2003", "xyz", 1, "ahs@yahoo.com", "0123456789"));
        doctors.add(new Doctor("3", "Tran Minh Hieu","22-4-2013", "dfg", 2, "Hieutmhe130@fpt.vn", "1324567890"));
        doctors.add(new Doctor("4", "Tran Nhat Hoang","2-12-2014", "4rd", 3, "Hoangtn@gmail.com", "0192837465"));

        do {
            menu();
            int choise = Integer.valueOf(scanner.nextLine());
            switch (choise) {
                case 1:
                    doctors.add(con.input(doctors));
                    break;
                case 2:
                    con.editDoctor(doctors);
                    break;
                case 3:
                    con.deleteDocterById(doctors);
                    break;
                case 4:
                    con.search(doctors);
                    break;
                case 5:
                    con.sort(doctors);
                    con.display(doctors);
                    break;
                case 6:
                    con.display(doctors);
                    break;
                case 7:
                    System.exit(0);
                    break;

            }
        } while (true);

    }

    public static void menu() {
        System.out.println("1.Create a Doctor");
        System.out.println("2.Edit a DOctor information");
        System.out.println("3.Delete a Doctor");
        System.out.println("4.Search doctor by ID and by Name");
        System.out.println("5.Sort doctor by DateOfBirth");
        System.out.println("6.Display");
        System.out.println("7.Exit");

    }

}
