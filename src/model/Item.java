package model;

/**
 * Retail item class that holds data about the items
 */

public abstract class Item

{

	// fields
	private String description; // description of item
	private int unitsOnHand; // number of items
	private double retailPrice; // price of item
	private double taxes; // default taxes percentage

	public void setDescription(String type) {
		description = type;
	}

	public void setUnitsOnHand(int unit) {
		unitsOnHand = unit;
	}

	public void setRetailPrice(double price) {
		retailPrice = price;
	}

	public String getDescription() {
		return description;
	}

	public int getUnitsOnHand() {
		return unitsOnHand;
	}

	public double getRetailPrice() {
		return retailPrice;
	}

	public double getTaxes() {
		return taxes;
	}

	public void setTaxes(double taxes) {
		this.taxes = taxes/100.0;
	}

	public abstract void displayItem() ;
}
