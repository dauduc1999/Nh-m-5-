
package entity;


/**
 *
 * @author Hieu
 */
public class Doctor {
    private String id;
    private String name;
    private String dateOFBirth;
    private String Specialization;
    private int status;
    private String email;
    private String mobile;

    public String displayStatus() {
        return this.status == 1 ? "Working" : "Vacation";
    }

    public Doctor() {
    }

    public Doctor(String id, String name, String dateOFBirth, String Specialization, int status, String email, String mobile) {
        this.id = id;
        this.name = name;
        this.dateOFBirth = dateOFBirth;
        this.Specialization = Specialization;
        this.status = status;
        this.email = email;
        this.mobile = mobile;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOFBirth() {
        return dateOFBirth;
    }

    public void setDateOFBirth(String dateOFBirth) {
        this.dateOFBirth = dateOFBirth;
    }

    public String getSpecialization() {
        return Specialization;
    }

    public void setSpecialization(String Specialization) {
        this.Specialization = Specialization;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        String str = String.format("%-8s|%-20s|%-10s|%-15s|%-23s|%-25s|%-10s", 
                this.id,this.name, this.dateOFBirth, this.Specialization, this.displayStatus(),
                this.email, this.mobile);
        return str;
    }

}
