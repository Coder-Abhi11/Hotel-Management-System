package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.Date;
import java.awt.event.*;

public class Checkout extends JFrame implements ActionListener {
    
    Choice ccustomer;
    JLabel lbroomnumber,lbcheckintime,lbcheckouttime;
    JButton  check,checkout,back;
    
    Checkout(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
         JLabel text = new JLabel("CheckOut");
         text.setFont(new Font ("Tahoma",Font.PLAIN,20));
         text.setBounds(100,20,100,30);
         text.setForeground(Color.BLUE);
         add(text);
         
         JLabel lbid = new JLabel("Customer Id");
         lbid.setBounds(30,80,100,30);
         add(lbid);
         
         ccustomer = new Choice();
         ccustomer.setBounds(150,85,150,25);
         add(ccustomer);
        
         ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/tick.png"));
         Image i2= i1.getImage().getScaledInstance(20, 20, 20);
         ImageIcon i3= new ImageIcon(i2);
         JLabel tick = new JLabel(i3);
         tick.setBounds(310,85,20,20);
         add(tick);
         
         JLabel lbroom = new JLabel("Room Number");
         lbroom.setBounds(30,130,100,30);
         add(lbroom);
         
         lbroomnumber = new JLabel();
         lbroomnumber.setBounds(150,135,100,30);
         add(lbroomnumber);
         
         JLabel lbcheckin = new JLabel("Checkin Time");
         lbcheckin.setBounds(30,180,100,30);
         add(lbcheckin);
         
         lbcheckintime = new JLabel();
         lbcheckintime.setBounds(150,185,100,30);
         add(lbcheckintime);
         
         JLabel lbcheckout = new JLabel("Checkout Time");
         lbcheckout.setBounds(30,220,100,30);
         add(lbcheckout);
         
         Date date = new Date();
         lbcheckouttime = new JLabel("" + date);
         lbcheckouttime.setBounds(150,225,148,30);
         add(lbcheckouttime);
         
         check =new JButton("Check");
         check.setBackground(Color.black);
         check.setForeground(Color.white);
         check.setBounds(30, 280, 120, 30);
         check.addActionListener(this);
         add(check);
         

        back = new JButton("Back");
        back.setBounds(170, 280, 120, 30);
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        checkout = new JButton("Checkout");
        checkout.setBounds(50, 320, 180, 30);
        checkout.setBackground(Color.black);
        checkout.setForeground(Color.WHITE);
        checkout.addActionListener(this);
        add(checkout);
        
         try{
             
             Conn c = new Conn();
             ResultSet rs=c.s.executeQuery("select * from customer");
             while(rs.next()){
                 ccustomer.add(rs.getString("number"));
                 lbroomnumber.setText(rs.getString("roomnumber"));
                 lbcheckintime.setText(rs.getString("checkin"));
             }
             
         }catch(Exception e){
             e.printStackTrace();
         }
        
        
         ImageIcon i4= new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
         Image i5= i4.getImage().getScaledInstance(400, 250, Image.SCALE_DEFAULT);
         ImageIcon i6= new ImageIcon(i5);
         JLabel image = new JLabel(i6);
         image.setBounds(350,50,400,250);
         add(image);
         
        setBounds(300,200,800,400);
        setVisible(true);
        
        
    }
    
    public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == check) {
        String id = ccustomer.getSelectedItem(); 
        String query = "SELECT * FROM customer WHERE number = '" + id + "'";
        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery(query);
            while (rs.next()) {
                lbroomnumber.setText(rs.getString("roomnumber"));
                lbcheckintime.setText(rs.getString("checkin"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    } else if (ae.getSource() == checkout) {
        String query1 = "DELETE FROM customer WHERE number = '" + ccustomer.getSelectedItem() + "'";
        String query2 = "UPDATE room SET availability = 'Available' WHERE roomnumber = '" + lbroomnumber.getText() + "'";
        try {
            Conn c = new Conn();
            c.s.executeUpdate(query1);
            c.s.executeUpdate(query2);
            JOptionPane.showMessageDialog(null, "Checkout Done");
            setVisible(false);
            new Reception();
        } catch (Exception e) {
            e.printStackTrace();
        }
    } else {
        setVisible(false);
        new Reception();
    }


    }
    
    public static void main(String args[]){
        new Checkout();
    }
    
}
