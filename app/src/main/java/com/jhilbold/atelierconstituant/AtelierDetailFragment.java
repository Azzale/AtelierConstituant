package com.jhilbold.atelierconstituant;

import android.content.Intent;
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
public class AtelierDetailFragment extends Fragment implements View.OnClickListener
{
	/**
	 * The fragment argument representing the item ID that this fragment represents.
	 */
	public static final String ARG_ITEM_ID = "item_id";

	/**
	 * The dummy title this fragment is presenting.
	 */
	private Atelier mItem;
	private boolean mIsInvitesExpanded = false;

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
			final TextView invitesTV = (TextView) rootView.findViewById(R.id.atelier_detail_invite);
			if(mItem.getInvites().size()>0)
			{
				invitesTV.setOnClickListener(this);
				invitesTV.setText("Participants ("+mItem.getInvites().size()+")");
				invitesTV.setCompoundDrawablesWithIntrinsicBounds(0, 0, android.R.drawable.arrow_down_float, 0);
			}
			((TextView) rootView.findViewById(R.id.atelier_detail_theme)).setText(mItem.getThemes().toString());
			((TextView) rootView.findViewById(R.id.atelier_detail_rapport)).setText(mItem.getRapports().toString());
			((TextView) rootView.findViewById(R.id.atelier_detail_article)).setText(mItem.getArticles().toString());
		}

		return rootView;
	}

	@Override
	public void onClick(View v)
	{
		switch (v.getId())
		{
			case R.id.atelier_detail_invite:
				if(mIsInvitesExpanded)
				{
					mIsInvitesExpanded = false;
					Intent i = new Intent(getActivity(), PersonneListActivity.class);
					i.putExtra("atelierID", mItem.getId());
					startActivity(i);
				}
				else
				{
					mIsInvitesExpanded = true;
					getView().findViewById(R.id.atelier_detail_invites_shortlist).setVisibility(View.VISIBLE);
					getView().requestLayout();


				}
				break;
		}
	}
}
