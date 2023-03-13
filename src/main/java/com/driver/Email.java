package com.driver;

public class Email {

    private String emailId;
    private String password;

    public Email(String emailId) {
        this.emailId = emailId;
        this.password = "Accio@123";
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }


    public void changePassword(String oldPassword, String newPassword) {
        //Change password only if the oldPassword is equal to current password and the new password meets all the following:
        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character

        if (oldPassword.equals(this.password)) {
            if (isValid(newPassword)) {
                System.out.println("Password updated successfully!");
                this.password = newPassword;
            } else {
                System.out.println("The new password is not match with the requirements!");
            }
        } else {
            System.out.println("The old password does not match with the current password!");
        }
    }

    public Boolean isValid(String password) {
        boolean capitalLetter = false;
        boolean smallLetter = false;
        boolean digit = false;
        boolean specialCharacter = false;

        if (password.length() < 8) {
            return false;
        } else {
            for (int i = 0; i < password.length(); i++) {
                if (password.charAt(i) >= 'A' && password.charAt(i) <= 'Z') {
                    capitalLetter = true;
                } else if (password.charAt(i) >= 'a' && password.charAt(i) <= 'z') {
                    smallLetter = true;
                } else if (password.charAt(i) >= '0' && password.charAt(i) <= '9') {
                    digit = true;
                } else {
                    specialCharacter = true;
                }
            }
            return capitalLetter && smallLetter && digit && specialCharacter;
        }
    }
}