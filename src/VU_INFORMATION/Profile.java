package VU_INFORMATION;

import java.time.LocalDate;
import java.util.Arrays;

public class Profile {

    private FullName fullName;
    private String gender;
    private String phone;
    private String email;
    private LocalDate dob;
    private final String[] genderList = {"male", "female", "LGBT"};

    public Profile(){
        //overloading
    }

    @Override
    public String toString() {
        return "Profile{" +"\n" +
                "     fullName=" + fullName + "\n" +
                "     gender='" + gender + '\'' +"\n" +
                "     phone='" + phone + '\'' +"\n" +
                "     email='" + email + '\'' +"\n" +
                "     dob=" + dob +"\n" +
                '}';
    }

    public Profile(FullName fullName, int gender, String phone, String email, LocalDate dob) {
        this.fullName = fullName;
        this.gender = genderList[gender-1];
        this.phone = phone;
        this.email = email;
        this.dob = dob;
    }

    public FullName getFullName() {
        return fullName;
    }

    public void setFullName(FullName fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }
}

