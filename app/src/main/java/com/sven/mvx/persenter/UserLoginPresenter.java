package com.sven.mvx.persenter;

import android.os.Handler;

import com.sven.mvx.model.IUserBiz;
import com.sven.mvx.model.OnLoginListener;
import com.sven.mvx.model.User;
import com.sven.mvx.model.UserBiz;
import com.sven.mvx.view.IUserLoginView;

/**
 * Created by 11002252 on 2017/10/14.
 */

public class UserLoginPresenter {

    private IUserBiz mUserBiz;
    private IUserLoginView mUserLoginView;
    private Handler mHandler;


    public UserLoginPresenter(IUserLoginView userLoginView){
        this.mUserLoginView = userLoginView;
        init();
    }

    public void init(){
        mUserBiz = new UserBiz();
        mHandler = new Handler();
    }

    public void login(){
        mUserBiz.login(mUserLoginView.getUserName(), mUserLoginView.getPassword(), new OnLoginListener() {
            @Override
            public void loginSuccess(final User user) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mUserLoginView.toMainActivity(user);
                    }
                });
            }

            @Override
            public void loginFailed() {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mUserLoginView.showFailedError();
                    }
                });
            }
        });
    }
}
