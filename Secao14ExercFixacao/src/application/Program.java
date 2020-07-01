package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {		
		
		Scanner sc = new Scanner(System.in);
		List<Product> list = new ArrayList<>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
		
		for(int i=0; i<n; i++) {
			System.out.print("The product is common, used or imported (Common = c; used = u; imported = i)?");
			sc.nextLine();
			char type = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Price: ");
			Double price = sc.nextDouble();		
			if(type == 'c') {
				list.add(new Product(name, price));	
			} else {
				if(type == 'u') {
					System.out.print("Manufactured date (DD/MM/YYY): ");
					Date manufactureDate = sdf.parse(sc.next());
					list.add(new UsedProduct(name, price, manufactureDate));
				}			
					else {
						System.out.print("Customs fee: ");
						Double customsFee = sc.nextDouble();
						list.add(new ImportedProduct(name, price, customsFee));
					}
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("PRICE TAGS: ");		
		for(Product c :list) {
			System.out.println(c.priceTag());
		}
		sc.close();		
	}

}
