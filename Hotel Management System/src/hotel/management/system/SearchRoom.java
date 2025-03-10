package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class SearchRoom extends JFrame implements ActionListener {

    JTable table;
    JButton back, submit;
    JCheckBox availableroom;
    ResultSet rs;

    SearchRoom() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("Search For Room");
        text.setBounds(400, 30, 200, 30);
        text.setFont(new Font("tahoma", Font.PLAIN, 20));
        add(text);

         availableroom = new JCheckBox("Only available rooms");
         availableroom.setBounds(50, 100, 150, 25);
        add( availableroom);

       

        JLabel l1 = new JLabel("Room Number");
        l1.setBounds(50, 160, 100, 20);
        add(l1);

        JLabel l2 = new JLabel("Availibility");
        l2.setBounds(270, 160, 100, 20);
        add(l2);

        JLabel l3 = new JLabel("Status");
        l3.setBounds(450, 160, 100, 20);
        add(l3);

        JLabel l4 = new JLabel("Bed Type");
        l4.setBounds(670, 160, 100, 20);
        add(l4);

        JLabel l5 = new JLabel("Price");
        l5.setBounds(870, 160, 100, 20);
        add(l5);

        // Create JTable
        table = new JTable();
        table.setBounds(0, 200, 1000, 300);
        add(new JScrollPane(table)); // Add table to a scroll pane

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from room");
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

        setBounds(300, 200, 1000, 600);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
       
        if(ae.getSource() == submit){
          try{
              String query2="select * from room where availability='Available' ";
             
              Conn conn = new Conn();
               
              if(availableroom.isSelected()){
                 rs=conn.s.executeQuery(query2);
              }
              
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
        new SearchRoom();
    }
}
