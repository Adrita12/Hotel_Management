
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
public class UpdateCheck extends JFrame implements ActionListener {
    JTextField tfname,tfcheckin,tfpaid,tfpending,tfroom;
    JButton check,update,back;
    Choice ccustomer;
    
    UpdateCheck(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text = new JLabel("Update Status");
        text.setFont(new Font("Tahoma",Font.PLAIN,20));
        text.setBounds(90,20,200,30);
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
	lblroom.setBounds(25, 129, 107, 14);
	add(lblroom);
                
                
        tfroom = new JTextField();
        tfroom.setBounds(200, 126, 140, 25);
        add(tfroom);
        
        JLabel lblname = new JLabel("Name : ");
	lblname.setBounds(25, 174, 97, 14);
	add(lblname);
		
        tfname = new JTextField();
	tfname.setBounds(200, 171, 140, 25);
	add(tfname);
	tfname.setColumns(10);
        
	JLabel lblcheckin = new JLabel("Checked-in :");
	lblcheckin.setBounds(25, 216, 107, 14);
	add(lblcheckin);
        
        tfcheckin = new JTextField();
	tfcheckin.setBounds(200, 216, 140, 25);
	add(tfcheckin);
	tfcheckin.setColumns(10);
		
	JLabel lblNewLabel_4 = new JLabel("Amount Paid (Rs) : ");
	lblNewLabel_4.setBounds(25, 261, 107, 14);
	add(lblNewLabel_4);
		
        tfpaid = new JTextField();
	tfpaid.setBounds(200, 258, 140, 25);
	add(tfpaid);
	tfpaid.setColumns(10);
        
	JLabel lblpending = new JLabel("Pending Amount (Rs) : ");
	lblpending.setBounds(25, 302, 150, 14);
	add(lblpending);
        
        tfpending = new JTextField();
	tfpending.setBounds(200, 299, 140, 25);
	add(tfpending);
	tfpending.setColumns(10);
	
        update = new JButton("Update");
	update.setBounds(158, 378, 89, 23);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
	add(update);
        
        check = new JButton("Check");
        check.setBounds(271, 378, 89, 23);
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        check.addActionListener(this);
	add(check);
		
        back = new JButton("Back");
        back.setBounds(46, 378, 89, 23);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
	add(back);
	
        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/nine.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,60,476,320);
        add(image);
     
        setBounds(300,100,900,500);
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
                    tfname.setText(rs.getString("name"));
                    tfcheckin.setText(rs.getString("checkintime"));
                    tfpaid.setText(rs.getString("deposit"));
                }
                
                ResultSet rs2 = c.s.executeQuery("select * from room where roomnumber = '"+tfroom.getText()+"'");
                while(rs2.next()){
                    String price = rs2.getString("price");
                    int amountPaid = Integer.parseInt(price) - Integer.parseInt(tfpaid.getText());
                    tfpending.setText(""+amountPaid);
                    
                }
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else if(ae.getSource()==update){
            String number = ccustomer.getSelectedItem();
            String room = tfroom.getText();
            String name = tfname.getText();
            String checkin = tfcheckin.getText();
            String deposit = tfpaid.getText();
            
            try{
                Conn c = new Conn();
                c.s.executeUpdate("update customer set room='"+room+"',name = '"+name+"',checkintime='"+checkin+"',deposit = '"+deposit+"' where number ='"+number+"'");
            
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
        new UpdateCheck();
    }
}
