import java.awt.Color;
import java.awt.Font;
import java.io.OutputStream; // code to extract pdf file from sql database 
import java.sql.Blob; 
import java.sql.Connection; 
import java.io.*; 
import java.io.InputStream; 
import java.sql.DriverManager; 
import java.sql.ResultSet; 
import java.sql.Statement; 
import java.sql.*; 
import javax.swing.*;
import java.awt.event.*;
import java.awt.Desktop;
public class DBToPDF extends JFrame implements ActionListener { 
     
    JLabel lb,lb1,lb2,lb3,lb5,lb6,lb7,lb8,lb9,lb10,lb11;
    JButton btn1,btn2,btn3;
    JTextField tf1,tf3,tf4,tf5,tf6,tf7,tf8,tf9;
    Connection connection; 
    Statement statement; 
    ResultSet rs; 
    PreparedStatement pst; 
    Blob blob; 
    InputStream in; 
    InputStream input; 
    OutputStream output; 

    DBToPDF() { 
         
        
        setTitle("Open Resume ");
        
        lb = new JLabel("Open A Resume");

        lb.setBounds(20, 10, 450, 30);

        lb.setForeground(Color.red);

        lb.setFont(new Font("Serif", Font.BOLD, 25));
        
        lb1 = new JLabel("Enter Mobile No.");

        lb1.setBounds(20, 50, 100, 20);

        tf1 = new JTextField(20);

        tf1.setBounds(150, 50, 200, 20);
                     
        lb3 = new JLabel("Enter Email ID");
        
        lb3.setBounds(20,100,100,20);
        
        tf3 = new JTextField();
        
        tf3.setBounds(150,100,200,20);
        
        btn1 = new JButton("Open Resume");
        
        btn1.setBounds(20,360,150,30);
       
        btn1.addActionListener(this);
        
        btn2 = new JButton("Home");
        
        btn2.setBounds(180,360,100,30);
        
        btn2.addActionListener(this);
        
        btn2.setForeground(Color.BLUE);
         btn3 = new JButton("Search");
        
        btn3.setBounds(20,130,100,25);
        
        btn3.addActionListener(this);
                     
        lb5 = new JLabel("OR");

        lb5.setBounds(20, 70, 450, 30);

        lb5.setForeground(Color.BLACK);

        lb5.setFont(new Font("Serif", Font.BOLD, 15));
        
        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(500, 500);
        
        setLayout(null);
        
        lb11 = new JLabel("Name");

        lb11.setBounds(20, 170, 100, 20);

        tf9 = new JTextField(20);

        tf9.setBounds(190,170, 350, 20);
        
        lb6 = new JLabel("Email ID");

        lb6.setBounds(20, 200, 100, 20);

        tf4 = new JTextField(20);

        tf4.setBounds(190,200, 350, 20);
 
        lb7 = new JLabel("Department");

        lb7.setBounds(20, 230, 100, 20);

        tf5 = new JTextField(20);

        tf5.setBounds(190,230, 350, 20);
        
        lb8 = new JLabel("Position Applied For");

        lb8.setBounds(20, 260, 100, 20);

        tf6 = new JTextField(20);

        tf6.setBounds(190,260, 350, 20);
        
        lb9 = new JLabel("Date Of Application");

        lb9.setBounds(20, 290, 100, 20);

        tf7 = new JTextField(20);

        tf7.setBounds(190,290, 350, 20);
        
        lb10 = new JLabel("Location");

        lb10.setBounds(20, 320, 100, 20);

        tf8 = new JTextField(20);

        tf8.setBounds(190,320, 350, 20);
        
       
        add(lb1);
        add(tf1);
        add(btn1);
        add(btn2);
        add(lb);
        add(lb3);
        add(tf3);
        add(lb5);
        add(lb6);
        add(lb7);
        add(lb8);
        add(lb9);
        add(lb10);
        add(lb11);
        add(tf4);
        add(tf5);
        add(tf6);
        add(tf7);
        add(tf8);
        add(tf9);
        add(btn3);
        
        
        tf9.setEditable(false);
        tf4.setEditable(false);
        tf5.setEditable(false);
        tf6.setEditable(false);
        tf7.setEditable(false);
        tf8.setEditable(false);
        
    
        
        
        
        
        
        
        
        
        // database connectivity 
        try { 
             
            Class.forName("com.mysql.jdbc.Driver"); 
            connection = DriverManager.getConnection("jdbc:mysql://192.168.1.3/sonoo", "root", "skv@123"); 
         
        } catch (ClassNotFoundException cnf) { 
            cnf.printStackTrace(); 
        } catch (java.sql.SQLException sql) { 
            sql.printStackTrace(); 
        } 
    }  
    
 public void actionPerformed(ActionEvent e) {
        
         String val1 = tf1.getText();
       
         String val3 = tf3.getText();
         
         if(e.getSource()==btn2){
                        this.dispose();
			Home bp=new Home();
			bp.setSize(1035,790);
			bp.setVisible(true);
         }
   else if(e.getSource()==btn1)
    {
        try { 
             
            statement = connection.createStatement(); 
             
            //query to fetch file from database 
            rs = statement.executeQuery("Select pdf_file from data1 where Mno='"+val1+"' OR email1='"+val3+"'"); 
            in = null; 
            while (rs.next()) { 
                in = rs.getBinaryStream(1); 
            } 

            int available1 = in.available(); 
            byte[] bt = new byte[available1]; 
            in.read(bt); 

            // new pdf file to store extracted data 
            FileOutputStream fout = new FileOutputStream("\\\\192.168.1.4\\Common\\Resume Management\\Resume.pdf"); 
            DataOutputStream dout = new DataOutputStream(fout); 
            dout.write(bt, 0, bt.length); 
            fout.close(); 
            if (Desktop.isDesktopSupported()) {
    try {
        File myFile = new File("\\\\192.168.1.4\\Common\\Resume Management\\Resume.pdf");
        Desktop.getDesktop().open(myFile);
    } catch (IOException ex) {
        // no application registered for PDFs
    }
}
          //  JOptionPane.showMessageDialog(null,"Resume Is Now Saved On The Common Folder Of Local Server");
             
        } catch (Exception ae) { 
            System.out.println(ae); 
        } 
        
    }
         else if (e.getSource()==btn3)
              {
        try {

            String str = tf1.getText();
            String mail = tf3.getText();

 

             Class.forName("com.mysql.jdbc.Driver");

           Connection con = DriverManager.getConnection("jdbc:mysql://192.168.1.3/sonoo", "root", "skv@123");
            PreparedStatement st = con.prepareStatement("select * from data1 where Mno=? OR email1='"+mail+"'");

            st.setString(1, str);

 

            //Excuting Query

            ResultSet rs = st.executeQuery();

 

            if (rs.next()) {

                String s = rs.getString(2);

                String s1 = rs.getString(4);

                String s2 = rs.getString(6);

                String s3 = rs.getString(7);
                String s4 = rs.getString(8);
                String s5 = rs.getString(9);
                
                
                tf9.setText(s);
                tf4.setText(s2);
                tf5.setText(s5);
                tf6.setText(s1);
                tf7.setText(s4);
                tf8.setText(s3);
                
           
            }      
          
         else {

                JOptionPane.showMessageDialog(null,"Not Found","Error",JOptionPane.ERROR_MESSAGE);

            }
        
        
        }
        
        
        catch (Exception ex) {


 

            System.out.println(ex);

                }
 }
 }

 
 
    public static void main(String args[]) { 
         
         
        new DBToPDF(); 
         
        
    } 

   
}