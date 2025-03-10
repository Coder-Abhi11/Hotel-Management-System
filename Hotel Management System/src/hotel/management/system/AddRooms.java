package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class AddRooms extends JFrame implements ActionListener {
    
    JButton add,cancel;
    JTextField tfroom,tfprice;
    JComboBox cbavailable,cbcleaing,cbtype;
    
    
    AddRooms(){
        
        setLayout(null);
        
        JLabel heading = new JLabel("ADD ROOMS");
        heading.setBounds(150, 20, 200, 20);
        heading.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(heading);
        
        JLabel lbroom = new JLabel("Room Number");
        lbroom.setBounds(60, 80, 120, 30);
        lbroom.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbroom);
        
        tfroom = new JTextField();
        tfroom.setBounds(200, 80, 120, 30);
        add(tfroom);
        
        JLabel lbavailable = new JLabel("Available");
        lbavailable.setBounds(60, 130, 120, 30);
        lbavailable.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbavailable);
        
        
        String availableOption[]={"Available","Occupied"};
        cbavailable= new JComboBox(availableOption);
        cbavailable.setBackground(Color.WHITE);
        cbavailable.setBounds(200,130,120,30);
        add(cbavailable);
        
        JLabel lbacleaning = new JLabel("Cleaning Status");
        lbacleaning.setBounds(60, 180, 120, 30);
        lbacleaning.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbacleaning);
        
        
        String cleaningOption[]={" ","Clean","Dirty"};
        cbcleaing = new JComboBox(cleaningOption);
        cbcleaing.setBackground(Color.WHITE);
        cbcleaing.setBounds(200,180,120,30);
        add(cbcleaing);
        
        JLabel lbprice= new JLabel("Price");
        lbprice.setBounds(60, 230, 120, 30);
        lbprice.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbprice);
        
        tfprice = new JTextField();
        tfprice.setBounds(200, 230, 120, 30);
        add(tfprice);
        
        JLabel lbtype = new JLabel("Bed Type");
        lbtype.setBounds(60, 280, 120, 30);
        lbtype.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbtype);
        
        
        String typeOption[]={"Single","Double"};
        cbtype= new JComboBox(typeOption);
        cbtype.setBackground(Color.WHITE);
        cbtype.setBounds(200,280,120,30);
        add(cbtype);
        
        add = new JButton("Add Room");
        add.setBackground(Color.black);
        add.setForeground(Color.WHITE);
        add.setBounds(60,350,130,30);
        add.addActionListener(this);
        add(add);
        
        cancel= new JButton("Cancel");
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(230,350,130,30);
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon i1 = new  ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(400, 30, 500, 300);
        add(image);
        
        
        
        setBounds(330,200,940,470);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);  
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== add){
           String roomnumber =tfroom.getText();
           String availability = (String)cbavailable.getSelectedItem();
           String cleaning_status=(String)cbcleaing.getSelectedItem();
           String price=tfprice.getText(); 
           String bed_type=(String)cbtype.getSelectedItem();
           
           try{
               Conn conn = new Conn();
               String str = "insert into room values('"+roomnumber+"','"+availability+"','"+cleaning_status+"','"+bed_type+"','"+price+"')";
               
               conn.s.executeUpdate(str);
               
             JOptionPane.showMessageDialog(null,"Room added succesfully");

              setVisible(false); 
           }catch(Exception e){
               e.printStackTrace();
           }
        }else{
            setVisible(false);
        }
        
        }
    
    public static void main(String[] args){
     
     new AddRooms();
 }   
}

