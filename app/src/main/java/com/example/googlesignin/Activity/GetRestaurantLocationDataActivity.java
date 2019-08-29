package com.example.googlesignin.Activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.googlesignin.R;

import androidx.appcompat.app.AppCompatActivity;

public class GetRestaurantLocationDataActivity extends AppCompatActivity {


    TextView companyName;
    EditText longitude, latitude;
    Button go;
    String scompanyname, slatitude, slongitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.get_restaurnt_location_data );


        companyName = findViewById( R.id.company_name );
        latitude = findViewById( R.id.latt );
        longitude = findViewById( R.id.longi );
        go = findViewById( R.id.go );

        companyName.setText( getIntent().getExtras().getString( "name" ) );
        latitude.setText( getIntent().getExtras().getString( "lati" ) );
        longitude.setText( getIntent().getExtras().getString( "longi" ) );


    }
}