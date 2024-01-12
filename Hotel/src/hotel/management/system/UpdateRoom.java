package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
public class UpdateRoom extends JFrame implements ActionListener {
    JTextField tfavailable,tfstatus,tfpaid,tfpending,tfroom;
    JButton check,update,back;
    Choice ccustomer;
    
    UpdateRoom(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text = new JLabel("Update Room Status");
        text.setFont(new Font("Tahoma",Font.PLAIN,25));
        text.setBounds(30,20,250,30);
        text.setForeground(Color.BLUE);
        add(text);
       
        JLabel lblid = new JLabel("Customer Id");
        lblid.setBounds(30,80,100,20);
        add(lblid);
        
        ccustomer = new Choice();
        ccustomer.setBounds(200,80,150,25);
        add(ccustomer);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("Select * from customer");
            while(rs.next()){
                ccustomer.add(rs.getString("number"));
            }
        }catch(Exception e){
        }
        
      
	JLabel lblroom = new JLabel("Room Number :");
	lblroom.setBounds(30, 130, 100, 20);
	add(lblroom);
                
                
        tfroom = new JTextField();
        tfroom.setBounds(200, 130, 140, 25);
        add(tfroom);
        
        JLabel lblname = new JLabel("Availability : ");
	lblname.setBounds(30, 180, 100, 20);
	add(lblname);
		
        tfavailable = new JTextField();
	tfavailable.setBounds(200, 180, 150, 25);
	add(tfavailable);
	//tfname.setColumns(10);
        
	JLabel lblcheckin = new JLabel("Cleaning Status :");
	lblcheckin.setBounds(30, 230, 100, 20);
	add(lblcheckin);
        
        tfstatus = new JTextField();
	tfstatus.setBounds(200, 230, 150, 25);
	add(tfstatus);
	
        update = new JButton("Update");
	update.setBounds(158, 300, 89, 23);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
	add(update);
        
        check = new JButton("Check");
        check.setBounds(271, 300, 89, 23);
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        check.addActionListener(this);
	add(check);
		
        back = new JButton("Back");
        back.setBounds(46, 300, 89, 23);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
	add(back);
	
        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/seventh.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,50,500,300);
        add(image);
     
        setBounds(200,100,980,500);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==check){
            String id = ccustomer.getSelectedItem();
            String query = "select * from customer where number = '"+id+"'";
            try{
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                
                while(rs.next()){
                    tfroom.setText(rs.getString("room"));
                    
                }
                
                ResultSet rs2 = c.s.executeQuery("select * from room where roomnumber = '"+tfroom.getText()+"'");
                while(rs2.next()){
                    tfavailable.setText(rs2.getString("availability"));
                    tfstatus.setText(rs2.getString("cleaning_status"));
                }
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else if(ae.getSource()==update){
            String number = ccustomer.getSelectedItem();
            String room = tfroom.getText();
            String available = tfavailable.getText();
            String status = tfstatus.getText();
           
            
            try{
                Conn c = new Conn();
                c.s.executeUpdate("update customer set availability='"+available+"',cleaning_status = '"+status+"'where roomnumber = '"+room+"'");
            
                JOptionPane.showMessageDialog(null,"Data Updated Successfully");
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
        new UpdateRoom();
    }
}

