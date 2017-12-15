package edu.chapman.cpsc.beerrun.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.HashSet;
import java.util.Set;

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

    private Set<String> user_set;

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

                        user_set = new HashSet<>();

                        if(user.getText().toString().equals("")
                                || passwd.getText().toString().equals("")){
                            Toast.makeText(getContext(),
                                    "Please complete both fields to register",
                                    Toast.LENGTH_SHORT).show();
                        }

                        else {
                            getHash();

                            SharedPreferences login = getContext().getSharedPreferences(
                                    "userInfo", Context.MODE_PRIVATE);

                            if(login.contains(username_key)){
                                Toast.makeText(getContext(), "Username unavailable",
                                        Toast.LENGTH_SHORT).show();
                            }

                            else {

                                SharedPreferences.Editor editor = login.edit();
                                editor.putStringSet(username_key, user_set);
                                editor.apply();
                                Toast.makeText(getContext(),
                                        "Welcome! please log in", Toast.LENGTH_SHORT).show();

                                create.setVisibility(view.GONE);
                                subBtn.setVisibility(view.VISIBLE);
                                user.setText("");
                                passwd.setText("");
                            }
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
                user_set = new HashSet<>();

                getHash();

                SharedPreferences login = getContext().getSharedPreferences(
                        "userInfo", Context.MODE_PRIVATE);

                Set<String> user_validation = login.getStringSet(username_key, new HashSet<String>());

                if(!user_validation.isEmpty() && user_set.equals(user_validation)){
                    BeerFragment beerFrag = new BeerFragment();
                    mainActivity.showFrag(beerFrag);
                }

                else{
                    showError();
                    Toast.makeText(getContext(), "Incorrect username" +
                            " or password, please try again", Toast.LENGTH_LONG).show();
                }
            }
        });

        return v;
    }

    private void visibilityChange(View view){
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

    private Set<String> getHash(){
        this.username_key = user.getText().toString();
        this.passwd_key = user.getText().toString();

        this.user_set.add(username_key);
        this.user_set.add(passwd_key);

        return user_set;
    }
}
