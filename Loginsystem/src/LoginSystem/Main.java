package LoginSystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class Main implements ActionListener {
	
	 JFrame frame = new JFrame("LOGINSYSTEM");
		JTextField  username = new JTextField();
		JTextField  password = new JTextField();
		JLabel  utext = new JLabel("USERID");
		JLabel ptext = new JLabel("PASSCODE");
		JButton loginbutton = new JButton("LOGIN");
		JButton refreshbutton = new JButton("REFRESH");
		
	  Main()
	  {   
		 
		  
		  username.setBounds(145, 100, 200, 30);
			password.setBounds(145, 150, 200, 30);
			
			utext.setText("USERID"+" "+"🙍‍♂️");
			ptext.setText("PASSWORD"+" "+"🔐");
			utext.setBounds(70, 100, 200, 30);
			ptext.setBounds(50, 150, 200, 30);
			
			
			
			loginbutton.setBounds(150, 200, 100, 20);
			refreshbutton.setBounds(260, 200, 95, 20);
			loginbutton.addActionListener(this);
			refreshbutton.addActionListener(this);
		
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(400,400);
			frame.setVisible(true);
	        frame.setLayout(null);
	        frame.add(username);
			frame.add(password);
			frame.add(utext);
			frame.add(ptext);
			frame.add(loginbutton);
			frame.add(refreshbutton);
			
		  
		  
	  }
   
	@Override
	public void actionPerformed(ActionEvent e) {
	   
		String uname=username.getText();
		String pname=password.getText();
		
		if (e.getSource()==loginbutton) 
			
		{
		

			try {
			    
				String query ="select user FROM login WHERE  name='uname'";
				if(query==uname) 
				{
					System.out.println("record already exist");
				}
				Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","s3112004@");
				PreparedStatement pat =con.prepareStatement("INSERT  INTO usernamepassword(user,pass)values(?,?)");
				pat.setString(1, uname);
				pat.setString(2, pname);
				int w =pat.executeUpdate();
				  
				if(w==1) {
					
					System.out.println("insertin records");
					username.setText("");
					password.setText("");
					
				  JOptionPane.showMessageDialog(null, "RECORD ADDED!");
				}
			} catch (Exception k) {
		
				System.out.println(k);
			}
			
			
			}
		
		if(e.getSource()==refreshbutton) 
		{
			username.setText(null);
			password.setText(null);
		}
		
	}

}