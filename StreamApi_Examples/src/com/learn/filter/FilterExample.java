package com.learn.filter;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;



public class FilterExample {

	public static void main(String[] args) {

		List<String> names = Arrays.asList("Peter", "Meter", "Ajay", "Jay", "Vijay", "Sam");

		for (String name : names) {

			if (!name.equals("Sam")) {
				System.out.print(name + " :: ");
			}
		}

		System.out.println();
		// how to achieve the above style through stream()

		// we will first apply anonymous class
		names.stream().filter(new Predicate<String>() {

			@Override
			public boolean test(String name) {

				return !name.equals("Sam");
			}

		}).forEach(name -> System.out.print(name + " :: "));

		System.out.println();
		// so the above anonymous class we can remove to lambda expression

		names.stream().filter((n) -> !n.equals("Sam")).forEach((name) -> System.out.print(name + " :: "));
		;

		System.out.println();
		// we can create a separate method isNotSam()

		names.stream().filter(n -> isNotSam(n)).forEach((name) -> System.out.print(name + " :: "));

		
		System.out.println("-----------");
		//we can use method referencing
		
		names.stream()
		.filter(FilterExample::isNotSam)
		.forEach(System.out::println);
		
	}
	
	

	private static boolean isNotSam(String name) {

		return !name.equals("Sam");
	}
}
