package com.example.tema;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

	private EditText emailAddressEditText;
	private EditText phoneEditText;
	private CheckBox termsCheckBox;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		emailAddressEditText = findViewById(R.id.emailAddressEditText);
		phoneEditText = findViewById(R.id.phoneEditText);
		termsCheckBox = findViewById(R.id.termsCheckbox);
	}

	@SuppressLint("SetTextI18n")
	public void loginOnClick(View view) {
		String email = emailAddressEditText.getText().toString();
		String phone = phoneEditText.getText().toString();
		if (!isValidEmail(email)) {
			emailAddressEditText.setError(getString(R.string.error_validate_mail));
		}
		if (!isValidPhone(phone)) {
			phoneEditText.setError(getString(R.string.error_validate_phone));
		}
		if (!termsCheckBox.isChecked()) {
			Toast.makeText(this, "Please accept terms & contitions", Toast.LENGTH_LONG).show();
		}
		if (!email.isEmpty() || !phone.isEmpty()) {
			TextView submittedValues = (TextView) findViewById(R.id.submittedValues);
			submittedValues.setText("Email: " + email + "Phone: " + phone + " Terms & conditions: " + termsCheckBox.isChecked());
		}
	}

	public static boolean isValidEmail(CharSequence target) {
		return (Patterns.EMAIL_ADDRESS.matcher(target).matches());
	}

	public static boolean isValidPhone(CharSequence target) {
		return (Patterns.PHONE.matcher(target).matches());
	}
}
