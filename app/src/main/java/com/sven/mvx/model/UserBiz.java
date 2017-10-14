package com.sven.mvx.model;

/**
 * Created by 11002252 on 2017/10/14.
 */

public class UserBiz implements IUserBiz{
    @Override
    public void login(final String username, final String password, final OnLoginListener loginListener) {
        new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if ("sven".equals(username) && "123".equals(password)){
                    User user = new User();
                    user.setName(username);
                    user.setName(password);
                    loginListener.loginSuccess(user);
                }else {
                    loginListener.loginFailed();
                }
            }
        }.start();
    }
}
