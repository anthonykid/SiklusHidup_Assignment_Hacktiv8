package com.example.siklushidup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public EditText mEditText;
    private static final String SAVED_TEXT_KEY = "SAVED_TEXT_KEY";
    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEditText = (EditText) findViewById(R.id.edtText);
        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        mEditText.setText(prefs.getString(SAVED_TEXT_KEY,""));
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(SAVED_TEXT_KEY, mEditText.getText().toString());
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mEditText.setText(savedInstanceState.getString(SAVED_TEXT_KEY));
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(SAVED_TEXT_KEY,mEditText.getText().toString());
        editor.commit();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "Siklus hidup onStart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "Siklus hidup onResume", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "Siklus hidup onPause", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "Siklus hidup onStop", Toast.LENGTH_SHORT).show();
    }
}