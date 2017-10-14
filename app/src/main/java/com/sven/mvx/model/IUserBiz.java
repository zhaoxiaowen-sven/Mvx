package com.sven.mvx.model;

/**
 * Created by 11002252 on 2017/10/14.
 */

public interface IUserBiz {
    void login(String username, String password, OnLoginListener loginListener);
}
