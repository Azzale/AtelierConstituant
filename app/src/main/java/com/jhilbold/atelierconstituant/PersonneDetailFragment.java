/*
 * Copyright(c) $year PagesJaunes, SoLocal Group - All Rights Reserved.
 *
 * Unauthorized copying of this file, via any medium is strictly prohibited. Proprietary and confidential
 */

package com.jhilbold.atelierconstituant;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jhilbold.atelierconstituant.metier.Personne;
import com.jhilbold.atelierconstituant.metier.Personnes;

/**
 * A fragment representing a single Personne detail screen. This fragment is either contained in a
 * {@link PersonneListActivity} in two-pane mode (on tablets) or a {@link PersonneDetailActivity} on
 * handsets.
 */
public class PersonneDetailFragment extends Fragment
{
	/**
	 * The fragment argument representing the item ID that this fragment represents.
	 */
	public static final String ARG_ITEM_ID = "item_id";

	/**
	 * The dummy content this fragment is presenting.
	 */
	private Personne mItem;

	/**
	 * Mandatory empty constructor for the fragment manager to instantiate the fragment (e.g. upon
	 * screen orientation changes).
	 */
	public PersonneDetailFragment()
	{
	}

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		if (getArguments().containsKey(ARG_ITEM_ID))
		{
			// Load the dummy content specified by the fragment
			// arguments. In a real-world scenario, use a Loader
			// to load content from a content provider.
			mItem = Personnes.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		View rootView = inflater.inflate(R.layout.fragment_personne_detail, container, false);

		// Show the dummy content as text in a TextView.
		if (mItem != null)
		{
			((TextView) rootView.findViewById(R.id.personne_detail_nom)).setText(mItem.getPrenom()+ " "+ mItem.getNom());
			((TextView) rootView.findViewById(R.id.personne_detail_photo)).setText(mItem.getPhotoUrl());
			((TextView) rootView.findViewById(R.id.personne_detail_telephone)).setText(mItem.getTelephone());
		}

		return rootView;
	}
}
