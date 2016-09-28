package me.zach.tcbasket;

import java.math.BigDecimal;

public class Item {
    private double id = Math.random();
    private String name;
    private BigDecimal cost;

    public Item() {
    }

    public Item(String name, BigDecimal cost) {
        this.name = name;
        this.cost = cost;
    }

    public Item(String name, double cost) {
        this.name = name;
        this.cost = BigDecimal.valueOf(cost);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (Double.compare(item.id, id) != 0) return false;
        return name.equals(item.name);

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(id);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + name.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                '}';
    }
}
