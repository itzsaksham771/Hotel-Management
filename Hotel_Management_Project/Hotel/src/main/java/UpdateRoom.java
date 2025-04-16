
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;


import javax.swing.*;

import com.mysql.*;
import com.mysql.cj.protocol.Resultset;

public class UpdateRoom extends JFrame implements ActionListener {
    Choice ccustomer;
    JButton check,update,back;
    JTextField tfroom,tfavaliblity,tfpaid,tfpending,tfStatus;
    UpdateRoom(){
		  getContentPane().setBackground(Color.white);
		  setLayout(null);
		 
		  JLabel text=new JLabel("Update Room Status");
		  text.setFont(new Font("Tahoma",Font.PLAIN,25));
		  text.setBounds(30,20,250,30);
		  text.setForeground(Color.blue);
		  add(text);
		  
		  JLabel lblid=new JLabel("Customer Id");
		  lblid.setBounds(30,80,100,20);
		  add(lblid);
		  
		  ccustomer=new Choice();
		  ccustomer.setBounds(200,80,150,25);
		  add(ccustomer);
		  
		  try {
			  Conn c= new Conn();
				 ResultSet rs=c.s.executeQuery("select * from coustomer");
			  while(rs.next()) {
				  ccustomer.add(rs.getString("number"));
			  }
			  
		  }catch(Exception e){
			  e.printStackTrace();
		  }		
		  
		  JLabel lblroom=new JLabel("Room Number");
		  lblroom.setBounds(30,120,100,20);
		  add(lblroom);
		  
		  tfroom = new JTextField();
		  tfroom.setBounds(200,120,100,25);
		  add(tfroom);
		 
		  
		  JLabel lblname=new JLabel("Avaliblity");
		  lblname.setBounds(30,160,100,20);
		  add(lblname);
		  
		  tfavaliblity = new JTextField();
		  tfavaliblity.setBounds(200,160,150,25);
		  add(tfavaliblity);
		  
		  
		  JLabel lblcheckin=new JLabel("Cleaning Status");
		  lblcheckin.setBounds(30,200,100,20);
		  add(lblcheckin);
		  
		  tfStatus = new JTextField();
		  tfStatus.setBounds(200,160,150,25);
		  add(tfStatus);
		 
		  
		  
		  		 
		  check = new JButton("Check");
		  check.setBackground(Color.black);
		  check.setForeground(Color.white);
		  check.setBounds(30,300,100,30);
		  check.addActionListener(this);
		  add(check);
		  
		  update = new JButton("Update");
		  update.setBackground(Color.black);
		  update.setForeground(Color.white);
		  update.setBounds(150,300,100,30);
		  update.addActionListener(this);
		  add(update);
		  
		  back = new JButton("back");
		  back.setBackground(Color.black);
		  back.setForeground(Color.white);
		  back.setBounds(270,300,100,30);
		  back.addActionListener(this);
		  add(back);
		  
		  ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/seventh.jpg"));
		  Image i2=i1.getImage().getScaledInstance(500, 300,Image.SCALE_DEFAULT);
		  ImageIcon i3=new ImageIcon(i2);
		  JLabel image=new JLabel(i3);
		  image.setBounds(400,50,500,300);
		  add(image);

		  
		setBounds(330,200,940,470);
		setVisible(true);
		
		
	}	
	public static void main(String[] args) {
		new UpdateRoom();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==check) {
			String id=ccustomer.getSelectedItem();
			String query="select * from coustomer where number='"+id+"'";
			try {
				Conn c=new Conn();
				 ResultSet rs=c.s.executeQuery(query);
				 while(rs.next()) {
					 tfroom.setText(rs.getString("room"));
					 
				 }
				 
			ResultSet rs2 = c.s.executeQuery("select*from room where room number ='"+tfroom.getText()"')	 
				 while(rs.next()) {
					 tfavailable.setText(rs.getString("available"))
				 }
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		}else if(e.getSource()==update) {
			String  number=ccustomer.getSelectedItem();
			String room = tfroom.getText();
			String name = tfroom.getText();
			String deposit=tfpaid.getText();
			try {
				Conn c=new Conn();
				c.s.executeUpdate("Update coustomer set room='"+room+"',name='"+name+"'");
				
				setVisible(false);
				new Reception();
				JOptionPane.showMessageDialog(null, "Data Updatad Successfully");
			}catch(Exception eq) {
				eq.printStackTrace();
			}
			
			
		}else {
			setVisible(false);
			new Reception();

		}
		
	}
}
