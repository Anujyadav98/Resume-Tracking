import java.awt.*; // Code for the home page 
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.awt.Image;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
public class Home extends JFrame implements ActionListener
{
	private final JButton upload,search,ulist,Int,Sch,Sum,Lgt,Down,delete;
        JLabel lb,lb2,lb3;
        FileDialog fd;
	Home()
	{
            
            try{
UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

}
         catch(Exception e)
         {}
             lb2 = new JLabel(new ImageIcon("\\\\192.168.1.4\\Common\\Resume Management\\SKV-Logo3.png"));
             lb2.setBounds(0,0,220, 110);
        lb = new JLabel("HOME");
        lb.setBounds(450, 10, 450, 40);
        lb.setForeground(Color.RED);
        lb.setFont(new Font("Serif", Font.BOLD, 50));        
                setTitle("Home");
               

		Container con=getContentPane();
  	        con.setLayout(null);
		upload=new JButton("Add A New Applicant");
		upload.addActionListener(this);
		upload.setBounds(300,150,200,50);
		search=new JButton("Search");
		search.addActionListener(this);
		search.setBounds(550,150,200,50);
                ulist=new JButton("View All Entries");
		ulist.addActionListener(this);
		ulist.setBounds(300,350,200,50);
                 Int=new JButton("Interviewer Remarks");
                 Int.addActionListener(this);
                Int.setBounds(550,350,200,50);
                Sch=new JButton("Schedule An Interview");
                Sch.addActionListener(this);
                Sch.setBounds(300,250,200,50);
                Sum=new JButton("Summary");
                Sum.addActionListener(this);
                Sum.setBounds(550,450,200,50);
                Lgt=new JButton("Log Out");
                Lgt.addActionListener(this);
                Lgt.setBounds(850,600,120,25);
                Down=new JButton("Open A Resume");
                Down.addActionListener(this);
                Down.setBounds(550,250,200,50);
                delete=new JButton("Delete A Record");
                delete.addActionListener(this);
                delete.setBounds(300,450,200,50);
               

      

              
		con.add(upload);
		con.add(search);
                con.add(ulist);
                con.add(Int);
                con.add(Sch);
                con.add(Sum);
                con.add(Lgt);
                con.add(Down);
                con.add(delete);
                con.add(lb);
                con.add(lb2);
                
                        
              
	}
       
        public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==upload)
		{
			this.dispose();
			Form fr= new Form();
			fr.setSize(1000,800);
			fr.setVisible(true);
                   
		}

		if(ae.getSource()==search)
		{
			this.dispose();
			SwingSearchApp bp=new SwingSearchApp();
			bp.setSize(1035,790);
			bp.setVisible(true);
                        
		}
                if(ae.getSource()==ulist)
		{
			this.dispose();
			UserList uli=new UserList();
			uli.setSize(1400,750);
			uli.setVisible(true);
		}
                if(ae.getSource()==Int)
		{
			this.dispose();
			Interview In=new Interview();
			In.setSize(1200,750);
			In.setVisible(true);

		}
                if(ae.getSource()==Lgt)
		{
			this.dispose();
			Log Lg=new Log();
			Lg.setSize(400,400);
			Lg.setVisible(true);

		}
                if(ae.getSource()==Sch)
		{
			this.dispose();
			Schedule bp1=new Schedule();
			bp1.setSize(1035,790);
			bp1.setVisible(true);

        }
                if(ae.getSource()==Down)
		{
			this.dispose();
			DBToPDF bp2=new DBToPDF();
			bp2.setSize(1035,790);
			bp2.setVisible(true);

        }
                 if(ae.getSource()==delete)
		{
			this.dispose();
			Delete dl=new Delete();
			dl.setSize(1035,790);
			dl.setVisible(true);
        }
                if(ae.getSource()==Sum)
		{
			this.dispose();
			Summary bp3=new Summary();
			bp3.setSize(1035,790);
			bp3.setVisible(true);
        }
          }
	
	public static void main(String args[])
	{
		Home h=new Home();
		h.setSize(1035,990);
		h.setVisible(true);
	}
}