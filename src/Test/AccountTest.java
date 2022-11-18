package Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.*;

import Code.Business_logic.Euro;
import Code.Database.Account;

public class AccountTest {
    Account account;

    @BeforeEach
    public void beforeEach() {
        account = new Account(9631458, 12345, new Euro(1374.36), new Euro(1565.20));
    }

    @Test 
    public void testCorrectPin() {
        assertTrue(account.validatePIN(12345));
    }

    @Test 
    public void testIncorrectPin() {
        assertTrue(!account.validatePIN(74563));
    }

    @Test
    public void testGetAvailableBalance() {
        assertEquals(137436, account.getAvailableBalance().getValore());
    }

    @Test
    public void testGetAccountNumber() {
        assertEquals(9631458, account.getAccountNumber());
    }

    @Test
    public void testGetTotalBalance() {
        assertEquals(156520, account.getTotalBalance().getValore());
    }

    @Test
    public void testCredit() {
        account.credit(new Euro(12.3));
        assertEquals(157750, account.getTotalBalance().getValore());
    }

    @Test
    public void testDebit() {
        account.debit(new Euro(49.99));
        assertEquals(151521, account.getTotalBalance().getValore());
        assertEquals(132437, account.getAvailableBalance().getValore());
    }
}
