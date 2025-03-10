package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
 
public class Reception extends JFrame implements ActionListener {
    
     JButton newcustomer,rooms,department,allemployee,customer_info,Managerinfo,Checkstatus,Roomstatus,pickupsrvice,searchroom,Checkout,logout;
    
    Reception(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        newcustomer = new JButton("New Customer From");
        newcustomer.setBounds(10,30,200,30);
        newcustomer.setBackground(Color.BLACK);
        newcustomer.setForeground(Color.WHITE);
        newcustomer.addActionListener(this);
        add(newcustomer);
        
        rooms = new JButton("Rooms");
        rooms.setBounds(10,70,200,30);
        rooms.setBackground(Color.BLACK);
        rooms.setForeground(Color.WHITE);
        rooms.addActionListener(this);
        add(rooms);
        
        
        department = new JButton("Department");
        department.setBounds(10,110,200,30);
        department.setBackground(Color.BLACK);
        department.setForeground(Color.WHITE);
        department.addActionListener(this);
        add(department);
        
        allemployee = new JButton("All Employee Info");
        allemployee.setBounds(10,150,200,30);
        allemployee.setBackground(Color.BLACK);
        allemployee.setForeground(Color.WHITE);
        allemployee.addActionListener(this);
        add(allemployee);
        
        customer_info = new JButton("Customer Info");
        customer_info.setBounds(10,190,200,30);
        customer_info.setBackground(Color.BLACK);
        customer_info.setForeground(Color.WHITE);
        customer_info.addActionListener(this);
        add(customer_info);
        
        Managerinfo = new JButton("Manager Info");
        Managerinfo.setBounds(10,230,200,30);
        Managerinfo.setBackground(Color.BLACK);
        Managerinfo.setForeground(Color.WHITE);
        Managerinfo.addActionListener(this);
        add(Managerinfo);
        
        
        searchroom = new JButton("Search Room");
        searchroom.setBounds(10,270,200,30);
        searchroom.setBackground(Color.BLACK);
        searchroom.setForeground(Color.WHITE);
        searchroom.addActionListener(this);
        add(searchroom);
       
        Roomstatus = new JButton("Update Room Status");
        Roomstatus.setBounds(10,310,200,30);
        Roomstatus.setBackground(Color.BLACK);
        Roomstatus.setForeground(Color.WHITE);
        Roomstatus.addActionListener(this);
        add(Roomstatus);
        
        Checkstatus = new JButton(" Update Status");
        Checkstatus.setBounds(10,350,200,30);
        Checkstatus.setBackground(Color.BLACK);
        Checkstatus.setForeground(Color.WHITE);
        Checkstatus.addActionListener(this);
        add(Checkstatus);
        
        pickupsrvice = new JButton("Pick Up Srvice");
        pickupsrvice.setBounds(10,390,200,30);
        pickupsrvice.setBackground(Color.BLACK);
        pickupsrvice.setForeground(Color.WHITE);
        pickupsrvice.addActionListener(this);
        add(pickupsrvice);
        
        
        Checkout = new JButton("Check Out");
        Checkout.setBounds(10,430,200,30);
        Checkout.setBackground(Color.BLACK);
        Checkout.setForeground(Color.WHITE);
        Checkout.addActionListener(this);
        add(Checkout);
        
       
        logout = new JButton("Logout");
        logout.setBounds(10,470,200,30);
        logout.setBackground(Color.BLACK);
        logout.setForeground(Color.WHITE);
        logout.addActionListener(this);
        add(logout);
        
        ImageIcon i1 = new  ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(250, 30, 500, 470);
        add(image);
        
        setBounds(350,200,800,570);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
       if(ae.getSource()==newcustomer){
           setVisible(false);
           new AddCustomer();
       } else if(ae.getSource()==rooms){
           setVisible(false);
           new Room();
       }  else if(ae.getSource()==department){
           setVisible(false);
           new Department();
       }  else if(ae.getSource()==allemployee){
           setVisible(false);
           new Employeeinfo();
       } else if(ae.getSource()==customer_info){
           setVisible(false);
           new CustomerInfo();
       }  else if(ae.getSource()==Managerinfo){
           setVisible(false);
           new ManagerInfo();
       } else if(ae.getSource()==searchroom){
           setVisible(false);
           new SearchRoom();
       } else if(ae.getSource()==Roomstatus){
           setVisible(false);
           new UpdateRoom();
           
       } else if(ae.getSource()==Checkstatus){
           setVisible(false);
           new UpdateCheck();
       }else if(ae.getSource()==pickupsrvice){
           setVisible(false);
           new Pickup();
       }else if(ae.getSource()==Checkout){
           setVisible(false);
           new Checkout();
       }else if(ae.getSource()==logout){
           setVisible(false);
           System.exit(0);
       }
           
       
    }
    
    public static void main(String args[]){
        new Reception();
    }
    
}
