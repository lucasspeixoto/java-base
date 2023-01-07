package concepts.generics_sets_maps.entities;

import java.time.Instant;
import java.util.Date;
import java.util.Objects;

public class UserLog {

    private String name;
    private Date loginDate;

    public UserLog(String name, Date loginDate) {
        this.name = name;
        this.loginDate = loginDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    @Override
    public String toString() {
        return "User Data Log: " + "Name: " + this.name + " | " + "Login date: " + this.loginDate + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserLog userLog)) return false;
        return Objects.equals(getName(), userLog.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
