package sddtu.org.protawk;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SignUp extends AppCompatActivity {

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        ActionBar actionBar = getSupportActionBar();

        getSupportActionBar().setTitle("Register Here");
        button = (Button) findViewById(R.id.signup_button);
    }

    public void SignUp(View view) {
        startActivity(new Intent(getApplicationContext(),SPprrofile.class));
    }
}
