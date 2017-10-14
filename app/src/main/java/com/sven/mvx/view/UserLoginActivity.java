package com.sven.mvx.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sven.mvx.MainActivity;
import com.sven.mvx.R;
import com.sven.mvx.model.User;
import com.sven.mvx.persenter.UserLoginPresenter;

/**
 * Created by 11002252 on 2017/10/14.
 */

public class UserLoginActivity extends Activity implements IUserLoginView {

    private static final String TAG = "UserLoginActivity";
    private EditText mEtUsername, mEtPassword;
    private Button mBtLogin;
    private UserLoginPresenter mUserLoginPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mUserLoginPresenter = new UserLoginPresenter(this);
        mEtUsername = findViewById(R.id.et_usn);
        mEtPassword = findViewById(R.id.et_pwd);
        mBtLogin = findViewById(R.id.bt_submit);

        mBtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mUserLoginPresenter.login();
            }
        });
    }

    @Override
    public String getUserName() {
        return mEtUsername.getText().toString();
    }

    @Override
    public String getPassword() {
        return mEtPassword.getText().toString();
    }

    @Override
    public void clearUserName() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void toMainActivity(User user) {
        Intent intent = new Intent(UserLoginActivity.this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void showFailedError() {
//        Log.i(TAG, "showFailedError: ");
        Toast.makeText(UserLoginActivity.this, "showFailedError", Toast.LENGTH_SHORT).show();
    }
}
