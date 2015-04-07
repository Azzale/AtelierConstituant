package com.jhilbold.atelierconstituant;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jhilbold.atelierconstituant.metier.Atelier;
import com.jhilbold.atelierconstituant.metier.Ateliers;

/**
 * A fragment representing a single Atelier detail screen. This fragment is either contained in a
 * {@link AtelierListActivity} in two-pane mode (on tablets) or a {@link AtelierDetailActivity} on
 * handsets.
 */
public class AtelierDetailFragment extends Fragment
{
	/**
	 * The fragment argument representing the item ID that this fragment represents.
	 */
	public static final String ARG_ITEM_ID = "item_id";

	/**
	 * The dummy title this fragment is presenting.
	 */
	private Atelier mItem;

	/**
	 * Mandatory empty constructor for the fragment manager to instantiate the fragment (e.g. upon
	 * screen orientation changes).
	 */
	public AtelierDetailFragment()
	{
	}

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		if (getArguments().containsKey(ARG_ITEM_ID))
		{
			// Load the dummy title specified by the fragment
			// arguments. In a real-world scenario, use a Loader
			// to load title from a title provider.
			mItem = Ateliers.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		View rootView = inflater.inflate(R.layout.fragment_atelier_detail, container, false);

		// Show the dummy title as text in a TextView.
		if (mItem != null)
		{
			((TextView) rootView.findViewById(R.id.atelier_detail_title)).setText(mItem.getTitle());
			((TextView) rootView.findViewById(R.id.atelier_detail_date)).setText(mItem.getDate());
			((TextView) rootView.findViewById(R.id.atelier_detail_lieu)).setText(mItem.getLieu());
			((TextView) rootView.findViewById(R.id.atelier_detail_invite)).setText(mItem.getInvites().toString());
			((TextView) rootView.findViewById(R.id.atelier_detail_theme)).setText(mItem.getThemes().toString());
			((TextView) rootView.findViewById(R.id.atelier_detail_rapport)).setText(mItem.getRapports().toString());
			((TextView) rootView.findViewById(R.id.atelier_detail_article)).setText(mItem.getArticles().toString());
		}

		return rootView;
	}
}
