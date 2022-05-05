package com.gamingCafe.model;

import java.io.Serializable;

public class OwnsComposite implements Serializable {
    private String pEmail;

    private String gid;


    // default constructor

    public OwnsComposite() {
    }

    public OwnsComposite(String pEmail, String gid) {
        this.pEmail = pEmail;
        this.gid = gid;
    }

    // equals() and hashCode()
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        OwnsComposite that = (OwnsComposite) o;

        if (pEmail != null ? !pEmail.equals(that.pEmail) : that.pEmail != null)
            return false;
        if (gid != null ? !gid.equals(that.gid) : that.gid != null)
            return false;

        return true;
    }
    @Override
    public int hashCode() {
        int result;
        result = (pEmail != null ? pEmail.hashCode() : 0);
        result = 31 * result + (gid != null ? gid.hashCode() : 0);
        return result;
    }
}
