package com.example.googlesignin;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.googlesignin.Adapter.RestaurntDataAdapter;
import com.example.googlesignin.Event.ResturantDataEvent;
import com.example.googlesignin.Mananger.ResturantMananger;
import com.example.googlesignin.Model.DegreeDataModel;
import com.example.googlesignin.Model.RestaurantDataModel;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import de.greenrobot.event.EventBus;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, GoogleApiClient.OnConnectionFailedListener {

    private Context mAppContext;
    private LinearLayout Prof_section;
    private Button SignOUt;
    private SignInButton SignIn;
    private TextView Name, Email;
    private ImageView porf_pic;
    private GoogleApiClient googleApiClient;
    private static final int REQ_CODE = 9001;

    RecyclerView resaurantDataRecycler;
    RestaurntDataAdapter restaurntDataAdapter;
    public static List<RestaurantDataModel> restaurantDataModels;
    public static List<DegreeDataModel> degreeDataModels;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        EventBus.getDefault().register( this );
        Prof_section = findViewById( R.id.prof_selection );
        SignOUt = findViewById( R.id.btn_logout );
        SignIn = findViewById( R.id.btn_login );
        Name = findViewById( R.id.prof_name );
        Email = findViewById( R.id.prof_email );
        porf_pic = findViewById( R.id.prof_pic );
        SignIn.setOnClickListener( this );
        SignOUt.setOnClickListener( this );
        Prof_section.setVisibility( View.GONE );

        resaurantDataRecycler = findViewById( R.id.restaurant_recycler );

        mAppContext = getApplicationContext();
        PMAppSession.getInstance( mAppContext, new AppConfig( mAppContext ) );
        ResturantMananger.getInstance().restaurntData();


        GoogleSignInOptions signInOptions = new GoogleSignInOptions.Builder( GoogleSignInOptions.DEFAULT_SIGN_IN ).requestEmail().build();

        googleApiClient = new GoogleApiClient.Builder( this ).enableAutoManage( this, this ).addApi( Auth.GOOGLE_SIGN_IN_API, signInOptions ).build();
    }

    public void onEvent(ResturantDataEvent resturantDataEvent) {


        restaurantDataModels = resturantDataEvent.getRestaurantDataModelList();
        resaurantDataRecycler.setHasFixedSize( true );
        resaurantDataRecycler.setLayoutManager( new LinearLayoutManager( getApplicationContext() ) );
        restaurntDataAdapter = new RestaurntDataAdapter( getApplicationContext(), restaurantDataModels, degreeDataModels );
        resaurantDataRecycler.setAdapter( restaurntDataAdapter );


    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_login:
                signIn();
                break;
            case R.id.btn_logout:
                signOut();
                break;

        }

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    private void signIn() {
        Intent intent = Auth.GoogleSignInApi.getSignInIntent( googleApiClient );
        startActivityForResult( intent, REQ_CODE );

    }


    private void signOut() {
        Auth.GoogleSignInApi.signOut( googleApiClient ).setResultCallback( new ResultCallback<Status>() {
            @Override
            public void onResult(@NonNull Status status) {
                updateUI( false );

            }
        } );

    }

    private void handleResult(GoogleSignInResult result) {

        if (result.isSuccess()) {
            GoogleSignInAccount account = result.getSignInAccount();
            String name = account.getDisplayName();
            String email = account.getEmail();
            //   String spider = "https://www.google.com/search?q=spiderman&tbm=isch&source=iu&ictx=1&fir=wEyNlPzHnzwvIM%253A%252CtQYLjkUHejOAvM%252C%252Fm%252F06ys2&vet=1&usg=AI4_-kQat7uzu5Byo0cAya__6KCL368hVA&sa=X&ved=2ahUKEwjWzunvlafkAhVPknAKHZ6GCMUQ_B0wIHoECAkQAw#imgrc=wEyNlPzHnzwvIM:";

            //  String img_url =( account.getPhotoUrl().toString() );


            Name.setText( name );
            Email.setText( email );
            // Glide.with( this ).load( img_url ).into( porf_pic );
            updateUI( true );


        } else {
            updateUI( false );
        }

    }

    private void updateUI(boolean isLogin) {

        if (isLogin) {
            Prof_section.setVisibility( View.VISIBLE );
            SignIn.setVisibility( View.GONE );
        } else {
            Prof_section.setVisibility( View.GONE );
            SignIn.setVisibility( View.VISIBLE );
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult( requestCode, resultCode, data );

        if (requestCode == REQ_CODE) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent( data );
            handleResult( result );
        }
    }
}
