package atmMachine;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class accountInfo {
	public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	public static JFrame frame = new JFrame("Account Info");
	
	public static void openAccountInfo(String userCardNumber, char[] userPinNumber) {
		String[] usersInfo = validateTemple.getUserInfo(userCardNumber);
		
		//frame setup 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.setSize(screenSize.width, screenSize.height);
		
		//header setup
		JPanel header = new JPanel();
		header.setPreferredSize(new Dimension(frame.getWidth(), 250));
		header.setBackground(new Color(70, 95, 255));
		header.setLayout(new BoxLayout(header, BoxLayout.Y_AXIS));
		frame.add(header, BorderLayout.NORTH);
		
		
		JLabel bankDisplay = new JLabel("Baldwin Banking");
		bankDisplay.setForeground(Color.white);
		bankDisplay.setFont(new Font("Serif", Font.BOLD, 36));
		bankDisplay.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		header.add(bankDisplay);
		
		JLabel nameDisplay = new JLabel("Welcome " + usersInfo[0] + "");
		nameDisplay.setForeground(Color.white);
		nameDisplay.setFont(new Font("Serif", Font.BOLD, 24));
		nameDisplay.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		header.add(nameDisplay, BorderLayout.CENTER);
		
		JLabel command1 = new JLabel("Please select the transaction:");
		command1.setForeground(Color.white);
		command1.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		command1.setFont(new Font("Serif", Font.BOLD, 24));
		header.add(command1);
		

		
		
		//panel setups
		JPanel userOptions = new JPanel();
		userOptions.setLayout(new GridLayout(1, 6));
		userOptions.setBackground(Color.green);
		frame.add(userOptions, BorderLayout.CENTER);
		
		//panelLEFT options1, 
		JPanel userOptions1 = new JPanel();
		userOptions1.setLayout(new GridLayout(4,1));
		userOptions1.setBackground(Color.LIGHT_GRAY);
		userOptions.add(userOptions1);
		
		//panelLEFT button 1
		
		JButton accountInfo = new JButton("Account Info");
		accountInfo.setBackground(Color.white);
		accountInfo.setForeground(Color.black);
		accountInfo.setFont(new Font("Serif",Font.BOLD, 24));
		userOptions1.add(accountInfo);
		
		//panelLEFT button 2
		
		JButton moreServices = new JButton("More Services");
		moreServices.setBackground(Color.white);
		moreServices.setForeground(Color.black);
		moreServices.setFont(new Font("Serif",Font.BOLD, 24));
		userOptions1.add(moreServices);
		
		//panelLeft button 3
		
		JButton deposit = new JButton("Deposit");
		deposit.setBackground(Color.white);
		deposit.setForeground(Color.black);
		deposit.setFont(new Font("Serif",Font.BOLD, 24));
		userOptions1.add(deposit);
		
		//panelLeft Button 4
		
		JButton pinChange = new JButton("Pin Change");
		pinChange.setBackground(Color.white);
		pinChange.setForeground(Color.black);
		pinChange.setFont(new Font("Serif",Font.BOLD, 24));
		userOptions1.add(pinChange);
		
		
		
		
		
		
		
		JPanel userOptions2 = new JPanel();
		userOptions2.setLayout(new GridLayout(4,1));
		userOptions2.setBackground(Color.gray);
		userOptions.add(userOptions2);
		
		JPanel userOptions3 = new JPanel();
		userOptions3.setLayout(new GridLayout(4,1));
		userOptions3.setBackground(Color.white);
		userOptions.add(userOptions3);
		
		JPanel userOptions4 = new JPanel();
		userOptions4.setLayout(new GridLayout(4,1));
		userOptions4.setBackground(Color.gray);
		userOptions.add(userOptions4);
		
		JPanel userOptions5 = new JPanel();
		userOptions5.setLayout(new GridLayout(4,1));
		userOptions5.setBackground(Color.white);
		userOptions.add(userOptions5);
		
		
		//Panel Right Options
		JPanel userOptions7 = new JPanel();
		userOptions7.setLayout(new GridLayout(4,1));
		userOptions7.setBackground(Color.white);
		userOptions.add(userOptions7);
		
		JButton balance = new JButton("Balance");
		balance.setBackground(Color.white);
		balance.setForeground(Color.black);
		balance.setFont(new Font("Serif",Font.BOLD, 24));
		userOptions7.add(balance);
		
		JButton recentTransactions = new JButton("Recent\n Transactions");
		recentTransactions.setBackground(Color.white);
		recentTransactions.setForeground(Color.black);
		recentTransactions.setFont(new Font("Serif",Font.BOLD, 19));
		userOptions7.add(recentTransactions);
		
		JButton withdrawal = new JButton("Withdrawal");
		withdrawal.setBackground(Color.white);
		withdrawal.setForeground(Color.black);
		withdrawal.setFont(new Font("Serif",Font.BOLD, 24));
		userOptions7.add(withdrawal);
		
		JButton test = new JButton("Test");
		test.setBackground(Color.white);
		test.setForeground(Color.black);
		test.setFont(new Font("Serif",Font.BOLD, 24));
		userOptions7.add(test);
		
		//baseline setup
		JPanel baseline = new JPanel();
		baseline.setSize(frame.getWidth(), 50);
		baseline.setBackground(new Color(70, 95, 255));
		frame.add(baseline, BorderLayout.SOUTH);
		
		JLabel command2 = new JLabel("TODO");
		command2.setForeground(Color.white);
		command2.setHorizontalAlignment(SwingConstants.CENTER);
		command2.setFont(new Font("Serif", Font.BOLD, 24));
		command2.setLayout(new BorderLayout());
		baseline.add(command2, BorderLayout.CENTER);
//--------------------

		
		//frame.pack();
		frame.setVisible(true);
	}
	
	public static void main (String[] args) {
		openAccountInfo("1234567812345678",new char[] {'1','2','3','4'});
	}
}
