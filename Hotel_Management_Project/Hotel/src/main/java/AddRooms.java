
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class AddRooms extends JFrame implements ActionListener{
	
	JButton add,cancel;
	JTextField tfroom,tfprice;
	JComboBox Typecombo,availablecombo,cleancombo;
	AddRooms(){
		getContentPane().setBackground(Color.white);
		setLayout(null);
		
		JLabel heading = new JLabel("Add Rooms");
		heading.setFont(new Font("Tahoma",Font.BOLD,18));
		heading.setBounds(150,20,200,30);
		add(heading);
		
		JLabel lblroomno = new JLabel(" Room number");
		lblroomno.setFont(new Font("Tahoma",Font.PLAIN,18));
		lblroomno.setBounds(60,80,120,20);
		add(lblroomno);
		
		
		tfroom=new JTextField();
		tfroom .setBounds(200,80,150,30);
		add(tfroom);
		
		JLabel lblavailable = new JLabel(" Available");
		lblavailable.setFont(new Font("Tahoma",Font.PLAIN,18));
		lblavailable.setBounds(60,130,120,20);
		add(lblavailable);
		
		String availableOptions[]= {"Aailable","Occupied"};
	    availablecombo = new JComboBox(availableOptions);
		availablecombo.setBounds(200,130,150,30);
		availablecombo.setBackground(Color.white);
		add(availablecombo);
		
		
		JLabel lblclean = new JLabel(" Cleaning Status");
		lblclean.setFont(new Font("Tahoma",Font.PLAIN,18));
		lblclean.setBounds(60,180,1250,20);
		add(lblclean);
		
		String cleanOptions[]= {"clean","Dirty"};
	    cleancombo = new JComboBox(cleanOptions);
		cleancombo.setBounds(200,180,150,30);
		cleancombo.setBackground(Color.white);
		add(cleancombo);
		
		JLabel lblprice = new JLabel(" price");
		lblprice.setFont(new Font("Tahoma",Font.PLAIN,18));
		lblprice.setBounds(60,230,120,20);
		add(lblprice);
		
		
	    tfprice=new JTextField();
		tfprice .setBounds(200,230,150,30);
		add(tfprice);
		
		JLabel lbltype = new JLabel(" Bed type");
		lbltype.setFont(new Font("Tahoma",Font.PLAIN,18));
		lbltype.setBounds(60,280,120,20);
		add(lbltype);

		
		String TypeOptions[]= {"Single Bed","Duble Bed"};
		Typecombo = new JComboBox(TypeOptions);
		Typecombo.setBounds(200,280,150,30);
		Typecombo.setBackground(Color.white);
		add(Typecombo);
		
		add=new JButton("Add Room");
		add.setForeground(Color.white);
		add.setBackground(Color.black);
		add.setBounds(60,350,130,30);
		add.addActionListener(this);
		add(add);
		
	   cancel=new JButton("Cancel");
		cancel.setForeground(Color.white);
		cancel.setBackground(Color.black);
		cancel.setBounds(220,350,130,30);
		cancel.addActionListener(this);
		add(cancel);
		
		  ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
		  JLabel image=new JLabel(i1);
		   image.setBounds(400,30,500,300);
		   add(image);

		
		setBounds(330,200,940,470);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new AddRooms();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == add) {
			String roomnumber = tfroom.getText();
			String availability = (String)availablecombo.getSelectedItem();
			String status=(String)cleancombo.getSelectedItem();
			String price=tfprice.getText();
			String type=(String)Typecombo.getSelectedItem();
			
			try {
				Conn conn=new Conn();
				String str="insert into room values('"+roomnumber+"','"+availability+"','"+status+"','"+price+"','"+type+"')";
				conn.s.executeUpdate(str);
				
				JOptionPane.showMessageDialog(null, "new Room Added Successfully");
				setVisible(false);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else {
			setVisible(false);
		}
	}
}
