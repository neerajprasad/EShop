package services;

import model.GeneralItem;
import model.Item;
import model.MedicalItem;

public class FactoryServices {
	Item instance = null;

	public FactoryServices() {
		
	}

	public Item getInstance(ItemEnum itemEnum) {
		switch (itemEnum) {
		case GENERAL:
			instance = new GeneralItem();
			break;

		case MEDICAL:
			instance = new MedicalItem();
			break;
		}
		return instance;
	}
}
