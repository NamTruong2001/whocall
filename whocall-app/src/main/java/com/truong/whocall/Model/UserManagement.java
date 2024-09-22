package com.truong.whocall.Model;
import java.util.Collection;
import java.util.Map;

public class UserManagement {
    private Map<String, User> users;
    /*
     * Todo:
     * finding user using username encrypt -> key
     * use the key to retrive O(1) finding
     */
    public UserManagement(Map<String, User> users) {
        this.users = users;
    }

    public boolean isUserIn(String key) {
        return users.containsKey(key);
    }

    public Collection<User> getUsers() {
        return users.values();
    }

    public User addUser(String key, User user) {
        return users.put(key, user);
    }

    public User removeUser(String key) {
        User user = users.remove(key);
        return user;
    }
    
}
