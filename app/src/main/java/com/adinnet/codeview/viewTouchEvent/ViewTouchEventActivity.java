package com.adinnet.codeview.viewTouchEvent;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.adinnet.codeview.R;


/**
 * @author zoujian.
 * @date 2018/9/18
 * android 触摸事件传递机制
 */

public class ViewTouchEventActivity extends AppCompatActivity implements View.OnClickListener,View.OnTouchListener{

    private static final String TAG = "ViewTouchEventActivity";
    private MyTextView mTextView ;

    @Override

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_touch_event_activity);
        mTextView = (MyTextView) findViewById(R.id.myTextView);
        mTextView.setOnClickListener(this);
        mTextView.setOnTouchListener(this);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:
                Log.e(TAG,"dispatchTouchEvent ACTION DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e(TAG,"dispatchTouchEvent ACTION MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.e(TAG,"dispatchTouchEvent ACTION UP");
                break;
            case MotionEvent.ACTION_CANCEL:
                Log.e(TAG,"dispatchTouchEvent ACTION CANCEL");
                break;
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                Log.e(TAG,"onTouchEvent ACTION DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e(TAG,"onTouchEvent ACTION MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.e(TAG,"onTouchEvent ACTION UP");
                break;
            case MotionEvent.ACTION_CANCEL:
                Log.e(TAG,"onTouchEvent ACTION CANCEL");
                break;
        }
        return super.onTouchEvent(event);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.myTextView:
                Log.e(TAG,"MyTextView onClick");
                break;
            default:
                break;
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (v.getId()){
            case R.id.myTextView:
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        Log.e(TAG,"MyTextView onTouchEvent ACTION DOWN");
                        break;
                    case MotionEvent.ACTION_MOVE:
                        Log.e(TAG,"MyTextView onTouchEvent ACTION MOVE");
                        break;
                    case MotionEvent.ACTION_UP:
                        Log.e(TAG,"MyTextView onTouchEvent ACTION UP");
                        break;
                    case MotionEvent.ACTION_CANCEL:
                        Log.e(TAG,"MyTextView onTouchEvent ACTION CANCEL");
                        break;
                }
                break;
            default:
                break;
        }
        return false;
    }
}
