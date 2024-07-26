package br.com.marcelocamacho.to_do_list.user;

public class UserModel {
    private String username;
    private String name;
    private String password;

    
    public String getUsername() {
        return username;
    }


    public String getName() {
        return name;
    }


    public String getPassword() {
        return password;
    }


    public void setUsername(String username) {
        this.username = username;
    }


    public void setName(String name) {
        this.name = name;
    }


    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "UserModel [username=" + username + ", name=" + name + ", password=" + password + "]";
    }
}
