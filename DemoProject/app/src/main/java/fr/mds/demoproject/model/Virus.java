package fr.mds.demoproject.model;

import java.io.Serializable;

public class Virus implements Serializable {

    private String name;
    private String countryOrigin;
    private int mortalityRate;

    public Virus() {
    }

    public Virus(String name, String countryOrigin, int mortalityRate) {
        this.name = name;
        this.countryOrigin = countryOrigin;
        this.mortalityRate = mortalityRate;
    }

    public String getName() {
        return name;
    }

    public String getCountryOrigin() {
        return countryOrigin;
    }

    public int getMortalityRate() {
        return mortalityRate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountryOrigin(String countryOrigin) {
        this.countryOrigin = countryOrigin;
    }

    public void setMortalityRate(int mortalityRate) {
        this.mortalityRate = mortalityRate;
    }

    @Override
    public String toString() {
        return "Virus{" +
                "name='" + name + '\'' +
                ", countryOrigin='" + countryOrigin + '\'' +
                ", mortalityRate=" + mortalityRate +
                '}';
    }
}
