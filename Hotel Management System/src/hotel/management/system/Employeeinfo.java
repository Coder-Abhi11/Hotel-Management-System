package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;


public class Employeeinfo extends  JFrame  implements ActionListener {
    
    JTable table;
    JButton back;
    
    Employeeinfo(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
         
       
        JLabel l1 = new JLabel("Name");
        l1.setBounds(40,10,100,20);
        add(l1);
        
        JLabel l2 = new JLabel("Age");
        l2.setBounds(170,10,100,20);
        add(l2);
        
        JLabel l3 = new JLabel("Gender");
        l3.setBounds(290,10,100,20);
        add(l3);
        
        JLabel l4 = new JLabel("Job");
        l4.setBounds(420,10,100,20);
        add(l4);
        
        JLabel l5 = new JLabel("Salary");
        l5.setBounds(540,10,100,20);
        add(l5);
        
        JLabel l6 = new JLabel("Phone no");
        l6.setBounds(640,10,100,20);
        add(l6);
        
        JLabel l7 = new JLabel("Email Id");
        l7.setBounds(770,10,100,20);
        add(l7);
        
        JLabel l8 = new JLabel("Aadhar no");
        l8.setBounds(880,10,100,20);
        add(l8);
        
        // Create JTable
        table = new JTable();
        table.setBounds(0,40,1000,400);
        add(new JScrollPane(table)); // Add table to a scroll pane
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from employee");
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
       new Employeeinfo();
    } 
}
