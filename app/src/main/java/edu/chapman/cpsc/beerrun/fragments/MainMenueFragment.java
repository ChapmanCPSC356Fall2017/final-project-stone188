package edu.chapman.cpsc.beerrun.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

import edu.chapman.cpsc.beerrun.R;
import edu.chapman.cpsc.beerrun.activities.MainActivity;

/**
 * Created by fried on 11/29/2017.
 *
 */

public class MainMenueFragment extends Fragment{
    private Button subBtn;
    private EditText user;
    private EditText passwd;
    private Button createAccount;
    private Button login;
    private Button create;

    private String username_key;
    private String passwd_key;

    private MainActivity mainActivity;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState){
        final View v = inflater.inflate(R.layout.fragment_main_menu, container, false);

        mainActivity = (MainActivity) getContext();

        this.subBtn = v.findViewById(R.id.submitButton);
        this.user = v.findViewById(R.id.username);
        this.passwd = v.findViewById(R.id.passwd);
        this.createAccount = v.findViewById(R.id.create_account);
        this.login = v.findViewById(R.id.login);
        this.create = v.findViewById(R.id.create);

        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                visibilityChange(view);
                create.setVisibility(view.VISIBLE);
                subBtn.setVisibility(view.GONE);

                create.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(user.getText().toString().equals("")
                                || passwd.getText().toString().equals("")){
                            Toast.makeText(getContext(),
                                    "Please complete both fields to register",
                                    Toast.LENGTH_SHORT).show();
                        }

                        else {
                            username_key = user.getText().toString();
                            passwd_key = user.getText().toString();

                            SharedPreferences login = getContext().getSharedPreferences(
                                    "userInfo", Context.MODE_PRIVATE);

                            SharedPreferences.Editor editor = login.edit();
                            editor.putString(username_key, user.getText().toString());
                            editor.putString(passwd_key, passwd.getText().toString());
                            editor.apply();
                            Toast.makeText(getContext(),
                                    "Welcome!, please log in", Toast.LENGTH_SHORT).show();

                            create.setVisibility(view.GONE);
                            subBtn.setVisibility(view.VISIBLE);
                            user.setText("");
                            passwd.setText("");
                        }
                    }
                });
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                visibilityChange(view);
                subBtn.setVisibility(view.VISIBLE);
            }
        });

        subBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                username_key = user.getText().toString();
                passwd_key = user.getText().toString();

                SharedPreferences login = getContext().getSharedPreferences(
                        "userInfo", Context.MODE_PRIVATE);

                String username = login.getString(username_key, "");
                String password = login.getString(passwd_key, "");

                if(username != null && password != null){
                    BeerFragment beerFrag = new BeerFragment();
                    mainActivity.showFrag(beerFrag);
                }

                else{
                    showError();

                    Toast.makeText(getContext(), username + " " + password, Toast.LENGTH_SHORT).show();

                    /*Toast.makeText(getContext(), "Incorrect username" +
                            " or password, please try again", Toast.LENGTH_LONG).show();*/
                }
            }
        });

        return v;
    }

    public void visibilityChange(View view){
        login.setVisibility(view.GONE);
        createAccount.setVisibility(view.GONE);
        user.setVisibility(view.VISIBLE);
        passwd.setVisibility(view.VISIBLE);
    }

    private void showError() {
        Animation shake = AnimationUtils.loadAnimation(getContext(), R.anim.shake);
        user.startAnimation(shake);
        passwd.startAnimation(shake);
    }
}
