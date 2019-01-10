package com.bingin.jnidemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by bingin on 2019/1/4.
 */

public class JniFirstActivity extends AppCompatActivity {

    private static final String TAG = "JniFirstActivity";

    static {
        System.loadLibrary("jni_first");
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        TextView tvFirst = (TextView) findViewById(R.id.tv_first);

        String retStr = jniFistMothod(" Para1 from JniFirstActivity.java ");
        Log.d(TAG, "onCreate: " + retStr);

        tvFirst.setText(retStr);
    }

    private native String jniFistMothod(String para1);
}
