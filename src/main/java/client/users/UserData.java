package client.users;

import java.io.Serializable;

public class UserData implements Serializable {
    public int uid;
    public String username;

    public UserData(int uid, String username){
        this.uid = uid;
        this.username = username;
    }
}
