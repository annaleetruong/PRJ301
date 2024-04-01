package a.user;

public class UserError {
    
    private String usernameLengthError;
    private String passwordLengthError;
    private String confirmPasswordError;
    private String fullnameLengthError;
    private String usernameExistError;

    public UserError() {
        
        this.usernameLengthError = "";
        this.passwordLengthError = "";
        this.confirmPasswordError = "";
        this.fullnameLengthError = "";
        this.usernameExistError = "";
    }

    public UserError(String usernameLengthError, String passwordLengthError, String confirmPasswordError, String fullnameLengthError, String usernameExistError) {
        this.usernameLengthError = usernameLengthError;
        this.passwordLengthError = passwordLengthError;
        this.confirmPasswordError = confirmPasswordError;
        this.fullnameLengthError = fullnameLengthError;
        this.usernameExistError = usernameExistError;
    }

    /**
     * @return the usernameLengthError
     */
    public String getUsernameLengthError() {
        return usernameLengthError;
    }

    /**
     * @param usernameLengthError the usernameLengthError to set
     */
    public void setUsernameLengthError(String usernameLengthError) {
        this.usernameLengthError = usernameLengthError;
    }

    /**
     * @return the passwordLengthError
     */
    public String getPasswordLengthError() {
        return passwordLengthError;
    }

    /**
     * @param passwordLengthError the passwordLengthError to set
     */
    public void setPasswordLengthError(String passwordLengthError) {
        this.passwordLengthError = passwordLengthError;
    }

    /**
     * @return the confirmPasswordError
     */
    public String getConfirmPasswordError() {
        return confirmPasswordError;
    }

    /**
     * @param confirmPasswordError the confirmPasswordError to set
     */
    public void setConfirmPasswordError(String confirmPasswordError) {
        this.confirmPasswordError = confirmPasswordError;
    }

    /**
     * @return the fullnameLengthError
     */
    public String getFullnameLengthError() {
        return fullnameLengthError;
    }

    /**
     * @param fullnameLengthError the fullnameLengthError to set
     */
    public void setFullnameLengthError(String fullnameLengthError) {
        this.fullnameLengthError = fullnameLengthError;
    }

    /**
     * @return the usernameExistError
     */
    public String getUsernameExistError() {
        return usernameExistError;
    }

    /**
     * @param usernameExistError the usernameExistError to set
     */
    public void setUsernameExistError(String usernameExistError) {
        this.usernameExistError = usernameExistError;
    }
    
}
