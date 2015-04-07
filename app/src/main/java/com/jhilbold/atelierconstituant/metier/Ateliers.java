package com.jhilbold.atelierconstituant.metier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample title for user interfaces created by Android template
 * wizards.
 * <p/>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class Ateliers
{

	/**
	 * An array of sample (dummy) items.
	 */
	public static List<Atelier> ITEMS = new ArrayList<Atelier>();

	/**
	 * A map of sample (dummy) items, by ID.
	 */
	public static Map<String, Atelier> ITEM_MAP = new HashMap<String, Atelier>();

	static
	{
		// Add 3 sample items.
		final Atelier item = new Atelier("1", "Atelier 1 à paris");
		item.setDate("le 3 janvier");
		item.setLieu("Paris 14");
		addItem(item);
		addItem(new Atelier("2", "Atelier 2 à paris"));
		addItem(new Atelier("3", "Atelier 3"));
	}

	private static void addItem(Atelier item)
	{
		ITEMS.add(item);
		ITEM_MAP.put(item.getId(), item);
	}

}
