package services;

import java.util.ArrayList;

import model.Item;

public class RetailServices {

	ArrayList<Item> purchaseItem = new ArrayList<>();

	public void addItem(Item item) {
		purchaseItem.add(item);
	}

	public ArrayList<Item> getAllItem() {
		return purchaseItem;
	}

	public double getTotalPrice(Item item) {
		return item.getRetailPrice() * item.getUnitsOnHand();
	}

	public double getMaxRetailPrice(Item item) {
		return (1 + item.getTaxes()) * getTotalPrice(item);
	}

	public double getSaleTaxes(Item item) {
		return item.getTaxes() * getTotalPrice(item);
	}
	
	public void display() {
		System.out.println("1.Biscuit");
		System.out.println("2.chocolate");
		System.out.println("3.Chips");
		System.out.println("4.paracitamol");
		System.out.println("5.avil");
		
	}
	public void display(ArrayList<Item> purchaseItem) {
		double totalMRP =0.0;
		double totalSale = 0.0;
		for (Item item : purchaseItem) {
			System.out.println(item.getUnitsOnHand()+" "+ item.getDescription()+" "+ getMaxRetailPrice(item));
			totalMRP+=getMaxRetailPrice(item);
			totalSale += getSaleTaxes(item);
		}
		System.out.println("tatal sales:"+ totalSale);
		System.out.println("tatal :"+ totalMRP);
	}
}
