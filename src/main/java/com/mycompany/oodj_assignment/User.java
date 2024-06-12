/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oodj_assignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class User {
    String user;
    String pass;
    
    public User() {
    }

    public User(String user) {
        this.user = user;
    }
    
    public User(String user, String pass) {
        this.user = user;
        this.pass = pass;
    }
    
    public void registerUser(String id, String pass, String role, String apWallet, String name, String tel){
        File f = new File("userAcc.txt");
        try {
            FileWriter fw = new FileWriter(f,true);
            fw.write(id+", "+pass+", "+role+", "+apWallet+", "+name+", "+tel+"\n");
            fw.close();
            String stat = "Register an user: UID:"+id+"  Role:"+role+"  apW:"+apWallet+"  Name:"+name+"  Tel:"+tel;
            logRecord(user, stat);
        } catch (IOException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public int getNewID(){
        File f = new File("userAcc.txt");
        int linecount = 0;
        try (Scanner sc = new Scanner(f)) {
            while(sc.hasNextLine()){
                sc.nextLine();
                linecount++;
            }
            sc.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        return linecount;
    }
    
    public void logRecord(String user, String stat){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();  
        File f = new File("logRecord.txt");
        try {
            FileWriter fw = new FileWriter(f,true);
            if ("in".equals(stat)) {
                fw.write(user+", "+"login"+", "+dtf.format(now)+"\n");
            }
            else if ("out".equals(stat)){
                fw.write(user+", "+"log out"+", "+dtf.format(now)+"\n");
            }
            else{
                fw.write(user+", "+stat+", "+dtf.format(now)+"\n");
            }
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean login(){
        if ("root".equals(user) && "toor".equals(pass)) {
            new StaffMenu("root","root","root").setVisible(true);
            logRecord(user, "in");
            return true;
        }
        else if (!"".equals(user) && !"".equals(pass)) {
            try {
                File f = new File("userAcc.txt");
                Scanner sc = new Scanner(f);
                while(sc.hasNextLine()){
                    String line = sc.nextLine();
                    String[] acc = line.split(", ");
                    if (acc[0].equals(user) && acc[1].equals(pass)){
                        sc.close();
                        switch (acc[2]) {
                            case "Manager" -> new StaffMenu(acc[0],acc[4],acc[2]).setVisible(true);
                            case "Customer" -> new CusMenu(acc[0],acc[4],acc[2]).setVisible(true);
                        }
                        logRecord(user, "in");
                        return true;
                    }
                }
                sc.close();
            } catch (FileNotFoundException ex) { 
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(null,"Incorrect UserID or Password.","Alert",JOptionPane.WARNING_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(null,"Please fill in the details.","Alert",JOptionPane.WARNING_MESSAGE);
        }
        return false;
    }
    
    ArrayList<ArrayList<String>> getUsers(){
        ArrayList<ArrayList<String>> users = new ArrayList<>();
        File f = new File("userAcc.txt");
        try (Scanner sc = new Scanner(f)){
            while (sc.hasNextLine()) {
                ArrayList<String> line = new ArrayList<>();     
                String nextLine = sc.nextLine();
                String[] acc = nextLine.split(", ");
                for (int i = 0; i < acc.length; i++) {
                    line.add(acc[i]);
                }
                users.add(line);
            }
            sc.close();
        } catch (FileNotFoundException ex) { 
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }
    
    ArrayList<ArrayList<String>> getLog(){
        ArrayList<ArrayList<String>> log = new ArrayList<>();
        File f = new File("logRecord.txt");
        try (Scanner sc = new Scanner(f)){
            while (sc.hasNextLine()) {
                ArrayList<String> line = new ArrayList<>();     
                String nextLine = sc.nextLine();
                String[] items = nextLine.split(",");
                for (int i = 0; i < items.length; i++) {
                    line.add(items[i]);
                }
                log.add(line);
            }
            sc.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        return log;
    }
    
    String[] getProf(){
        String[] prof = null;
        File f = new File("userAcc.txt");
        try (Scanner sc = new Scanner(f)){
            while (sc.hasNextLine()) {   
                String nextLine = sc.nextLine();
                prof = nextLine.split(", ");
                if ((prof[0].equals(user))) {
                    break;
                }
            }
            sc.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        return prof;
    }
    
    void updateProf(String uName, String pass, String tel){
        String[] oldAcc = null;
        ArrayList<ArrayList<String>> users = new ArrayList<>();
        File f = new File("userAcc.txt");
        try (Scanner sc = new Scanner(f)){
            while (sc.hasNextLine()) {
                ArrayList<String> line = new ArrayList<>();     
                String nextLine = sc.nextLine();
                String[] acc = nextLine.split(", ");
                if (acc[0].equals(user)) {
                    oldAcc = acc;
                    acc[1]=pass;
                    acc[4]=uName;
                    acc[5]=tel;
                }
                for (int i = 0; i < acc.length; i++) {
                    line.add(acc[i]);
                }
                users.add(line);
            }
            sc.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            FileWriter fw = new FileWriter(f);
            for (int i = 0; i < users.size(); i++) {
                ArrayList<String> acc = users.get(i);
                fw.write(acc.get(0)+", "+acc.get(1)+", "+acc.get(2)+", "+acc.get(3)+", "+acc.get(4)+", "+acc.get(5)+"\n");
            }
            fw.close();
            String stat = "Update Profile:  Username:"+oldAcc[4]+" to "+uName+"  Password:******"+"  Tel:"+oldAcc[5]+" to "+tel;
            User o = new User();
            o.logRecord(user, stat);
            JOptionPane.showMessageDialog(null,"Profile update successful.","Info",JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    boolean payOrder(String total) {
        boolean flag = false;
        ArrayList<ArrayList<String>> users = new ArrayList<>();
            File f = new File("userAcc.txt");
            try (Scanner sc = new Scanner(f)){
                while (sc.hasNextLine()) {
                    ArrayList<String> line = new ArrayList<>();     
                    String nextLine = sc.nextLine();
                    String[] acc = nextLine.split(", ");
                    if (acc[0].equals(user)) {
                        float bal = Float.parseFloat(acc[3])-Float.parseFloat(total);
                        if (bal >= 0) {
                            acc[3] = String.format("%.2f",bal);
                            flag = true;
                        }
                        else{
                            break;
                        }
                    }
                    for (int i = 0; i < acc.length; i++) {
                        line.add(acc[i]);
                    }
                    users.add(line);
                }
                sc.close();
            } catch (FileNotFoundException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
            if (flag==true) {
            try {
                FileWriter fw = new FileWriter(f);
                for (int i = 0; i < users.size(); i++) {
                    ArrayList<String> acc = users.get(i);
                    fw.write(acc.get(0)+", "+acc.get(1)+", "+acc.get(2)+", "+acc.get(3)+", "+acc.get(4)+", "+acc.get(5)+"\n");
                }
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
        return flag;
    }

    
}
