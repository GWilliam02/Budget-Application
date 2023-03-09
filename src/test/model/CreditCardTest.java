package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CreditCardTest {
    private CreditCard cc1;

    @BeforeEach
    public void setUp() {
        cc1 = new CreditCard("RBC Visa", 200, 5000);
    }

    @Test
    public void testConstructor() {
        assertEquals(200, cc1.getBalance());
        assertEquals(5000, cc1.getLimit());
        assertEquals("RBC Visa", cc1.getName());
    }

    @Test
    public void testSpend() {
        assertTrue(cc1.spend(100));
        assertEquals(300, cc1.getBalance());
        assertTrue(cc1.spend(4699));
        assertEquals(4999, cc1.getBalance());
        assertTrue(cc1.spend(1));
        assertEquals(5000, cc1.getBalance());

        assertFalse(cc1.spend(1));
        assertEquals(5000, cc1.getBalance());
    }

    @Test
    public void testPayBill() {
        assertTrue(cc1.payBill(100));
        assertEquals(100, cc1.getBalance());
        assertTrue(cc1.payBill(99));
        assertEquals(1, cc1.getBalance());
        assertTrue(cc1.payBill(1));
        assertEquals(0, cc1.getBalance());

        assertFalse(cc1.payBill(1));
        assertEquals(0, cc1.getBalance());
    }

    @Test
    public void testToJson() {
        assertEquals(cc1.toJson().toString(), "{\"balance\":200,\"name\":\"RBC Visa\",\"limit\":5000}");
    }

    @Test
    public void testSetBalance() {
        cc1.setBalance(1000);
        assertEquals(1000, cc1.getBalance());
    }

    @Test
    public void testSetName() {
        cc1.setName("Scotiabank Mastercard");
        assertEquals("Scotiabank Mastercard", cc1.getName());
    }

    @Test
    public void testSetLimit() {
        cc1.setLimit(12345);
        assertEquals(12345, cc1.getLimit());
    }
}
