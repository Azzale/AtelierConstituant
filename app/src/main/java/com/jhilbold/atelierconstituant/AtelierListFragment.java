package com.jhilbold.atelierconstituant;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.transition.TransitionInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.jhilbold.atelierconstituant.metier.Atelier;
import com.jhilbold.atelierconstituant.metier.Ateliers;

/**
 * A list fragment representing a list of Ateliers. This fragment also supports tablet devices by
 * allowing list items to be given an 'activated' state upon selection. This helps indicate which
 * item is currently being viewed in a {@link AtelierDetailFragment}.
 * <p/>
 * Activities containing this fragment MUST implement the {@link Callbacks} interface.
 */
public class AtelierListFragment extends ListFragment
{

	/**
	 * The serialization (saved instance state) Bundle key representing the activated item position.
	 * Only used on tablets.
	 */
	private static final String STATE_ACTIVATED_POSITION = "activated_position";

	/**
	 * The fragment's current callback object, which is notified of list item clicks.
	 */
	private Callbacks mCallbacks = null;

	/**
	 * The current activated item position. Only used on tablets.
	 */
	private int mActivatedPosition = ListView.INVALID_POSITION;

	/**
	 * A callback interface that all activities containing this fragment must implement. This
	 * mechanism allows activities to be notified of item selections.
	 */
	public interface Callbacks
	{
		/**
		 * Callback for when an item has been selected.
		 */
		public void onAtelierSelected(ListView lv, View view, Atelier a);
	}

	/**
	 * Mandatory empty constructor for the fragment manager to instantiate the fragment (e.g. upon
	 * screen orientation changes).
	 */
	public AtelierListFragment()
	{
	}

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);


		// TODO: replace with a real list adapter.
		setListAdapter(new ArrayAdapter<Atelier>(getActivity(), R.layout.default_list_item, R.id.li_text, Ateliers.ITEMS));

	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState)
	{
		super.onViewCreated(view, savedInstanceState);

		// Restore the previously serialized activated item position.
		if (savedInstanceState != null && savedInstanceState.containsKey(STATE_ACTIVATED_POSITION))
		{
			setActivatedPosition(savedInstanceState.getInt(STATE_ACTIVATED_POSITION));
		}
		View header = getLayoutInflater(savedInstanceState).inflate(R.layout.atelier_list_header, null);
		((TextView)header.findViewById(R.id.atelier_list_header_title)).setText("Ateliers constituants");
		getListView().addHeaderView(header, null, false);
		getListView().setDividerHeight(0);
		getListView().setOnTouchListener((View.OnTouchListener) getActivity());
		getListView().setClipToPadding(false);
		getListView().setScrollBarStyle(View.SCROLLBARS_OUTSIDE_OVERLAY);
	}

	@Override
	public void onAttach(Activity activity)
	{
		super.onAttach(activity);

		// Activities containing this fragment must implement its callbacks.
		if (!(activity instanceof Callbacks))
		{
			throw new IllegalStateException("Activity must implement fragment's callbacks.");
		}

		mCallbacks = (Callbacks) activity;
	}

	@Override
	public void onDetach()
	{
		super.onDetach();

		// Reset the active callbacks interface to the dummy implementation.
		mCallbacks = null;
	}

	@Override
	public void onListItemClick(ListView listView, View view, int position, long id)
	{
		position -= listView.getHeaderViewsCount();

		super.onListItemClick(listView, view, position, id);

		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			setSharedElement();
		}


		// Notify the active callbacks interface (the activity, if the
		// fragment is attached to one) that an item has been selected.
		mCallbacks.onAtelierSelected(listView, view, Ateliers.ITEMS.get(position));
	}

	@TargetApi(Build.VERSION_CODES.KITKAT)
	private void setSharedElement()
	{
		setSharedElementReturnTransition(TransitionInflater.from(getActivity()).inflateTransition(R.transition.list_to_detail));
		setExitTransition(TransitionInflater.from(getActivity()).inflateTransition(android.R.transition.explode));
	}

	@Override
	public void onSaveInstanceState(Bundle outState)
	{
		super.onSaveInstanceState(outState);
		if (mActivatedPosition != ListView.INVALID_POSITION)
		{
			// Serialize and persist the activated item position.
			outState.putInt(STATE_ACTIVATED_POSITION, mActivatedPosition);
		}
	}

	/**
	 * Turns on activate-on-click mode. When this mode is on, list items will be given the
	 * 'activated' state when touched.
	 */
	public void setActivateOnItemClick(boolean activateOnItemClick)
	{
		// When setting CHOICE_MODE_SINGLE, ListView will automatically
		// give items the 'activated' state when touched.
		getListView().setChoiceMode(activateOnItemClick
									? ListView.CHOICE_MODE_SINGLE
									: ListView.CHOICE_MODE_NONE);
	}

	private void setActivatedPosition(int position)
	{
		if (position == ListView.INVALID_POSITION)
		{
			getListView().setItemChecked(mActivatedPosition, false);
		}
		else
		{
			getListView().setItemChecked(position, true);
		}

		mActivatedPosition = position;
	}
}
