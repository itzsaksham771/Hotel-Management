
import java.awt.Color;
import java.awt.event.*;
import java.awt.Font;
import javax.swing.*;

public class HotelManagementSystem extends JFrame implements ActionListener{
	HotelManagementSystem(){
		//setSize(1366,565);
		//setLocation(100,100);
		setBounds(0,0,1316,565);
		setLayout(null);
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
		JLabel image=new JLabel(i1);
		image.setBounds(0,0,1366,565);
		add(image);
		JLabel text = new JLabel("HOTEL MANAGEMENT SYSTEM");
		text.setBounds(20,430,1000,90);
		text.setForeground(Color.white);
		text.setFont(new Font("serif",Font.PLAIN,50));
		image.add(text);
		
		JButton next=new JButton("Next");
		next.setBounds(1150,450,150,50);
		next.setBackground(Color.white);
		next.setForeground(Color.black);
		next.addActionListener(this);
		next.setFont(new Font("serif",Font.PLAIN,24));
		image.add(next);
		setVisible(true);
		while(true) {//deeper 
			text.setVisible(false);
			try {
				Thread.sleep(500);//hide for 5milliSecond
			}catch(Exception e) {
				e.printStackTrace();
			}
			text.setVisible(true);
			try {
				Thread.sleep(500);//hide for 5milliSecond
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
	
   public static void main(String[] args) {
	   new HotelManagementSystem();
	   
   }


@Override
public void actionPerformed(ActionEvent e) {
	setVisible(false);
	new Login();
	
   }
}
