package studentinfo;

import java.math.BigDecimal;
import java.util.*;

import com.jimbob.ach.Ach;
import com.jimbob.ach.AchCredentials;
import com.jimbob.ach.AchResponse;
import com.jimbob.ach.AchStatus;
import com.jimbob.ach.AchTransactionData;

import junit.framework.Assert;
import junit.framework.TestCase;

public class AccountTest extends TestCase {
    static final String ABA = "102000012";
    static final String ACCOUNT_NUMBER = "194431518811";

    private Account account;

    @Override
    protected void setUp() throws Exception {
        account = new Account();
        account.setBankABa(ABA);
        account.setBankAccountNumber(ACCOUNT_NUMBER);
        account.setBankAccountType(Account.BankAccountType.CHECKING);
    }
	
    public void testTransactions() {
        account.credit(new BigDecimal("0.10"));
        account.credit(new BigDecimal("11.00"));
        assertEquals(new BigDecimal("11.10"), account.getBalance());
    }

    public void testTransactionAverage() {
        Account account = new Account();
        account.credit(new BigDecimal("0.10"));
        account.credit(new BigDecimal("11.00"));
        account.credit(new BigDecimal("2.99"));
        assertEquals(new BigDecimal("4.70"), account.transactionAverage());
    }

    public void testAverageForNoScores() {
        Performance performance = new Performance();
        assertEquals(0.0, performance.average());
    }

    public void testFlags() {
        Student student = new Student("a");
        student.set(Student.Flag.ON_CAMPUS, Student.Flag.TAX_EXEMPT, Student.Flag.MINOR);
        assertTrue(student.isOn(Student.Flag.ON_CAMPUS));
        assertTrue(student.isOn(Student.Flag.TAX_EXEMPT));
        assertTrue(student.isOn(Student.Flag.MINOR));

        assertFalse(student.isOff(Student.Flag.ON_CAMPUS));
        assertTrue(student.isOff(Student.Flag.TROUBLEMAKER));

        student.unset(Student.Flag.ON_CAMPUS);
        assertTrue(student.isOff(Student.Flag.ON_CAMPUS));
        assertTrue(student.isOn(Student.Flag.TAX_EXEMPT));
        assertTrue(student.isOn(Student.Flag.MINOR));
    }

    public void testTransferFromBank() {
        Ach mockAch = new MockAch() {
            public AchResponse issueDebit(AchCredentials credentials, AchTransactionData data) {

                return null;

            }

            public AchResponse markTransactionAsNSF(AchCredentials credentials, AchTransactionData data, String traceCode) {
                return null;
            }

            public AchResponse refundTransaction(AchCredentials credentials, AchTransactionData data, String traceCode) {
                return null;
            }

            public AchResponse issueCredit(AchCredentials credentials, AchTransactionData data) {
                return null;
            }

            public AchResponse voidSameDayTransaction(AchCredentials credentials, AchTransactionData data, String traceCode) {
                return null;
            }

            public AchResponse queryTransactionStatus(AchCredentials credentials, AchTransactionData data) {
                return null;
            }
        };
//		account.setAch(new MockAch());
        account.setAch(crateMockAch(AchStatus.SUCCESS));
        final BigDecimal amount = new BigDecimal("50.00");
        account.transferFromBank(amount);

        assertEquals(amount, account.getBalance());
    }

    private Ach crateMockAch(final AchStatus status) {
        return new MockAch() {
            public AchResponse issueDebit(AchCredentials credentials, AchTransactionData data) {
                Assert.assertTrue(data.account.equals(AccountTest.ACCOUNT_NUMBER));
                Assert.assertTrue(data.aba.equals(AccountTest.ABA));

                AchResponse response = new AchResponse();
                response.timestamp = new Date();
                response.traceCode = "1";
                response.status = status;
                return response;
            }
        };
    }

    public void testFailedTransferFromBank() {
        account.setAch(crateMockAch(AchStatus.FAILURE));
        final BigDecimal amount = new BigDecimal("50.00");
        account.transferFromBank(amount);
        assertEquals(new BigDecimal("0.00"), account.getBalance());
    }
}
