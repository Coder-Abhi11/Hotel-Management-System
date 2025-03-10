package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
 
public class AddDrivers extends JFrame implements ActionListener {
    
    JButton add,cancel;
    JTextField tfname,tfcompany,tfage,tfmodel,tflocation;
    JComboBox cbavailable,cbgender;
    
    
    AddDrivers(){
        
        setLayout(null);
        
        JLabel heading = new JLabel("ADD DRIVERS");
        heading.setBounds(150, 10, 200, 20);
        heading.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(heading);
        
        JLabel lbname = new JLabel("Name");
        lbname.setBounds(60, 70, 120, 30);
        lbname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbname);
        
        tfname = new JTextField();
        tfname.setBounds(200, 70, 120, 30);
        add(tfname);
        
        JLabel lbage = new JLabel("Age");
        lbage.setBounds(60, 110, 120, 30);
        lbage.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbage);
        
        
        tfage = new JTextField();
        tfage.setBounds(200, 110, 120, 30);
        add(tfage);
        
        
        JLabel lbgender = new JLabel("Gender ");
        lbgender.setBounds(60, 150, 120, 30);
        lbgender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbgender);
        
        
        String genderOption[]={"Male","Female"};
        cbgender = new JComboBox(genderOption);
        cbgender.setBackground(Color.WHITE);
        cbgender.setBounds(200,150,120,30);
        add(cbgender);
        
        JLabel lbcar= new JLabel("Car Company");
        lbcar.setBounds(60, 190, 120, 30);
        lbcar.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbcar);
        
        tfcompany = new JTextField();
        tfcompany.setBounds(200, 190, 120, 30);
        add(tfcompany);
        
        JLabel lbtype = new JLabel("Car Model");
        lbtype.setBounds(60, 230, 120, 30);
        lbtype.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbtype);
        
        
        tfmodel = new JTextField();
        tfmodel.setBounds(200, 230, 120, 30);
        add(tfmodel);
        
        JLabel lblocation = new JLabel("Location");
        lblocation.setBounds(60, 270, 120, 30);
        lblocation.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblocation);
        
        tflocation = new JTextField();
        tflocation.setBounds(200, 270, 120, 30);
        add(tflocation);
        
        add = new JButton("Add Driver");
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
        
        ImageIcon i1 = new  ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
        Image i2= i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT );
        ImageIcon i3= new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 30, 500, 300);
        add(image);
        
        
        
        setBounds(300,200,980,470);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);  
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== add){
           String name =(String)tfname.getText();
           String age = (String)tfage.getText();
           String gender=(String)cbgender.getSelectedItem();
           String car_company=tfcompany.getText(); 
           String model=tfmodel.getText(); 
           String location=(String)tflocation.getText();
           
           try{
               Conn conn = new Conn();
               String str = "insert into driver values('"+name+"','"+age+"','"+gender+"','"+car_company+"','"+model+"','"+location+"')";
               
               conn.s.executeUpdate(str);
               
             JOptionPane.showMessageDialog(null,"Driver added succesfully");

              setVisible(false); 
           }catch(Exception e){
               e.printStackTrace();
           }
        }else{
            setVisible(false);
        }
        
        }
 public static void main(String[] args){
    new AddDrivers();
 }
}

