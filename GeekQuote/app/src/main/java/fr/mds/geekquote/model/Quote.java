package fr.mds.geekquote.model;

import java.util.Date;

import fr.mds.geekquote.MainActivity;

public class Quote {
    private String strQuote;
    private Integer rating;
    private Date creationDate;

    public Quote() {
    }

    public Quote(String strQuote) {
        super();
        this.rating = 0;
        this.creationDate = new Date();
    }

    public Quote(String strQuote, Integer rating, Date creationDate) {
        this.strQuote = strQuote;
        this.rating = rating;
        this.creationDate = creationDate;
    }

    public void setStrQuote(String strQuote) {
        this.strQuote = strQuote;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getStrQuote() {
        return strQuote;
    }

    public Integer getRating() {
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
