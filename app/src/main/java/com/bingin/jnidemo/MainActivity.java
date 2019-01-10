package com.bingin.jnidemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example of a call to a native method
        mTv = (TextView) findViewById(R.id.sample_text);
        mTv.setText(stringFromJNI());

        Button btn_Name = (Button) findViewById(R.id.button1);
        Button btn_Age = (Button) findViewById(R.id.button2);
        Button btn_Other = (Button) findViewById(R.id.button3);
//        startActivity(new Intent(this, JniFirstActivity.class));

        btn_Name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTv.setText(answerFromJni("name"));
            }
        });
        btn_Age.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTv.setText(answerFromJni("age"));
            }
        });
        btn_Other.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTv.setText(answerFromJni("other"));
            }
        });
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
    private native String answerFromJni(String question);

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
        System.loadLibrary("native-bingin");
    }
}
