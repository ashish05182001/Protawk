package sddtu.org.protawk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ShareActionProvider;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;

import org.w3c.dom.Text;


/**
 * Created by Dell on 3/16/2017.
 */

public class LoginActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener{
    Button signIn;
    SignInButton googleSignInButton;
    TextView nametv,emailtv;
    ImageView UserImage;
    LinearLayout drawerLayout;
    GoogleApiClient googleApiClient;
    static  final int REQUEST_CODE=9001;
    int signInCheckInt=0;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginactivity);
        drawerLayout=(LinearLayout)findViewById(R.id.drawer_layout) ;
        googleSignInButton=(SignInButton)findViewById(R.id.googleSignInBtn);
        nametv=(TextView) findViewById(R.id.nametv);
        emailtv=(TextView)findViewById(R.id.emailtv);
        UserImage=(ImageView)findViewById(R.id.userimage);

        GoogleSignInOptions googleSignInOptions=new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail().build();
        googleApiClient=new GoogleApiClient.Builder(this).enableAutoManage(this,this)
                .addApi(Auth.GOOGLE_SIGN_IN_API,googleSignInOptions).build();



        googleSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
                startActivityForResult(intent,REQUEST_CODE);
            }
        });


        signIn=(Button)findViewById(R.id.signin);
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==REQUEST_CODE){
            GoogleSignInResult result=Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleResult(result);
        }
    }

    private void handleResult(GoogleSignInResult result){
        if(result.isSuccess()){
            GoogleSignInAccount account=result.getSignInAccount();

            if (account != null) {
                String name = account.getDisplayName();
                String email=account.getEmail();
                String image=account.getPhotoUrl().toString();
                signInCheckInt=1;
                SharedPreferences sharedPreferences=getSharedPreferences("GoogleInt", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putInt("GInt",signInCheckInt);
                editor.putString("GName",name);
                editor.putString("GEmail",email);
                editor.putString("GPic",image);
                editor.commit();

                Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);
            }


        }
    }
}
