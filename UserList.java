    import javax.swing.*; // This code retrieves the data from database into a JTABLE
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
public class UserList extends JFrame implements ActionListener{
    DefaultTableModel model = new DefaultTableModel();
    //TableColumnModel mode2 = new TableColumnModel();
   Container cnt = this.getContentPane();
    JPanel panel = new JPanel();
    JCheckBox b1 = new JCheckBox("Select");
    JTextField tf1 = new JTextField();
    JTable jtbl = new JTable(model);
    JButton btn1= new JButton("Home");
   // JButton btn2= new JButton("Filter records");
    JFrame f = new JFrame();
    
        public UserList() {
            setTitle("All Entries");
            
     
        cnt.setBounds(100,2,600,500);
   
        model.addColumn("Mobile NO.");
        model.addColumn("First Name");
        model.addColumn("Last Name");
        model.addColumn("Job Applied for");
        model.addColumn("Department");
        model.addColumn("Email");
        model.addColumn("Interviewer 1 Name");
        model.addColumn("Interviewer 1 Remarks");
        model.addColumn("Interviewer 2 Name");
        model.addColumn("Interviewer 2 Remarks");
        
        cnt.add(btn1);
     //   cnt.add(btn2);
        jtbl.setBounds(50,20,600,900);
        btn1.addActionListener(this);
        btn1.setForeground(Color.BLUE);
        
        btn1.setBounds(40,650,80,40);


                try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://192.168.1.3/sonoo", "root", "skv@123");
            PreparedStatement pstm = con.prepareStatement("SELECT Mno,fname,lname,job,department,email,Inter1,Int1r,Inter2,Int2r FROM data1 t1 INNER JOIN InterviewR t2 ON t1.Mno=t2.Mob ORDER BY fname");
            ResultSet Rs = pstm.executeQuery();          

            
            
            while(Rs.next()){
                model.addRow(new Object[]{Rs.getString(1), Rs.getString(2),Rs.getString(3),Rs.getString(4), Rs.getString(5),Rs.getString(6),Rs.getString(7),Rs.getString(8),Rs.getString(9),Rs.getString(10)});
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        JScrollPane pg = new JScrollPane(jtbl);
        cnt.add(pg);
        
        this.pack();
    }
        
public void actionPerformed(ActionEvent ae) {

      if(ae.getSource()==btn1)
		{
			this.dispose();
			Home hn=new Home();
			hn.setSize(1035,790);
			hn.setVisible(true);
		}
}
public static void main(String[] args) {
        JFrame frame = new UserList();
        frame.setTitle("All Entries");
        frame.setSize(1400, 750);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
