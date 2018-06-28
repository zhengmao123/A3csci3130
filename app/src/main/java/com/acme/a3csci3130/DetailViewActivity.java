package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DetailViewActivity extends Activity {

    private EditText bidField, nameField,pbField,addressField,proviceField;
    private Button deleteButton,updateButton;
    Contact receivedPersonInfo;
    private MyApplicationData appState;
    private DatabaseReference data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        appState = ((MyApplicationData) getApplicationContext());
        setContentView(R.layout.activity_detail_view);
        receivedPersonInfo = (Contact)getIntent().getSerializableExtra("Contact");


        deleteButton=(Button)findViewById(R.id.deleteButton);
        updateButton=(Button)findViewById(R.id.updateButton);
        bidField = (EditText) findViewById(R.id.bid);
        nameField = (EditText) findViewById(R.id.name);
        pbField = (EditText) findViewById(R.id.pb);
        addressField = (EditText) findViewById(R.id.address);
        proviceField = (EditText) findViewById(R.id.provice);

        if(receivedPersonInfo != null){
            bidField.setText(receivedPersonInfo.bid);
            nameField.setText(receivedPersonInfo.name);
            pbField.setText(receivedPersonInfo.pb);
            addressField.setText(receivedPersonInfo.address);
            proviceField.setText(receivedPersonInfo.provice);

        }
    }

    /**
     * this function we are ready to update a contact's information after we click on the update button,
     * from the above steps, we choose the object that we are ready to update,and the we use the object
     * to get its uid to help us find the object in FireBase, the we are back to the TextFields to use
     * the function of getText() to get the value of every textFiled, namely the updated value. then we
     * are back to the FireBase to use the setValue() to set the new value of the updated object.
     */
    public void updateContact(View v){
        //TODO: Update contact funcionality
        String personID=receivedPersonInfo.uid;
        String bid=bidField.getText().toString();
        String name=nameField.getText().toString();
        String pb=pbField.getText().toString();
        String address=addressField.getText().toString();
        String provice=proviceField.getText().toString();

        data=FirebaseDatabase.getInstance().getReference();
        data.child("contacts").child(personID).child("bid").setValue(bid);
        data.child("contacts").child(personID).child("name").setValue(name);
        data.child("contacts").child(personID).child("pb").setValue(pb);
        data.child("contacts").child(personID).child("address").setValue(address);
        data.child("contacts").child(personID).child("provice").setValue(provice);
    }

    /**
     * this function is to delete the contact when we click on the delete button, from above steps, we find the
     * contact that we want to delete, then we find the id of the contact from the database, and then use the
     * function of removeValue()to remove the while object.
     */
    public void eraseContact(View v)
    {
        //TODO: Erase contact functionality
        appState.firebaseReference.child(receivedPersonInfo.uid).removeValue();

    }


}
