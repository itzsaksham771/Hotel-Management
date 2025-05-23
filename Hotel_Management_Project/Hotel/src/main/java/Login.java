import java.awt.Color;
import java.awt.Image;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener {
	JTextField username;
	JPasswordField password;
	JButton Login,cancel;
	
   Login(){
	   getContentPane().setBackground(Color.white);
	   setLayout(null);
	   JLabel user = new JLabel("Username");
	   user.setBounds(40,20,100,30);
	   add(user);
	 
	   username = new JTextField();
	   username.setBounds(160,20,150,30);
	   add(username);
	   
	   JLabel pass = new JLabel("pass");
	   pass.setBounds(40,70,100,30);
	   add(pass);
	   
	   password = new JPasswordField();
	   password.setBounds(160,70,150,30);
	   add(password);
	   
	   Login=new JButton("Login");
	   Login.setBounds(40,150,120,30);
	   Login.setBackground(Color.black);
	   Login.setForeground(Color.white);
	   Login.addActionListener(this);
	   add(Login);
	   
	    cancel=new JButton("cancel");
	   cancel.setBounds(180,150,120,30);
	   cancel.setBackground(Color.black);
	   cancel.setForeground(Color.white);
	   cancel.addActionListener(this);
	   add(cancel);
	   
	   ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
	   Image i2=i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);//compress image size
	   ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(350,10,200,200);
		add(image);
	   
	 
	   
	   
	   setBounds(500,200,600,300);
	   setVisible(true);
	   
   }
   
   
   public static void main(String[]args) {
	   new Login();
   }


@Override
public void actionPerformed(ActionEvent ea) {
	if(ea.getSource() == Login) {
		String user=username.getText();
		String pass=password.getText();
		
		try {
			Conn c=new Conn();
			String query="Select*from login where username = '"+ user +"'and password ='"+ pass+"' ";
			
			ResultSet rs =c.s.executeQuery(query);
			
			if(rs.next()) {
				setVisible(false);
				new Dashbord();
			}else {
				JOptionPane.showMessageDialog(null,"Invalid username or password");
			    setVisible(false);
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}else if(ea.getSource() == cancel) {
		setVisible(false);
	}
	
  }
}
