
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;

import net.proteanit.sql.*;
 
public class SearchRoom extends JFrame implements ActionListener{
	JComboBox bedType;
	JTable  table;
	JButton back,submit;
	JCheckBox available; 
	SearchRoom(){
    	getContentPane().setBackground(Color.white);
		setLayout(null);
		
		JLabel text=new JLabel("Search for Room");
		text.setFont(new Font("Tahoma",Font.PLAIN,20));
		text.setBounds(400,30,200,20);
		add(text);
		
		JLabel lblbed=new JLabel("Bed Type");
		lblbed.setBounds(50,100,100,20);
		add(lblbed);
		
		bedType = new JComboBox(new String[] {"Single Bed","Double Bed"});
		bedType.setBounds(150,100,150,25);
		bedType.setBackground(Color.white);
		add(bedType);
		
		available =new JCheckBox("Only display Available");
		available.setBounds(650,100,150,25);
		available.setBackground(Color.white);
		add(available);
		
		 JLabel l1=new JLabel("Room number");
		 l1.setBounds(50,160,100,20);
		 add(l1);

		 JLabel l2=new JLabel("Availibility");
		 l2.setBounds(270,160,100,20);
		 add(l2);
		 

		 JLabel l3=new JLabel("Status");
		 l3.setBounds(450,160,100,20);
		 add(l3);
		 

		 JLabel l4=new JLabel("Price ");
		 l4.setBounds(670,160,100,20);
		 add(l4);

		 JLabel l5=new JLabel("Bed Type");
		 l5.setBounds(870,160,100,20);
		 add(l5);
		 
		 
		 table = new JTable();
		 table.setBounds(0,200,1000,300);
		 add(table);
		 
		 try {
			 Conn c= new Conn();
			 ResultSet rs=c.s.executeQuery("select * from room");
			 table.setModel(DbUtils.resultSetToTableModel(rs));
			 
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		 
		 submit = new JButton("Submit");
		 submit.setForeground(Color.white);
		 submit.setBackground(Color.black);
		 submit.setBounds(300,520,120,30);
		 submit.addActionListener(this);
		 add(submit);

    	
		 back = new JButton("Back");
		 back.setForeground(Color.white);
		 back.setBackground(Color.black);
		 back.setBounds(500,520,120,30);
		 back.addActionListener(this);
		 add(back);
		 
    	setBounds(300,200,1000,600);
    	setVisible(true);
    	
    	
    }
	
	public static void main(String[] args) {
		new SearchRoom();
		
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == submit) {
		try {
			String query1="select * from room where bed_type ='"+bedType.getSelectedIndex()+"'";
			String query2="select * from room where availability ='Aailable'AND '"+bedType.getSelectedIndex()+"'";
		   Conn conn = new Conn();
		   ResultSet rs;
		   
		   if(available.isSelected()) {
			   rs=conn.s.executeQuery(query2);
		   }else {
			   rs=conn.s.executeQuery(query1);
		   }
		   table.setModel(DbUtils.resultSetToTableModel(rs));
		
		}catch(Exception e) {
			e.printStackTrace();
		}
			
		}else {
		setVisible(false);
		new Reception();
		}
	}

}
