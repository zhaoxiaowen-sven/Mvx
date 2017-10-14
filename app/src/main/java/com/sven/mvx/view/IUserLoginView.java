package com.sven.mvx.view;

import com.sven.mvx.model.User;

/**
 * Created by 11002252 on 2017/10/14.
 */

public interface IUserLoginView {

    String getUserName();

    String getPassword();

    void clearUserName();

    void showLoading();

    void hideLoading();

    void toMainActivity(User user);

    void showFailedError();
}
