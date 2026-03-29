package sit707_week4;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests functions in LoginForm.
 * @author 
 */
public class LoginFormTest 
{

    //  Required identity tests
    @Test
    public void testStudentIdentity() {
        System.out.println("Running testStudentIdentity...");
        String studentId = "225168932";
        Assert.assertNotNull("Student ID is null", studentId);
        System.out.println("Student ID Test Passed");
    }

    @Test
    public void testStudentName() {
        System.out.println("Running testStudentName...");
        String studentName = "Palak Rani";
        Assert.assertNotNull("Student name is null", studentName);
        System.out.println("Student Name Test Passed");
    }

    // =============================
    // ❌ FAILURE CASES (Decision Table)
    // =============================

    // R1: Empty username & password
    @Test
    public void testEmptyUsernameAndPassword() {
        System.out.println("Running testEmptyUsernameAndPassword...");
        LoginStatus status = LoginForm.login(null, null);
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Empty Username", status.getErrorMsg());
        System.out.println("testEmptyUsernameAndPassword Passed");
    }

    // R2: Empty username, wrong password
    @Test
    public void testEmptyUsernameWrongPassword() {
        System.out.println("Running testEmptyUsernameWrongPassword...");
        LoginStatus status = LoginForm.login(null, "xyz");
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Empty Username", status.getErrorMsg());
        System.out.println("testEmptyUsernameWrongPassword Passed");
    }

    // R3: Wrong username, wrong password
    @Test
    public void testWrongUsernameWrongPassword() {
        System.out.println("Running testWrongUsernameWrongPassword...");
        LoginStatus status = LoginForm.login("abc", "xyz");
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Credential mismatch", status.getErrorMsg());
        System.out.println("testWrongUsernameWrongPassword Passed");
    }

    // R4: Correct username, empty password
    @Test
    public void testCorrectUsernameEmptyPassword() {
        System.out.println("Running testCorrectUsernameEmptyPassword...");
        LoginStatus status = LoginForm.login("ahsan", null);
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Empty Password", status.getErrorMsg());
        System.out.println("testCorrectUsernameEmptyPassword Passed");
    }

    // R5: Correct username, wrong password
    @Test
    public void testCorrectUsernameWrongPassword() {
        System.out.println("Running testCorrectUsernameWrongPassword...");
        LoginStatus status = LoginForm.login("ahsan", "xyz");
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Credential mismatch", status.getErrorMsg());
        System.out.println("testCorrectUsernameWrongPassword Passed");
    }

    // R6: Wrong username, correct password
    @Test
    public void testWrongUsernameCorrectPassword() {
        System.out.println("Running testWrongUsernameCorrectPassword...");
        LoginStatus status = LoginForm.login("abc", "ahsan_pass");
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Credential mismatch", status.getErrorMsg());
        System.out.println("testWrongUsernameCorrectPassword Passed");
    }

    // =============================
    // ✅ SUCCESS CASE
    // =============================

    // R7: Correct username & password
    @Test
    public void testValidLogin() {
        System.out.println("Running testValidLogin...");
        LoginStatus status = LoginForm.login("ahsan", "ahsan_pass");
        Assert.assertTrue(status.isLoginSuccess());
        Assert.assertEquals("123456", status.getErrorMsg());
        System.out.println("testValidLogin Passed");
    }

    // =============================
    //  VALIDATION CODE TESTING
    // =============================

    // R8: Empty validation code
    @Test
    public void testEmptyValidationCode() {
        System.out.println("Running testEmptyValidationCode...");
        boolean result = LoginForm.validateCode(null);
        Assert.assertFalse(result);
        System.out.println("testEmptyValidationCode Passed");
    }

    // R9: Wrong validation code
    @Test
    public void testWrongValidationCode() {
        System.out.println("Running testWrongValidationCode...");
        boolean result = LoginForm.validateCode("abcd");
        Assert.assertFalse(result);
        System.out.println("testWrongValidationCode Passed");
    }

    // R10: Correct validation code
    @Test
    public void testCorrectValidationCode() {
        System.out.println("Running testCorrectValidationCode...");
        boolean result = LoginForm.validateCode("123456");
        Assert.assertTrue(result);
        System.out.println("testCorrectValidationCode Passed");
    }
}