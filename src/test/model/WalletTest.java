package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WalletTest {

    Wallet wallet;
    CreditCard cc1;
    CreditCard cc2;


    @BeforeEach
    public void setUp() {
        wallet = new Wallet();
        wallet.setBankBalance(1000);
        cc1 = new CreditCard("RBC Visa", 100, 5000);
        cc2 = new CreditCard("TD Amex", 700, 10000);
        wallet.addCreditCard(cc1);
        wallet.addCreditCard(cc2);
    }

    @Test
    public void testWithdrawCash() {
        assertTrue(wallet.withdrawCash(400));
        assertEquals(400, wallet.getCash());
        assertEquals(600, wallet.getBankBalance());
        assertTrue(wallet.withdrawCash(599));
        assertEquals(999, wallet.getCash());
        assertEquals(1, wallet.getBankBalance());
        assertTrue(wallet.withdrawCash(1));
        assertEquals(1000, wallet.getCash());
        assertEquals(0, wallet.getBankBalance());

        assertFalse(wallet.withdrawCash(1));
        assertEquals(1000, wallet.getCash());
        assertEquals(0, wallet.getBankBalance());

    }

    @Test
    public void testDepositCash() {
        wallet.withdrawCash(200);

        assertTrue(wallet.depositCash(100));
        assertEquals(100, wallet.getCash());
        assertEquals(900, wallet.getBankBalance());
        assertTrue(wallet.depositCash(99));
        assertEquals(1, wallet.getCash());
        assertEquals(999, wallet.getBankBalance());
        assertTrue(wallet.depositCash(1));
        assertEquals(0, wallet.getCash());
        assertEquals(1000, wallet.getBankBalance());

        assertFalse(wallet.depositCash(1));
        assertEquals(0, wallet.getCash());
        assertEquals(1000, wallet.getBankBalance());
    }

    @Test
    public void testAddCreditCard() {
        assertEquals(2, wallet.getCards().size());
    }

    @Test
    public void testRemoveCreditCard() {
        wallet.removeCreditCard(cc1);
        assertEquals(1, wallet.getCards().size());
        assertEquals(cc2, wallet.getCards().get(0));
    }

    @Test
    public void testTakeOutCard() {
        CreditCard cc3 = wallet.takeOutCard("TD Amex");
        assertEquals(cc2, cc3);
        assertEquals(2, wallet.getCards().size());
    }

    @Test
    public void testSetCash() {
        wallet.setCash(200);
        assertEquals(200, wallet.getCash());
    }

}
