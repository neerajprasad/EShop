package business;

import java.util.ArrayList;

import model.GeneralItem;
import model.Item;
import model.MedicalItem;

public class RetailShop {

	public static void main(String[] args) {
		ArrayList<Item> purchaseItem = new ArrayList<>();
		String option = null;
		do {
			
		}while(option=="q");
		Item gItem = new GeneralItem("Biscuit", 1, 15);
		Item gItem1 = new GeneralItem("chip", 1, 15);
		Item gItem2= new GeneralItem("chocolate", 1, 50);
		Item gItem3 = new GeneralItem("book", 1, 150);
		Item gItem4 = new GeneralItem("pencil", 10, 5);
		Item mItem = new MedicalItem("Eavil", 1, 15);
		purchaseItem.add(gItem);
		purchaseItem.add(gItem1);
		purchaseItem.add(gItem2);
		purchaseItem.add(gItem3);
		purchaseItem.add(gItem4);
		purchaseItem.add(mItem);
		double totalMRP =0.0;
		double totalSale = 0.0;
		for (Item item : purchaseItem) {
			System.out.println(item.getUnitsOnHand()+" "+ item.getDescription()+" "+ item.getMaxRetailPrice());
			totalMRP+=item.getMaxRetailPrice();
			totalSale += item.getSaleTaxes();
		}
		System.out.println("tatal sales:"+ totalSale);
		System.out.println("tatal :"+ totalMRP);
		
	}

}
