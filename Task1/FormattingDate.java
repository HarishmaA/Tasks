package Tasks;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class FormattingDate {
	public static void main(String[] args) {
		// to format
		LocalDate date1 = LocalDate.now();
		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("d/MMMM/uuuu");
		System.out.println(date1.format(formatter1));
		System.out.println();
		System.out.println();
		// to parse and the task
		Scanner scanner = new Scanner(System.in);
		String strDate = scanner.nextLine().trim();
		DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("d/MM/uuuu");
		LocalDate date2 = LocalDate.parse(strDate, formatter2);
		System.out.println(date2.format(formatter1));
		scanner.close();
	}
}