package sample.sp24.t4s2.user;

import java.util.Date;

public class UserDTO {
    private String userID;
    private String fullName;
    private String password;
    private String roleID;
    private String address;
    private Date dob;
    private String phone;
    private String email;
    private int status;
    private double spent;

    public UserDTO() {
    }

    public UserDTO(String userID, String fullName, String password, String roleID, String address, Date dob, String phone, String email, int status) {
        this.userID = userID;
        this.fullName = fullName;
        this.password = password;
        this.roleID = roleID;
        this.address = address;
        this.dob = dob;
        this.phone = phone;
        this.email = email;
        this.status = status;
    }

    public UserDTO(String userID, String fullName, String address, Date dob, String phone, String email, double spent) {
        this.userID = userID;
        this.fullName = fullName;
        this.address = address;
        this.dob = dob;
        this.phone = phone;
        this.email = email;
        this.spent = spent;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoleID() {
        return roleID;
    }

    public void setRoleID(String roleID) {
        this.roleID = roleID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public double getSpent() {
        return spent;
    }

    public void setSpent(double spent) {
        this.spent = spent;
    }
    
    
}
