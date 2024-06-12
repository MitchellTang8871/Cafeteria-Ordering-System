/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oodj_assignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class Order {
    String user;
    String role;

    public Order() {
    }

    public Order(String user) {
        this.user = user;
    }

    public Order(String user, String role) {
        this.user = user;
        this.role = role;
    }
    
    void registerOrder(ArrayList<ArrayList<String>> cart, String total){
        File f = new File("order.txt");
        try {
            f.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(Order.class.getName()).log(Level.SEVERE, null, ex);
        }
        int linecount = 0;
        try (Scanner sc = new Scanner(f)) {
            while(sc.hasNextLine()){
                sc.nextLine();
                linecount++;
            }
            sc.close();
            FileWriter fw = new FileWriter(f,true);
            fw.write(linecount+", "+user+", "+LocalDate.now().toString()+", "+total+", "+"Pending");
            for (int i = 0; i < cart.size(); i++) {
                fw.write(", "+cart.get(i).get(0)+", "+cart.get(i).get(1));
            }
            fw.write("\n");
            fw.close();
            String stat = "Make an order: Order ID:"+linecount+"  Total: RM "+total;
            User o = new User();
            o.logRecord(user, stat);
            JOptionPane.showMessageDialog(null,"Order successfully added. Your Order ID is "+linecount,"Info",JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            Logger.getLogger(Order.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    ArrayList<ArrayList<String>> getOrders(){
        ArrayList<ArrayList<String>> orders = new ArrayList<>();
        File f = new File("order.txt");
        try (Scanner sc = new Scanner(f)){
            while (sc.hasNextLine()) {
                ArrayList<String> line = new ArrayList<>();     
                String nextLine = sc.nextLine();
                String[] items = nextLine.split(", ");
                for (int i = 0; i < 5; i++) {
                    line.add(items[i]);
                }
                orders.add(line);
            }
            sc.close();
        } catch (FileNotFoundException ex) { 
            Logger.getLogger(Order.class.getName()).log(Level.SEVERE, null, ex);
        }
        if ("Customer".equals(role)) {
            ArrayList<ArrayList<String>> filOrders = new ArrayList<>();
            for (int i = 0; i < orders.size(); i++){
                ArrayList<String> order = orders.get(i);
                if (order.get(1).equals(user)) {
                    filOrders.add(order);
                }
            }
            orders = filOrders;
        }
        return orders;
    }

    String[] getOrderDetail(String oid) {
        File f = new File("order.txt");
        String[] order = null;
        try (Scanner sc = new Scanner(f)){
            while (sc.hasNextLine()) {    
                String nextLine = sc.nextLine();
                order = nextLine.split(", ");
                if (order[0].equals(oid)) {
                    break;
                }
                order=null;
            }
            sc.close();
        } catch (FileNotFoundException ex) { 
            Logger.getLogger(Order.class.getName()).log(Level.SEVERE, null, ex);
        }
        return order;
    }
    
    void payOrder(String oid, String total){
        String stat;
        boolean flag = false;
        if ("Customer".equals(role)) {
            User o = new User(user);
            flag = o.payOrder(total);
            stat = "Make Payment: Order ID:"+oid+"  Total: RM "+total;
        }
        else{
            flag = true;
            stat = "Collect Payment: Order ID:"+oid+"  Total: RM "+total;
        }
        if (flag==true) {
            ArrayList<ArrayList<String>> orders = new ArrayList<>();
            File f = new File("order.txt");
            try (Scanner sc = new Scanner(f)){
                while (sc.hasNextLine()) {
                    ArrayList<String> newOrder = new ArrayList<>();     
                    String nextLine = sc.nextLine();
                    String[] order = nextLine.split(", ");
                    if (order[0].equals(oid)) {
                        order[4]="Paid";
                    }
                    for (int i = 0; i < order.length; i++) {
                        newOrder.add(order[i]);
                    }
                    orders.add(newOrder);
                }
                sc.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Order.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                FileWriter fw = new FileWriter(f);
                for (int i = 0; i < orders.size(); i++) {
                    ArrayList<String> order = orders.get(i);
                    for (int j = 0; j < order.size(); j++) {
                        fw.write(order.get(j));
                        if (j != order.size()-1) {
                            fw.write(", ");
                        }
                    }
                    fw.write("\n");
                }
                fw.close();
                User o = new User();
                o.logRecord(user, stat);
                String feedback = JOptionPane.showInputDialog(null,"Order payment has successfully paid/collected. You may give feedback for the service.","Info",JOptionPane.INFORMATION_MESSAGE);
                saveFeedback(oid, feedback);
            } catch (IOException ex) {
                Logger.getLogger(Order.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
        else{
            JOptionPane.showMessageDialog(null,"Insufficient balance to pay the order.","Alert",JOptionPane.WARNING_MESSAGE);
        }
    }
        
    void saveFeedback(String oid, String feedback){
        File f = new File("feedback.txt");
        try {
            f.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(Order.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            FileWriter fw = new FileWriter(f,true);
            fw.write(oid+" - "+feedback+"\n");
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(Order.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    String getFeedback(String oid){
        String feedback = null;
        File f = new File("feedback.txt");
        try (Scanner sc = new Scanner(f)){
            while (sc.hasNextLine()) {    
                String line = sc.nextLine();
                if (line.substring(0,oid.length()).equals(oid)){
                    feedback = line.substring(oid.length()+3,line.length());
                    break;
                }
            }
            sc.close();
        } catch (FileNotFoundException ex) { 
            Logger.getLogger(Order.class.getName()).log(Level.SEVERE, null, ex);
        }
        return feedback;
    }

    ArrayList<ArrayList<String>> getOrdersWithDates(String st, String ed) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date start = null;
        Date end = null;
        try {
            start = sdf.parse(st);
            end = sdf.parse(ed);
        } catch (ParseException ex) {
            Logger.getLogger(Order.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<ArrayList<String>> orders = new ArrayList<>();
        File f = new File("order.txt");
        try (Scanner sc = new Scanner(f)){
            while (sc.hasNextLine()) {
                String nextLine = sc.nextLine();
                String[] order = nextLine.split(", ");
                if ("Paid".equals(order[4])) {
                    Date orderDate = sdf.parse(order[2]);
                    if (orderDate.compareTo(start) >= 0 && orderDate.compareTo(end) <= 0){
                        ArrayList<String> line = new ArrayList<>();
                        for (int i = 0; i < order.length; i++) {
                        line.add(order[i]);
                        }
                        orders.add(line);
                    }
                }
            }
            sc.close();
        } catch (FileNotFoundException ex) { 
            Logger.getLogger(Order.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Order.class.getName()).log(Level.SEVERE, null, ex);
        }
        return orders;
    }
}

    

