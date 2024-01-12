package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HotelManagementSystem extends JFrame implements ActionListener {
    
    HotelManagementSystem(){
        setSize(1366, 565); //length,breadth
        setLocation(0,0); //left,top
        setLayout(null);//location w.r.t screen
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        JLabel Image = new JLabel(i1);
        Image.setBounds(0,0,1366,565);//locatiion w.r.t frame
        add(Image);
        //Layouts say how to place components in frame
        //Flow layout, Border layout(by-default), Grid layout
        //setLayout(null);Border Layout has center
        
        //Jlabel is used to write text on frame
        JLabel text = new JLabel("HOTEL MANAGEMENT SYSTEM");
        text.setBounds(20,430,1000,90);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("serif",Font.PLAIN,50));
        Image.add(text);
        
        JButton next = new JButton("Next");
        next.setBounds(1150,450, 150,50);
        next.setBackground(Color.WHITE);
        next.setForeground(Color.MAGENTA);
        next.addActionListener(this);
        next.setFont(new Font("serif",Font.PLAIN,25));
        Image.add(next);
        
        
        setVisible(true);
        
        while(true) {
            text.setVisible(false);
            try {
                Thread.sleep(500);
            }
            catch (Exception e){
                e.printStackTrace();
            }
            text.setVisible(true);
            try {
                Thread.sleep(500);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Login();
    }
    
    public static void main(String[] args) {
        new HotelManagementSystem();
    }
    
}
