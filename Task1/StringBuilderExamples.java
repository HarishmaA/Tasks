package Tasks;

import java.util.GregorianCalendar;

public class StringBuilderExamples {

	public static void main(String[] args) {
		StringBuilder str1 = new StringBuilder("Java");
		str1.append(" Programming is good");
		str1.insert(0, 'I');
		str1.insert(1, " like ");
		str1.insert(31, true);
		str1.replace(27, 31, "best ");
		System.out.println(str1.reverse());
		str1.reverse();
		str1.delete(0, 1);
		System.out.println(str1);
		System.out.println(str1.charAt(1));
		System.out.println(str1.capacity());
		System.out.println(str1.length());
		System.out.println(str1.substring(0, 5));
		
		//String Builder performance
				System.gc();
				long start=new GregorianCalendar().getTimeInMillis();
				long startMemory=Runtime.getRuntime().freeMemory();
				StringBuilder sb = new StringBuilder();
				//StringBuffer sb = new StringBuilder();
				for(int i = 0; i<100000; i++){
					sb.append(":"+i);
					sb.insert(i, "Hi");
				}
				long end=new GregorianCalendar().getTimeInMillis();
				long endMemory=Runtime.getRuntime().freeMemory();
				System.out.println("Time Taken:"+(end-start));
				System.out.println("Memory used:"+(startMemory-endMemory));
	}

}
