package com.truong.whocall.ApiHandler;

import com.truong.whocall.Model.APIResponse;
import com.truong.whocall.Model.EncryptedUser;
import com.truong.whocall.Model.User;
import com.truong.whocall.Model.UserManagement;
import com.truong.whocall.util.EncryptionUtil;

import io.javalin.http.Context;

import java.util.function.*;
import java.util.UUID;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;


public class UserHandler {
    private static final UserManagement userManagement = new UserManagement(new HashMap<String, User>());;

    public UserHandler() {
    }

    public static User connectApplication(Context context, String username) throws Exception {
        // String uuidString = UUID.randomUUID().toString();
        String encryptedUsername = EncryptionUtil.encrypt(username);
        EncryptedUser encryptedUser = new EncryptedUser(encryptedUsername);
        User user = new User(username);
        context.json(encryptedUser);
        return userManagement.addUser(encryptedUsername, user);   
    }

    public static String leaveApplication(Context context, String token) {
        String uuidString = UUID.randomUUID().toString();
        context.result("Remove success");
        return uuidString;
    }

    public static Collection<User> getAllUsers(Context ctx) {
        Collection<User> users = userManagement.getUsers(); 
        ctx.json(new APIResponse(null, 200, users));
        return users;
    }
}


