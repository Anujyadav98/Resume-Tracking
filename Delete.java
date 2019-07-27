import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class Delete extends JFrame implements ActionListener {
    JLabel lb,lb1,lb2,lb3,lb4,lb5,lb6,lb7,lb8,lb9,lb10;
    JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8;
   JButton btn,btn1,btn2;


Delete()
{
    try{
UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

}
         catch(Exception e)
         {}
lb = new JLabel("Enter Mobile No.");

        lb.setBounds(20, 60, 100, 20);

        tf1 = new JTextField(20);

        tf1.setBounds(190, 60, 350, 20);
        
        lb1 = new JLabel("Enter Email ID");

        lb1.setBounds(20, 100, 100, 20);

        tf2 = new JTextField(20);

        tf2.setBounds(190, 100, 350, 20);
        
        lb2 = new JLabel("OR");

        lb2.setBounds(20, 75, 450, 30);

        lb2.setForeground(Color.BLACK);

        lb2.setFont(new Font("Serif", Font.BOLD, 15));
        
        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(500, 500);
        
        setLayout(null);
        btn2 = new JButton("Search");

        btn2.setBounds(20, 135, 100, 30);

        btn2.addActionListener(this);
        lb5 = new JLabel("Name");

        lb5.setBounds(20, 180, 100, 20);

        tf3 = new JTextField(20);

        tf3.setBounds(190,180, 350, 20);
        
        lb6 = new JLabel("Email ID");

        lb6.setBounds(20, 210, 100, 20);

        tf4 = new JTextField(20);

        tf4.setBounds(190,210, 350, 20);
 
        lb7 = new JLabel("Department");

        lb7.setBounds(20, 240, 100, 20);

        tf5 = new JTextField(20);

        tf5.setBounds(190,240, 350, 20);
        
        lb8 = new JLabel("Position Applied For");

        lb8.setBounds(20, 270, 100, 20);

        tf6 = new JTextField(20);

        tf6.setBounds(190,270, 350, 20);
        
        lb9 = new JLabel("Date Of Application");

        lb9.setBounds(20, 300, 100, 20);

        tf7 = new JTextField(20);

        tf7.setBounds(190,300, 350, 20);
        
        lb10 = new JLabel("Location");

        lb10.setBounds(20, 330, 100, 20);

        tf8 = new JTextField(20);

        tf8.setBounds(190,330, 350, 20);
        
        btn = new JButton("Delete");

        btn.setBounds(20, 370, 100, 30);

        btn.addActionListener(this);
        
        lb3 = new JLabel("Delete A Record From Database");

        lb3.setBounds(20, 10, 450, 30);

        lb3.setForeground(Color.red);

        lb3.setFont(new Font("Serif", Font.BOLD, 25));

        btn1 = new JButton("Home");

        btn1.setBounds(130, 370, 100, 30);
 
        btn1.setForeground(Color.BLUE);
        
        btn1.addActionListener(this);
        
       
        
        add(lb);
        add(tf1);
        add(lb1);
        add(tf2);
        add(lb2);
        add(btn);
        add(lb3);
        add(btn1);
        add(btn2);
        add(lb5);
        add(tf3);
        add(lb6);
        add(tf4);
        add(lb7);
        add(tf5);
        add(lb8);
        add(tf6);
        add(lb9);
        add(tf7);
        add(lb10);
        add(tf8);
       
        
        tf3.setEditable(false);
        tf4.setEditable(false);
        tf5.setEditable(false);
        tf6.setEditable(false);
        tf7.setEditable(false);
        tf8.setEditable(false);
       
        
}

 public void actionPerformed(ActionEvent e) {
     
     if(e.getSource()==btn1)
		{
			this.dispose();
			Home h1=new Home();
			h1.setSize(1035,790);
			h1.setVisible(true);
		}
     
     else if (e.getSource()==btn)
              {
        try {

            String str = tf1.getText();
            String mail = tf2.getText();

 

             Class.forName("com.mysql.jdbc.Driver");

           Connection con = DriverManager.getConnection("jdbc:mysql://192.168.1.3/sonoo", "root", "skv@123");
           Statement st=con.createStatement();
           st.executeUpdate("delete from rating1 where Mob='"+str+"' OR email= '"+mail+"'");
           st.executeUpdate("delete from InterviewR where Mob='"+str+"' OR email= '"+mail+"'");
           st.executeUpdate("delete from data1 where Mno='"+str+"' OR email1 = '"+mail+"'");
           

     JOptionPane.showMessageDialog(null,"Record Deleted !");
        
        
        
        
        
        }
        catch (Exception ex) {


 

            System.out.println(ex);

        }
              }
     
      else if (e.getSource()==btn2)
              {
        try {

            String str = tf1.getText();
            String mail = tf2.getText();

 

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
                
                
                tf3.setText(s);
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

        new Delete();

    }

} 

