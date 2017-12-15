package edu.chapman.cpsc.beerrun.activities;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import edu.chapman.cpsc.beerrun.R;
import edu.chapman.cpsc.beerrun.fragments.MainMenueFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainMenueFragment mainMenu = new MainMenueFragment();

        showFrag(mainMenu);
    }

    public void showFrag(Fragment frag){
        int inAnimation = android.R.anim.fade_in;
        int outAnimation = android.R.anim.fade_out;

        getSupportFragmentManager()
                .beginTransaction()
                .setCustomAnimations(inAnimation, outAnimation)
                .addToBackStack(null)
                .replace(R.id.fragment_container, frag)
                .commit();
    }
}
