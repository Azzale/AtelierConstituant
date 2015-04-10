/*
 * Copyright(c) $year PagesJaunes, SoLocal Group - All Rights Reserved.
 *
 * Unauthorized copying of this file, via any medium is strictly prohibited. Proprietary and confidential
 */

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
public class Personnes
{

	/**
	 * An array of sample (dummy) items.
	 */
	public static List<Personne> ITEMS = new ArrayList<Personne>();

	/**
	 * A map of sample (dummy) items, by ID.
	 */
	public static Map<String, Personne> ITEM_MAP = new HashMap<String, Personne>();

	static
	{
		// Add 3 sample items.
		final Personne item = new Personne();
		item.setId("1");
		item.setNom("toto");
		item.setPrenom("salut");
		item.setTelephone("01 02 03 04 05");
		addItem(item);
		final Personne item1 = new Personne();
		item1.setId("2");
		item1.setNom("tata");
		addItem(item1);
		final Personne item2 = new Personne();
		item2.setId("3");
		addItem(item2);
	}

	private static void addItem(Personne item)
	{
		ITEMS.add(item);
		ITEM_MAP.put(item.getId(), item);
	}

}
