/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oodj_assignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class Menu {
    String user;
    String menuFile;
    
    public Menu() {
    }

    public Menu(String user) {
        this.user = user;
    }
    
    ArrayList<ArrayList<String>> getMenu(String mf){
        if ("food".equals(mf)) {
            menuFile = "foodMenu.txt";
        }
        else{
            menuFile = "beverageMenu.txt";
        }
        ArrayList<ArrayList<String>> menu = new ArrayList<>();
        File f = new File(menuFile);
        try (Scanner sc = new Scanner(f)){
            while (sc.hasNextLine()) {
                ArrayList<String> line = new ArrayList<>();     
                String nextLine = sc.nextLine();
                String[] items = nextLine.split(", ");
                for (int i = 0; i < items.length; i++) {
                    line.add(items[i]);
                }
                menu.add(line);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        return menu;
    }
    
    void addMenuItem(String mf, String iName, String iPrice){
        String log;
        if ("food".equals(mf)) {
            menuFile = "foodMenu.txt";
            log = "Add Food:";
        }
        else{
            menuFile = "beverageMenu.txt";
            log = "Add Beverage:";
        }
        File f = new File(menuFile);
        try {
            FileWriter fw = new FileWriter(f,true);
            fw.write(iName+", "+iPrice+"\n");
            fw.close();
            String stat = log+iName+"  Price:"+iPrice;
            User o = new User();
            o.logRecord(user, stat);
        } catch (IOException ex) { 
            Logger.getLogger(RegisterAcc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void saveDel(String mf, String[] itemDeleted, ArrayList<ArrayList<String>> menu){
        String log;
        if ("food".equals(mf)) {
            menuFile = "foodMenu.txt";
            log = "Del Food:";
        }
        else{
            menuFile = "beverageMenu.txt";
            log = "Del Beverage:";
        }
        File f = new File(menuFile);
        try {
            FileWriter fw = new FileWriter(f);
            for (int i = 0; i < menu.size(); i++) {
                fw.write(menu.get(i).get(0)+", "+menu.get(i).get(1)+"\n");
            }
            fw.close();
            String stat = log+itemDeleted[0]+"  Price:"+itemDeleted[1];
            User o = new User();
            o.logRecord(user, stat);
        } catch (IOException ex) { 
            Logger.getLogger(RegisterAcc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
