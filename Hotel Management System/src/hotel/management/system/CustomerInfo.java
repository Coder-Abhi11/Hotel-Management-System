package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;


public class CustomerInfo extends  JFrame  implements ActionListener {
    
    JTable table;
    JButton back;
    
    CustomerInfo(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
         
       
        JLabel l1 = new JLabel("Name");
        l1.setBounds(5,10,100,20);
        add(l1);
        
        JLabel l2 = new JLabel("ID");
        l2.setBounds(130,10,100,20);
        add(l2);
        
        JLabel l3 = new JLabel("Number");
        l3.setBounds(250,10,100,20);
        add(l3);
        
        JLabel l4 = new JLabel("Gender");
        l4.setBounds(375,10,100,20);
        add(l4);
        
        JLabel l5 = new JLabel("Location");
        l5.setBounds(500,10,100,20);
        add(l5);
        
        JLabel l6 = new JLabel("Room Number");
        l6.setBounds(625,10,100,20);
        add(l6);
        
        JLabel l7 = new JLabel("Checkin Time");
        l7.setBounds(750,10,100,20);
        add(l7);
        
        JLabel l8 = new JLabel("Deposit");
        l8.setBounds(880,10,100,20);
        add(l8);
        
        // Create JTable
        table = new JTable();
        table.setBounds(0,40,1000,400);
        add(new JScrollPane(table)); // Add table to a scroll pane
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer ");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            add(table); 
            
        } catch(Exception e){
            e.printStackTrace();
        }
        
        back = new JButton("Back");
        back.setBounds(420,500,120,30);
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        
       
        setBounds(300,200,1000,600);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Reception();
    }
   
    public static void main(String args[]){
       new CustomerInfo();
    } 
}


