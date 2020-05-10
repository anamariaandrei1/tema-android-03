package com.example.tema;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

	private Spinner androidVersions;
	private List<String> versions;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.code_challenge_two);
		//setContentView(R.layout.code_challenge_two_screen_two);
		setContentView(R.layout.spinner_sample);
		androidVersions = findViewById(R.id.spinnerAndroidVersions);
		setVersions();
		androidVersions.setAdapter(getSpinnerAdapter());
		androidVersions.setOnItemSelectedListener(new SpinnerActivity());
	}

	private void setVersions() {
		versions = new ArrayList<>();
		versions.add("Cupcake");
		versions.add("Donut");
		versions.add("Eclair");
		versions.add("KitKat");
		versions.add("Pie");
	}

	private ArrayAdapter<String> getSpinnerAdapter() {
		return new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, versions);
	}


}
