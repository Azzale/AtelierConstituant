/*
 * Copyright(c) $year PagesJaunes, SoLocal Group - All Rights Reserved.
 *
 * Unauthorized copying of this file, via any medium is strictly prohibited. Proprietary and confidential
 */

package com.jhilbold.atelierconstituant;

import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.AbsListView;

import com.jhilbold.atelierconstituant.ui.LayerEnablingAnimatorListenerCompat;
import com.jhilbold.atelierconstituant.ui.SlidingTabLayout;
import com.nineoldandroids.animation.ObjectAnimator;
import com.nineoldandroids.view.ViewHelper;

public class MainActivity extends ActionBarActivity implements AtelierListFragment.Callbacks, PersonneListFragment.Callbacks,ArticleListFragment.Callbacks, View.OnTouchListener
{
	private Toolbar toolbar;
	private ViewPager pager;
	private float mInity;
	private SlidingTabLayout tabs;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		toolbar = (Toolbar) findViewById(R.id.tool_bar);
		setSupportActionBar(toolbar);

		// Creating The ViewPagerAdapter and Passing Fragment Manager, Titles fot the Tabs and Number Of Tabs.
		CharSequence[] titles = {"Ateliers", "Amis", "Articles"};
		ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), titles, 3);

		// Assigning ViewPager View and setting the adapter
		pager = (ViewPager) findViewById(R.id.pager);
		pager.setAdapter(adapter);

		// Assiging the Sliding Tab Layout View
		tabs = (SlidingTabLayout) findViewById(R.id.tabs);
		tabs.setDistributeEvenly(true); // To make the Tabs Fixed set this true, This makes the tabs Space Evenly in Available width

		// Setting Custom Color for the Scroll bar indicator of the Tab View
		tabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer()
		{
			@Override
			public int getIndicatorColor(int position)
			{
				return getResources().getColor(R.color.tabsScrollColor);
			}
		});

		// Setting the ViewPager For the SlidingTabsLayout
		tabs.setViewPager(pager);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		if (id == R.id.action_settings)
		{
			return true;
		}

		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onItemSelected(String id)
	{

	}

//	@Override
//	public void onScrollStateChanged(AbsListView view, int scrollState)
//	{
//
//	}
//
//	@Override
//	public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount)
//	{
//		if(view.getChildAt(firstVisibleItem)!= null)
//		{
//			int scrollY = view.getChildAt(firstVisibleItem).getTop();
//			int toolbarHeight = toolbar.getMeasuredHeight();
//			float translationY = 0;
//			if (scrollY < 0)
//			{
//				translationY = scrollY;
//			}
////			ObjectAnimator animator = ObjectAnimator.ofFloat(toolbar, "translationY", translationY);
////			animator.setInterpolator(new AccelerateInterpolator());
////			animator.setDuration(0);
////
////			animator.addListener(new LayerEnablingAnimatorListenerCompat(toolbar));
////			animator.start();
//
//
//			ViewHelper.setTranslationY(toolbar, scrollY / 2);
//
//			// Translate list background
//			//ViewHelper.setTranslationY(pager, Math.max(0, -scrollY + 300));
//
//		}
//	}

	@Override
	public boolean onTouch(View v, MotionEvent event)
	{
		if(event.getAction() == MotionEvent.ACTION_DOWN)
		{
			mInity = event.getY();
		}
		else if(event.getAction() == MotionEvent.ACTION_MOVE)
		{
			float scrollY = event.getY() - mInity;
			Log.d("test", "y: "+event.getY() + " scrollY: "+scrollY);

			if(scrollY < 0)
				ViewHelper.setTranslationY(toolbar, scrollY / 2);

			if( scrollY> (-toolbar.getHeight()) && scrollY < 0)
				ViewHelper.setTranslationY(tabs, scrollY);
		}
		else if(event.getAction() == MotionEvent.ACTION_UP)
		{
			mInity = 0;
		}
		return false;
	}
}
