package edu.lyon1;

/**
 * Created by p1614402 on 03/05/2017.
 */
public class UserAgent {

    private String userAgent;
    private String nom;

    public UserAgent(String userAgent) {
        this.userAgent = userAgent;
        this.setNom(userAgent);
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String cle) {
        switch(cle) {
            case "Firefox/40.1" :
                nom = "Firefox";
            break;
            case "MSIE" :
                nom = "Internet Explorer";
            break;
            case "AppleWebKit/537.75.14" :
                nom = "Safari";
            break;
            case "Chrome/41.0.2228.0" :
                nom = "Chrome";
            break;
        }
    }
}
