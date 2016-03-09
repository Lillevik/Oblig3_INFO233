package no.uib.info233.v2016.puz001.esj002.Oblig3.Issue;

import java.security.SecureRandom;
import java.math.BigInteger;
/**
 * Created by mariuslillevik on 09.03.16.
 */
public class User {

    private SecureRandom random = new SecureRandom();
    private String name;
    private String id;
    private String pass;

    public User(String n, String id){
        this.name = n;
        this.id = id;
    }

    public String randomPass() {
        return new BigInteger(64, random).toString(32);
    }

    public String getName() {
        return name;
    }

    public String getPass() {
        return pass;
    }

    public String getId() {
        return id;
    }
}
