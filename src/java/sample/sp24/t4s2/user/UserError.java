package sample.sp24.t4s2.user;

public class UserError {

    private String userIDError;
    private String fullNameError;
    private String passwordError;
    private String roleIDError;
    private String addressError;
    private String dobError;
    private String phoneError;
    private String emailError;
    private String confirmError;
    private String error;

    public UserError() {
        this.userIDError = "";
        this.fullNameError = "";
        this.passwordError = "";
        this.roleIDError = "";
        this.addressError = "";
        this.dobError = "";
        this.phoneError = "";
        this.emailError = "";
        this.confirmError = "";
        this.error = "";
    }

    public UserError(String userIDError, String fullNameError, String passwordError, String roleIDError, String addressError, String dobError, String phoneError, String emailError, String confirmError, String error) {
        this.userIDError = userIDError;
        this.fullNameError = fullNameError;
        this.passwordError = passwordError;
        this.roleIDError = roleIDError;
        this.addressError = addressError;
        this.dobError = dobError;
        this.phoneError = phoneError;
        this.emailError = emailError;
        this.confirmError = confirmError;
        this.error = error;
    }

    public String getUserIDError() {
        return userIDError;
    }

    public void setUserIDError(String userIDError) {
        this.userIDError = userIDError;
    }

    public String getFullNameError() {
        return fullNameError;
    }

    public void setFullNameError(String fullNameError) {
        this.fullNameError = fullNameError;
    }

    public String getPasswordError() {
        return passwordError;
    }

    public void setPasswordError(String passwordError) {
        this.passwordError = passwordError;
    }

    public String getRoleIDError() {
        return roleIDError;
    }

    public void setRoleIDError(String roleIDError) {
        this.roleIDError = roleIDError;
    }

    public String getAddressError() {
        return addressError;
    }

    public void setAddressError(String addressError) {
        this.addressError = addressError;
    }

    public String getDobError() {
        return dobError;
    }

    public void setDobError(String dobError) {
        this.dobError = dobError;
    }

    public String getPhoneError() {
        return phoneError;
    }

    public void setPhoneError(String phoneError) {
        this.phoneError = phoneError;
    }

    public String getEmailError() {
        return emailError;
    }

    public void setEmailError(String emailError) {
        this.emailError = emailError;
    }

    public String getConfirmError() {
        return confirmError;
    }

    public void setConfirmError(String confirmError) {
        this.confirmError = confirmError;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    
}
