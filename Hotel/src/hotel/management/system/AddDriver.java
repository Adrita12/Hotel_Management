package hotel.management.system;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class AddDriver extends JFrame implements ActionListener {

   
    JTextField tfname,tfage,tfcompany,tfmodel,tflocation;
    JComboBox gendercombo,drivercombo;
    JButton add,cancel;
   


    public AddDriver() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Add Drivers");
        heading.setFont(new Font("Tahoma",Font.BOLD,18));
        heading.setBounds(150,10,200,20);
        add(heading);
        
        JLabel lblname = new JLabel("Name");
        lblname.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblname.setBounds(60,80,120,20);
        add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(200,80,150,30);
        add(tfname);
        
        JLabel lblage = new JLabel("Age");
        lblage.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblage.setBounds(60,120,120,30);
        add(lblage);
        
        tfage = new JTextField();
        tfage.setBounds(200,120,150,30);
        add(tfage);
   
        
        JLabel lblgender = new JLabel("Gender");
        lblgender.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblgender.setBounds(60,160,120,30);
        add(lblgender);
        
        String genderOptions[] = {"Male","Female"};
        gendercombo = new JComboBox(genderOptions);
        gendercombo.setBounds(200,160,150,30);
        gendercombo.setBackground(Color.WHITE);
        add(gendercombo);
        
        JLabel lblcompany = new JLabel("Car company");
        lblcompany.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblcompany.setBounds(60,200,120,30);
        add(lblcompany);
        
        tfcompany = new JTextField();
        tfcompany.setBounds(200,200,150,30);
        add(tfcompany);
        
        
        JLabel lblmodel = new JLabel("Car Model");
        lblmodel.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblmodel.setBounds(60,240,120,30);
        add(lblmodel);
        
         tfmodel = new JTextField();
         tfmodel.setBounds(200,240,150,30);
         add(tfmodel);
        
        JLabel lblavailable = new JLabel("Availability");
        lblavailable.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblavailable .setBounds(60,280,120,30);
        add(lblavailable ); 
        
        String driverOptions[] = {"Available","Busy"};
        drivercombo = new JComboBox(driverOptions);
        drivercombo.setBounds(200,280,150,30);
        drivercombo.setBackground(Color.WHITE);
        add(drivercombo);
        
        JLabel lbllocation = new JLabel("Location");
        lbllocation.setFont(new Font("Tahoma",Font.PLAIN,16));
        lbllocation.setBounds(60,320,120,30);
        add(lbllocation);
        
         tflocation = new JTextField();
         tflocation.setBounds(200,320,150,30);
         add(tflocation);
         
        add = new JButton("Add Driver");
        add.setBounds(60,370,130,30);
        add.setForeground(Color.WHITE);
        add.setBackground(Color.BLACK);
        add.addActionListener(this);
        add(add);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(220,370,130,30);
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,70,500,300);
        add(image);
      
        
        setBounds(300,150,980,470);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== add){
           
            try{
            String name = tfname.getText();
            String age = tfage.getText();
            String gender = (String)gendercombo.getSelectedItem();
            String company  = tfcompany.getText();
            String model = tfmodel.getText();
            String avail = (String)drivercombo.getSelectedItem();
            String location = tflocation.getText();
                Conn c1 = new Conn();
                String str = "INSERT INTO driver values( '"+name+"', '"+age+"', '"+gender+"','"+company+"', '"+model+"','"+avail+"','"+location+"')";
            
                c1.s.executeUpdate(str);
		JOptionPane.showMessageDialog(null, "Driver Successfully Added");
                this.setVisible(false);
                
            }catch(Exception e){
                System.out.println(e);
            }
            
        }else{
            setVisible(false);
        }
    }
    
     public static void main(String[] args) {
        new AddDriver();
    }
}