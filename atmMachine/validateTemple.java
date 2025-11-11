package atmMachine;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class validateTemple {
	public static String[] line;
	public static boolean validateUser(String inputCard, char[] inputPin){
		try(BufferedReader reader = new BufferedReader(new FileReader("accounts.txt"))){
			String read;
			while ((read = reader.readLine()) != null) {
			line = read.split(",");
			String cardNumber = line[1];
			
			if (cardNumber.equals(inputCard)) {
				String pinNumber = line[2];
				String pinString = new String(inputPin);
				if (pinString.equals(pinNumber)) {
					ATMmachineLogin.feedback.setText("Loggin In...");
					System.out.println("Sussceful login, account found!");
					return true;
				}
			}		
		}	
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e1) {
		e1.printStackTrace();
	}
		return false;
		
	}
//-----------------------------------------------------------------------------------------------------------------
	public static String[] getUserInfo(String userCardNumber) {
		try(BufferedReader reader = new BufferedReader(new FileReader("accounts.txt"))){
			String read;
			while ((read = reader.readLine()) != null) {
			line = read.split(",");
			String cardNumber = line[1];
			
			if (cardNumber.equals(userCardNumber)) {
				return line;
			}		
		}	
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e1) {
		e1.printStackTrace();
	}
		
		return line;
	}
}
