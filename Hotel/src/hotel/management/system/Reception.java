package hotel.management.system;

import javax.swing.*;

import java.sql.*;	
import java.awt.event.*;
import java.awt.*;

public class Reception extends JFrame implements ActionListener{
    JButton newCustomer,department,logout,allEmployee,managerInfo,allCustomer,searchRoom,update,roomStatus,pickup,checkout;
    JButton room;
    Reception(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        newCustomer =  new JButton("New Customer Form");
        newCustomer.setBounds(10,30,200,30);
        newCustomer.setBackground(Color.BLACK);
        newCustomer.setForeground(Color.WHITE);
        newCustomer.addActionListener(this);
        add(newCustomer);
        
        room =  new JButton("Rooms");
        room.setBounds(10,70,200,30);
        room.setBackground(Color.BLACK);
        room.setForeground(Color.WHITE);
        room.addActionListener(this);
        add(room);
        
        department =  new JButton("Department");
        department.setBounds(10,110,200,30);
        department.setBackground(Color.BLACK);
        department.setForeground(Color.WHITE);
        department.addActionListener(this);
        add(department);
        
        allEmployee =  new JButton("All Employees");
        allEmployee.setBounds(10,150,200,30);
        allEmployee.setBackground(Color.BLACK);
        allEmployee.setForeground(Color.WHITE);
        allEmployee.addActionListener(this);
        add(allEmployee);
        
        allCustomer =  new JButton("All Customer");
        allCustomer.setBounds(10,190,200,30);
        allCustomer.setBackground(Color.BLACK);
        allCustomer.setForeground(Color.WHITE);
        allCustomer.addActionListener(this);
        add(allCustomer);
        
        managerInfo =  new JButton("Manager Info");
        managerInfo.setBounds(10,230,200,30);
        managerInfo.setBackground(Color.BLACK);
        managerInfo.setForeground(Color.WHITE);
        managerInfo.addActionListener(this);
        add(managerInfo);
        
        checkout =  new JButton("Checkout");
        checkout.setBounds(10,270,200,30);
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.WHITE);
        checkout.addActionListener(this);
        add(checkout);
        
        update =  new JButton("Update status");
        update.setBounds(10,310,200,30);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);
        
        roomStatus =  new JButton("Update Room status");
        roomStatus.setBounds(10,350,200,30);
        roomStatus.setBackground(Color.BLACK);
        roomStatus.setForeground(Color.WHITE);
        roomStatus.addActionListener(this);
        add(roomStatus);
        
        pickup =  new JButton("Pickup Service");
        pickup.setBounds(10,390,200,30);
        pickup.setBackground(Color.BLACK);
        pickup.setForeground(Color.WHITE);
        pickup.addActionListener(this);
        add(pickup);
        
        searchRoom =  new JButton("Search Room");
        searchRoom.setBounds(10,430,200,30);
        searchRoom.setBackground(Color.BLACK);
        searchRoom.setForeground(Color.WHITE);
        searchRoom.addActionListener(this);
        add(searchRoom);
        
        logout =  new JButton("Logout");
        logout.setBounds(10,470,200,30);
        logout.setBackground(Color.BLACK);
        logout.setForeground(Color.WHITE);
        logout.addActionListener(this);
        add(logout);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(250,30,500,470);
        add(image);
        
        
        
        setBounds(300,80,800,570);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
    if(ae.getSource()==newCustomer){
        setVisible(false);
        new NewCustomer();
    }
    else if(ae.getSource()==room){
        setVisible(false);
        new Room();
    }
    else if(ae.getSource()== department){
        setVisible(false);
        new Department();
    }
    else if(ae.getSource()== allEmployee){
        setVisible(false);
        new EmployeeInfo();
    }
    else if(ae.getSource()== managerInfo){
        setVisible(false);
        new ManagerInfo();
    }
    else if(ae.getSource()== allCustomer){
        setVisible(false);
        new CustomerInfo();
    }else if(ae.getSource()== searchRoom){
        setVisible(false);
        new SearchRoom();
    }else if(ae.getSource()== update){
        setVisible(false);
        new UpdateCheck();
    }else if(ae.getSource()==roomStatus){
        setVisible(false);
        new UpdateRoom();
    }else if(ae.getSource()==pickup){
        setVisible(false);
        new Pickup();
    }else if(ae.getSource()==checkout){
        
       setVisible(false);
       new Checkout();
    }
    else if(ae.getSource()==logout){
        setVisible(false);
    }
    }
    
    public static void main(String args[]){
        new Reception();
    }
}
