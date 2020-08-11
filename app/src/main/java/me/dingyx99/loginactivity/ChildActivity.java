package me.dingyx99.loginactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ChildActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.child);

        final EditText et_name = (EditText) findViewById(R.id.et_name);
        Button btn_sure = (Button)findViewById(R.id.btn_login);
        TextView tv_username = (TextView) findViewById(R.id.resetName);

        Intent data = getIntent();
        tv_username.setText(data.getStringExtra("Name"));

        btn_sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uriString = et_name.getText().toString();
                Uri data = Uri.parse(uriString);
                Intent result = new Intent(null, data);
                setResult(RESULT_OK, result);
                finish();
            }
        });
    }
}