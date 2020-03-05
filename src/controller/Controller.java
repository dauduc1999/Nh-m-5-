 
package controller;

import entity.Doctor;
import java.util.Date;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Hieu
 */
public class Controller {
    Scanner sc = new Scanner(System.in);
    Doctor doctor = new Doctor();
    CheckInfor checkInfor=new CheckInfor();

    public Doctor input(ArrayList<Doctor> list) {

        
        String id = (list.size()+1)+"";
        System.out.println("The id is: "+id);
        System.out.println("Enter name:");
        String name = checkInfor.checkEmpty("Please enter Name");
        System.out.println("Enter date of birth(Date-Month-Year):");
        String dateOfBirth = checkInfor.checkDate();
        System.out.println("Enter specialized:");
        String specialized = checkInfor.checkEmpty("Please enter Specialized");
        System.out.println("Enter status(1-Workking 2-Vacation:");
        int status = Integer.valueOf(checkInfor.checkStatus());

        System.out.println("Enter email:");
        String email = checkInfor.checkGmail(list);
        System.out.println("Enter phone:");
        String phone = checkInfor.checkPhone(list);
        return new Doctor(id, name, dateOfBirth, specialized, status, email, phone);

    }

    public void editDoctor(ArrayList<Doctor> list) {
        if (list.isEmpty()) {
            System.out.println("List is Empty!!");
            return;
        }
        int temp = 0;
        do {
            System.out.println("Enter ID:");
            String ID = checkInfor.checkId();
            for (int i = list.size() - 1; i >= 0; i--) {
                if (list.get(i).getId().equals(ID) == true) {
                    temp++;
                    System.out.println(list.get(i));
                    System.out.println("Do you want do update(Y/N)?");
                    String a = checkInfor.yOrN();
                    switch (a) {
                        case "Y":
                            System.out.println("Enter name:");
                            String name = checkInfor.checkEmpty("Please enter Name");
                            list.get(i).setName(name);

                            System.out.println("Enter date of birth(yyyy/mm/dd):");
                            list.get(i).setDateOFBirth(checkInfor.checkDate());

                            System.out.println("Enter specialized:");
                            String specialized = checkInfor.checkEmpty("Please enter Specialized");
                            list.get(i).setSpecialization(specialized);

                            System.out.println("Enter status(1-Working  2-Vacation :");
                            int status = Integer.valueOf(checkInfor.checkStatus());
                            list.get(i).setStatus(status);

                            System.out.println("Enter email:");
                            String email = checkInfor.checkGmail(list);
                            list.get(i).setEmail(email);

                            System.out.println("Enter phone:");
                            String phone = checkInfor.checkPhone(list);
                            list.get(i).setMobile(phone);
                            break;
                        case "N":
                            temp = 1;
                            break;
                    }
                }
            }
            if (temp == 0) {
                System.out.println("The ID isn't exsits in the list!!");
            }
        } while (temp == 0);

    }

    public void deleteDocterById(ArrayList<Doctor> list) {
        if (list.isEmpty()) {
            System.out.println("List is Empty!!");
            return;
        }
        int temp = 0;
        do {
            System.out.println("Enter ID:");
            String ID = checkInfor.checkId();
            for (int i = list.size() - 1; i >= 0; i--) {
                if (list.get(i).getId().equals(ID) == true) {
                    temp++;
                    System.out.println(list.get(i));
                    System.out.println("Do you want to delete(Y/N)?");
                    String a = checkInfor.yOrN();
                    switch (a) {
                        case "Y":
                            list.remove(i);
                            swapid(list);
                            System.out.println("Delete successfully! and Display");
                            display(list);
                            break;
                        case "N":
                            temp = 1;
                            break;
                    }
                }
            }
            if (temp == 0) {
                System.out.println("The ID isn't exsits in the list!!");
            }
        } while (temp == 0);
    }
    public void swapid(ArrayList<Doctor> list)
    {
        for(int i=0;i<list.size();i++)
        {
            list.get(i).setId((i+1)+"");
        }
    }

    public void search(ArrayList<Doctor> list) {
        Doctor d=new Doctor();
        System.out.println("Enter id:");
        String id = checkInfor.checkId();
        boolean check=false;
        for (int i = 0; i < list.size(); i++) {
            if (id.equals(list.get(i).getId())==true) {
                check = true;
                d=list.get(i);
                break;
            }
        }
        if (check == false) {
            System.out.println("Nothing!!");
        }
        else{
            System.out.println(d.toString());;
        }
    }

    public void sort(ArrayList<Doctor> list) {
        list.sort((o1, o2) -> o1.getDateOFBirth().compareTo(o2.getDateOFBirth()));

    }

    public void display(ArrayList<Doctor> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).toString());
        }
    }

}
