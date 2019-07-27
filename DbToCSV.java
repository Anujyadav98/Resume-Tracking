import java.awt.Color;
import java.awt.Font;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.*;
import javax.swing.*;
public class DbToCSV extends JFrame implements ActionListener{
    JButton btn1,btn2;
    JLabel lb1,lb2,lb3,lb4,lb5,lb6;
    JTextField tf1,tf2;
    
    DbToCSV(){
        setTitle("Export");
        btn1 = new JButton("Export Whole Data");

        btn1.setBounds(20,60, 150, 30);

        btn1.addActionListener(this);
        
        btn2 = new JButton("Export");
        
        btn2.setBounds(20,220, 100, 30);

        btn2.addActionListener(this);
        
        
        lb2= new JLabel("Export Month Wise Data");
        
        lb2.setBounds(20, 100, 250, 30);
        
        lb2.setForeground(Color.BLACK);
        
        lb2.setFont(new Font("Serif", Font.BOLD, 20));
        
        lb3= new JLabel("Enter Month");
        
        lb3.setBounds(20, 150, 150, 20);
        
        tf1= new JTextField();
        
        tf1.setBounds(130,150,150,20);
        lb5= new JLabel("Enter Year");
        
        lb5.setBounds(20, 180, 150, 20);
        
        tf2= new JTextField();
        
        tf2.setBounds(130,180,150,20);
        
        lb6 = new JLabel ("YYYY");
        
        lb6.setBounds(290, 180, 200, 20);
        
        lb6.setForeground(Color.LIGHT_GRAY);
                
        lb6.setFont(new Font("Serif", Font.BOLD, 15));
        
        lb1= new JLabel("Export Data");
        
        lb1.setBounds(20, 10, 150, 30);
        
        lb1.setForeground(Color.red);
        
        lb1.setFont(new Font("Serif", Font.BOLD, 25));
        
        lb4 = new JLabel ("MM");
        lb4.setBounds(290, 150, 200, 20);
        lb4.setForeground(Color.LIGHT_GRAY);

        lb4.setFont(new Font("Serif", Font.BOLD, 15));
        
        setLayout(null);
        
        setVisible(true);

       // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(500, 500);
        
        add(btn1);
        add(btn2);
        add(lb1);
        add(lb4);
        
        add(lb2);
        add(lb3);
        add(lb5);
        add(tf1);
        add(tf2);
        add(lb6);
    }
      public void actionPerformed(ActionEvent e) {
      
     if(e.getSource()==btn1){
     
     String filename ="\\\\192.168.1.4\\Common\\Resume Management\\Data.csv";
        try {
            FileWriter fw = new FileWriter(filename);
           
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.1.3:3306/sonoo", "root", "skv@123");
            String query = "SELECT Mno,fname,lname,job,email1,location,dateofapp,Inter1,Int1r,Inter2,Int2r,dat,time,date2,time2,department,skee,ipc,temp,arr,skee1,ipc1,temp1,arr1 FROM data1 t1 INNER JOIN InterviewR t2 INNER JOIN rating1 t3 ON t1.Mno=t2.Mob AND t1.Mno=t3.Mob ORDER BY Mno";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            fw.append("Mobile No.");
            fw.append(',');
            fw.append("First Name");
            fw.append(',');
            fw.append("Last name");
            fw.append(',');
            fw.append("Position ");
            fw.append(',');
            fw.append("Email");
            fw.append(',');
            fw.append("Location");
            fw.append(',');
            fw.append("Date Of Application");
            fw.append(',');
            fw.append("Interviewer 1 Name");
            fw.append(',');
            fw.append("Interviewer 1 Remarks");
            fw.append(',');
            fw.append("Interviewer 2 Name");
            fw.append(',');
            fw.append("Interviewer 2 Remarks");
            fw.append(',');
            fw.append("Date Of Interview 1");
            fw.append(',');
            fw.append("Time Of Interview 1");
            fw.append(',');
            fw.append("Date Of Interview 2");
            fw.append(',');
            fw.append("Time Of Interview 2");
            fw.append(',');
            fw.append("Department");
            fw.append(',');
            fw.append("Skee 1 ");
            fw.append(',');
            fw.append("Ipc 1");
            fw.append(',');
            fw.append("Temperament 1");
            fw.append(',');
            fw.append("Arr 1");
            fw.append(',');
            fw.append("Skee 2");
            fw.append(',');
            fw.append("Ipc 2");
            fw.append(',');
            fw.append("Temperament 2");
            fw.append(',');
            fw.append("Arr 2");
            fw.append('\n');
            
            while (rs.next()) {
                fw.append(rs.getString(1));
                fw.append(',');
                fw.append(rs.getString(2));
                fw.append(',');
                fw.append(rs.getString(3));
                fw.append(',');
                fw.append(rs.getString(4));
                fw.append(',');
                fw.append(rs.getString(5));
                fw.append(',');
                fw.append(rs.getString(6));
                fw.append(',');
                fw.append(rs.getString(7));
                fw.append(',');
                fw.append(rs.getString(8));
                fw.append(',');
                fw.append(rs.getString(9));
                fw.append(',');
                fw.append(rs.getString(10));
                fw.append(',');
                fw.append(rs.getString(11));
                fw.append(',');
                fw.append(rs.getString(12));
                fw.append(',');
                fw.append(rs.getString(13));
                fw.append(',');
                fw.append(rs.getString(14));
                fw.append(',');
                fw.append(rs.getString(15));
                fw.append(',');
                fw.append(rs.getString(16));
                fw.append(',');
                fw.append(rs.getString(17));
                fw.append(',');
                fw.append(rs.getString(18));
                fw.append(',');
                fw.append(rs.getString(19));
                fw.append(',');
                fw.append(rs.getString(20));
                fw.append(',');
                fw.append(rs.getString(21));
                fw.append(',');
                fw.append(rs.getString(22));
                fw.append(',');
                fw.append(rs.getString(23));
                fw.append(',');
                fw.append(rs.getString(24));
                fw.append('\n');
                
               }
            
            fw.flush();
            fw.close();
            conn.close();
            JOptionPane.showMessageDialog(null,"Data Has Been Exported To A CSV File In Resume Management Folder");
            System.out.println("CSV File is created successfully.");
        } catch (Exception ae) {
            ae.printStackTrace();
        }
     
     }
     
     if(e.getSource()==btn2){
     
     String filename ="\\\\192.168.1.4\\Common\\Resume Management\\Data.csv";
        try {
            String str= tf1.getText();
            String str1 = tf2.getText();
            FileWriter fw = new FileWriter(filename);
           
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.1.3:3306/sonoo", "root", "skv@123");
            String query = "SELECT Mno,fname,lname,job,email1,location,dateofapp,Inter1,Int1r,Inter2,Int2r,dat,time,date2,time2,department,skee,ipc,temp,arr,skee1,ipc1,temp1,arr1 FROM data1 t1 INNER JOIN InterviewR t2 INNER JOIN rating1 t3 ON t1.Mno=t2.Mob AND t1.Mno=t3.Mob where Month(dateofapp)='"+str+"' AND YEAR(dateofapp)='"+str1+"'ORDER BY dateofapp DESC ";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            fw.append("Mobile No.");
            fw.append(',');
            fw.append("First Name");
            fw.append(',');
            fw.append("Last name");
            fw.append(',');
            fw.append("Position ");
            fw.append(',');
            fw.append("Email");
            fw.append(',');
            fw.append("Location");
            fw.append(',');
            fw.append("Date Of Application");
            fw.append(',');
            fw.append("Interviewer 1 Name");
            fw.append(',');
            fw.append("Interviewer 1 Remarks");
            fw.append(',');
            fw.append("Interviewer 2 Name");
            fw.append(',');
            fw.append("Interviewer 2 Remarks");
            fw.append(',');
            fw.append("Date Of Interview 1");
            fw.append(',');
            fw.append("Time Of Interview 1");
            fw.append(',');
            fw.append("Date Of Interview 2");
            fw.append(',');
            fw.append("Time Of Interview 2");
            fw.append(',');
            fw.append("Department");
            fw.append(',');
            fw.append("Skee 1 ");
            fw.append(',');
            fw.append("Ipc 1");
            fw.append(',');
            fw.append("Temperament 1");
            fw.append(',');
            fw.append("Arr 1");
            fw.append(',');
            fw.append("Skee 2");
            fw.append(',');
            fw.append("Ipc 2");
            fw.append(',');
            fw.append("Temperament 2");
            fw.append(',');
            fw.append("Arr 2");
            fw.append('\n');
            
            while (rs.next()) {
                fw.append(rs.getString(1));
                fw.append(',');
                fw.append(rs.getString(2));
                fw.append(',');
                fw.append(rs.getString(3));
                fw.append(',');
                fw.append(rs.getString(4));
                fw.append(',');
                fw.append(rs.getString(5));
                fw.append(',');
                fw.append(rs.getString(6));
                fw.append(',');
                fw.append(rs.getString(7));
                fw.append(',');
                fw.append(rs.getString(8));
                fw.append(',');
                fw.append(rs.getString(9));
                fw.append(',');
                fw.append(rs.getString(10));
                fw.append(',');
                fw.append(rs.getString(11));
                fw.append(',');
                fw.append(rs.getString(12));
                fw.append(',');
                fw.append(rs.getString(13));
                fw.append(',');
                fw.append(rs.getString(14));
                fw.append(',');
                fw.append(rs.getString(15));
                fw.append(',');
                fw.append(rs.getString(16));
                fw.append(',');
                fw.append(rs.getString(17));
                fw.append(',');
                fw.append(rs.getString(18));
                fw.append(',');
                fw.append(rs.getString(19));
                fw.append(',');
                fw.append(rs.getString(20));
                fw.append(',');
                fw.append(rs.getString(21));
                fw.append(',');
                fw.append(rs.getString(22));
                fw.append(',');
                fw.append(rs.getString(23));
                fw.append(',');
                fw.append(rs.getString(24));
                fw.append('\n');
                
               }
            
            fw.flush();
            fw.close();
            conn.close();
            JOptionPane.showMessageDialog(null,"Data Has Been Exported To A CSV File In Resume Management Folder");
            System.out.println("CSV File is created successfully.");
        } catch (Exception ae) {
            ae.printStackTrace();
        }
     
     }
     
     
     
     
     
     }
         
         
         
    public static void main(String[] args) {
        new DbToCSV();
        
    }

  
}