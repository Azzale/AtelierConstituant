/*
 * Copyright(c) $year PagesJaunes, SoLocal Group - All Rights Reserved.
 *
 * Unauthorized copying of this file, via any medium is strictly prohibited. Proprietary and confidential
 */
package com.jhilbold.atelierconstituant.metier;

/**
 * //TODO : Add a class header comments
 * <p/>
 * created on 07/04/2015
 *
 * @author PagesJaunes
 * @version //TODO : add version
 */
public class Article
{
	private String id;

	public Article(String s)
	{
		this.id = s;
	}

	public String getId()
	{
		return id;
	}

	@Override
	public String toString()
	{
		return id;
	}
}
