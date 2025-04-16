import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;


public class AddCostomer extends JFrame implements ActionListener{
    JComboBox comboid;
	JButton Jadd,back;
    JTextField tfnumber,tfname,tfcountry,tfdeposit;
    JRadioButton rmale,rfemale;
    Choice croom;
   
	
	AddCostomer(){
		getContentPane().setBackground(Color.white);
		setLayout(null);
         
		
		 JLabel text=new JLabel("New Customer Form");
		 text.setBounds(100,20,300,30);
		 text.setFont(new Font("Raleway",Font.PLAIN,20));
		 add(text);
		 
		 JLabel lblid=new JLabel("ID");
		 lblid.setBounds(35,80,100,20);
		 lblid.setFont(new Font("Raleway",Font.PLAIN,20));
		 add(lblid);
		 
		 String options[]= {"Aadhae Card","Passport","Driving License","Voter-id Card","Ration Card"};
		 comboid =new JComboBox(options);
		 comboid.setBounds(200,80,150,25);
		 comboid.setBackground(Color.white);
		 add(comboid);
		 
		 JLabel lblnumber=new JLabel("Number");
		 lblnumber.setBounds(35,120,100,20);
		 lblnumber.setFont(new Font("Raleway",Font.PLAIN,20));
		 add(lblnumber);
		
		 tfnumber = new JTextField();
		 tfnumber.setBounds(200,120,150,25);
		 add(tfnumber);
		 
		 JLabel lblname=new JLabel("Name");
		 lblname.setBounds(35,160,100,20);
		 lblname.setFont(new Font("Raleway",Font.PLAIN,20));
		 add(lblname);
		
		 tfname = new JTextField();
		 tfname.setBounds(200,160,150,25);
		 add(tfname);
		 
		 JLabel lblgender=new JLabel("Gender");
		 lblgender.setBounds(35,200,100,20);
		 lblgender.setFont(new Font("Raleway",Font.PLAIN,20));
		 add(lblgender);

		   rmale=new JRadioButton("Male");
		   rmale.setBackground(Color.white);
		   rmale.setBounds(200,200,60,25);
		   add(rmale);
			
			rfemale=new JRadioButton("Female");		
			rfemale.setBackground(Color.white);
			rfemale.setBounds(270,200,100,25);
			add(rfemale);

			 JLabel lblcountry=new JLabel("Country");
			 lblcountry.setBounds(35,240,100,20);
			 lblcountry.setFont(new Font("Raleway",Font.PLAIN,20));
			 add(lblcountry);
			
			 tfcountry = new JTextField();
			 tfcountry.setBounds(200,240,150,25);
			 add(tfcountry);
			 
			 JLabel lblroom=new JLabel("Room Number");
			 lblroom.setBounds(35,280,150,20);
			 lblroom.setFont(new Font("Raleway",Font.PLAIN,20));
			 add(lblroom);
             
			 croom = new Choice();
			 try {
				 Conn conn=new Conn();
				 String quary="select * from room where availability ='Aailable'";
				 ResultSet rs=conn.s.executeQuery(quary);
				 while(rs.next()) {
					 croom.add(rs.getString("roomnumber"));
				 }
				 
			 }catch(Exception e) {
				 e.printStackTrace();
			 }
			 croom.setBounds(200,280,150,25);
			 add(croom);
	 


			 JLabel lbldeposit=new JLabel("Deposit");
			 lbldeposit.setBounds(35,340,100,20);
			 lbldeposit.setFont(new Font("Raleway",Font.PLAIN,20));
			 add(lbldeposit);
			
			 tfdeposit = new JTextField();
			 tfdeposit.setBounds(200,340,150,25);
			 add(tfdeposit);
			 
			    Jadd=new JButton("Add");
			    Jadd.setForeground(Color.white);
			    Jadd.setBackground(Color.black);
			    Jadd.setBounds(50,400,130,30);
			    Jadd.addActionListener(this);
				add(Jadd);
				
			    back=new JButton("Back");
			    back.setForeground(Color.white);
			    back.setBackground(Color.black);
				back.setBounds(260,400,130,30);
				back.addActionListener(this);
				add(back);
				
				 ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
				 Image i2=i1.getImage().getScaledInstance(300, 400, Image.SCALE_DEFAULT);
				 ImageIcon i3=new ImageIcon(i2);
			     JLabel image=new JLabel(i3);
				 image.setBounds(400,50,300,400);
				 add(image);

		 
		setBounds(350,200,800,550);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		new AddCostomer();

	}
	@Override
	public void actionPerformed(ActionEvent ea) {
		if(ea.getSource() == Jadd) {
			String id = (String)comboid.getSelectedItem();
			String number = tfnumber.getText();
			String name = tfname.getText();
			String gender=null;
			if(rmale.isSelected()) {
				gender = "Male";
			}else {
				gender = "Female";
			}
			
			String country = tfcountry.getText();
		    String room = croom.getSelectedItem();
		    String deposit = tfdeposit.getText();
		    try {
		    	
				String query="insert into coustomer values('"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+room+"','"+deposit+"')";
				String query2="update room set availability ='Occupide' where roomnumber = '"+room+"'";
				
				Conn conn=new Conn();
				conn.s.executeUpdate(query);
				conn.s.executeUpdate(query2);
				
				JOptionPane.showMessageDialog(null, "New coustomer Added Successfully");
				setVisible(false);
				new Reception();
		    }catch(Exception e) {
		    	e.printStackTrace();
		    }
		}else if(ea.getSource() ==back) {
			setVisible(false);
			new Reception();

		}
		
	}

}
