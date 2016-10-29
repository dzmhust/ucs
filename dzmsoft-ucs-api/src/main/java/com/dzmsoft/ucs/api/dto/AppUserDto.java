package com.dzmsoft.ucs.api.dto;

import java.io.Serializable;

/**
 * App用户信息
 * @author dzm
 */
public class AppUserDto implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = -3181159043589544925L;
    public String token;
    public String userId;
    public String username;
    public String role;
    
    public AppUserDto(String token ,String userId, String username, String role){
        this.token = token;
        this.userId = userId;
        this.username = username;
        this.role = role;
    }
    
    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
