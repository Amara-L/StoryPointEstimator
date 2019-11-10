package jhack.spe.tests;

import jhack.spe.services.TestService;
import jhack.spe.services.TestServiceImp;
import jhack.spe.tests.mocks.TestDAOMock;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * Test class for TestService business logic.
 *
 * @author FirstName S. LastName
 * @version 1.0.0 created 09.11.2019
 */
@RunWith(MockitoJUnitRunner.class) // <--- annotation indicating about use mocks
public class TestTestClass {

    /**
     * Mock-object TestDAO.
     */
    @Spy
    private TestDAOMock testDAOMock;

    /**
     * Object TestService with initialisation mock-object TestDAO
     */
    @InjectMocks // <--- add mock-object (TestDAOMock) in TestService
    private TestService testService = new TestServiceImp();

    /**
     * Test-method check method getNameUserById() in TestService.
     */
    @Test  // <--- annotation indicating test method
    public void checkUserName() {

        Assert.assertEquals(testService.getNameUserById(0), "Pierre");
        Assert.assertEquals(testService.getNameUserById(2), "Andreas");

    }

}
