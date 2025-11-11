package atmMachine;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Withdrawal {
	public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	public static JFrame frame = new JFrame("Withdrawal");
	
	public static void openWithdrawal(String userCardNumber, char[] userPinNumber) {
String[] usersInfo = validateTemple.getUserInfo(userCardNumber);
		
		//frame setup 
		JFrame frame = new JFrame("Withdrawal");
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
		
		JLabel command1 = new JLabel("Please use slider or type amount for withdrawal:");
		command1.setForeground(Color.white);
		command1.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		command1.setFont(new Font("Serif", Font.BOLD, 24));
		header.add(command1);
		

		//panel setups
		JPanel userOptions = new JPanel();
		userOptions.setLayout(new GridLayout(3, 1));
		userOptions.setBackground(Color.green);
		frame.add(userOptions, BorderLayout.CENTER);
				
		//Slider panel
		JPanel userOptions1 = new JPanel();
		userOptions1.setLayout(new GridLayout(3,1));
		userOptions1.setBackground(Color.white);
		userOptions.add(userOptions1);
		
		JLabel sliderHelp = new JLabel("Slider Deposit", SwingConstants.CENTER);
		sliderHelp.setBackground(Color.white);
		sliderHelp.setForeground(Color.black);
		sliderHelp.setFont(new Font("Serif",Font.BOLD, 24));
		userOptions1.add(sliderHelp);
		
		// Container to hold label + slider
		JPanel sliderPanel = new JPanel();
		sliderPanel.setBackground(Color.white);
		sliderPanel.setLayout(new BoxLayout(sliderPanel, BoxLayout.Y_AXIS));

		// Label to display current value
		JLabel sliderValueLabel = new JLabel("Deposit Amount: $0", SwingConstants.CENTER);
		sliderValueLabel.setFont(new Font("Serif", Font.BOLD, 22));
		sliderValueLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		sliderPanel.add(sliderValueLabel);

		// Slider setup
		JSlider depositSlider = new JSlider(0, 1000, 0);
		depositSlider.setPaintTicks(false);
		depositSlider.setBackground(Color.white);
		depositSlider.setMaximumSize(new Dimension(500, 50));
		depositSlider.setAlignmentX(JSlider.CENTER_ALIGNMENT);
		depositSlider.addChangeListener(e -> {
			int value = depositSlider.getValue();
			sliderValueLabel.setText("Withdrawal Amount: $" + value);
		});
		sliderPanel.add(depositSlider);

		// Add to options panel
		userOptions1.add(sliderPanel);
		
		//Submit Slider deposit
		JPanel sliderSubmitPanel = new JPanel();
		sliderSubmitPanel.setLayout(new GridLayout(1,5));
		sliderSubmitPanel.setBackground(Color.white);
		userOptions1.add(sliderSubmitPanel);
		
		sliderSubmitPanel.add(new JLabel("")); 
		sliderSubmitPanel.add(new JLabel("")); 
		
		JButton depositSliderAmount = new JButton("Click to withdrawal amount on Slider");
		depositSliderAmount.setBackground(Color.white);
		depositSliderAmount.setForeground(Color.black);
		depositSliderAmount.setFont(new Font("Serif",Font.BOLD, 24));
		depositSliderAmount.setMaximumSize(new Dimension(200,50));
		sliderSubmitPanel.add(depositSliderAmount);
		
		depositSliderAmount.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				float previousBalance = Float.parseFloat(usersInfo[3]);
				float addBalance = depositSlider.getValue();
				float newBalance = previousBalance - addBalance;
				
				try{
					File inputFile = new File("accounts.txt");
					File tempFile = new File("temp_accounts.txt");
					
					BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
					
					String read;
					while ((read = reader.readLine()) != null) {
					String[] line = read.split(",");
					String cardNumber = line[1];
					
					if (cardNumber.equals(userCardNumber)) {
						line[3] = String.format("%.2f", newBalance);
						read = String.join(",", line);
						
						}
					writer.write(read);
					writer.newLine();
					}
					reader.close();
					writer.close();
					
					if (inputFile.delete()) {
		                tempFile.renameTo(inputFile);
		            }
					String userFeedback = "Recent: Balance Withdrew $" + addBalance + "; Current Balance: $" + newBalance;
					frame.dispose();
					userHomepage.openHomepage(userCardNumber, userPinNumber, userFeedback);
				}	
			 
			 catch (IOException e1) {
				e1.printStackTrace();
			 }	
			}
		});
		
		sliderSubmitPanel.add(new JLabel("")); 
		sliderSubmitPanel.add(new JLabel("")); 

		//TextField panel
		
		JPanel userOptions2 = new JPanel();
		userOptions2.setLayout(new GridLayout(3,1));
		userOptions2.setBackground(Color.white);
		userOptions.add(userOptions2);
		
		JLabel balance = new JLabel("Text Withdrawal, Enter Dollar amount with decimal (ex 14.24, or 10.00)",SwingConstants.CENTER);
		balance.setBackground(Color.white);
		balance.setForeground(Color.black);
		balance.setFont(new Font("Serif",Font.BOLD, 24));
		userOptions2.add(balance);
		
		JPanel getUserDepositPanel = new JPanel();
		getUserDepositPanel.setLayout(new GridLayout(1,5));
		getUserDepositPanel.setBackground(Color.white);
		userOptions2.add(getUserDepositPanel);
		getUserDepositPanel.add(new JLabel("")); 
		getUserDepositPanel.add(new JLabel("")); 
		JTextField getUserDeposit = new JTextField();
		getUserDepositPanel.add(getUserDeposit);
		getUserDepositPanel.add(new JLabel("")); 
		getUserDepositPanel.add(new JLabel("")); 
		
		
		
		//feedback, Balance panel
		JPanel userOptions3 = new JPanel();
		userOptions3.setLayout(new GridLayout(3,1));
		userOptions3.setBackground(Color.white);
		userOptions.add(userOptions3);
		
		JLabel balanceText = new JLabel("Current Balance: $0", SwingConstants.CENTER);
		balanceText.setText("Current Balance: $" + usersInfo[3]);
		balanceText.setFont(new Font("Serif", Font.BOLD, 22));
		balanceText.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		userOptions3.add(balanceText);
		
		
		//baseline setup
		JPanel baseline = new JPanel();
		baseline.setSize(frame.getWidth(), 50);
		baseline.setBackground(new Color(70, 95, 255));
		frame.add(baseline, BorderLayout.SOUTH);
		
		JLabel command2 = new JLabel("Withdrawal");
		command2.setForeground(Color.white);
		command2.setHorizontalAlignment(SwingConstants.CENTER);
		command2.setFont(new Font("Serif", Font.BOLD, 24));
		command2.setLayout(new BorderLayout());
		baseline.add(command2, BorderLayout.CENTER);
//--------------------

		//frame.pack();
		frame.setVisible(true);
	}
}