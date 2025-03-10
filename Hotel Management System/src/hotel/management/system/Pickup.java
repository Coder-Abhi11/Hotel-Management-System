package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Pickup extends JFrame implements ActionListener {

    JTable table;
    JButton back, submit;
    Choice typeofcar ;
    JCheckBox available;

    Pickup () {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("Pickup Service");
        text.setBounds(400, 30, 200, 30);
        text.setFont(new Font("tahoma", Font.PLAIN, 20));
        add(text);

        JLabel lblbedtype = new JLabel("Type of Car");
        lblbedtype.setBounds(50, 100, 100, 20);
        add(lblbedtype);
        
        typeofcar = new Choice();
        typeofcar.setBounds(150,100,200,25);
        add(typeofcar);
        
        try{
            Conn c= new Conn();
            ResultSet rs = c.s.executeQuery("select * from driver ");
            while(rs.next()){
                typeofcar.add(rs.getString("model"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        

       

        JLabel l1 = new JLabel("Name");
        l1.setBounds(30, 170, 100, 20);
        add(l1);

        JLabel l2 = new JLabel("Age");
        l2.setBounds(200, 170, 100, 20);
        add(l2);

        JLabel l3 = new JLabel("Gender");
        l3.setBounds(370, 170, 100, 20);
        add(l3);

        JLabel l4 = new JLabel("Company");
        l4.setBounds(540, 170, 100, 20);
        add(l4);

        JLabel l5 = new JLabel("Brand");
        l5.setBounds(700, 170, 100, 20);
        add(l5);

        JLabel l6 = new JLabel("Location");
        l6.setBounds(860, 170, 100, 20);
        add(l6);
        
        // Create JTable
        table = new JTable();
        table.setBounds(0, 200, 950, 300);
        add(new JScrollPane(table)); // Add table to a scroll pane

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from driver");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            add(table);

        } catch (Exception e) {
            e.printStackTrace();
        }

        submit = new JButton("Submit");
        submit.setBounds(300, 520, 120, 30);
        submit.setBackground(Color.black);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

        back = new JButton("Back");
        back.setBounds(500, 520, 120, 30);
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        setBounds(300, 200, 950, 600);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
       
        if(ae.getSource() == submit){
          try{
              String query="select * from driver where model = '"+typeofcar.getSelectedItem()+"'";
              
              Conn conn= new Conn();
              
              ResultSet rs= conn.s.executeQuery(query);
              table.setModel(DbUtils.resultSetToTableModel(rs));
              
          }catch(Exception e){
              e.printStackTrace();
          }
        }else{
        setVisible(false);
        new Reception();
        }
    }

    public static void main(String args[]) {
        new Pickup();
    }
}
