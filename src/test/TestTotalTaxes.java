package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import model.GeneralItem;
import model.Item;

public class TestTotalTaxes {
	Item gItem = new GeneralItem("Biscuit", 1, 15);
	@Test
	public void testSalesTax() {
		double st = gItem.getTaxes()*gItem.getUnitsOnHand()*gItem.getRetailPrice();
//		System.out.println(st);
//		System.out.println(gItem.getSaleTaxes());
		assertEquals(st, gItem.getSaleTaxes());
	}
	@Test
	public void testTotalMRP() {
		double mrp = gItem.getTaxes()*gItem.getRetailPrice()+gItem.getRetailPrice();
//		System.out.println(st);
//		System.out.println(gItem.getSaleTaxes());
		assertEquals(mrp, gItem.getMaxRetailPrice());
	}
}
