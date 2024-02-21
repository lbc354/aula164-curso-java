package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Circle;
import entities.Rectangle;
import entities.Shape;
import entities.enums.Color;

public class Aula164 {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Shape> shapes = new ArrayList<Shape>();
		
		int i = 1;
		char rc;
		
		do {
			System.out.println("Shape #" + i + " data:");
			System.out.print("Rectangle(r) or Circle(c)? Press (x) to quit ");
			rc = sc.next().charAt(0);
			
			while (rc != 'r' && rc != 'R' && rc != 'c' && rc != 'C' && rc != 'x' && rc != 'X') {
				System.out.print("Try again: ");
				rc = sc.next().charAt(0);
			}
			if (rc == 'x' || rc == 'X') {
				break;
			}
			
			System.out.print("Color(BLACK/RED/BLUE): ");
			Color color = Color.valueOf(sc.next());
			
			if (rc == 'r' || rc == 'R') {
				System.out.print("Width: ");
				double width = sc.nextDouble();
				System.out.print("Height: ");
				double height = sc.nextDouble();
				shapes.add(new Rectangle(color, width, height));
			}
			if (rc == 'c' || rc == 'C') {
				System.out.print("Radius: ");
				shapes.add(new Circle(color, sc.nextDouble()));
			}
			
			i++;
		} while (i > 0);
		
		System.out.println("\nShape Areas:");
		for (Shape shape : shapes) {
			System.out.println(String.format("%.2f", shape.area()));
		}
		
		sc.close();
	}

}