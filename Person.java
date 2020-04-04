package bmiproject;

import java.util.Map;
import java.util.TreeMap;

public class Person {
	
	private double weight;
	private String firstName;
	private String lastName;
	private double height;
	private int age;
	private String fullName;
	private String dateOfBirth;
	private String system;
	
	public Person(double weight, String firstName, String lastName, double height, 
					int age, String dateOfBirth, String system) {
		this.weight = weight;
		this.firstName = firstName;
		this.lastName = lastName;
		this.height = height;
		this.age = age;
		this.dateOfBirth = dateOfBirth;
		this.fullName = this.firstName + " " + this.lastName;
		this.system = system;
	}
	
	public double calculateBMI(String unit) {
		double BMI = 0.0;
		
		BMI = unit.equals("kilograms") ? (weight / (Math.pow(height, 2))) : unit.equals("pounds") ? (703 * (weight / (Math.pow(height, 2)))) : null;
		
		return BMI;
	}
	
	public String evaluateBMI(double bmi) {
		String result = "Nothing seem to came up for your bmi hmmm";
		TreeMap<Double,Integer> ranges = new TreeMap<Double,Integer>();
		 
		ranges.put(18.5, 1);
		ranges.put(24.9, 2);
		ranges.put(29.9, 3);
		ranges.put(39.9, 4);
		
		Map.Entry<Double,Integer> entry = ranges.ceilingEntry(bmi);
		if (entry != null) {
		    switch(entry.getValue()) {
		        case 1:
		        	result = "You're underweight :(";
					break;
		        case 2:
		        	result = "You're healthy! Keep it up!";
		        	break;
		        case 3:
		        	result = "You're overweight :( Try eating healthier and start doing more cardio!";
		        	break;
		        case 4:
			        result = "You're obese :(( You should get a personal trainer and work on becoming healthier. It'll be hard but you got this!!";
					break;
		       	default:
		       		result = "Unfortunately, your weight is not applicable to any BMI ranges.";
		    }
		}
		
		return result;
			
		
	}
	
	public String getSummary(Person person) {
		StringBuilder summary = new StringBuilder();
		summary.append("About You:\nYou are " + person.getAge() + " years old, born on " + person.getBirthDate() + "\n");
		summary.append("You weigh " + person.getWeight() + " at an height of " + person.getHeight() + " inches\n");
		summary.append("As a result, your BMI is: " + person.calculateBMI(person.getSystem()));
		summary.append("Here's some information about your BMI: " + evaluateBMI(person.calculateBMI(person.getSystem())));
		
		return summary.toString();
	}
	
	public String getSystem() {
		return system;
	}
	
	public String getBirthDate() {
		return dateOfBirth;
	}
	
	public String getFullName() {
		return fullName;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public double getHeight() {
		return height;
	}
	
	public int getAge() {
		return age;
	}
	
	
	
	
	
	
}
