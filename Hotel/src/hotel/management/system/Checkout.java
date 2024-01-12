package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.Date;
import java.awt.event.*;

public class Checkout extends JFrame implements ActionListener{
    Choice ccustomer;
    JLabel lblroomnumber,lblcheckintime,lblcheckouttime;
    JButton back,checkout;
    Checkout(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text = new JLabel("Checkout");
        text.setBounds(100,20,150,30);
        text.setForeground(Color.BLUE);
        text.setFont(new Font("Tohoma",Font.PLAIN,20));
        add(text);
        
        JLabel lblid = new JLabel("Customer Id");
        lblid.setBounds(30,80,100,30);
        add(lblid);
        
        ccustomer = new Choice();
        ccustomer.setBounds(150,80,150,25);
        add(ccustomer);

        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/tick.png"));
        Image i2 = i1.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(310,80,20,20);
        add(image);
     
        JLabel lblroom = new JLabel("Room Number");
        lblroom.setBounds(30,130,100,30);
        add(lblroom);
        
        lblroomnumber = new JLabel();
        lblroomnumber.setBounds(150,130,100,30);
        add(lblroomnumber);
        
        JLabel lblcheckin = new JLabel("Checkin Time");
        lblcheckin.setBounds(30,180,100,30);
        add(lblcheckin);
        
        lblcheckintime = new JLabel();
        lblcheckintime.setBounds(150,180,170,30);
        add(lblcheckintime);
        
        JLabel lblcheckout = new JLabel("Checkiout Time");
        lblcheckout.setBounds(30,230,100,30);
        add(lblcheckout);
        
        Date date = new Date();
        lblcheckouttime = new JLabel(""+date);
        lblcheckouttime.setBounds(150,230,170,30);
        add(lblcheckouttime);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setBounds(30,280,120,30);
        add(back);
        
        checkout = new JButton("Checkout");
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.WHITE);
        checkout.addActionListener(this);
        checkout.setBounds(170,280,120,30);
        add(checkout);
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("Select * from customer");
            while(rs.next()){
                ccustomer.add(rs.getString("number"));
                lblroomnumber.setText(rs.getString("room"));
                lblcheckintime.setText(rs.getString("checkintime"));
            }
        }catch(Exception e){
            
            e.printStackTrace();
        }
        
        ImageIcon i4  = new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
        Image i5 = i4.getImage().getScaledInstance(400,250,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image1 = new JLabel(i6);
        image1.setBounds(350,50,400,250);
        add(image1);
        
        setBounds(200,100,800,400);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== checkout){
            //delete from  customer data
            String query1 = "delete from customer where number = '"+ccustomer.getSelectedItem()+"'";
            //make room 
            String query2 = "update room set availability = 'Available' where roomnumber ='"+lblroomnumber.getText()+"'";
            try{
                Conn c = new Conn();
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                
                JOptionPane.showMessageDialog(null,"Checkout done");
                
                setVisible(false);
                new Reception();
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
            new Reception();
        }
    }
    public static void main(String[] args){
        new Checkout();
    }
}
