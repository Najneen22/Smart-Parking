package com.example.tailoredtech.smartparking.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.EditText;

import com.example.tailoredtech.smartparking.R;

public class AppEditText extends EditText {

    public AppEditText(Context context) {
        super(context);
    }

    public AppEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.customView, 0, 0);
        try {
            int fontIndex = typedArray.getInt(R.styleable.customView_textStyle, 0);
            setTextFont(context, fontIndex);
        } finally {
            typedArray.recycle();
        }
    }

    public AppEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setTextFont(Context context, int fontIndex) {
        Typeface typeface = new FontHelper(FontHelper.FONT_OPENSANS).getFont(context,fontIndex);
        setTypeface(typeface);
    }
}
