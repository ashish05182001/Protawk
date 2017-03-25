package sddtu.org.protawk;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Dell on 3/16/2017.
 */

public class CustomerSPActivity extends Activity {
    Button customerChoose,SPChoose;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitycustomersp);
        customerChoose=(Button)findViewById(R.id.customerbtn);
        SPChoose=(Button)findViewById(R.id.serviceproviderbtn);
        customerChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CustomerSPActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
        SPChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CustomerSPActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
