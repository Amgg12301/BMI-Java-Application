package bmiproject;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

public class Calculator {

	public static void main(String[] args) {
		HashMap<Integer, Person> personList = new HashMap<Integer, Person>();
		String input = "";
		while(!input.toLowerCase().equals("quit")){
			input = JOptionPane.showInputDialog("Have you registered your information in the system previously (Yes or No)?");
			if(input.toLowerCase().equals(("no"))){
				String[] multipleInputs = {"input"};
				String[] name = {"name"};
				do{
					name = JOptionPane.showInputDialog("What's your name (FirstName, LastName)?").split(", ");
					if(name.length != 2) {
						JOptionPane.showMessageDialog(null, "Please enter your answer in the format (FirstName, LastName)! Thank you!");
					}
				}while(name.length != 2);
				
				String firstName = name[0];
				String lastName = name[1];
				String system = JOptionPane.showInputDialog("What metric system do you use (pounds or kilograms)?");
				
				do{
					multipleInputs = JOptionPane.showInputDialog("What's your weight, age, and height (in inches) (weight, age, height)?").split(", ");
					if(multipleInputs.length != 3) {
						JOptionPane.showMessageDialog(null, "Please enter your answer in the format (weight, age, height)! Thank you!");
					}
				}while(multipleInputs.length != 3);
					
				double weight = Double.parseDouble(multipleInputs[0]);
				int age = Integer.parseInt(multipleInputs[1]);
				double height = Double.parseDouble(multipleInputs[2]);
				
				String birthDate = "";
				do{
					birthDate = JOptionPane.showInputDialog("Whats your date of birth (ex. 01/01/1901)?");
					multipleInputs = birthDate.split("/");
					if(multipleInputs.length != 3) {
						JOptionPane.showMessageDialog(null, "Please enter your answer in the format (mm/dd/yyyy)! Thank you!");
					}
				}while(multipleInputs.length != 3);
				
				int month = Integer.parseInt(multipleInputs[0]);
				int day = Integer.parseInt(multipleInputs[1]);
				int year = Integer.parseInt(multipleInputs[2]);
				
				Person person = new Person(weight, firstName, lastName, height, age, birthDate, system);
				personList.put(personList.size(), person);
			}else if(input.toLowerCase().equals("yes")) {
				String[] name;
				do{
					name = JOptionPane.showInputDialog("What's your name (FirstName, LastName)?").split(", ");
					if(name.length != 2) {
						JOptionPane.showMessageDialog(null, "Please enter your answer in the format (FirstName, LastName)! Thank you!");
					}
				}while(name.length != 2);
				Person current = null;
				for(int i = 0; i < personList.size(); i++) {
					if(personList.get(i).getFullName().equals(name[0] + " " + name[1])) {
						current = personList.get(i);
					}
				}
				JOptionPane.showMessageDialog(null, "Welcome Back " + current.getFullName() + "!!");
				
			}
			input = JOptionPane.showInputDialog("Would you like to continue? (Type 'quit' to exit)");
		}	
		
	}
}
