/*
 * Copyright(c) $year PagesJaunes, SoLocal Group - All Rights Reserved.
 *
 * Unauthorized copying of this file, via any medium is strictly prohibited. Proprietary and confidential
 */
package com.jhilbold.atelierconstituant.ui;

import android.os.Build;
import android.view.View;

import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorListenerAdapter;

/**
 * An AnimatorListener to switch to layer type Hardware and have a fast animation.
 * <p/>
 * created on 10/03/15
 *
 * @author sluu
 */
public class LayerEnablingAnimatorListenerCompat extends AnimatorListenerAdapter
{
	private final View mTargetView;

	private int mLayerType;

	public LayerEnablingAnimatorListenerCompat(View targetView) {
		mTargetView = targetView;
	}

	public View getTargetView() {
		return mTargetView;
	}

	@Override
	public void onAnimationStart(Animator animation) {
		super.onAnimationStart(animation);
		if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB)
		{
			mLayerType = mTargetView.getLayerType();
			mTargetView.setLayerType(View.LAYER_TYPE_HARDWARE, null);
		}
	}

	@Override
	public void onAnimationEnd(Animator animation) {
		super.onAnimationEnd(animation);
		if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB)
		{
			mTargetView.setLayerType(mLayerType, null);
		}
	}

}
