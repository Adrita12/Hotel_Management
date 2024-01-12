package hotel.management.system;
import java.awt.EventQueue;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;


public class AddEmployee extends JFrame implements ActionListener{
    
    JTextField tfname,tfemail,tfPhno,tfage,tfsalary,tfaadhar;
    JRadioButton rbmale,rbfemale;
    JButton submit;
    JComboBox cbjob;
    
    AddEmployee(){
        setLayout(null);
        
        JLabel lblname = new JLabel("NAME:");
        lblname.setBounds(60,30,120,30);
       //60 start and 120 width thus textfield from 180 keep 20 gap thus 200
        lblname.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(200, 30, 150, 30);
        add(tfname);
        
        JLabel lblage = new JLabel("AGE:");
        lblage.setBounds(60,80,120,30);
        lblage.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblage);
        
        tfage = new JTextField();
        tfage.setBounds(200, 80, 150, 30);
        add(tfage);
        
        JLabel lblgender = new JLabel("GENDER:");
        lblgender.setBounds(60,130,120,30);
        lblgender.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblgender);
        
        rbmale = new JRadioButton("Male");
        rbmale.setBounds(200, 130, 70, 30);
        rbmale.setFont(new Font("Tohoma",Font.PLAIN,14));
        rbmale.setBackground(Color.WHITE);
        add(rbmale);
        
        rbfemale = new JRadioButton("Female");
        rbfemale.setBounds(280, 130, 90, 30);
        rbfemale.setFont(new Font("Tohoma",Font.PLAIN,14));
        rbfemale.setBackground(Color.WHITE);
        add(rbfemale);
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(rbmale);
        bg.add(rbfemale);
        
        JLabel lbljob = new JLabel("JOB:");
        lbljob.setBounds(60,180,120,30);
        lbljob.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lbljob);
        
        //dropdown
        String str[]  = { "Front Desk Clerks", "Porters","Housekeeping","Kitchen Staff","Chefs","Room Service","Waiter/Waitress","Manager","Accountant"};
        cbjob = new JComboBox(str);
        cbjob.setBounds(200,180,150,30);
        cbjob.setBackground(Color.WHITE);
        add(cbjob);
        
        JLabel lblsalary = new JLabel("SALARY");
        lblsalary.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblsalary.setBounds(60, 230, 120, 30);
        add(lblsalary);
			
        tfsalary = new JTextField();
        tfsalary.setBounds(200, 230, 150, 30);
        add(tfsalary);
	
        
        JLabel lblPhno = new JLabel("PHONE NO.");
        lblPhno.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblPhno.setBounds(60, 280, 150, 30);
        add(lblPhno);
			
        tfPhno = new JTextField();
        tfPhno.setBounds(200, 280, 150, 30);
        add(tfPhno);
	
        
        JLabel lblemail = new JLabel("EMAIL");
        lblemail.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblemail.setBounds(60, 330, 150, 30);
        add(lblemail);
			
        tfemail = new JTextField();
        tfemail.setBounds(200, 330, 150, 30);
        add(tfemail);
        
        JLabel lblaadhar = new JLabel("AADHAR");
        lblaadhar.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblaadhar.setBounds(60, 380, 150, 30);
        add(lblaadhar);
			
        tfaadhar= new JTextField();
        tfaadhar.setBounds(200, 380, 150, 30);
        add(tfaadhar);

        submit = new JButton("SUBMIT");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(200, 430, 150, 30);
        submit.addActionListener(this);
        add(submit);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
        Image i3 = i1.getImage().getScaledInstance(450, 450,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel image = new JLabel(i2);
        image.setBounds(380,60,450,370);
        add(image);
        
        getContentPane().setBackground(Color.WHITE);
       // setBounds(350, 200,850,540);
        setVisible(true);
        setSize(900,600);
        setLocation(230,75);
    }   
        public void actionPerformed(ActionEvent ae){
        String name = tfname.getText();
        String age = tfage.getText();
        String salary = tfsalary.getText();
        String phone = tfPhno.getText();
        String aadhar = tfaadhar.getText();
        String email = tfemail.getText();
        
        String gender = null;
        if(rbmale.isSelected()){
            gender = "male";
                    
        }else if(rbfemale.isSelected()){
            gender = "female";
        }
        
         String job = (String)cbjob.getSelectedItem();
         try {
                        Conn c = new Conn();
                        String str = "INSERT INTO employee values( '"+name+"', '"+age+"', '"+gender+"','"+job+"', '"+salary+"', '"+phone+"','"+aadhar+"', '"+email+"')";
                        
                        c.s.executeUpdate(str); //DML command thus executeUpdate command
                        JOptionPane.showMessageDialog(null,"Employee Added");
                        setVisible(false);
                    
                    } catch (Exception e) {
                        e.printStackTrace();
        	    }
      }
        
        
    
    public static void main(String[] args){
        new AddEmployee();
    }
}
