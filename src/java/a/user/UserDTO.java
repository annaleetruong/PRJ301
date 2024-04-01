package a.user;

public class UserDTO {

    private String userID;
    private String fullName;
    private String roleID;
    private String password;
    private boolean isBanned;

    public UserDTO() {
        this.userID = "";
        this.fullName = "";
        this.roleID = "";
        this.password = "";
        this.isBanned = false;
    }

    public UserDTO(String userID, String fullName, String roleID, String password, boolean isBanned) {
        this.userID = userID;
        this.fullName = fullName;
        this.roleID = roleID;
        this.password = password;
        this.isBanned = isBanned;
    }
    
    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getRoleID() {
        return roleID;
    }

    public void setRoleID(String roleID) {
        this.roleID = roleID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isIsBanned() {
        return isBanned;
    }

    public void setIsBanned(boolean isBanned) {
        this.isBanned = isBanned;
    }
    
    
}

