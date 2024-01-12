
package hotel.management.system;

import java.awt.BorderLayout;
import java.awt.*;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.Image;
import java.sql.*;	
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Date;

public class NewCustomer extends JFrame implements ActionListener{
    JComboBox comboid;
    TextField tfnumber,tfname,tfcountry,tfdeposit;
    JRadioButton rmale, rfemale;
    Choice croom;
    JLabel time;
    JButton add,back;
    NewCustomer(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
	JLabel text = new JLabel("NEW CUSTOMER FORM");
        text.setBounds(100,20,300,30);
        text.setFont(new Font("Raleway",Font.BOLD,16));
        add(text);
        
        JLabel lblid = new JLabel("ID");
        lblid.setBounds(35,80,100,20);
        lblid.setFont(new Font("Raleway",Font.BOLD,16));
        add(lblid);
        
        String options[] = {"Aadhar Card","Passport","Driving License","Voter-id Card"};
        comboid = new JComboBox(options);
        comboid.setBounds(200,80,150,25);
        comboid.setBackground(Color.WHITE);
        add(comboid);
        
        JLabel lblnumber = new JLabel("Number");
        lblnumber.setBounds(35,120,100,20);
        lblnumber.setFont(new Font("Raleway",Font.BOLD,16));
        add(lblnumber);
        
        tfnumber = new TextField();
        tfnumber.setBounds(200,120,150,25);
        add(tfnumber);
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(35,160,100,20);
        lblname.setFont(new Font("Raleway",Font.BOLD,16));
        add(lblname);
        
        tfname = new TextField();
        tfname.setBounds(200,160,150,25);
        add(tfname);
        
        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(35,200,100,20);
        lblgender.setFont(new Font("Raleway",Font.BOLD,16));
        add(lblgender);
        
        rmale = new JRadioButton("Male");
        rmale.setBackground(Color.WHITE);
        rmale.setBounds(200,180,60,55);
        add(rmale);
        
        rfemale = new JRadioButton("Female");
        rfemale.setBackground(Color.WHITE);
        rfemale.setBounds(270,180,100,55);
        add(rfemale);
        
        JLabel lblcountry = new JLabel("Country");
        lblcountry.setBounds(35,240,100,20);
        lblcountry.setFont(new Font("Raleway",Font.BOLD,16));
        add(lblcountry);
        
        tfcountry = new TextField();
        tfcountry.setBounds(200,240,150,25);
        add(tfcountry);
        
        JLabel lblroom = new JLabel("Room Number");
        lblroom.setBounds(35,280,150,20);
        lblroom.setFont(new Font("Raleway",Font.BOLD,16));
        add(lblroom);
        
        croom = new Choice();
        
        try{
            Conn conn = new Conn();
            String query = "select * from room where availability='Available'";
            ResultSet rs = conn.s.executeQuery(query);
             while(rs.next()){
                 croom.add(rs.getString("roomnumber"));
             }
        }catch(Exception e){
            System.out.println(e);
        }
        
        croom.setBounds(200,280,150,25);
        add(croom);
                
        
        JLabel lbltime = new JLabel("Check-in Time");
        lbltime.setBounds(35,320,150,20);
        lbltime.setFont(new Font("Raleway",Font.BOLD,16));
        add(lbltime);
        
        Date date = new Date();
        
        time = new JLabel(""+date);
        time.setBounds(200,320,210,25);
        time.setFont(new Font("Raleway",Font.PLAIN,16));
        add(time);
        
        JLabel lbldeposit = new JLabel("Deposit");
        lbldeposit.setBounds(35,360,100,20);
        lbldeposit.setFont(new Font("Raleway",Font.BOLD,16));
        add(lbldeposit);
        
        tfdeposit = new TextField();
        tfdeposit.setBounds(200,360,150,25);
        add(tfdeposit);
        
        add =  new JButton("ADD");
        add.setBounds(50,410,120,30);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);
        
        back =  new JButton("BACK");
        back.setBounds(200,410,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,50,300,400);
        add(image);
        
        setBounds(350, 100, 800, 550);
        setVisible(true);
                
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==add){
            String id = (String)comboid.getSelectedItem();
            String number = tfnumber.getText();
            String name = tfname.getText();
            String gender = null;
            
            if(rmale.isSelected()){
                gender = "Male";
            }
            else{
                gender = "Female";
            }
            
            String country = tfcountry.getText();
            String room = croom.getSelectedItem();
            String checkin = time.getText();
            String deposit = tfdeposit.getText();
            
            try{
                Conn conn = new Conn();
                String query1 = "insert into customer values('"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+room+"','"+checkin+"','"+deposit+"')";
                String query2 = "update room set availability = 'Occupied' where roomnumber = '"+room+"'";
                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                
                JOptionPane.showMessageDialog(null, "New Customer Added Successfully");
                setVisible(false);
                new Reception();
            
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }
        else if(ae.getSource()==back){
            setVisible(false);
            new Reception();
        }
    }
    public static void main(String[] args){
        new NewCustomer();
    }
}
