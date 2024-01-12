package hotel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener{
    public Dashboard(){
      //  setSize(1360,800);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1550, 1000,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2); 
	JLabel image = new JLabel(i3);
	image.setBounds(0, 0, 1400,1000); 
        add(image);
        
        JLabel text = new JLabel("THE TAJ GROUP WELCOMES YOU");
	text.setForeground(Color.WHITE);
        text.setFont(new Font("Tahoma", Font.PLAIN, 46));
	text.setBounds(400, 80, 1000,50);
	image.add(text);
        
        JMenuBar mb = new JMenuBar();
	mb.setBounds(0,0,1550,30);
        image.add(mb);
        
        JMenu hotel = new JMenu("HOTEL MANAGEMENT");
        hotel.setForeground(Color.BLUE);
	mb.add(hotel);
        
        JMenuItem reception = new JMenuItem("RECEPTION");
        reception.addActionListener(this);
	hotel.add(reception);
        
        JMenu admin = new JMenu("ADMIN");
        admin.setForeground(Color.BLUE);
	mb.add(admin);
        
        JMenuItem addemployee = new JMenuItem("ADD EMPLOYEE");
        addemployee.addActionListener(this);
	admin.add(addemployee);
        
        JMenuItem addroom = new JMenuItem("ADD ROOM");
        addroom.addActionListener(this);
	admin.add(addroom);
        
        JMenuItem adddrivers = new JMenuItem("ADD DRIVER");
        adddrivers.addActionListener(this);
	admin.add(adddrivers);
        
        setSize(1400,1000);
        //setLocation(0,0);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getActionCommand().equals("ADD EMPLOYEE")){
            new AddEmployee();
        }
        else if(ae.getActionCommand().equals("ADD ROOM")){
            new AddRooms();
        }
        else if(ae.getActionCommand().equals("ADD DRIVER")){
            new AddDriver();
        }
        else if(ae.getActionCommand().equals("RECEPTION")){
            new Reception();
        }
    }
    
    public static void main(String[] args) {
        new Dashboard().setVisible(true);
    }
    
}
