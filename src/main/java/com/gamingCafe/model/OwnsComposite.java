package com.gamingCafe.model;

import java.io.Serializable;

public class OwnsComposite implements Serializable {
    private String p_email;

    private String g_id;

    // default constructor

    public OwnsComposite() {
    }

    public OwnsComposite(String p_email, String g_id) {
        this.p_email = p_email;
        this.g_id = g_id;
    }

    // equals() and hashCode()
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        OwnsComposite that = (OwnsComposite) o;

        if (p_email != null ? !p_email.equals(that.p_email) : that.p_email != null)
            return false;
        if (g_id != null ? !g_id.equals(that.g_id) : that.g_id != null)
            return false;

        return true;
    }
    @Override
    public int hashCode() {
        int result;
        result = (p_email != null ? p_email.hashCode() : 0);
        result = 31 * result + (g_id != null ? g_id.hashCode() : 0);
        return result;
    }
}
