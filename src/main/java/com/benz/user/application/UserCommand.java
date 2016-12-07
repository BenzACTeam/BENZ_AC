package com.benz.user.application;

import com.benz.user.domain.User;
import org.hibernate.validator.constraints.Length;

/**
 * Created by paulliu on 2016/12/7.
 */
public class UserCommand {

    private static final long serialVersionUID = 1L;

    @Length(max=10)
    private String name;

    @Length(max=16, min=5)
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserCommand() {

    }

    public UserCommand(String name, String password) {
        this.name = name;
        this.password = password;
    }
}
