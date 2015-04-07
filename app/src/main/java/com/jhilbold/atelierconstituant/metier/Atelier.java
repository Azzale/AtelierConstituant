/*
 * Copyright(c) $year PagesJaunes, SoLocal Group - All Rights Reserved.
 *
 * Unauthorized copying of this file, via any medium is strictly prohibited. Proprietary and confidential
 */

package com.jhilbold.atelierconstituant.metier;

import java.util.ArrayList;

public class Atelier
{
	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getDate()
	{
		return date;
	}

	public void setDate(String date)
	{
		this.date = date;
	}

	public String getLieu()
	{
		return lieu;
	}

	public void setLieu(String lieu)
	{
		this.lieu = lieu;
	}

	public ArrayList<Personne> getInvites()
	{
		return invites;
	}

	public void setInvites(ArrayList<Personne> invites)
	{
		this.invites = invites;
	}

	public ArrayList<Theme> getThemes()
	{
		return themes;
	}

	public void setThemes(ArrayList<Theme> themes)
	{
		this.themes = themes;
	}

	public ArrayList<Article> getArticles()
	{
		return articles;
	}

	public void setArticles(ArrayList<Article> articles)
	{
		this.articles = articles;
	}

	public ArrayList<Rapport> getRapports()
	{
		return rapports;
	}

	public void setRapports(ArrayList<Rapport> rapports)
	{
		this.rapports = rapports;
	}

	public int getPopularite()
	{
		return popularite;
	}

	public void setPopularite(int popularite)
	{
		this.popularite = popularite;
	}

	private String id;
		private String title;
		private String date;
		private String lieu;
		private ArrayList<Personne> invites;
		private ArrayList<Theme> themes;
		private ArrayList<Article> articles;
		private ArrayList<Rapport> rapports;
		private int popularite;

		public Atelier(String id, String content)
		{
			this.id = id;
			this.title = content;
			invites = new ArrayList<>();
			themes = new ArrayList<>();
			articles = new ArrayList<>();
			rapports = new ArrayList<>();
		}

		@Override
		public String toString()
		{
			return title;
		}

}