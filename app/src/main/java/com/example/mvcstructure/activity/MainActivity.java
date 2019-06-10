package com.example.mvcstructure.activity;

import android.os.Build;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.mvcstructure.R;
import com.example.mvcstructure.fragment.MainFragment;
import com.example.mvcstructure.fragment.SecondFragment;
import com.example.mvcstructure.util.ScreenUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int screenWidth = ScreenUtil.getInstance().getScreenWidth();
        int screenHeight = ScreenUtil.getInstance().getScreenHeight();
        Toast.makeText(this,
                "Height = " + screenHeight + "Width = " + screenWidth,
                Toast.LENGTH_LONG).show();
        if (Build.VERSION.SDK_INT >= 21) {
            //over android 21
        } else {

        }
        if (savedInstanceState == null) {
            //First Created
            //Place Fragment here
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contentContainer
                            , MainFragment.newInstance(123)
                            , "MainFragment")
                    .commit();


            SecondFragment secondFragment = SecondFragment.newInstance();

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contentContainer
                            , secondFragment
                            , "SecondFragment")
                    .detach(secondFragment)
                    .commit();
        }
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        if (savedInstanceState == null) {
            MainFragment fragmentByTag = (MainFragment)
                    getSupportFragmentManager().findFragmentByTag("MainFragment");
            fragmentByTag.setText("Hi from Activity\n\n\n\n\n\n\n\n\n\n\n\nasaacxascascas\naadna\ndanda\nandandandand\nad\nadna\nandandandand\nad\nadna\nandandandand\nad\nadna\nandandandand\nad\nadna\nandandandand\nad\nadna\nandandandand\nad\nadna\nandandandand\nad\nadna\nandandandand\nad\nadna\nandandandand\nad\nadna\nandandandand\nad\nadna\nandandandand\nad\nadna");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_second_fragment: {

                Fragment fragment = (Fragment)
                        getSupportFragmentManager().findFragmentById(R.id.contentContainer);
                if (fragment instanceof SecondFragment == false) {
                    getSupportFragmentManager().beginTransaction()
//                            .setCustomAnimations(R.anim.from_right, R.anim.to_left, R.anim.from_left, R.anim.to_right)
                            .replace(R.id.contentContainer, SecondFragment.newInstance())
                            .addToBackStack(null)
                            .commit();
                }
                return true;
            }
            case R.id.action_first_tab: {

                MainFragment mainFragment = (MainFragment)
                        getSupportFragmentManager().findFragmentByTag("MainFragment");
                SecondFragment secondFragment = (SecondFragment)
                        getSupportFragmentManager().findFragmentByTag("SecondFragment");
                getSupportFragmentManager().beginTransaction()
                        .attach(mainFragment)
                        .detach(secondFragment)
                        .commit();
                return true;
            }
            case R.id.action_second_tab: {

                MainFragment mainFragment = (MainFragment)
                        getSupportFragmentManager().findFragmentByTag("MainFragment");
                SecondFragment secondFragment = (SecondFragment)
                        getSupportFragmentManager().findFragmentByTag("SecondFragment");
                getSupportFragmentManager().beginTransaction()
                        .attach(secondFragment)
                        .detach(mainFragment)
                        .commit();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
