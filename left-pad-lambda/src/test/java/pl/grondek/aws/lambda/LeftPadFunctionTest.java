package pl.grondek.aws.lambda;

import org.junit.Assert;
import org.junit.Test;

public class LeftPadFunctionTest {

    @Test
    public void testFunction() {
        // setup
        LeftPadFunction leftPadFunction = new LeftPadFunction();

        // given
        PadRequest request = new PadRequest();
        request.setCharacter(' ');
        request.setSize(10);
        request.setString("Test");

        // when
        final String response = leftPadFunction.handleRequest(request, null);

        // then
        Assert.assertEquals(response.length(), 10);
        Assert.assertEquals(response, "      Test");
    }
}