import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class AddEmployee extends JFrame implements ActionListener{
	
	JTextField tfname,tfemail,tfphone,tfage,tfsalary,tfaadhar;
	JRadioButton rbmale,rbfemale;
	JButton submit;
	JComboBox cbjob;
	AddEmployee(){
		setLayout(null);
		JLabel lblname=new JLabel("NAME");
		lblname.setBounds(60,30,120,30);
		lblname.setFont(new Font("Tahoma",Font.PLAIN,17));
		add(lblname);
		
		 tfname = new JTextField();
		tfname.setBounds(200,30,150,30);
		add(tfname);
		
		JLabel lblage=new JLabel("AGE");
		lblage.setBounds(60,80,120,30);
		lblage.setFont(new Font("Tahoma",Font.PLAIN,17));
		add(lblage);
		
		 tfage = new JTextField();
		tfage.setBounds(200,80,150,30);
		add(tfage);
		
		JLabel lblgender=new JLabel("GENDER");
		lblgender.setBounds(60,130,120,30);
		lblgender.setFont(new Font("Tahoma",Font.PLAIN,17));
		add(lblgender);
		
	    rbmale=new JRadioButton("Male");
		rbmale.setBounds(200,130,70,30);
		rbmale.setFont(new Font("Tahoma",Font.PLAIN,14));
		rbmale.setBackground(Color.white);
		add(rbmale);
		
		rbfemale=new JRadioButton("Female");
		rbfemale.setBounds(280,130,70,30);
		rbfemale.setFont(new Font("Tahoma",Font.PLAIN,14));
		rbfemale.setBackground(Color.white);
		add(rbfemale);
		
		ButtonGroup bg=new ButtonGroup();
		bg.add(rbmale);
		bg.add(rbfemale);
		
		
		
		JLabel lbljobr=new JLabel("JOB");
		lbljobr.setBounds(60,180,120,30);
		lbljobr.setFont(new Font("Tahoma",Font.PLAIN,17));
		add(lbljobr);

		String str[]= {"Front Desk Clerks","porters","Housekeeping","Kitchen Staf","RoomService","Chefs","Waiter/Waitress","Manager","Account"};
		cbjob = new JComboBox(str);
		cbjob.setBounds(200,180,150,30);
		cbjob.setBackground(Color.white);
		add(cbjob);
		
		
		JLabel lbsalary=new JLabel("SALARY");
		lbsalary.setBounds(60,230,120,30);
		lbsalary.setFont(new Font("Tahoma",Font.PLAIN,17));
		add(lbsalary);
		
		tfsalary = new JTextField();
		tfsalary.setBounds(200,230,150,30);
		add(tfsalary);
		
		JLabel lbphone=new JLabel("PHONE");
		lbphone.setBounds(60,280,120,30);
		lbphone.setFont(new Font("Tahoma",Font.PLAIN,17));
		add(lbphone);
		
		tfphone = new JTextField();
		tfphone.setBounds(200,280,150,30);
		add(tfphone);

		JLabel lblemil=new JLabel("Email");
		lblemil.setBounds(60,330,120,30);
		lblemil.setFont(new Font("Tahoma",Font.PLAIN,17));
		add(lblemil);
		
		tfemail = new JTextField();
		tfemail.setBounds(200,330,150,30);
		add(tfemail);
		
		JLabel lbaadhar=new JLabel("AADHAR");
		lbaadhar.setBounds(60,380,120,30);
		lbaadhar.setFont(new Font("Tahoma",Font.PLAIN,17));
		add(lbaadhar);
		
		tfaadhar = new JTextField();
		tfaadhar.setBounds(200,380,150,30);
		add(tfaadhar);
		
		
		
	    submit = new JButton("SUBMIT");
		submit.setBackground(Color.black);
		submit.setForeground(Color.white);
		submit.setBounds(200,430,150,30);
		submit.addActionListener(this);
		add(submit);
		
	    

		   ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
		   Image i2=i1.getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT);//compress image size
		   ImageIcon i3=new ImageIcon(i2);
		   JLabel image=new JLabel(i3);
		   image.setBounds(380,60,450,380);
		   add(image);
		   

		
		getContentPane().setBackground(Color.white);
		setBounds(350,200,850,540);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		new AddEmployee();

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String name = tfname.getText();
		String age = tfage.getText();
		String salary = tfsalary.getText();
		String phone = tfphone.getText();
		String email = tfemail.getText();
		String aadhar = tfaadhar.getText();
		
		String gender = null;
		//form name not be empty
		if(name.equals("")) {
			JOptionPane.showMessageDialog(null,"Name should not be empty");
			return;
		}
		
		if(rbmale.isSelected()) {
			gender ="Male";
		}else if(rbfemale.isSelected()) {
			gender ="Female";
		}
		
		String job = (String)cbjob.getSelectedItem();
		try {
			Conn conn=new Conn();
			
			String query="insert into employee values('"+name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+phone+"','"+email+"','"+aadhar+"')";
			conn.s.executeUpdate(query);
			
			JOptionPane.showMessageDialog(null,"Employee added successfully");
			
			setVisible(false);
		  }catch(Exception x) {
			x.printStackTrace();
		}
	}

}
