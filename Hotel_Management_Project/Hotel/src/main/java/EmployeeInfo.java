
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;

import net.proteanit.sql.*;
 
public class EmployeeInfo extends JFrame implements ActionListener{
	
	JTable  table;
	JButton back;
	EmployeeInfo(){
    	getContentPane().setBackground(Color.white);
		setLayout(null);
		
				 
		 JLabel l1=new JLabel("Name");
		 l1.setBounds(40,10,100,20);
		 add(l1);

		 JLabel l2=new JLabel("Age");
		 l2.setBounds(170,10,100,20);
		 add(l2);
		 

		 JLabel l3=new JLabel("Gender");
		 l3.setBounds(290,10,100,20);
		 add(l3);
		 

		 JLabel l4=new JLabel("Job ");
		 l4.setBounds(400,10,100,20);
		 add(l4);

		 JLabel l5=new JLabel("Salary");
		 l5.setBounds(540,10,100,20);
		 add(l5);
		 
		 JLabel l6=new JLabel("Phone ");
		 l6.setBounds(670,10,100,20);
		 add(l6);

		 JLabel l7=new JLabel("Email");
		 l7.setBounds(790,10,100,20);
		 add(l7);
		 
		 JLabel l8=new JLabel("Aadhar");
		 l8.setBounds(910,10,100,20);
		 add(l8);

		 
		 
		 
		 table = new JTable();
		 table.setBounds(0,40,1000,400);
		 add(table);
		 
		 try {
			 Conn c= new Conn();
			 ResultSet rs=c.s.executeQuery("select * from employee");
			 table.setModel(DbUtils.resultSetToTableModel(rs));
			 
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
    	
		 back = new JButton("Back");
		 back.setForeground(Color.white);
		 back.setBackground(Color.black);
		 back.setBounds(420,500,120,30);
		 back.addActionListener(this);
		 add(back);
		 
    	setBounds(300,200,1000,600);
    	setVisible(true);
    	
    	
    }
	
	public static void main(String[] args) {
		new EmployeeInfo();
		
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		setVisible(false);
		new Reception();
		
	}

}
