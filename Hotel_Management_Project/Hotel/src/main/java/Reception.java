import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.*;

public class Reception extends JFrame implements ActionListener{
      
	JButton newCustomer, rooms,department,allEmployee,customer,managerInfo,searchRoom,update;
	Reception(){
		getContentPane().setBackground(Color.white);
		setLayout(null);
		
		
	    newCustomer = new JButton("New Customer From");
		newCustomer.setBounds(10,30,200,30);
		newCustomer.setBackground(Color.BLACK);
		newCustomer.setForeground(Color.white);
		newCustomer.addActionListener(this);
		add(newCustomer);
		
		rooms = new JButton("Rooms");
		rooms.setBounds(10,70,200,30);
		rooms.setBackground(Color.BLACK);
		rooms.setForeground(Color.white);
		rooms.addActionListener(this);
		add(rooms);
		
	    department = new JButton("Department");
		department.setBounds(10,110,200,30);
		department.setBackground(Color.BLACK);
		department.setForeground(Color.white);
		department.addActionListener(this);
		add(department);
		
		allEmployee = new JButton("All Employee");
		allEmployee.setBounds(10,150,200,30);
		allEmployee.setBackground(Color.BLACK);
		allEmployee.setForeground(Color.white);
		allEmployee.addActionListener(this);
		add(allEmployee);
		
		 customer = new JButton("Customer Info");
		customer.setBounds(10,190,200,30);
		customer.setBackground(Color.BLACK);
		customer.setForeground(Color.white);
		customer.addActionListener(this);
		add(customer);
		
		 managerInfo = new JButton("Manager Info");
		managerInfo.setBounds(10,230,200,30);
		managerInfo.setBackground(Color.BLACK);
		managerInfo.setForeground(Color.white);
		managerInfo.addActionListener(this);
		add(managerInfo);
		
		JButton checkout = new JButton("Checkout ");
		checkout.setBounds(10,270,200,30);
		checkout.setBackground(Color.BLACK);
		checkout.setForeground(Color.white);
		add(checkout);
		
	    update = new JButton("Update Status ");
		update.setBounds(10,310,200,30);
		update.setBackground(Color.BLACK);
		update.setForeground(Color.white);
		update.setForeground(Color.white);
		update.addActionListener(this);
		add(update);
		
		JButton roomStatus = new JButton("Update  Room Status ");
		roomStatus.setBounds(10,350,200,30);
		roomStatus.setBackground(Color.BLACK);
		roomStatus.setForeground(Color.white);
		add(roomStatus);

		JButton pickup = new JButton("Pickup service ");
		pickup.setBounds(10,390,200,30);
		pickup.setBackground(Color.BLACK);
		pickup.setForeground(Color.white);
		add(pickup);


		searchRoom = new JButton("Search Room ");
		searchRoom.setBounds(10,430,200,30);
		searchRoom.setBackground(Color.BLACK);
		searchRoom.setForeground(Color.white);
		searchRoom.addActionListener(this);
		add(searchRoom);
		
	
		JButton logout = new JButton("Logout ");
		logout.setBounds(10,470,200,30);
		logout.setBackground(Color.BLACK);
		logout.setForeground(Color.white);
		add(logout);
	
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
		 // Image i2=i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);//compress image size
		 // ImageIcon i3=new ImageIcon(i2);
     	  JLabel image=new JLabel(i1);
		   image.setBounds(250,30,500,470);
		   add(image);

		
		setBounds(350,200,800,570);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Reception();

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== newCustomer) {
			setVisible(false);
			new AddCostomer();
		}else if(e.getSource()== rooms)
			{
			setVisible(false);
		    new Room();
			}
	         else if(e.getSource()==department) {
	    	
	        	 setVisible(false);
	 		    new Department();
	    }else if(e.getSource()==allEmployee) {
	    	
       	 setVisible(false);
		    new EmployeeInfo();
	    }else if(e.getSource()==managerInfo) {
	    	
	       	 setVisible(false);
			    new ManagerInfo();
		 }
	    else if(e.getSource()==customer) {
	    	
	       	 setVisible(false);
			    new CostomerInfo();
		 }
	    else if(e.getSource()==searchRoom) {
	    	
	       	 setVisible(false);
			    new SearchRoom();
	    }
	    else if(e.getSource() == update) {
	    	
	       	 setVisible(false);
			    new UpdateCheck();
	    }

         
	}
}
