import javax.swing.*;// code to store data in mysql through swing form
import java.awt.*;
import java.io.*;
import java.awt.event.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
class Form extends JFrame implements ActionListener
{
   // Connection dbConnection = null;
JButton ADD,Browse,Home,Update,Search;
JLabel label,label1,label2,label3,label4,label5,label6,label7,label8,label9,label10,label11;
FileDialog fd;
String filepath="";
final JTextField text1,text2,text3,text4,text5,picture_text,text6,text7,text8,text9;
Form(){
   
 label = new JLabel("Add A New Applicant");

        label.setBounds(20, 10, 450, 30);
        label.setForeground(Color.red);

        label.setFont(new Font("Serif", Font.BOLD, 25));
        
label11 = new JLabel("Mobile No");
label11.setBounds(20,50,200,20);
text9 = new JTextField();
text9.setBounds(160,50,200,20);
Search=new JButton("Search");
Search.setBounds(20,80,100,20);
        
label1 = new JLabel("Mobile No");
label1.setBounds(20,110,200,20);
text1 = new JTextField();
text1.setBounds(160,110,200,20);

label2 = new JLabel("First Name");
label2.setBounds(20,140,200,20);
text2 = new JTextField();
text2.setBounds(160,140,200,20);

label3 = new JLabel("Last Name");
label3.setBounds(20,170,200,20);
text3 = new JTextField();
text3.setBounds(160,170,200,20);

label4 = new JLabel("Position Applied For");
label4.setBounds(20,200,200,20);
text4 = new JTextField();
text4.setBounds(160,200,200,20);

label5 = new JLabel("Email");
label5.setBounds(20,320,200,20);
text5 = new JTextField();
text5.setBounds(160,320,200,20);

label6 = new JLabel("Add Resume");
label6.setBounds(20,350,200,20);

label7 = new JLabel("Location");
label7.setBounds(20,290,200,20);
text6 = new JTextField();
text6.setBounds(160, 290, 200, 20);

label8 = new JLabel("Date Of Application");
label8.setBounds(20,260,200,20);
text7 = new JTextField();
text7.setBounds(160, 260, 200, 20);

label10 = new JLabel("YYYY-MM-DD");

label10.setBounds(370, 260, 450, 20);
label10.setForeground(Color.LIGHT_GRAY);
label10.setFont(new Font("Serif", Font.BOLD, 15));

label9 = new JLabel("Department");
label9.setBounds(20,230,200,20);
text8 = new JTextField();
text8.setBounds(160, 230, 200, 20);



picture_text=new JTextField();
picture_text.setBounds(160,350,200,20);		

Home=new JButton("Home");
Home.setBounds(340,390,100,30);
Update=new JButton("Update Record");
Update.setBounds(180,390,150,30);
ADD=new JButton("Add Applicant");
ADD.setBounds(20,390,150,30);
Browse=new JButton("Browse Resume");
Browse.setBounds(380,350,160,20);
 setVisible(true);

 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

// setSize(50, 50);
 setLayout(null);
 
add(label);
add(label1);
add(label2);
add(label3);
add(label4);
add(label5);
add(label6);
add(label7);
add(label8);
add(label9);
add(label10);
add(label11);
add(text1);
add(text2);
add(text3);
add(text4);
add(text5);
add(text6);
add(text7);
add(text8);
add(text9);
add(picture_text);
add(Browse);
add(Home);
add(ADD);
add(Update);
add(Search);


fd=new FileDialog(new JFrame());

setTitle("Upload New");
ADD.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent ae){
    
    

String value1=text1.getText();
String value2=text2.getText();
String value3=text3.getText();
String value4=text4.getText();
String value5=text5.getText();
String value6 = text6.getText();
String value7 = text7.getText();
String value8 = text8.getText();
// code to upload pdf file 
File pdfFile = new File(filepath);
byte[] pdfData = new byte[(int) pdfFile.length()];
DataInputStream dis = null;
    
    try {
        dis = new DataInputStream(new FileInputStream(pdfFile));
    } catch (FileNotFoundException ex) {
        Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    
    try {
        dis.readFully(pdfData);
    } catch (IOException ex) {
        Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
    }
   

try{
Class.forName("com.mysql.jdbc.Driver").newInstance();
        Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.1.3/sonoo", "root", "skv@123" );
      PreparedStatement ps = conn.prepareStatement(
        "INSERT INTO data1(Mno,fname,lname,job,pdf_file,email1,location,dateofapp,department)"+ " VALUES (?,?,?,?,?,?,?,?,?)");
         
      ps.setString(1, value1);
      ps.setString(2, value2);
      ps.setString(3, value3);
      ps.setString(4, value4);
      ps.setBytes(5, pdfData);
      ps.setString(6, value5); 
      ps.setString(7, value6);
      ps.setString(8, value7);
      ps.setString(9, value8);
        ps.executeUpdate(); 
        
        
        Statement st=conn.createStatement();

           st.executeUpdate("insert into InterviewR(Mob,email) values('"+value1+"','"+value5+"')");
           
            Statement st2=conn.createStatement();

           st2.executeUpdate("insert into rating1(Mob,email) values('"+value1+"','"+value5+"')");
            JOptionPane.showMessageDialog(null,"Applicant Added!");
            
           
        }
catch(Exception e){}
}
});
Browse.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent ae){
    fd.setVisible(true);
			filepath=fd.getDirectory()+fd.getFile();
			picture_text.setText(filepath);
                         fd.setSize(50, 50);
}
});

Home.addActionListener(this);
Home.setForeground(Color.BLUE);
Home.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent ae){
    Home h1 = new Home();
    h1.setSize(1000,1000);
    h1.setVisible(true);
    dispose();
}});

Search.addActionListener(this);
Search.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent ae){
    String str = text9.getText();

        try{
Class.forName("com.mysql.jdbc.Driver");
Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.1.3/sonoo", "root", "skv@123" );
PreparedStatement st = conn.prepareStatement("select * from data1 where Mno='"+str+"'");
ResultSet rs = st.executeQuery();
         if (rs.next()) {

                
                String s1 = rs.getString(1);

                String s2 = rs.getString(2);

                String s3 = rs.getString(3);
               String s4 = rs.getString(4);
               // String s5 = rs.getString(5);
                String s6 = rs.getString(6);
                String s7 = rs.getString(7);
                String s8 = rs.getString(8);
                String s9 = rs.getString(9);
                
               text1.setText(s1);
               text2.setText(s2);
               text3.setText(s3);
               text4.setText(s4);
               text5.setText(s6);
               text6.setText(s7);
               text7.setText(s8);
               text8.setText(s9);
               
        
        }else {
                        JOptionPane.showMessageDialog(null,"Not Found","Error",JOptionPane.ERROR_MESSAGE);
                        }
                     
                  
                 }
     
 catch(Exception xe){}
}});

Update.addActionListener(this);
Update.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent ae){
    
    

String value1=text7.getText();

File pdfFile = new File(filepath);
byte[] pdfData = new byte[(int) pdfFile.length()];
DataInputStream dis = null;
    
    try {
        dis = new DataInputStream(new FileInputStream(pdfFile));
    } catch (FileNotFoundException ex) {
        Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    
    try {
        dis.readFully(pdfData);
    } catch (IOException ex) {
        Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
    }
   

try{
    String str = text9.getText();

Class.forName("com.mysql.jdbc.Driver").newInstance();
        Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.1.3/sonoo", "root", "skv@123" );
     PreparedStatement ps = conn.prepareStatement(
        "UPDATE data1 SET pdf_file = ?,dateofapp =? WHERE Mno=?");
         
   
       ps.setBytes(1, pdfData);
           ps.setString(2, value1);
           ps.setString(3, str);
      
      int row = ps.executeUpdate();
      
      JOptionPane.showMessageDialog(null,"Record Updated!");
      
      
          
    
    

    



}
  catch(Exception xe){}


       




















}});

    
}

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

class FormDemo extends Form
{
public static void main(String arg[])
{
try
{
Form frame=new Form();
frame.setSize(500,500);
frame.setVisible(true);
}
catch(Exception e)
{
}
}
}