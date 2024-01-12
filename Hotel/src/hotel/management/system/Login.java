package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    JTextField username;
    JPasswordField password;//so that it is hidden 
    JButton login,cancel;
    Login(){
        getContentPane().setBackground(Color.WHITE);
        
       setLayout(null);
       
       JLabel user = new JLabel("Username");
       user.setBounds(40,20,100,30);
       add(user);
       
       username = new JTextField();
       username.setBounds(150,20,150,30);
       add(username);
       
       JLabel pass = new JLabel("Password");
       pass.setBounds(40,70,100,30);
       add(pass);
       
       password = new JPasswordField();
       password.setBounds(150,70,150,30);
       add(password);
       
       login = new JButton("Login");
       login.setBounds(40,150,120,30);
       login.setBackground(Color.BLACK);
       login.setForeground(Color.WHITE);
       login.addActionListener(this);
       add(login);
       
       cancel = new JButton("Cancel");
       cancel.setBounds(180,150,120,30); 
       cancel.setBackground(Color.BLACK);
       cancel.setForeground(Color.WHITE);
       cancel.addActionListener(this);
       add(cancel);
       
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
       Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
       ImageIcon i3 = new ImageIcon(i2);
       JLabel image = new JLabel(i3);
       image.setBounds(350,10,200,200);
       add(image);
        
       setBounds(500,200,600,300);
       setVisible(true);
        
    }
     public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==login){ //helps us know which button was clicked
        try{
            String u = username.getText();//returns string
            String v = password.getText();
            
            Conn c = new Conn();
            String q = "select * from login where username='"+u+"' and password='"+v+"'";
            
            ResultSet rs = c.s.executeQuery(q); //DDL command thus executeQuery command
            if(rs.next()){ //if it has found value
                new Dashboard().setVisible(true);
                setVisible(false);
            }else{ //JoptionPane shows pop up
                JOptionPane.showMessageDialog(null, "Invalid login");
                setVisible(false);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        }else if(ae.getSource()==cancel){
            setVisible(false);
        }
    }
    
    public static void main(String[] args){
        new Login();
    }
}
