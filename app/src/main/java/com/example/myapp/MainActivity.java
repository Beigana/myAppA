package com.example.myapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private BroadcastReceiver MyReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent i) {
            int level = i.getIntExtra("level", 0);
            ProgressBar pb = (ProgressBar) findViewById(R.id.pb);
            pb.setProgress(level);
            TextView Tv = (TextView) findViewById(R.id.Tv);
            Tv.setText("Battery Level: " + Integer.toString(level) + "%");
        }
    };
    private View view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sendMessage(view);
    }
    public void sendMessage(View view) {
        EditText message = (EditText)findViewById(R.id.message);
        Intent intent = new Intent(this,displaymessage.class);
        intent.putExtra("MESSAGE", message.getText().toString());
        startActivity(intent);
        message.setText("");


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //responding to menu items selected
        switch(item.getItemId()){
            case R.id.fore:
                startActivity(new Intent(this,act1.class));
                return true;
            case R.id.bac:
                startActivity(new Intent(this,act2.class));
                return true;

            default:
                return true;

        }

    }
}

