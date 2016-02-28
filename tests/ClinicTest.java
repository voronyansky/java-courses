package tests;
import org.junit.Test;
import junit.framework.*;
import src.calculator.Clinic;

/**
 * Created with IntelliJ IDEA.
 * User: Egor
 * Date: 22.02.16
 * Test for clinic
 */
public class ClinicTest {

    @Test
    public void createClinic()
    {
        Assert.assertNotNull(new Clinic(10));
    }

    @Test
    public void addClient()
    {
        Clinic clinic = new Clinic(10);
        clinic.addClient();
    }

}
