package cn.jzvd.demo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import cn.jzvd.demo.R;

/**
 * Created by Nathen on 16/8/23.
 */
public class AutoTinyActivity extends AppCompatActivity implements View.OnClickListener {

    Button normal, list;
    private Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        requestWindowFeature(Window.FEATURE_ACTION_BAR);

        mContext = getApplicationContext();

        int m = AppCompatDelegate.getDefaultNightMode();

        if(m==AppCompatDelegate.MODE_NIGHT_YES) {
            WindowManager.LayoutParams lp = getWindow().getAttributes();
            lp.screenBrightness = Float.parseFloat("0.2");
            getWindow().setAttributes(lp);
        }
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayUseLogoEnabled(false);
        getSupportActionBar().setTitle("AutoTinyWindow");
        setContentView(R.layout.activity_auto_tiny);
        normal = (Button) findViewById(R.id.screen_normal);
        list = (Button) findViewById(R.id.screen_list);

        normal.setOnClickListener(this);
        list.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.screen_normal:
                startActivity(new Intent(this, AutoTinyNormalActivity.class));
                break;
            case R.id.screen_list:
                startActivity(new Intent(this, AutoTinyListActivity.class));
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
