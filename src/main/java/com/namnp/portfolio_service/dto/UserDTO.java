package com.namnp.portfolio_service.dto;

public class UserDTO {
    private long id;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String email;
    private UserFinancialDetailDTO userFinancialInfo;

    public UserDTO() {
    }

    public UserDTO(long id, String firstName, String lastName, String userName, String password, String email, UserFinancialDetailDTO userFinancialInfo) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.userFinancialInfo = userFinancialInfo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserFinancialDetailDTO getUserFinancialInfo() {
        return userFinancialInfo;
    }

    public void setUserFinancialInfo(UserFinancialDetailDTO userFinancialInfo) {
        this.userFinancialInfo = userFinancialInfo;
    }
}
