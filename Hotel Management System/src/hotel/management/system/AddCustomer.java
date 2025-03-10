package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.Date;
import java.awt.event.*;


 
public class AddCustomer extends JFrame implements ActionListener {
    
    JComboBox cbid;
    JTextField number,name,tfcountry,tfcheck,tfdeposit;
    JRadioButton rmale,rfemale;   
    Choice croom;
    JLabel time;
    JButton add,back;
    
    AddCustomer(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text = new JLabel("NEW  CUSTOMER FROM");
        text.setBounds(100,20,300,30);
        text.setFont(new Font("Railway", Font.BOLD , 20));
        text.setForeground(Color.BLUE);
        add(text);
        
        JLabel lbname = new JLabel("NAME");
        lbname.setBounds(35,80,100,20);
        lbname.setFont(new Font("Railway", Font.BOLD, 18));
        add(lbname);
        
        name =new JTextField();
        name.setBounds(200,80,150,25);
        add(name);
        
        JLabel lbid = new JLabel("ID");
        lbid.setBounds(35,120,100,20);
        lbid.setFont(new Font("Railway", Font.BOLD, 18));
        add(lbid);
        
        String options[]={"Aadhar Card","Pastport","Driving Licence","PAN Card"};
        cbid=new JComboBox(options);
        cbid.setBounds(200,120,150,25);
        cbid.setBackground(Color.white);
        add(cbid);
     
        JLabel lbnumber = new JLabel("NUMBER");
        lbnumber.setBounds(35,160,100,20);
        lbnumber.setFont(new Font("Railway", Font.BOLD, 18));
        add(lbnumber);
   
        number =new JTextField();
        number.setBounds(200,160,150,25);
        add(number);
        
        JLabel lbgender = new JLabel("GENDER");
        lbgender.setBounds(35,200,100,20);
        lbgender.setFont(new Font("Railway", Font.BOLD, 18));
        add(lbgender);
        
        rmale =new JRadioButton("MALE");
        rmale.setBounds(200,200,60,25);
        rmale.setBackground(Color.white);
        add(rmale);
        
        rfemale =new JRadioButton("FEMALE");
        rfemale.setBounds(270,200,100,25);
        rfemale.setBackground(Color.white);
        add(rfemale);
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(rmale);
        bg.add(rfemale);
        
        JLabel lbcountry = new JLabel("COUNTRY");
        lbcountry.setBounds(35,240,100,20);
        lbcountry.setFont(new Font("Railway", Font.BOLD, 18));
        add(lbcountry);
        
        tfcountry =new JTextField();
        tfcountry.setBounds(200,240,150,25);
        add(tfcountry);
        
        JLabel lbroom = new JLabel("ROOM NUMBER");
        lbroom.setBounds(35,280,150,20);
        lbroom.setFont(new Font("Railway", Font.BOLD, 18));
        add(lbroom);
        
        croom = new Choice();
        try{
           Conn conn = new Conn();
           String query = "select * from room where availability = 'Available'";
           ResultSet rs=conn.s.executeQuery(query);
           while(rs.next()){
               croom.add(rs.getString("roomnumber"));
           }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        croom.setBounds(200,280,150,20);
        add(croom);
       
        JLabel check = new JLabel("CHECKIN TIME");
        check.setBounds(35,320,150,20);
        check.setFont(new Font("Railway", Font.BOLD, 18));
        add(check);
       
        Date date = new Date();
        
        time = new JLabel("" + date);
        time.setBounds(200,320,150,20);
        time.setFont(new Font("Railway", Font.BOLD, 15));
        add(time);
       
        JLabel deposit = new JLabel("DEPOSIT");
        deposit.setBounds(35,360,120,20);
        deposit.setFont(new Font("Railway", Font.BOLD, 18));
        add(deposit);
       
        tfdeposit =new JTextField();
        tfdeposit.setBounds(200,360,150,25);
        add(tfdeposit);
        
        add = new JButton("Add Customer");
        add.setBounds(40,420,150,30);
        add.setFont(new Font("Railway", Font.BOLD, 14));
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);
        
        back = new JButton("Back");
        back.setBounds(250,420,150,30);
        back.setFont(new Font("Railway", Font.BOLD, 14));
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new  ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
        Image i2= i1.getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT );
        ImageIcon i3= new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(380, 60, 450, 370);
        add(image);
        
        
        setBounds(350,200,800,550);
        setVisible(true);
    }
    
     public void actionPerformed(ActionEvent ae){
       if(ae.getSource()== add){
             String cname=name.getText();
            String comboid=(String)cbid.getSelectedItem();
            String cnumber = number.getText();
            String gender = null;
            if(rmale.isSelected()){
                gender = "Male";
            }else
                gender="Female";
            String country = tfcountry.getText();
            String room= croom.getSelectedItem();
            String checkin=time.getText();
            String deposit = tfdeposit.getText();   
       
           try{
              
              Conn conn = new Conn();
               
              String str = "insert into customer values('" + cname + "','" + comboid + "','" + cnumber + "','" + gender + "','" + country + "','" + room + "','" + checkin + "','" + deposit + "')";
              String str2="update room set availability = 'Occupied' where roomnumber = '"+room+"'";
              
              conn.s.executeUpdate(str);
              conn.s.executeUpdate(str2);
              
              JOptionPane.showMessageDialog(null,"New Customer added succesfully");
              
              setVisible(false);
              new Reception();
              
              
           }catch(Exception e){
               e.printStackTrace();
           }
       }else if(ae.getSource()== back){
           
           setVisible(false);
           new Reception();
           
       }
              
    }
    
    
    public static void main(String args[]){
        new AddCustomer();
    }

  }
