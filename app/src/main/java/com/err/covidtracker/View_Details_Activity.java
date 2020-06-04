package com.err.covidtracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import de.hdodenhof.circleimageview.CircleImageView;

public class View_Details_Activity extends AppCompatActivity {

    TextView one,two,three,four,five,six,seven,eigth,nine,threee,twoo;

    CircleImageView img;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppBarTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view__details_);


        getSupportActionBar().setTitle(getIntent().getStringExtra("country"));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        one=(TextView)findViewById(R.id.one);
        two=(TextView)findViewById(R.id.two);
        three=(TextView)findViewById(R.id.three);
        four=(TextView)findViewById(R.id.four);
        five=(TextView)findViewById(R.id.five);
        six =(TextView)findViewById(R.id.six);
        seven=(TextView)findViewById(R.id.seven);
        eigth =(TextView)findViewById(R.id.eigth);
        nine=(TextView)findViewById(R.id.nine);
        threee=(TextView)findViewById(R.id.threee);
        twoo=(TextView)findViewById(R.id.twoo);
        img=(CircleImageView)findViewById(R.id.img);

        Glide.with(View_Details_Activity.this)
                .load(getIntent().getStringExtra("flag"))
                .into(img);

        one.setText(getIntent().getStringExtra("cases"));
        two.setText(getIntent().getStringExtra("deaths"));
        twoo.setText(getIntent().getStringExtra("recover"));
        three.setText(getIntent().getStringExtra("active"));
        threee.setText(getIntent().getStringExtra("critical"));
        four.setText(getIntent().getStringExtra("tcases"));
        five.setText(getIntent().getStringExtra("tdeaths"));
        six.setText(getIntent().getStringExtra("cpm"));
        seven.setText(getIntent().getStringExtra("tpm"));
        eigth.setText(getIntent().getStringExtra("ddm"));
        nine.setText(getIntent().getStringExtra("cont"));






    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
