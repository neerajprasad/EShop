package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import model.GeneralItem;
import model.Item;
import model.MedicalItem;
import services.RetailServices;
// given - when -then
public class TestTotalTaxes {
	RetailServices retailServices = new RetailServices();
	
	public void setUp() {
		Item med_item = new MedicalItem();
		med_item.setDescription("paracitamol");
		med_item.setUnitsOnHand(2);
		med_item.setRetailPrice(20);
		retailServices.addItem(med_item);
		
		Item gitem = new GeneralItem();
		gitem.setDescription("biscuit");
		gitem.setUnitsOnHand(2);
		gitem.setRetailPrice(20);
		retailServices.addItem(gitem);
		
		Item gen_1 = new GeneralItem();
		gen_1.setDescription("Chips");
		gen_1.setUnitsOnHand(1);
		gen_1.setRetailPrice(15);
		retailServices.addItem(gen_1);
	}
	@Test
	public void test_GIVEN_General_item_THEN_20_percentage_tax() {
		Item item = new GeneralItem();
		item.setDescription("biscuit");
		item.setUnitsOnHand(2);
		item.setRetailPrice(20);
//		double st = 0.20*2*20;
		double st = item.getTaxes()*item.getUnitsOnHand()*item.getRetailPrice();
		assertEquals(st, retailServices.getSaleTaxes(item));
	}
	@Test
	public void test_GIVEN_medical_item_THEN_0_percentage_tax() {
		Item item = new MedicalItem();
		item.setDescription("paracitamol");
		item.setUnitsOnHand(2);
		item.setRetailPrice(20);
//		double st = 0.20*2*20;
		double st = item.getTaxes()*item.getUnitsOnHand()*item.getRetailPrice();
		assertEquals(st, retailServices.getSaleTaxes(item));
	}
	@Test
	public void test_GIVEN_item_WHEN_default_percentage_THEN_total_mrp() {
		setUp();
		
		ArrayList<Item> items = retailServices.getAllItem();
		double totalMRP =0.0;
		for (Item item : items) {
			totalMRP +=retailServices.getMaxRetailPrice(item);
		}
		double test_mrp=0.0;
		for (Item item : items) {
			test_mrp +=(1+item.getTaxes())*item.getRetailPrice()*item.getUnitsOnHand();
		}
		assertEquals(test_mrp, totalMRP);
	}
	@Test
	public void test_GIVEN_item_WHEN_default_percentage_THEN_total_sale_tax() {
		setUp();
		
		ArrayList<Item> items = retailServices.getAllItem();
		double salesTax =0.0;
		for (Item item : items) {
			salesTax +=retailServices.getSaleTaxes(item);
		}
		double test_salesTax=0.0;
		for (Item item : items) {
			test_salesTax +=(item.getTaxes())*item.getRetailPrice()*item.getUnitsOnHand();
		}
		assertEquals(test_salesTax, salesTax);
	}
	@Test
	public void test_GIVEN_gen_item_WHEN_10_percentage_THEN_total_sale_tax() {
		Item item = new GeneralItem();
		item.setDescription("paracitamol");
		item.setUnitsOnHand(2);
		item.setRetailPrice(20);
		item.setTaxes(10);

		double test_salesTax =(item.getTaxes())*item.getRetailPrice()*item.getUnitsOnHand();
		assertEquals(test_salesTax, retailServices.getSaleTaxes(item));
		
	}
	@Test
	public void test_GIVEN_item_WHEN_0_unit_item_THEN_total_sale_tax() {
		Item item = new GeneralItem();
		item.setDescription("paracitamol");
		item.setUnitsOnHand(0);
		item.setRetailPrice(20);
		assertEquals(0, retailServices.getSaleTaxes(item));
		
	}
}
