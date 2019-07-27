import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
//import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class Detailed extends JFrame implements ActionListener {
    JLabel lb,lb18,lb6,lb12,lb13,lb14,lb7,lb15,lb16,lb17,lb19,lb1;
    JTextField tf7,tf12,tf13,tf14,tf8,tf15,tf16,tf17,tf1;
    JButton btn;
    

Detailed()
{
    super("Ratings");
lb = new JLabel("Detailed Ratings");

        lb.setBounds(20, 15, 500, 30);

        lb.setForeground(Color.red);

        lb.setFont(new Font("Serif", Font.BOLD, 25));
        
        lb1 = new JLabel("Mobile No.");

        lb1.setBounds(20, 60, 130, 20);

        tf1 = new JTextField(50);

        tf1.setBounds(200, 60, 200, 20);
        
        lb18=new JLabel("Interviewer 1 Rating");
        lb18.setBounds(20,90, 170, 22);
        lb18.setFont(new Font("Serif", Font.BOLD, 17));
        lb6 = new JLabel("SKEE");

        lb6.setBounds(20, 120, 130, 20);

        tf7 = new JTextField(50);

        tf7.setBounds(200, 120, 200, 20);
        lb12 = new JLabel("IPC");

        lb12.setBounds(20, 150, 130, 20);

        tf12 = new JTextField(50);

        tf12.setBounds(200, 150, 200, 20);
        lb13 = new JLabel("TEMPRAMENT");

        lb13.setBounds(20, 180, 130, 20);

        tf13 = new JTextField(50);

        tf13.setBounds(200, 180, 200, 20);
        lb14 = new JLabel("Accepts Role Requirement");

        lb14.setBounds(20, 210, 170, 20);

        tf14 = new JTextField(50);

        tf14.setBounds(200, 210, 200, 20);
        
        lb19=new JLabel("Interviewer 2 Rating");
        lb19.setBounds(20, 235, 170, 22);
        lb19.setFont(new Font("Serif", Font.BOLD, 17));
        
        setLayout(null);
          
        
        lb7 = new JLabel("SKEE");

        lb7.setBounds(20, 270, 130, 20);

        tf8 = new JTextField(50);

        tf8.setBounds(200, 270, 200, 20);
        
        lb15 = new JLabel("IPC");

        lb15.setBounds(20, 300, 130, 20);

        tf15 = new JTextField(50);

        tf15.setBounds(200, 300, 200, 20);
        lb16 = new JLabel("TEMPRAMENT");

        lb16.setBounds(20, 330, 130, 20);

        tf16 = new JTextField(50);

        tf16.setBounds(200, 330, 200, 20);
        lb17 = new JLabel("Accepts Role Requirement");

        lb17.setBounds(20, 360, 170, 20);

        tf17 = new JTextField(50);

        tf17.setBounds(200, 360, 200, 20);
        
        btn = new JButton("Get");
        btn.setBounds(20, 390, 70, 30);
        btn.addActionListener(this);

        
        setVisible(true);
        
     //  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(500, 500);
        
        add(lb);
        add(lb12);
        add(tf12);
        add(lb13);
        add(tf13);
        add(lb14);
        add(tf14);
        add(lb15);
        add(tf15);
        add(lb16);
        add(tf16);
        add(lb17);
        add(tf17);
        add(lb18);
        add(lb19);
        add(lb6);
        add(tf7);
        add(lb7);
        add(tf8);
        add(btn);
        add(lb1);
        add(tf1);
        
        tf12.setEditable(false);

        tf13.setEditable(false);

        tf14.setEditable(false);

        tf15.setEditable(false);
        
        tf16.setEditable(false);
        tf7.setEditable(false);
        tf8.setEditable(false);
        tf17.setEditable(false);
        
       

}
public void actionPerformed(ActionEvent e) {
   if (e.getSource()== btn) 
   {
   
    try {
        String str = tf1.getText();
        
             Class.forName("com.mysql.jdbc.Driver");

           Connection con = DriverManager.getConnection("jdbc:mysql://192.168.1.3/sonoo", "root", "skv@123");

            PreparedStatement st = con.prepareStatement("select * from rating1 where Mob=?");

            st.setString(1, str);

 

            //Excuting Query

            ResultSet rs = st.executeQuery();

 

            if (rs.next()) {

                String s = rs.getString(2);

                String s1 = rs.getString(3);

                String s2 = rs.getString(4);

                String s3 = rs.getString(5);

                String s4 = rs.getString(6);

                String s5 = rs.getString(7);

                String s6 = rs.getString(8);

                String s7 = rs.getString(9);

                //Sets Records in TextFields.

                tf7.setText(s);

                tf12.setText(s1);

                tf13.setText(s2);

                tf14.setText(s3);
                tf8.setText(s4);
                tf15.setText(s5);
                tf16.setText(s6);
               tf17.setText(s7);

            } else {

                 JOptionPane.showMessageDialog(null,"Not Found","Error",JOptionPane.ERROR_MESSAGE);
                 JOptionPane.showConfirmDialog(rootPane, "hi");

            }

 

          
        } catch (Exception ex) {


 

            System.out.println(ex);

        }
    
    
}
}
public static void main(String args[]) {
    
    

        new Detailed();

    }}