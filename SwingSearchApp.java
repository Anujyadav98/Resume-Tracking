import javax.swing.*;
// This code is to search the data for matching records using GUI
import java.awt.event.*;

import java.awt.*;

import java.sql.*;


 

public class SwingSearchApp extends JFrame implements ActionListener {

 

//Initializing Components

    JLabel lb, lb1, lb2, lb3, lb4, lb5,lb6,lb7,lb8,lb9,lb10,lb11,lb12,lb13,lb14,lb15,lb16,lb17,lb18,lb19,lb20,lb21,lb22,lb23;

    JTextField tf1, tf2, tf3, tf4, tf5,tf6,tf7,tf8,tf9,tf10,tf11,tf12,tf13,tf14,tf15,tf16,tf17,tf18,tf19,tf20,tf21;

    JButton btn,btn1,btn2;
 

    //Creating Constructor for initializing JFrame components

    SwingSearchApp() {

        //Providing Title
    
        setTitle("Search");

        lb5 = new JLabel("Enter Mobile No.");

        lb5.setBounds(20, 50, 100, 20);

        tf5 = new JTextField(20);

        tf5.setBounds(190, 50, 350, 20);
        
        lb14 = new JLabel("Enter Email ID");

        lb14.setBounds(20, 90, 100, 20);

        tf14 = new JTextField(20);

        tf14.setBounds(190, 90, 350, 20);

 

        btn = new JButton("Submit");

        btn.setBounds(20, 125, 100, 20);

        btn.addActionListener(this);

 

        lb = new JLabel("Fetching Applicant Information From Database");

        lb.setBounds(20, 150, 450, 30);

        lb.setForeground(Color.red);

        lb.setFont(new Font("Serif",Font.PLAIN, 20));
        
        lb22 = new JLabel("OR");

        lb22.setBounds(20, 65, 450, 30);

        lb22.setForeground(Color.BLACK);

        lb22.setFont(new Font("Serif", Font.BOLD, 15));

        setVisible(true);

     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       setSize(500, 500);

 

        lb1 = new JLabel("Mobile No.");

        lb1.setBounds(20, 200, 100, 20);

        tf1 = new JTextField(50);

        tf1.setBounds(190, 200, 350, 20);

        lb2 = new JLabel("First Name");

        lb2.setBounds(20, 230, 100, 20);

        tf2 = new JTextField(100);

        tf2.setBounds(190, 230, 350, 20);

        lb3 = new JLabel("Last Name");

        lb3.setBounds(20, 260, 100, 20);

        tf3 = new JTextField(50);

        tf3.setBounds(190, 260, 350, 20);

        lb4 = new JLabel("Position Applied For");

        lb4.setBounds(550, 290, 160, 20);

        tf4 = new JTextField(50);

        tf4.setBounds(690, 290, 200, 20);

        lb23 = new JLabel("Department");

        lb23.setBounds(20, 290, 160, 20);

        tf21 = new JTextField(50);

        tf21.setBounds(190, 290, 350, 20);
        
        lb21 = new JLabel("Date Of Application");

        lb21.setBounds(550, 320, 150, 20);

        tf20 = new JTextField(50);

        tf20.setBounds(690, 320, 200, 20);

        lb20 = new JLabel("Location");

        lb20.setBounds(20, 320, 100, 20);

        tf19 = new JTextField(50);

        tf19.setBounds(190, 320, 350, 20);

        lb6= new JLabel("Email ID");

        lb6.setBounds(20, 350, 100, 20);

        tf6 = new JTextField(50);

        tf6.setBounds(190, 350, 350, 20);

     
        lb7 = new JLabel("Interviewer 1 Name");

        lb7.setBounds(20, 380, 150, 20);

        tf7 = new JTextField(50);

        tf7.setBounds(190, 380, 350, 20);

        lb8 = new JLabel("Date Of Interview 1");

        lb8.setBounds(20, 410, 150, 20);

        tf8 = new JTextField(50);

        tf8.setBounds(190, 410, 350, 20);

        lb9 = new JLabel("Time Of Interview 1");

        lb9.setBounds(20, 440, 150, 20);

        tf9 = new JTextField(50);

        tf9.setBounds(190, 440, 350, 20);

        lb10 = new JLabel("Interviewer 1 Remarks");

        lb10.setBounds(20, 470, 150, 20);

        tf10 = new JTextField(50);

        tf10.setBounds(190, 470, 350, 20);

        lb17 = new JLabel("Interviewer 1 Rating");

        lb17.setBounds(550, 470, 150, 20);

        tf17 = new JTextField(50);

        tf17.setBounds(690, 470, 200, 20);
        
        lb11 = new JLabel("Interviewer 2 Name");

        lb11.setBounds(20, 500, 150, 20);

        tf11 = new JTextField(50);

        tf11.setBounds(190, 500, 350, 20);
        
        lb12 = new JLabel("Date Of Interview 2");

        lb12.setBounds(20, 530, 150, 20);

        tf12 = new JTextField(50);

        tf12.setBounds(190, 530, 350, 20);
        
        lb13 = new JLabel("Time of Interview 2");

        lb13.setBounds(20, 560 , 150, 20);

        tf13 = new JTextField(50);

        tf13.setBounds(190, 560, 350, 20);
        
        lb15 = new JLabel("Interviewer 2 Remarks");

        lb15.setBounds(20, 590 , 150, 20);

        tf15 = new JTextField(50);

        tf15.setBounds(190, 590, 350, 20);

        lb18 = new JLabel("Interviewer 2 Rating");

        lb18.setBounds(550, 590, 150, 20);

        tf18 = new JTextField(50);

        tf18.setBounds(690, 590, 200, 20);
        
        lb16 = new JLabel("Selected ");

        lb16.setBounds(20, 620 , 150, 20);

        tf16 = new JTextField(50);

        tf16.setBounds(190, 620, 350, 20);
        
         
        
        btn1 = new JButton("Home");

        btn1.setBounds(20,660, 100, 30);

        btn1.addActionListener(this);
        
        btn1.setForeground(Color.BLUE);
        
        lb19 = new JLabel("Search Database");

        lb19.setBounds(20, 10, 450, 30);

        lb19.setForeground(Color.red);

        lb19.setFont(new Font("Serif", Font.BOLD, 25));

        btn2 = new JButton("Get Detailed Rating");

        btn2.setBounds(140,660, 150, 30);

        btn2.addActionListener(this);
        



        //Add components to the JFrame
        setLayout(null);
       
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
        add(lb6);
        add(tf6);
        add(btn1);
        add(lb7);
        add(tf7);
        add(lb8);
        add(tf8);
        add(lb9);
        add(tf9);
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
        add(tf18);
        add(lb19);
        add(lb20);
        add(tf19);
        add(lb21);
        add(tf20);
        add(lb22);
        add(btn2);
        add(lb23);
        add(tf21);

      
        
        
        
        tf1.setEditable(false);
        tf2.setEditable(false);
        tf3.setEditable(false);
        tf4.setEditable(false);
        tf6.setEditable(false);
        tf7.setEditable(false);
        tf8.setEditable(false);
        tf9.setEditable(false);
        tf10.setEditable(false);
        tf11.setEditable(false);
        tf12.setEditable(false);
        tf13.setEditable(false);
        tf15.setEditable(false);
        tf16.setEditable(false);
        tf17.setEditable(false);
        tf18.setEditable(false);
        tf19.setEditable(false);
        tf20.setEditable(false);
        tf21.setEditable(false);
      
        

    }

 


    public void actionPerformed(ActionEvent e) {

        //Create DataBase Coonection and Fetching Records
      if(e.getSource()==btn1)
		{
			this.dispose();
			Home bp=new Home();
			bp.setSize(1035,790);
			bp.setVisible(true);
		}
    else  if(e.getSource()==btn2)
		{
			
			Detailed dt=new Detailed();
			dt.setSize(1035,790);
			dt.setVisible(true);
		}
      else if (e.getSource()==btn)
              {
        try {

            String str = tf5.getText();
            String mail = tf14.getText();

 

             Class.forName("com.mysql.jdbc.Driver");

           Connection con = DriverManager.getConnection("jdbc:mysql://192.168.1.3/sonoo", "root", "skv@123");

            PreparedStatement st = con.prepareStatement("SELECT Mno,fname,lname,job,email1,location,dateofapp,Inter1,Int1r,Inter2,Int2r,dat,time,date2,time2,department FROM data1 t1 INNER JOIN InterviewR t2 ON t1.Mno=t2.Mob where (t1.Mno=?) OR (t1.email1=?)");
            
            st.setString(1, str);
            st.setString(2,mail);

 

            

            ResultSet rs = st.executeQuery();

 

            if (rs.next()) {

                String s = rs.getString(1);
                String s1 = rs.getString(2);
                String s2 = rs.getString(3);
                String s3 = rs.getString(4);
                String s4 = rs.getString(5);
                String s5 = rs.getString(8);
                String s6 = rs.getString(9);
                String s7 = rs.getString(10);
                String s8 = rs.getString(11);
                String s9 = rs.getString(12);
                String s10 = rs.getString(13);
                String s13 = rs.getString(14);
                String s14 = rs.getString(15);
                String s15 = rs.getString(6);
                String s16 = rs.getString(7);
                 String s17 = rs.getString(16);
                
                
                
                

 

                //Sets Records in TextFields.

                tf1.setText(s);

                tf2.setText(s1);

                tf3.setText(s2);

                tf4.setText(s3);
                
                tf6.setText(s4);
                tf7.setText(s5);
                tf8.setText(s9);
                tf9.setText(s10);
                tf10.setText(s6);
                tf11.setText(s7);
                tf12.setText(s13);
                tf15.setText(s8);
               
                tf13.setText(s14);
                tf19.setText(s15);
                tf20.setText(s16);
                tf21.setText(s17);

            }
else {

                JOptionPane.showMessageDialog(null,"Not Found","Error",JOptionPane.ERROR_MESSAGE);

            }      
            
        }
        catch (Exception ex) {


 

            System.out.println(ex);

        }
         try {
             
             String str = tf5.getText();
             String mail = tf14.getText();
             Class.forName("com.mysql.jdbc.Driver");

           Connection con = DriverManager.getConnection("jdbc:mysql://192.168.1.3/sonoo", "root", "skv@123");

             
                PreparedStatement st = con.prepareStatement("SELECT skee,ipc,temp,arr,skee1,ipc1,temp1,arr1 FROM rating1 where Mob=? OR email='"+mail+"'");
            
            st.setString(1, str);
          

 


            ResultSet rs = st.executeQuery();

 

            if (rs.next()) {

                String s = rs.getString(1);

                String s1 = rs.getString(2);

                String s2 = rs.getString(3);

                String s3 = rs.getString(4);
              
                String s4 = rs.getString(5);
                String s5 = rs.getString(6);
                String s6 = rs.getString(7);
                String s7 = rs.getString(8);
                
       
                 
               Float skee = Float.parseFloat(s);
               Float ipc = Float.parseFloat(s1);
               Float temp = Float.parseFloat(s2);
               Float arr = Float.parseFloat(s3);
               Float skee1 = Float.parseFloat(s4);
               Float ipc1 = Float.parseFloat(s5);
               Float temp1 = Float.parseFloat(s6);
               Float arr1 = Float.parseFloat(s7);
               
               Float rating1 = (skee+ipc+temp+arr)/4;
               Float rating2 = (skee1+ipc1+temp1+arr1)/4;
               
               String rat1 = Float.toString(rating1);
               String rat2 = Float.toString(rating2);
               
                tf17.setText(rat1);
                tf18.setText(rat2);
                
                
                        
            if (rating1+rating2>=15){
               tf16.setText("Yes"); 
            }
             else if (rating1+rating2<15){
                 tf16.setText("No");  
             } 
                 
            
            
            
            
          

 


           

        
               
                
                
                
                

            } 

 

            //Create Exception Handler

        } catch (Exception ex) {


 

            System.out.println(ex);

        }
    }}
    
   
    public static void main(String args[]) {

       SwingSearchApp s1 =  new SwingSearchApp();
       s1.setSize(500,500);
       s1.setVisible(true);

    }

} 