package sudoalgorithm.hukuma;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class SilverNolCardActivity extends AppCompatActivity {

    private LinearLayout mLinearLayout;
    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_silver_nol_card);

        Toast.makeText(getApplicationContext(), "Activating NFC, Get Ready To Tag", Toast.LENGTH_LONG).show();
        startActivity(new Intent(android.provider.Settings.ACTION_WIRELESS_SETTINGS));


        mLinearLayout = (LinearLayout) findViewById(R.id.activity_silver_nol_card);
        mImageView = (ImageView) findViewById(R.id.nfclogo);
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(mLinearLayout,"Nol Card Tagged",Snackbar.LENGTH_SHORT).show();
            }
        });

    }
}
