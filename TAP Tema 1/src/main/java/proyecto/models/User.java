package proyecto.models;

import proyecto.enums.UserType;

public class User implements java.io.Serializable {
    private String id_user;
    private UserType user_type;
    private String username;
    private String password;

    public User() {
    }

    public User(String username) {
        id_user = "GUEST";
        user_type = UserType.GUEST;
        username = username;
        password = "";
    }


    public User(String id_user, UserType user_type, String username, String password) {
        this.id_user = id_user;
        this.user_type = user_type;
        this.username = username;
        this.password = password;
    }


    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    public UserType getUser_type() {
        return user_type;
    }

    public void setUser_type(UserType user_type) {
        this.user_type = user_type;
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