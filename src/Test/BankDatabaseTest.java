package Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import Code.Business_logic.Euro;
import Code.Database.BankDatabase;

public class BankDatabaseTest {
    BankDatabase database;
    @Before
    public void before() {
         database = new BankDatabase();
    }
    
    @Test
    public void testAuthenticateUser() {
        assertTrue(database.authenticateUser(12345, 54321));
    }

    @Test
    public void testFailAuthenticateUser() {
        assertTrue(!database.authenticateUser(3489, 9843));
    }

    @Test
    public void testCredit() {
        database.credit(12345, new Euro(200.0));
        assertEquals(140000, database.getTotalBalance(12345).getValore());

    }

    @Test
    public void testDebit() {
        database.debit(12345, new Euro(200.0));
        assertEquals(100000, database.getTotalBalance(12345).getValore());
        assertEquals(80000, database.getAvailableBalance(12345).getValore());
    }

    @Test
    public void testGetAvailableBalance() {
        assertEquals(100000, database.getAvailableBalance(12345).getValore());
    }

    @Test
    public void testGetTotalBalance() {
        assertEquals(120000, database.getTotalBalance(12345).getValore());
    }
}
