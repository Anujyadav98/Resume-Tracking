import javax.swing.*;//code to Schedule an interview ,,, The data entered is saved into two tables Interview and InterviewR
import java.awt.*;
import java.io.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
public class Schedule extends JFrame implements ActionListener{
    JLabel lb1,lb2,lb3,lb4,lb5,lb6,lb7,lb,lb8,lb9,lb10,lb11;
    JButton btn1,btn2,btn3;
    JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8;
  
    Schedule(){
        
        setTitle("Schedule an Interview");
        lb = new JLabel("Schedule an Interview");

        lb.setBounds(20, 10, 450, 30);

        lb.setForeground(Color.red);

        lb.setFont(new Font("Serif", Font.BOLD, 25));

        lb1 = new JLabel("Enter Mobile No.");

        lb1.setBounds(20, 50, 100, 20);

        tf1 = new JTextField(20);

        tf1.setBounds(150, 50, 200, 20);
        
        lb8 = new JLabel("Enter Email ID");

        lb8.setBounds(400, 50, 100, 20);

        tf8 = new JTextField(20);

        tf8.setBounds(490, 50, 200, 20);
        
        lb2 = new JLabel("Interviewer 1 Name");

        lb2.setBounds(20, 110, 120, 20);

        tf2 = new JTextField(20);

        tf2.setBounds(150, 110, 200, 20);
        
        lb3 = new JLabel("Interview 1 Date");

        lb3.setBounds(20, 140, 120, 20);

        tf3 = new JTextField(20);

        tf3.setBounds(150, 140, 200, 20);
         lb10 = new JLabel("YYYY-MM-DD");

        lb10.setBounds(360, 140, 450, 20);
        lb10.setForeground(Color.LIGHT_GRAY);

        lb10.setFont(new Font("Serif", Font.BOLD, 15));
        
         lb4 = new JLabel("Interview 1 Time");

        lb4.setBounds(20, 170, 120, 20);

        tf4 = new JTextField(20);

        tf4.setBounds(150, 170, 200, 20);
       
        lb5 = new JLabel("Interviewer 2 Name");

        lb5.setBounds(20, 200, 120, 20);

        tf5 = new JTextField(20);

        tf5.setBounds(150, 200, 200, 20);
        
         lb6 = new JLabel("Interview 2 Date");

        lb6.setBounds(20, 230, 120, 20);

        tf6 = new JTextField(20);

        tf6.setBounds(150, 230, 200, 20);
        lb11 = new JLabel("YYYY-MM-DD");

        lb11.setBounds(360, 230, 450, 20);
        lb11.setForeground(Color.LIGHT_GRAY);

        lb11.setFont(new Font("Serif", Font.BOLD, 15));
        
        lb7 = new JLabel("Interview 2 Time");

        lb7.setBounds(20, 260, 120, 20);

        tf7 = new JTextField(20);

        tf7.setBounds(150, 260, 200, 20);
        
        btn1 = new JButton("Schedule");
        
        btn1.setBounds(20,300,100,30);
 
        btn1.addActionListener(this);
        
        btn2 = new JButton("Home");
        
        btn2.setBounds(130,300,100,30);
        
        btn2.addActionListener(this);
        
        btn2.setForeground(Color.BLUE);
        
        btn3 = new JButton("Search");
        
        btn3.setBounds(20,80,100,20);
        
        btn3.addActionListener(this);
        
        lb9 = new JLabel("OR");

        lb9.setBounds(365, 45, 450, 30);

        lb9.setForeground(Color.BLACK);

        lb9.setFont(new Font("Serif", Font.BOLD, 15));
        
        
        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(500, 500);
        
        setLayout(null);
       
        add(lb);
        add(lb1);
        add(tf1);
        add(lb2);
        add(tf2);
        add(lb3);
        add(tf3);
        add(lb4);
        add(tf4);
        add(lb5);
        add(tf5);
        add(lb6);
        add(tf6);
        add(lb7);
        add(tf7);
        add(lb8);
        add(tf8);
        add(btn3);
        add(btn1);
        add(btn2);
        add(lb9);
        add(lb10);
        add(lb11);


    }
    
    
     public void actionPerformed(ActionEvent e) {
        
         String val1 = tf1.getText();
         String val2 = tf2.getText();
         String val3 = tf3.getText();
         String val4 = tf4.getText();
         String val5 = tf5.getText();
         String val6 = tf6.getText();
         String val7 = tf7.getText();
         String val8 = tf8.getText();
         

       
         if(e.getSource()==btn2){
                        this.dispose();
			Home bp=new Home();
			bp.setSize(1035,790);
			bp.setVisible(true);
         }
         
         else if (e.getSource()==btn1) {
             try{
Class.forName("com.mysql.jdbc.Driver").newInstance();
        Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.1.3/sonoo", "root", "skv@123" );
        Statement st=conn.createStatement();

          //   st.executeUpdate("Update Interview set Inter1='"+val2+"',  Inter2='"+val5+"' where Mob = '"+val1+"'");
             st.executeUpdate("Update InterviewR set Inter1='"+val2+"', Inter2='"+val5+"',dat='"+val3+"',time ='"+val4+"' ,date2='"+val6+"',time2='"+val7+"' where Mob = '"+val1+"' OR email='"+val8+"'");
             JOptionPane.showMessageDialog(null,"Interview Scheduled!");
         }
                  catch(Exception xe){}
             
             }
         
         if(e.getSource()==btn3)
                 {
                     String str = tf1.getText();
                     String str1 = tf8.getText();

 try {
 

             Class.forName("com.mysql.jdbc.Driver");

           Connection con = DriverManager.getConnection("jdbc:mysql://192.168.1.3/sonoo", "root", "skv@123");

            PreparedStatement st = con.prepareStatement("select * from InterviewR where Mob='"+str+"' OR email='"+str1+"'");

          
 

            //Excuting Query

            ResultSet rs = st.executeQuery();

 

            if (rs.next()) {

                String s = rs.getString(2);

                String s1 = rs.getString(4);

                String s2 = rs.getString(6);

                String s3 = rs.getString(7);
                String s4 = rs.getString(8);
                String s5 = rs.getString(9);
                
              
                               

 

                //Sets Records in TextFields.

                tf2.setText(s);

                tf5.setText(s1);

                tf3.setText(s2);

                tf4.setText(s3);
                tf6.setText(s4);
                tf7.setText(s5);
            }  
            else {
                        JOptionPane.showMessageDialog(null,"Not Found","Error",JOptionPane.ERROR_MESSAGE);
                        }
                     
                  
                 }
     
 catch(Exception xe){}
 
                 } }
    
    public static void main(String args[]) {

        new Schedule();

    }
    
    
    
}
