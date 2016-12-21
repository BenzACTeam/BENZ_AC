package com.benz.framework.ftp;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by hongying.fu on 12/21/2016.
 */
@ConfigurationProperties(prefix="ftp")
public class FTPParameter {
    private String url;
    private int port;
    private String username;
    private String password;

    private String httpUrl;

    public String getHttpUrl() {
        return httpUrl;
    }

    public String getUrl() {
        return url;
    }

    public int getPort() {
        return port;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }


}
