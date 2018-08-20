package model;

public class MedicalItem extends Item {

	public MedicalItem() {
		super();
		super.setTaxes(0);
	}

	@Override
	public void displayItem() {
		System.out.println("1.paracitamol:10");
		System.out.println("2.avil:5");
	}
}
