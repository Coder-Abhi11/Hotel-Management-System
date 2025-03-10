
package hotel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class Dashboard extends JFrame implements ActionListener {
    
    Dashboard(){
        setBounds(0,0,1550,1000);
        
        setLayout(null);
        
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2=i1.getImage().getScaledInstance(1550,1000,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1550,1000);
        add(image);
        
        JLabel text= new JLabel("TAJ GROUP WELCOMES YOU");
        text.setBounds(450,80,1000,50);
        text.setFont(new Font("Tahoma",Font.ITALIC,46));
        text.setForeground(Color.WHITE);
        image.add(text);
        
       JMenuBar mb=new JMenuBar();
       mb.setBounds(0,0,1550,30);
       image.add(mb);
       
       JMenu hotel=new JMenu("Hotel Mnagement");
       hotel.setForeground(Color.red);
       mb.add(hotel);
       
       
       JMenuItem reception = new JMenuItem("RECEPTION");
       reception.addActionListener(this);
       hotel.add(reception);
       
       JMenu admin = new JMenu("Admin");
       admin.setForeground(Color. BLUE);
       mb.add(admin);
       
       
       JMenuItem employee = new JMenuItem("ADD EMPLOYEE");
       employee.addActionListener(this);
       admin.add(employee);
       
       JMenuItem room = new JMenuItem("ADD ROOMS");
       room.addActionListener(this);
       admin.add(room);
       
       JMenuItem driver = new JMenuItem("ADD DRIVERS");
       driver.addActionListener(this);
       admin.add(driver);

        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getActionCommand().equals("ADD EMPLOYEE")){
            new AddEmployee(); 
        }else if (ae.getActionCommand().equals("ADD ROOMS")){
            new AddRooms();
        }else if (ae.getActionCommand().equals("ADD DRIVERS")){
            new AddDrivers();
        }else if (ae.getActionCommand().equals("RECEPTION")){
            new Reception();
        }
    }
    
    public static void main(String args[]){
        
        new Dashboard();
    }
    
}
