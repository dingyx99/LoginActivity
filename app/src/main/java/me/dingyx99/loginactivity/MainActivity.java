package me.dingyx99.loginactivity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final int subactivity = 1;
    TextView tv_name;
    Button bt_login;
    EditText et_name;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == subactivity) {
            if(data != null) {
                if(resultCode == RESULT_OK) {
                   Uri uriData = data.getData();
                    tv_name.setText(uriData.toString());
                }
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.father);
        init();
        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ChildActivity.class);
                intent.putExtra("Name",et_name.getText().toString());
                startActivityForResult(intent, subactivity);
            }
        });
    }

    protected void init() {
        tv_name = (TextView) findViewById(R.id.resetName);
        bt_login = (Button) findViewById(R.id.btn_login);
        et_name = (EditText) findViewById(R.id.et_name);
    }
}