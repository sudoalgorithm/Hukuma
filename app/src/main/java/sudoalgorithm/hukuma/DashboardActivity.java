package sudoalgorithm.hukuma;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class DashboardActivity extends AppCompatActivity {

    private ImageView mImageView;
    private ListView mListView;
    private CustomAdapter mAdapter;
    private Integer[] imgID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        mImageView = (ImageView) findViewById(R.id.camera);
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DashboardActivity.this, CameraActivity.class));
            }
        });

        imgID = new Integer[]{
                R.drawable.emiratedid,
                R.drawable.silvernolcard,
                R.drawable.rakbank,
                R.drawable.mashreq,
                R.drawable.card
        };

        List<RowItem> items = new ArrayList<RowItem>();
        for (int i = 0; i < imgID.length; i++){
            RowItem item = new RowItem(imgID[i]);
            items.add(item);
        }

        mListView = (ListView) findViewById(R.id.listView);
        mAdapter = new CustomAdapter(this,items);
        mListView.setAdapter(mAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        startActivity(new Intent(DashboardActivity.this,EmiratedIDActivity.class));
                        break;
                    case 1:
                        startActivity(new Intent(DashboardActivity.this,SilverNolCardActivity.class));
                }
            }
        });


    }
}
