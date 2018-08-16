package model;

public class MedicalItem extends Item {

	public MedicalItem(String description, int unitsOnHand, double retailPrice) {
		super(description, unitsOnHand, retailPrice);
		super.setTaxes(0.0);
	}

}
