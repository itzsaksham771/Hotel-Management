import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class Dashbord extends JFrame implements ActionListener {
  
	
	Dashbord(){
		setBounds(0,0,1510,1000);
		setLayout(null);
		   ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
		   Image i2=i1.getImage().getScaledInstance(1550, 1000, Image.SCALE_DEFAULT);
		   ImageIcon i3=new ImageIcon(i2);
		   JLabel image=new JLabel(i3);
		   image.setBounds(0,0,1550,1000);
		   add(image);
		   
		   JLabel text=new JLabel("THE TAJ GROUP WELCOME YOU");
		   text.setBounds(400,80,1000,50);
		   text.setFont(new Font("Tahoma",Font.PLAIN,46));
		   text.setForeground(Color.white);
		    image.add(text);
		    
		    JMenuBar mb=new JMenuBar();
		    mb.setBounds(0,0,1550,30);
		    image.add(mb); 
		    
		    JMenu hotel=new JMenu("HOTEL MANAGEMENT");
		    hotel.setForeground(Color.red);
		    mb.add(hotel);
		    JMenuItem reception = new JMenuItem("RECEPTION");
		    reception.addActionListener(this);
		    hotel.add(reception);
		    
		    JMenu admin=new JMenu("ADMIN");
		    admin.setForeground(Color.blue);
		    mb.add(admin);
		    
		    JMenuItem addemployee = new JMenuItem("ADD EMPLOYEE");
		    addemployee.addActionListener(this);
		    admin.add(addemployee);
		    
		    JMenuItem addrooms = new JMenuItem("ADD ROOMS");
		    addrooms.addActionListener(this);
		    admin.add(addrooms);
		    
		    JMenuItem adddriver = new JMenuItem("ADD DRIVER");
		    adddriver.addActionListener(this);
		    admin.add(adddriver);
		    
      		setVisible(true);
	}
	public static void main(String[] args) {
		new Dashbord();
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("ADD EMPLOYEE")) {
			new AddEmployee();
		}else if(e.getActionCommand().equals("ADD ROOMS")) {
			new AddRooms();
		}else if(e.getActionCommand().equals("ADD DRIVER")) {
			new AddDriver();
		}else if(e.getActionCommand().equals("RECEPTION")) {
			new Reception();
		}
		
	}
}
