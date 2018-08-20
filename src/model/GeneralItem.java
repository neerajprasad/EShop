package model;

public class GeneralItem extends Item {

	public GeneralItem() {
		super();
		super.setTaxes(20);
	}

	@Override
	public void displayItem() {
		System.out.println("1.Biscuit:20");
		System.out.println("2.chocolate:50");
		System.out.println("3.Chips:15");
	}

}
