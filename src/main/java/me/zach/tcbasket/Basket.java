package me.zach.tcbasket;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Basket {
    private static final Logger logger = LogManager.getLogger(Basket.class);

    private List<Item> items = new ArrayList<Item>();

    public void addItem(Item item) {
        items.add(item);
    }


    public BigDecimal total() {
        // apply discounts
        int breadDiscounts = getNumberOfDiscountableBread();
        int milkDiscounts = getNumberOfDiscountableMilk();

        BigDecimal sum = BigDecimal.ZERO;
        for (Iterator<Item> iterator = items.iterator(); iterator.hasNext();) {
            Item item = iterator.next();
            if (item.getName().equalsIgnoreCase("bread") && breadDiscounts > 0) {
                item.setCost(item.getCost().divide(BigDecimal.valueOf(2)));

                breadDiscounts--;
            }
            if (item.getName().equalsIgnoreCase("milk") && milkDiscounts > 0) {
                item.setCost(BigDecimal.ZERO);

                milkDiscounts--;
            }
            sum = sum.add(item.getCost());
        }

        return sum;
    }

    private int getNumberOfDiscountableBread() {
        long numOfBreads = items.stream().filter(item -> item.getName().equalsIgnoreCase("bread")).count();
        if (numOfBreads > 0) {
            long numOfButter = items.stream().filter(item -> item.getName().equalsIgnoreCase("butter")).count();
            if (numOfButter > 1) {
                return (int) Math.floor(numOfButter / 2);
            }
        }

        return 0;
    }

    private int getNumberOfDiscountableMilk() {
        long numOfMilk = items.stream().filter(item -> item.getName().equalsIgnoreCase("milk")).count();
        if (numOfMilk > 3) {
            return (int) Math.floor(numOfMilk / 4);
        }

        return 0;
    }
}
