package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;


public class Department extends  JFrame  implements ActionListener {
    
    JTable table;
    JButton back;
        
    Department(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel l1 = new JLabel("Departments");
        l1.setBounds(150,20,100,20);
        add(l1);
        
        JLabel l2 = new JLabel("Budget");
        l2.setBounds(470,20,100,20);
        add(l2);
        
         back =new JButton("Back");
         back.setBackground(Color.black);
         back.setForeground(Color.white);
         back.setBounds(270,250,100,30);
         back.addActionListener(this);
         add(back);
         
         
        // Create JTable
        table = new JTable();
        table.setBounds(20,50,700,400);
        add(new JScrollPane(table)); // Add table to a scroll pane
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from department");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            add(table);
        } catch(Exception e){
            e.printStackTrace();
        }
        
       
       
        setBounds(400,200,700,500);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == back){
           setVisible(false);
           new Reception(); 
        }
        
        setVisible(false);
        new Reception();
    }
   
    public static void main(String args[]){
       new Department();
    } 
}
