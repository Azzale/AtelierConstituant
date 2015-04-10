/*
 * Copyright(c) $year PagesJaunes, SoLocal Group - All Rights Reserved.
 *
 * Unauthorized copying of this file, via any medium is strictly prohibited. Proprietary and confidential
 */

package com.jhilbold.atelierconstituant;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;

/**
 * An activity representing a list of Personnes. This activity has different presentations for
 * handset and tablet-size devices. On handsets, the activity presents a list of items, which when
 * touched, lead to a {@link PersonneDetailActivity} representing item details. On tablets, the
 * activity presents the list of items and item details side-by-side using two vertical panes.
 * <p/>
 * The activity makes heavy use of fragments. The list of items is a {@link PersonneListFragment}
 * and the item details (if present) is a {@link PersonneDetailFragment}.
 * <p/>
 * This activity also implements the required {@link PersonneListFragment.Callbacks} interface to
 * listen for item selections.
 */
public class PersonneListActivity extends ActionBarActivity implements PersonneListFragment.Callbacks
{

	/**
	 * Whether or not the activity is in two-pane mode, i.e. running on a tablet device.
	 */
	private boolean mTwoPane;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_personne_list);

		if (findViewById(R.id.personne_detail_container) != null)
		{
			// The detail container view will be present only in the
			// large-screen layouts (res/values-large and
			// res/values-sw600dp). If this view is present, then the
			// activity should be in two-pane mode.
			mTwoPane = true;

			// In two-pane mode, list items should be given the
			// 'activated' state when touched.
			((PersonneListFragment) getSupportFragmentManager().findFragmentById(R.id.personne_list)).setActivateOnItemClick(true);
		}

		// TODO: If exposing deep links into your app, handle intents here.
	}

	/**
	 * Callback method from {@link PersonneListFragment.Callbacks} indicating that the item with the
	 * given ID was selected.
	 */
	@Override
	public void onItemSelected(String id)
	{
		if (mTwoPane)
		{
			// In two-pane mode, show the detail view in this activity by
			// adding or replacing the detail fragment using a
			// fragment transaction.
			Bundle arguments = new Bundle();
			arguments.putString(PersonneDetailFragment.ARG_ITEM_ID, id);
			PersonneDetailFragment fragment = new PersonneDetailFragment();
			fragment.setArguments(arguments);
			getSupportFragmentManager().beginTransaction().replace(R.id.personne_detail_container, fragment).commit();

		}
		else
		{
			// In single-pane mode, simply start the detail activity
			// for the selected item ID.
			Intent detailIntent = new Intent(this, PersonneDetailActivity.class);
			detailIntent.putExtra(PersonneDetailFragment.ARG_ITEM_ID, id);
			startActivity(detailIntent);
		}
	}
}
