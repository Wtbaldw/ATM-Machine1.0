package atmMachine;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;



public class ATMmachineLogin {
	public static JLabel feedback = new JLabel("");
	
	public static void main (String[] args) {
		//frame setup
		JFrame frame = new JFrame("ATM Machine");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(220,300);
		frame.setLayout(new BorderLayout());
		
		//header setup
		JLabel header = new JLabel("ATM Machine", SwingConstants.CENTER);
		header.setOpaque(true);
		header.setPreferredSize(new Dimension(frame.getWidth(), 40));
		header.setBackground(new Color(70, 95, 255));
		header.setForeground(Color.white);
		frame.add(header, BorderLayout.NORTH);
		
		//panel setup(panel1)
		JPanel panel1 = new JPanel();
		panel1.setBackground(Color.white);
		panel1.setPreferredSize(new Dimension(220, 600));
		panel1.setLayout(null);
		frame.add(panel1);
		
		//user name Setup(panel1)
		JLabel displayCardNumber = new JLabel("Card Number:");
		displayCardNumber.setOpaque(true);
		displayCardNumber.setBounds(10,0,190,20);
		panel1.add(displayCardNumber);
		
		JTextField getCardNumber = new JTextField();
		getCardNumber.setBounds(10,25,190,20);
		panel1.add(getCardNumber);
		
		//password setup(panel 1)
		JLabel displayPin = new JLabel("Pin:");
		displayPin.setOpaque(true);
		displayPin.setBounds(10,50,190,20);
		panel1.add(displayPin);
		
		JPasswordField getPin = new JPasswordField();
		getPin.setBounds(10,75,190,20);
		panel1.add(getPin);

		//login button setup(panel 1)
		JButton loginButton = new JButton("LOGIN");
		loginButton.setOpaque(true);
		loginButton.setBounds(20,100,160,25);
		loginButton.setBackground(Color.blue);
		loginButton.setForeground(Color.white);
		panel1.add(loginButton);
		
		loginButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				String inputCardNumber = getCardNumber.getText(); //user name typed from user
				char[] inputPinChars = getPin.getPassword(); // password typed from user
				if (validateTemple.validateUser(inputCardNumber, inputPinChars)) {
					System.out.println("Login successful!");
					frame.dispose();
					userHomepage.openHomepage(inputCardNumber, inputPinChars, null);
				}
				else {
					feedback.setText("Card Number or pin Invalid, please try again.");
					
				}
				
			}
			
		});
		
		//Create account?
		JButton NeedAssistanceButton = new JButton("Need Assistance?");
		NeedAssistanceButton.setOpaque(true);
		NeedAssistanceButton.setBounds(20,130,160,20);
		NeedAssistanceButton.setBackground(Color.white);
		NeedAssistanceButton.setForeground(new Color(70, 95, 255));
		NeedAssistanceButton.setBorderPainted(false);
		panel1.add(NeedAssistanceButton, SwingConstants.CENTER);
		
		NeedAssistanceButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				needAssistance.main(null);
				
			}
			
		});

		//feedback from login
		feedback.setOpaque(true);
		feedback.setBounds(20,150,160,20);
		feedback.setBackground(Color.white);
		feedback.setForeground(Color.red);
		panel1.add(feedback, SwingConstants.CENTER);
		
		
		frame.setVisible(true);
		
		
		
		
		
	}
}
