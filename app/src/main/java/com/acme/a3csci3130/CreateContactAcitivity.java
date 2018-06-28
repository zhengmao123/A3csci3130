package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreateContactAcitivity extends Activity {

    private Button submitButton;
    private EditText bidField, nameField,pbField,addressField,proviceField;
    private MyApplicationData appState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_contact_acitivity);
        //Get the app wide shared variables
        appState = ((MyApplicationData) getApplicationContext());

        submitButton = (Button) findViewById(R.id.submitButton);
        bidField = (EditText) findViewById(R.id.bid);
        nameField = (EditText) findViewById(R.id.name);
        pbField = (EditText) findViewById(R.id.pb);
        addressField = (EditText) findViewById(R.id.address);
        proviceField = (EditText) findViewById(R.id.provice);

    }

    public void submitInfoButton(View v) {
        //each entry needs a unique ID
        String personID = appState.firebaseReference.push().getKey();
        String bid = bidField.getText().toString();
        String name = nameField.getText().toString();
        String pb = pbField.getText().toString();
        String address = addressField.getText().toString();
        String provice= proviceField.getText().toString();

        Contact person = new Contact( personID, bid, name, pb , address, provice);

        appState.firebaseReference.child(personID).setValue(person);

        finish();

    }
}
