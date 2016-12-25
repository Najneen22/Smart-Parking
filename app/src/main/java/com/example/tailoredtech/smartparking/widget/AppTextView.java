package com.example.tailoredtech.smartparking.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import com.example.tailoredtech.smartparking.R;

public class AppTextView extends TextView {


    public AppTextView(Context context) {
        super(context);
    }

    public AppTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.customView, 0, 0);
        try {
            int fontIndex = typedArray.getInt(R.styleable.customView_textStyle, 0);
            setTextFont(context, fontIndex);
        } finally {
            typedArray.recycle();
        }
    }

    public AppTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setTextFont(Context context, int fontIndex) {
        Typeface typeface = new FontHelper(FontHelper.FONT_OPENSANS).getFont(context,fontIndex);
        setTypeface(typeface);
    }
}
