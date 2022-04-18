package com.example.diexpml.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;

import com.example.diexpml.R;

public class PageIndicator extends View {
    public PageIndicator(Context context, AttributeSet attributeSet) {
        super(context,attributeSet);
        TypedArray typedArray = getContext().obtainStyledAttributes(attributeSet, R.styleable.PageIndicator);
        int count = typedArray.getInt(R.styleable.PageIndicator_pi_count,0);
        typedArray.recycle();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
