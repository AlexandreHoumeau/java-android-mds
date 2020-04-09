package fr.mds.geekquote.model;

import android.util.Log;

import java.io.Serializable;
import java.util.Date;

import fr.mds.geekquote.activity.MainActivity;

public class Quote implements Serializable {
    private String strQuote;
    private Float rating;
    private Date creationDate;

    public Quote(Object response) {
    }

    public Quote(String strQuote) {
        super();
        this.strQuote = strQuote;
        this.rating = 0F;
        this.creationDate = new Date();
    }

    public Quote(String strQuote, Float rating, Date creationDate) {
        this.strQuote = strQuote;
        this.rating = rating;
        this.creationDate = creationDate;
    }


    public void setStrQuote(String strQuote) {
        this.strQuote = strQuote;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getStrQuote() {
        return strQuote;
    }

    public Float getRating() {
        return rating;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "strQuote='" + strQuote + '\'' +
                ", rating=" + rating +
                ", creationDate=" + creationDate +
                '}';
    }
}
