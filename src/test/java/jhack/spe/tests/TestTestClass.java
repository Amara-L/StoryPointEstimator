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

@RunWith(MockitoJUnitRunner.class) // <--- annotation indicating about use mocks
public class TestTestClass {

    @Spy
    private TestDAOMock testDAOMock;

    @InjectMocks // <--- add mock-object (TestDAOMock) in TestService
    private TestService testService = new TestServiceImp();

    @Test  // <--- annotation indicating test method
    public void checkUserName() {

        Assert.assertEquals(testService.getNameUserById(0), "Pierre");
        Assert.assertEquals(testService.getNameUserById(2), "Andreas");

    }

}
