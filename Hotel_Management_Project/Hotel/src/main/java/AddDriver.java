

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class AddDriver extends JFrame implements ActionListener{
	
	JButton add,cancel;
	JTextField tfname,tfage,tfcompany,tfmodel,tflocation;
	JComboBox Typecombo,availablecombo,cleancombo,agecombo,gendercombo;
	AddDriver(){
		getContentPane().setBackground(Color.white);
		setLayout(null);
		
		JLabel heading = new JLabel("Add Drivers");
		heading.setFont(new Font("Tahoma",Font.BOLD,18));
		heading.setBounds(150,10,200,30);
		add(heading);
		
		JLabel lblroomno = new JLabel(" Name");
		lblroomno.setFont(new Font("Tahoma",Font.PLAIN,18));
		lblroomno.setBounds(60,50,120,20);
		add(lblroomno);
		
		
		tfname=new JTextField();
		tfname .setBounds(200,50,150,30);
		add(tfname);
		
		JLabel lblage = new JLabel(" Age");
		lblage.setFont(new Font("Tahoma",Font.PLAIN,18));
		lblage.setBounds(60,90,120,30);
		add(lblage);
		
		tfage=new JTextField();
		tfage .setBounds(200,90,150,30);
		add(tfage);		
		
		JLabel lblclean = new JLabel("Gender");
		lblclean.setFont(new Font("Tahoma",Font.PLAIN,18));
		lblclean.setBounds(60,130,150,30);
		add(lblclean);
		
		String cleanOptions[]= {"Male","Female"};
	    gendercombo = new JComboBox(cleanOptions);
	    gendercombo.setBounds(200,130,150,30);
	    gendercombo.setBackground(Color.white);
		add(gendercombo);
		
		JLabel lblprice = new JLabel(" Car company");
		lblprice.setFont(new Font("Tahoma",Font.PLAIN,18));
		lblprice.setBounds(60,170,120,30);
		add(lblprice);
		
		
	    tfcompany=new JTextField();
	    tfcompany .setBounds(200,170,150,30);
		add(tfcompany);
		
		JLabel lbltype = new JLabel("Car Model");
		lbltype.setFont(new Font("Tahoma",Font.PLAIN,18));
		lbltype.setBounds(60,210,120,20);
		add(lbltype);

		
		tfmodel=new JTextField();
		tfmodel .setBounds(200,210,150,30);
		add(tfmodel);
		
		JLabel lblavailable = new JLabel("Available");
		lblavailable.setFont(new Font("Tahoma",Font.PLAIN,18));
		lblavailable.setBounds(60,250,120,30);
		add(lblavailable);
		
		String driverOptions[]= {"Available","Busy"};
		availablecombo = new JComboBox(driverOptions);
		availablecombo.setBounds(200,250,150,30);
		availablecombo.setBackground(Color.white);
		add(availablecombo);
		
		JLabel lbllocation = new JLabel("Location");
		lbllocation.setFont(new Font("Tahoma",Font.PLAIN,18));
		lbllocation.setBounds(60,290,120,20);
		add(lbllocation);
		
		
		tflocation=new JTextField();
		tflocation .setBounds(200,290,150,30);
		add(tflocation);
		
		add=new JButton("Add Driver");
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
		
		  ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
		  Image i2=i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);//compress image size
		  ImageIcon i3=new ImageIcon(i2);
       	  JLabel image=new JLabel(i3);
		   image.setBounds(400,30,500,300);
		   add(image);

		
		setBounds(300,200,980,470);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new AddDriver();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == add) {
			String name = tfname.getText();
			String age = tfage.getText();
			String gender=(String)gendercombo.getSelectedItem();
			String company=tfcompany.getText();
			String brand=tfmodel.getText();
			String available =(String)availablecombo.getSelectedItem();
			String location = tflocation.getText();
			
			try {
				Conn conn=new Conn();
				String str="insert into driver values('"+name+"','"+age+"','"+gender+"','"+company+"','"+brand+"','"+available+"','"+location+"')";
				conn.s.executeUpdate(str);
				
				JOptionPane.showMessageDialog(null, "new driver Added Successfully");
				setVisible(false);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else {
			setVisible(false);
		}
	}
}
