package business;

import java.util.Scanner;

import model.Item;
import services.FactoryServices;
import services.ItemEnum;
import services.RetailServices;

public class RetailShop {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		RetailServices retailServices = new RetailServices();
		FactoryServices factory = new FactoryServices();
		
		Scanner input = new Scanner(System.in);
		Item item;
		int value;
//		Just have static input
		do {
			System.out.println("Please enter the following option");
			System.out.println("1. list for general item");
			System.out.println("2. list for medical item");
			System.out.println("3. to Quit");
			
			value = input.nextInt();
			switch (value) {
			case 1:
				item = factory.getInstance(ItemEnum.GENERAL);
				item.setDescription("biscuit");
				item.setUnitsOnHand(2);
				item.setRetailPrice(20);
				retailServices.addItem(item);
				break;
			case 2:
				item = factory.getInstance(ItemEnum.MEDICAL);
				item.setDescription("paracitamol");
				item.setUnitsOnHand(20);
				item.setRetailPrice(20);
				retailServices.addItem(item);
				break;

			}

		} while (3 != value);

		retailServices.display(retailServices.getAllItem());

	}

}
