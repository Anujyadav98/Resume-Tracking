import java.awt.*; // this is the code to see the interview remarks 
// linked to Interview table in the database 
import javax.swing.*;
import java.awt.event.*;
//import java.io.File;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Interview extends JFrame implements ActionListener{
    
     JLabel lb, lb1, lb2, lb3, lb4, lb5,lb6,lb7,lb8,lb9,lb10,lb11,lb12,lb13,lb14,lb15,lb16,lb17,lb18,lb19,lb20;

    JTextField tf1, tf2, tf3, tf4, tf5,tf6,tf7,tf8,tf9,tf10,tf11,tf12,tf13,tf14,tf15,tf16,tf17,tf18;

    JButton btn,btn1,btn2,btn3;
      Statement stmt;
    Interview()
    {
        setTitle("Interviewer Remarks");
      
        lb5 = new JLabel("Enter Mobile No.");

        lb5.setBounds(20, 60, 100, 20);

        tf5 = new JTextField(20);

        tf5.setBounds(200, 60, 200, 20);

        btn = new JButton("Submit");

        btn.setBounds(20, 90, 100, 20);

        btn.addActionListener(this);

 

        lb = new JLabel("Fetch Interviewer Remarks From Database");

        lb.setBounds(20, 15, 500, 30);

        lb.setForeground(Color.red);

        lb.setFont(new Font("Serif", Font.BOLD, 25));

        setVisible(true);

       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(500, 500);
        lb10= new JLabel("Position Applied For");

        lb10.setBounds(410, 130, 150, 20);

        tf10 = new JTextField(50);

        tf10.setBounds(540, 130, 200, 20);

        lb20= new JLabel("Department");

        lb20.setBounds(20, 130, 150, 20);

        tf18 = new JTextField(50);

        tf18.setBounds(200, 130, 200, 20);
        
        lb11= new JLabel("Location");

        lb11.setBounds(20, 160, 100, 20);

        tf11 = new JTextField(50);

        tf11.setBounds(200, 160, 200, 20);
        
        

 

        lb1 = new JLabel("Interviewer 1");

        lb1.setBounds(20, 190, 130, 20);

        tf1 = new JTextField(50);

        tf1.setBounds(200, 190, 200, 20);
 
        lb2 = new JLabel("Interviewer 1 Remarks");

        lb2.setBounds(20, 220, 150, 20);

        tf2 = new JTextField(100);

        tf2.setBounds(200, 220, 200, 20);
        
        lb18=new JLabel("Interviewer 1 Rating");

        lb18.setBounds(20, 245, 170, 22);

        lb18.setFont(new Font("Serif", Font.BOLD, 17));

        lb6 = new JLabel("SKEE");

        lb6.setBounds(20, 280, 130, 20);

        tf7 = new JTextField(50);

        tf7.setBounds(200, 280, 200, 20);

        lb12 = new JLabel("IPC");

        lb12.setBounds(20, 310, 130, 20);

        tf12 = new JTextField(50);

        tf12.setBounds(200, 310, 200, 20);

        lb13 = new JLabel("TEMPRAMENT");

        lb13.setBounds(20, 340, 130, 20);

        tf13 = new JTextField(50);

        tf13.setBounds(200, 340, 200, 20);

        lb14 = new JLabel("Accepts Role Requirement");

        lb14.setBounds(20, 370, 170, 20);

        tf14 = new JTextField(50);

        tf14.setBounds(200, 370, 200, 20);

        lb3 = new JLabel("Interviewer 2");

        lb3.setBounds(20, 400, 130, 20);

        tf3 = new JTextField(50);

        tf3.setBounds(200,400, 200, 20);

        lb4 = new JLabel("Interviewer 2 Remarks");

        lb4.setBounds(20, 430, 150, 20);

        tf4 = new JTextField(50);

        tf4.setBounds(200, 430, 200, 20);
        
        lb19=new JLabel("Interviewer 2 Rating");

        lb19.setBounds(20, 455, 170, 22);

        lb19.setFont(new Font("Serif", Font.BOLD, 17));
        
        setLayout(null);
        
        btn1 = new JButton("Upload Remarks");

        btn1.setBounds(20,620, 150, 30);

        btn1.addActionListener(this);

        btn2 = new JButton("Home");

        btn2.setBounds(200,620, 100, 30);

        btn2.addActionListener(this);

        btn2.setForeground(Color.BLUE);
      
        lb7 = new JLabel("SKEE");

        lb7.setBounds(20, 490, 130, 20);

        tf8 = new JTextField(50);

        tf8.setBounds(200, 490, 200, 20);
        
        lb15 = new JLabel("IPC");

        lb15.setBounds(20, 520, 130, 20);

        tf15 = new JTextField(50);

        tf15.setBounds(200, 520, 200, 20);
 
        lb16 = new JLabel("TEMPRAMENT");

        lb16.setBounds(20, 550, 130, 20);

        tf16 = new JTextField(50);

        tf16.setBounds(200, 550, 200, 20);
   
        lb17 = new JLabel("Accepts Role Requirement");

        lb17.setBounds(20, 580, 170, 20);

        tf17 = new JTextField(50);

        tf17.setBounds(200, 580, 200, 20);
        
        lb8 = new JLabel("Enter Email ID");

        lb8.setBounds(470, 60, 100, 20);

        tf9 = new JTextField(50);

        tf9.setBounds(610, 60, 200, 20);
        
        lb9 = new JLabel("OR");

        lb9.setBounds(410, 55, 450, 30);

        lb9.setForeground(Color.BLACK);

        lb9.setFont(new Font("Serif", Font.BOLD, 15));
 

        //Add components to the JFrame

        add(lb5);

        add(tf5);

        add(btn);

 

        add(lb);

        add(lb1);

        add(tf1);

        add(lb2);

        add(tf2);

        add(lb3);

        add(tf3);

        add(lb4);

        add(tf4);
       
        add(btn1);
        
        add(btn2);
        
        add(lb6);
        
        add(tf7);
        
        add(lb7);
        
        add(tf8);
        
        add(lb8);
        add(tf9);
        

        
        add(lb9);
        add(lb10);
        add(tf10);
        add(lb11);
        add(tf11);
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
        add(lb20);
        add(tf18);
       
       

       tf1.setEditable(false);
//
    // tf2.setEditable(false);
//
     tf3.setEditable(false);
//
//      tf4.setEditable(false);
   
         tf10.setEditable(false);
          tf11.setEditable(false);
          tf18.setEditable(false);
        

    }
        
    public void actionPerformed(ActionEvent e) {
      
     if(e.getSource()==btn2)
		{
			this.dispose();
			Home h2=new Home();
			h2.setSize(1035,790);
			h2.setVisible(true);
		}
     else if(e.getSource()==btn1)
     {
         try {
         String str1 = tf5.getText();
         String str2 = tf2.getText();
         String str3 = tf4.getText();
         
       
         String str6 = tf9.getText();
         
     Class.forName("com.mysql.jdbc.Driver");

           Connection con = DriverManager.getConnection("jdbc:mysql://192.168.1.3/sonoo", "root", "skv@123");

          // PreparedStatement st1 = con.prepareStatement("UPDATE Interview SET Int1r = ?,Int2r= ? WHERE Mob = ?");
         stmt = con.createStatement();
           
        String  sql = "UPDATE InterviewR SET Int1r ='"+str2+"',Int2r= '"+str3+"' WHERE Mob='" +str1+"' OR email='"+str6+"'";
       
         int rs1 = stmt.executeUpdate(sql);
         
          JOptionPane.showMessageDialog(null, "Remarks Updated");
           } catch (Exception ex) {


 

            System.out.println(ex);
           }
         try{
          String str9 = tf5.getText();    
         String str1 = tf7.getText();
         String str2 = tf12.getText();
         String str3 = tf13.getText();
         String str4 = tf14.getText();
         String str5 = tf8.getText();
         String str6 = tf15.getText();
         String str7 = tf16.getText();
         String str8 = tf17.getText();
         String str10 = tf9.getText();
          
       
            
             
         Class.forName("com.mysql.jdbc.Driver").newInstance();
        Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.1.3/sonoo", "root", "skv@123" );
      PreparedStatement ps = conn.prepareStatement(
        "UPDATE rating1 SET skee ='" +str1+"' ,ipc = '" +str2+"',temp = '" +str3+"',arr='" +str4+"',skee1='" +str5+"',ipc1='" +str6+"',temp1='" +str7+"',arr1='" +str8+"' WHERE Mob='" +str9+"' OR email='"+str10+"'");
         
      
     
      
        ps.executeUpdate();
        
       Float skee = Float.parseFloat(str1);
               Float ipc = Float.parseFloat(str2);
               Float temp = Float.parseFloat(str3);
               Float arr = Float.parseFloat(str4);
               Float skee1 = Float.parseFloat(str5);
               Float ipc1 = Float.parseFloat(str6);
               Float temp1 = Float.parseFloat(str7);
               Float arr1 = Float.parseFloat(str8);
               
               Float rating1 = (skee+ipc+temp+arr)/4;
               Float rating2 = (skee1+ipc1+temp1+arr1)/4;
               
               String rat1 = Float.toString(rating1);
               String rat2 = Float.toString(rating2);
               
               PreparedStatement st1 = conn.prepareStatement("UPDATE InterviewR SET selected1 ='"+rat1+"',selected2= '"+rat2+"' where Mob=? OR email='"+str10+"'");
             st1.setString(1, str9);
              st1.executeUpdate();
       
         }
          catch (Exception ex) {


 

            System.out.println(ex);

        }
     }
         
        
     
     
     
     else if(e.getSource()==btn) {
           try {

               String str3 = getTitle();
               System.out.println(str3);
               String str = tf5.getText();
            String str1 = tf9.getText();
        
             //String str2 = tf1.getText();//interviewer 1 name       
             // String str4 = tf3.getText();//interviewer 2 name
            

 

             Class.forName("com.mysql.jdbc.Driver");

           Connection con = DriverManager.getConnection("jdbc:mysql://192.168.1.3/sonoo", "root", "skv@123");

            PreparedStatement st = con.prepareStatement("select * from InterviewR where Mob=? OR email='"+str1+"'");

            st.setString(1, str);

 

            //Excuting Query

            ResultSet rs = st.executeQuery();

 

            if (rs.next()) {

                String s = rs.getString(2);

                String s1 = rs.getString(3);

                String s2 = rs.getString(4);

                String s3 = rs.getString(5);
                
                
              
                               

 

                //Sets Records in TextFields.

                tf1.setText(s);

                tf2.setText(s1);

                tf3.setText(s2);

                tf4.setText(s3);
                
      
                
               

            } else {

                JOptionPane.showMessageDialog(null,"Not Found","Error",JOptionPane.ERROR_MESSAGE);

            }

 

            //Create Exception Handler

        } catch (Exception ex) {


 

            System.out.println(ex);

        }
            try {

            String str = tf5.getText();
            String str1 = tf9.getText();


 

             Class.forName("com.mysql.jdbc.Driver");

           Connection con = DriverManager.getConnection("jdbc:mysql://192.168.1.3/sonoo", "root", "skv@123");

            PreparedStatement st = con.prepareStatement("select job,location,department from data1 where Mno=? OR email1='"+str1+"'");

            st.setString(1, str);

 

            //Excuting Query

            ResultSet rs = st.executeQuery();

 

            if (rs.next()) {

                String s = rs.getString(1);

                String s1 = rs.getString(2);
                
                String s2 = rs.getString(3);

             
              
                               

 

                //Sets Records in TextFields.

                tf10.setText(s);

                tf11.setText(s1);
                
                tf18.setText(s2);

               
                
               

            } else {

              // JOptionPane.showMessageDialog(null,"Job,Location Or Department Not Found","Error",JOptionPane.ERROR_MESSAGE);

            }

 

            //Create Exception Handler

        } catch (Exception ex) {


 

            System.out.println(ex);

        
    } 
             try {

            String str = tf5.getText();
            String str1 = tf9.getText();


 

             Class.forName("com.mysql.jdbc.Driver");

           Connection con = DriverManager.getConnection("jdbc:mysql://192.168.1.3/sonoo", "root", "skv@123");

            PreparedStatement st = con.prepareStatement("select * from rating1 where Mob=? OR email='"+str1+"'");

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

                 //JOptionPane.showMessageDialog(null,"Ratings Not Found","Error",JOptionPane.ERROR_MESSAGE);

            }

 

            //Create Exception Handler

        } catch (Exception ex) {


 

            System.out.println(ex);

        }
     

 

            

      

 

    
    }
    }
public static void main(String args[]) {

        new Interview();

   }}