package com.baizhi.jbc.entity;


import java.util.ArrayList;
import java.util.Objects;

public class ProDTO {

    private String sex;
    private ArrayList<City> cities;

    public ProDTO(String sex, ArrayList<City> cities) {
        this.sex = sex;
        this.cities = cities;
    }

    public ProDTO() {
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public ArrayList<City> getCities() {
        return cities;
    }

    public void setCities(ArrayList<City> cities) {
        this.cities = cities;
    }


    @Override
    public String toString() {
        return "ProDTO{" +
                "sex='" + sex + '\'' +
                ", cities=" + cities +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProDTO proDTO = (ProDTO) o;
        return Objects.equals(sex, proDTO.sex) &&
                Objects.equals(cities, proDTO.cities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sex, cities);
    }
}
