package model;



public class GeneralItem extends Item{
	public GeneralItem(String description, int unitsOnHand, double retailPrice) {
		super(description, unitsOnHand, retailPrice);
		super.setTaxes(0.20);
	}

}
