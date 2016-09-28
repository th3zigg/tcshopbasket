package me.zach.tcbasket;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import java.math.BigDecimal;


public class BasketTest {

    @Test
    public void testShouldFailIf1Bread1Butter1MilkIsNot2_95() {
        Basket basket = new Basket();
        basket.addItem(new Item("bread", BigDecimal.valueOf(1.00)));
        basket.addItem(new Item("butter", BigDecimal.valueOf(0.80)));
        basket.addItem(new Item("milk", BigDecimal.valueOf(1.15)));

        assertEquals(BigDecimal.valueOf(2.95), basket.total());
    }

    @Test
    public void testShouldFailIf2ButterAnd2BreadTotalIsNot3_10() {
        Basket basket = new Basket();
        basket.addItem(new Item("bread", BigDecimal.valueOf(1.00)));
        basket.addItem(new Item("bread", BigDecimal.valueOf(1.00)));
        basket.addItem(new Item("butter", BigDecimal.valueOf(0.80)));
        basket.addItem(new Item("butter", BigDecimal.valueOf(0.80)));

        assertEquals(BigDecimal.valueOf(3.10), basket.total());
    }

    @Test
    public void testShouldFailIf4MilkIsNot3_45() {
        Basket basket = new Basket();
        basket.addItem(new Item("milk", BigDecimal.valueOf(1.15)));
        basket.addItem(new Item("milk", BigDecimal.valueOf(1.15)));
        basket.addItem(new Item("milk", BigDecimal.valueOf(1.15)));
        basket.addItem(new Item("milk", BigDecimal.valueOf(1.15)));

        assertEquals(BigDecimal.valueOf(3.45), basket.total());
    }

    @Test
    public void testShouldFailIf2Butter1BreadAnd8MilkIsNot9() {
        Basket basket = new Basket();

        basket.addItem(new Item("butter", BigDecimal.valueOf(0.80)));
        basket.addItem(new Item("butter", BigDecimal.valueOf(0.80)));

        basket.addItem(new Item("bread", BigDecimal.valueOf(1.00)));

        basket.addItem(new Item("milk", BigDecimal.valueOf(1.15)));
        basket.addItem(new Item("milk", BigDecimal.valueOf(1.15)));
        basket.addItem(new Item("milk", BigDecimal.valueOf(1.15)));
        basket.addItem(new Item("milk", BigDecimal.valueOf(1.15)));
        basket.addItem(new Item("milk", BigDecimal.valueOf(1.15)));
        basket.addItem(new Item("milk", BigDecimal.valueOf(1.15)));
        basket.addItem(new Item("milk", BigDecimal.valueOf(1.15)));
        basket.addItem(new Item("milk", BigDecimal.valueOf(1.15)));

        assertEquals(BigDecimal.valueOf(9), basket.total().setScale(0));
    }
}
