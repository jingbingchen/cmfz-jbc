package com.baizhi.jbc.entity;



import java.util.Objects;


public class Mouth {
    private Integer count;
    private String months;

    public Mouth(Integer count, String months) {
        this.count = count;
        this.months = months;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getMonths() {
        return months;
    }

    public void setMonths(String months) {
        this.months = months;
    }

    public Mouth() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mouth mouth = (Mouth) o;
        return Objects.equals(count, mouth.count) &&
                Objects.equals(months, mouth.months);
    }

    @Override
    public int hashCode() {
        return Objects.hash(count, months);
    }

    @Override
    public String toString() {
        return "Mouth{" +
                "count=" + count +
                ", months='" + months + '\'' +
                '}';
    }
}
