/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Doctor;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Hieu
 */
public class CheckInfor {

    Scanner sc = new Scanner(System.in);

    public String yOrN() {
        String a = null;
        boolean check = false;
        do {
            a = sc.nextLine().toUpperCase();
            if (checkYesNo(a) == false) {
                System.out.println("Please re-enter Y/N: ");
                check = false;
            } else {
                check = true;
            }
        } while (!check);
        return a;
    }

    //Check id
    public String checkId() {
        String a = null;
        boolean check = true;
        do {
            a = sc.nextLine();
            if (checkID(a) == false) {
                System.out.println("Please re-enter a ID: ");
                check = false;
            } else {
                check = true;
            }
        } while (!check);
        return a;
    }

    public String checkId(ArrayList<Doctor> list) {
        String a = null;
        boolean check = true;
        do {
            a = sc.nextLine();
            if (checkID(a) == false) {
                System.out.println("Please re-enter a ID: ");
                check = false;
            } else if (duplicate(list, a, 2) == false) {
                System.out.println("ID already exists in the system");
                check = false;
            } else {
                check = true;
            }
        } while (!check);
        return a;
    }

    //Check Name
    public String checkEmpty(String text) {
        String a = null;
        boolean check = true;
        do {
            a = sc.nextLine().trim();
            if (checkName(a) == false) {
                System.out.println(text);
                check = false;
            } else {
                check = true;
            }
        } while (!check);
        return a;
    }

    //Check gmail number
    public String checkGmail(ArrayList<Doctor> list) {
        String a = null;

        boolean check = true;
        do {
            a = sc.nextLine();
            if (checkGmail(a) == false) {
                System.out.println("Please re-enter gmail(with format <account name>@<domain>.ss): ");
                check = false;
            } else if (duplicate(list, a, 0) == false) {
                System.out.println("Email already exists in the system");
                check = false;
            } else {
                check = true;
            }
        } while (!check);
        return a;
    }

    //check phone
    public String checkPhone(ArrayList<Doctor> list) {
        String a = null;

        boolean check = true;
        do {
            a = sc.nextLine();
            if (checkPhone(a) == false) {
                System.out.println("Please re-enter phone number: ");
                check = false;
            } else if (duplicate(list, a, 1) == false) {
                System.out.println("Phone number already exists !!,input again :");
                check = false;
            } else {
                check = true;
            }
        } while (check == false);
        return a;
    }

    boolean duplicate(ArrayList<Doctor> list, String str, int key) {
        for (int i = 0; i < list.size(); i++) {
            if (key == 0) {
                if (list.get(i).getEmail().equals(str)) {
                    return false;
                }
            } else if (key == 1) {
                if (list.get(i).getMobile().equals(str)) {
                    return false;
                }
            } else if (key == 2) {
                if (list.get(i).getId().equals(str)) {
                    return false;
                }
            }
        }
        return true;
    }

    public String checkChoise() {
        String a = null;
        boolean check = false;
        do {
            a = sc.nextLine();
            if (checkChoise(a) == false) {
                System.out.println("Please re-enter an option: ");
                check = false;
            } else {
                check = true;
            }
        } while (check == false);
        return a;
    }

    public String checkStatus() {
        String a = null;
        boolean check = false;
        do {
            a = sc.nextLine();
            if (checkStatus(a) == false) {
                System.out.println("Please re-enter an number(1 or 2): ");
                check = false;
            } else {
                check = true;
            }
        } while (!check);
        return a;
    }

    public String checkDate() {

        String date = null;
        boolean check = false;
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        df.setLenient(false);
// set false để kiểm tra tính hợp lệ của date. VD: tháng 2 phải có 28-29 ngày, năm có 12 tháng,....
        do {
            date =sc.nextLine();
            try {
                String Check = df.parse(date) +"";
                check = true;
            } catch (ParseException e) {
                System.out.println("Invalid date, Please Enter again:");
            }
        } while (check == false);
        return date;
    }

    public boolean checkYesNo(String str) {
        String check = "[Y|N]{1}";
        return str.matches(check);
    }

    public boolean checkID(String str) {
        String check = "({2}[0-9]{1})";
        return str.matches(check);
    }

    public boolean checkName(String str) {
        String check = "[a-zA-Z]{1,}";
        return str.matches(check);
    }

    public boolean checkChoise(String str) {
        String check = "[1-7]{1}";
        return str.matches(check);
    }

    public boolean checkStatus(String str) {
        String check = "[1-2]{1}";
        return str.matches(check);
    }

    public boolean checkGmail(String str) {
        String check = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return str.matches(check);
    }

    public boolean checkPhone(String str) {
        String check = "\\d{10}";
        return str.matches(check);
    }

}
