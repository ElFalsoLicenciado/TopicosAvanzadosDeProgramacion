package proyecto.models;

import proyecto.enums.UserType;
import java.util.UUID;

public class User implements java.io.Serializable {
    private final String userID;
    private UserType userType;
    private String username;
    private String password;

    public User(UserType userType, String username, String password) {
        userID = "U" + UUID.randomUUID().toString().replace("-", "").substring(0,5);
        this.userType = userType;
        this.username = username;
        this.password = password;
    }

    public String getUserID() {
        return userID;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}