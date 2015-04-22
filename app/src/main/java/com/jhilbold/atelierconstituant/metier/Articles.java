/*
 * Copyright(c) $year PagesJaunes, SoLocal Group - All Rights Reserved.
 *
 * Unauthorized copying of this file, via any medium is strictly prohibited. Proprietary and confidential
 */
package com.jhilbold.atelierconstituant.metier;

import java.util.ArrayList;
import java.util.List;

/**
 * //TODO : Add a class header comments
 * <p/>
 * created on 22/04/2015
 *
 * @author PagesJaunes
 * @version //TODO : add version
 */
public class Articles
{
	public static List<Article> ITEMS = new ArrayList<Article>();
	static {
		ITEMS.add(new Article("1"));
		ITEMS.add(new Article("2"));
		ITEMS.add(new Article("3"));
		ITEMS.add(new Article("4"));
		ITEMS.add(new Article("5"));
		ITEMS.add(new Article("6"));
	}
}
