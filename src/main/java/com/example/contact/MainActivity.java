package com.example.contact;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.contact.Adapter.contactadapter;
import com.example.contact.module.contact;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvContact;
    ArrayList<contact> listContact;
    contactadapter adapter;
    Button btnAdd, btnUpdate;
    RadioButton rbtnNam, rbtnNu;
    EditText etName;
    EditText etNumber;
    int index = -1;


    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);
        SetWidget ();

        lvContact = findViewById (R.id.lvContact);
        listContact = new ArrayList <> ();


        //listContact.add (new contact(false,"0162874523", "banh"));


        adapter = new contactadapter (MainActivity.this, R.layout.list_icon_contact,listContact);

        // do du lieu trong apdater vao listview
        lvContact.setAdapter (adapter);

        lvContact.setOnItemClickListener (new AdapterView.OnItemClickListener () {
            @Override
            public void onItemClick (AdapterView <?> parent, View view, int position, long id) {
                // Toast.makeText (MainActivity.this, position, Toast.LENGTH_SHORT ).show ();
                Toast.makeText (MainActivity.this, " this is number " + listContact.get(position), Toast.LENGTH_SHORT).show ();
                etName.setText (listContact.get(position));
                index = position;
            }
        });

        // xet su kien an du 1 danh sach
        lvContact.setOnItemLongClickListener (new AdapterView.OnItemLongClickListener () {
            @Override
            public boolean onItemLongClick (AdapterView <?> parent, View view, final int position, long id) {
                final AlertDialog.Builder builder = new AlertDialog.Builder (MainActivity.this);
                builder.setTitle (" Notification ");
                builder.setMessage (" Do you want delete this number ? " );
                builder.setPositiveButton (" OK ", new DialogInterface.OnClickListener () {
                    @Override
                    public void onClick (DialogInterface dialog, int which) {
                        Toast.makeText ( MainActivity.this, " Deleted ", Toast.LENGTH_SHORT).show ();
                        listContact.remove (position);
                        adapter.notifyDataSetChanged ();
                    }
                });
                builder.setNegativeButton ("CANCEL", new DialogInterface.OnClickListener () {
                    @Override
                    public void onClick (DialogInterface dialog, int which) {
                        dialog.dismiss ();
                    }
                });
                builder.show ();
                return false;
            }
        });
       // btnUpdate.setOnClickListener (new View.OnClickListener () {
         //   @Override
          //  public void onClick (View v) {
            //    contact contact = new contact ( true, etNumber.getText ().toString (), etName.getText ().toString ());
             //   listContact.set (index, contact);
              //   adapter.notifyDataSetChanged ();
           // }
       // });


    }
    public void SetWidget(){
        btnAdd = findViewById (R.id.btnAdd);
        btnUpdate = findViewById (R.id.btnUpdate);
        rbtnNam = findViewById (R.id.rbtnNam);
        rbtnNu = findViewById (R.id.rbtnNu);
        etName = findViewById (R.id.etName);
        etNumber = findViewById (R.id.etNumber);

    }


    public void ADD (View view) {
        if(view.getId ()==R.id.btnAdd){
            String name = etName.getText ().toString ().trim ();
            String number = etNumber.getText ().toString ().trim ();
            boolean isMale = true;
            if(rbtnNam.isChecked ()){
                isMale = true;
            }
            else {
                isMale = false;
            }
            if(TextUtils.isEmpty (name) || TextUtils.isEmpty (number)){
                Toast.makeText (this, "Please input your number or your name ", Toast.LENGTH_SHORT).show ();
            }
            else {
                contact contact = new contact (isMale, number, name);
                listContact.add (contact);
            }
            adapter.notifyDataSetChanged ();

        }
    }

}
