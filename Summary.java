import java.io.*; 
import java.sql.*;
import javax.swing.*; 
import java.awt.*;
import java.awt.event.ActionEvent;
import java.math.*;
import java.awt.event.ActionListener;





public class Summary extends JFrame implements ActionListener{
    JLabel lb, lb1, lb2, lb3, lb4,lb5,lb6,lb7;
    JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7;
    JButton btn1,btn2,btn3;
    int rowcount,selectedc,rejectedc,pipelinec;
    float percents,percentr,percentp;
    String str1,str2,str3,str4;


Summary(){
     setTitle("Summary");
     
      lb = new JLabel("Summary");

        lb.setBounds(20, 10, 450, 30);

        lb.setForeground(Color.red);

        lb.setFont(new Font("Serif", Font.BOLD, 25));

        lb1 = new JLabel("Total No. Of Entries Uploaded");

        lb1.setBounds(20, 60, 200, 20);
        
        tf1 = new JTextField();
        tf1.setBounds(290,60,150,20);
        
         lb2 = new JLabel("Total No. Of Selected Candidates");

        lb2.setBounds(20, 100, 250, 20);
        
        tf2 = new JTextField();
        tf2.setBounds(290, 100,150,20);
        
        lb5 = new JLabel("Total No. Of Rejected Candidates");
        
        lb5.setBounds(20, 140, 250, 20);
        
       tf5 = new JTextField();
       tf5.setBounds(290, 140, 150, 20);
       
       lb6 = new JLabel("Total No. Of Candidates In Pipeline");
        
        lb6.setBounds(20, 180, 250, 20);
        
       tf6 = new JTextField();
       tf6.setBounds(290, 180, 150, 20);
       
        
        
        lb3 = new JLabel("% Of Selected Candidates");

        lb3.setBounds(20, 220, 250, 20);
        
         tf3 = new JTextField();
        tf3.setBounds(290,220,150,20);
        
        lb4 = new JLabel("% Of Rejected Candidates");

        lb4.setBounds(20, 260, 250, 20);
        tf4 = new JTextField();
        tf4.setBounds(290,260,150,20);
        
        lb7 = new JLabel("% Of Candidates In Pipeline");

        lb7.setBounds(20, 300, 250, 20);
        tf7 = new JTextField();
        tf7.setBounds(290,300,150,20);
        
        btn1= new JButton("Get Total");
        btn1.setBounds(20, 340, 100, 30);

        btn1.addActionListener(this);
        
        btn2 = new JButton("Home");
        btn2.setBounds(240, 340, 100, 30);
        btn2.setForeground(Color.BLUE);
        
        btn2.addActionListener(this);
        
         btn3= new JButton("Export Data");
        btn3.setBounds(130, 340, 100, 30);

        btn3.addActionListener(this);
     
        
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
        add(btn1);
        add(btn2);
        add(btn3);
        
        
         tf1.setEditable(false);
         tf3.setEditable(false);
         tf4.setEditable(false);
         tf2.setEditable(false);
         tf5.setEditable(false);
         tf6.setEditable(false);
         tf7.setEditable(false);
}

public void actionPerformed(ActionEvent e) {
    
    if (e.getSource()==btn1)
              {
        try {

            

 

             Class.forName("com.mysql.jdbc.Driver");

           Connection con = DriverManager.getConnection("jdbc:mysql://192.168.1.3/sonoo", "root", "skv@123");

            PreparedStatement st = con.prepareStatement("SELECT Mno from data1");
            
            ResultSet rs = st.executeQuery();
            
            while (rs.next()){   
           rowcount = rs.getRow();

        
            }
            String str = Integer.toString(rowcount);
            //System.out.println(rowcount);
           tf1.setText(str);
         
      
      
     
        
           
          
        }
          
            
            catch (Exception ex) {
                
           System.out.println(ex);

        } 
        
        
        try {

            

 

             Class.forName("com.mysql.jdbc.Driver");

           Connection con = DriverManager.getConnection("jdbc:mysql://192.168.1.3/sonoo", "root", "skv@123");

            PreparedStatement st = con.prepareStatement("SELECT Mob from InterviewR where selected1+selected2>=15");
            
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                selectedc = rs.getRow();
                
      str1 = Integer.toString(selectedc);
      
      tf2.setText(str1);
            }
            
      
            
        }
        
        catch (Exception ex) 
        {
                
           System.out.println(ex);

        }
        try {

            

 

             Class.forName("com.mysql.jdbc.Driver");

           Connection con = DriverManager.getConnection("jdbc:mysql://192.168.1.3/sonoo", "root", "skv@123");

            PreparedStatement st = con.prepareStatement("SELECT Mob from InterviewR where selected1+selected2<15");
            
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                rejectedc = rs.getRow();
                
                str2 = Integer.toString(rejectedc);
      
      tf5.setText(str2);
                
      
            } }
            catch (Exception ex) 
        {
                
           System.out.println(ex);

        }
        
        pipelinec = rowcount-selectedc-rejectedc;
        
        str3 = Integer.toString(pipelinec);
      
      tf6.setText(str3);
            
      float result = Float.parseFloat(str1); //selected
     
      float z= rowcount;
      float x= rejectedc;//rejected
      float y= pipelinec;//in pipeline
     
      percents = (result/z)*100;
        
      String str2 = Float.toString(percents);
      
      tf3.setText(str2);
     
      percentr = (x/z)*100 ; 
      
      String str3 = Float.toString(percentr);
      
      tf4.setText(str3);
      
      percentp = (y/z)*100;
      
      String str4 = Float.toString(percentp);
      
      tf7.setText(str4);
      
              }
    
    
    else if(e.getSource()==btn2)
		{
	
                    
                    this.dispose();
			Home h1=new Home();
			h1.setSize(1035,790);
			h1.setVisible(true);
		}
     else if(e.getSource()==btn3)
		{
	
                    
                    
			DbToCSV dtc=new DbToCSV();
                       dtc.setSize(500,500);
			dtc.setVisible(true);
                             
		}

}
         public static void main(String args[]) {

        new Summary();

    }

  
}    

