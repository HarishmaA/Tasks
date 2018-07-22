package Tasks;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

//My own exception
class InvalidAgeException extends Exception {
	InvalidAgeException(String s) {
		super(s);
	}
}

public class Staff implements java.io.Serializable {
	private static String companyName = "Full";
	private int staffId;
	private String staffName;
	private int staffAge;
	private String staffDesignation;
	private String teamName;
	private double staffSalary;

	static void validate(int age) throws InvalidAgeException {
		if (age < 18)
			throw new InvalidAgeException("not valid");
		else
			System.out.println("Age is valid!!!");
	}

	public static char grade(double salary) {
		if (salary > 80000)
			return 'A';
		else if (salary > 50000 && salary < 80000)
			return 'B';
		else if (salary > 30000 && salary < 50000)
			return 'C';
		else
			return 'D';
	}

	public Staff(int staffId, String staffName, int staffAge, String staffDesignation, String teamName,
			double staffSalary) {
		this.staffId = staffId;
		this.staffName = staffName;
		this.staffAge = staffAge;
		this.staffDesignation = staffDesignation;
		this.teamName = teamName;
		this.staffSalary = staffSalary;
	}

	@Override
	public String toString() {
		return companyName + "\t\t" + staffId + "\t" + staffName + "\t\t" + staffAge + "\t" + staffDesignation + "\t\t"
				+ teamName + "\t\t" + staffSalary + "\t" + grade(this.staffSalary);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("STAFF DETAILS!!");
		System.out.println();
		System.out.println("Enter the number of Staffs");
		int n = scanner.nextInt();
		Staff[] staff = new Staff[n];
		int staffId, staffAge;
		String staffName, staffDesignation, teamName;
		double staffSalary;
		for (int i = 0; i < staff.length; i++) {
			try {
				System.out.println("Enter the id number");
				staffId = scanner.nextInt();
				System.out.println("Enter name");
				staffName = scanner.next();
				System.out.println("Enter the age");
				staffAge = scanner.nextInt();
				try {
					validate(staffAge);
				} catch (Exception m) {
					System.out.println("Exception occured: " + m);
					System.exit(-1);
				}

				System.out.println("Enter the designation");
				staffDesignation = scanner.next();
				System.out.println("Enter the team name");
				teamName = scanner.next();
				System.out.println("Enter the salary");
				staffSalary = scanner.nextDouble();
			}

			catch (InputMismatchException e) {
				throw new InputMismatchException("OOPS!!! YOU TYPED WRONG INPUT!!!");
			}

			staff[i] = new Staff(staffId, staffName, staffAge, staffDesignation, teamName, staffSalary);

			// Serialization
			try {
				// Saving of object in a file
				FileOutputStream file = new FileOutputStream("D:\\Task1\\task1.txt");
				ObjectOutputStream out = new ObjectOutputStream(file);

				// Method for serialization of object
				out.writeObject(staff[i]);

				out.close();
				file.close();

				System.out.println("Object has been serialized");

			}

			catch (IOException ex) {
				System.out.println("IOException is caught");
			}

			staff[i] = null;

			// Deserialization
			try {
				// Reading the object from a file
				FileInputStream file = new FileInputStream("D:\\Task1\\task1.txt");
				ObjectInputStream in = new ObjectInputStream(file);

				// Method for deserialization of object
				staff[i] = (Staff) in.readObject();

				in.close();
				file.close();

				System.out.println("Object has been deserialized ");
				System.out.println("Staff Id  " + staff[i].staffId);
				System.out.println("Staff Name  " + staff[i].staffName);
				System.out.println("Staff Age  " + staff[i].staffAge);
				System.out.println("Staff Designation  " + staff[i].staffDesignation);
				System.out.println("Team Name   " + staff[i].teamName);
				System.out.println("Staff Salary   " + staff[i].staffSalary);

			}

			catch (IOException ex) {
				System.out.println("IOException is caught");
			}

			catch (ClassNotFoundException ex) {
				System.out.println("ClassNotFoundException is caught");
			}
		}
		scanner.close();
		System.out.println();
		System.out.println("COMPANY NAME\tID NO.\tSTAFF NAME\tAGE\tDESIGNATION\tTEAMNAME\tSALARY\tGRADE");
		System.out.println();
		for (int i = 0; i < staff.length; i++) {
			System.out.println(staff[i].toString());
			System.out.println();
		}

	}

}
