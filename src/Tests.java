import org.junit.*;

import static org.junit.Assert.*;


public class Tests {


    @Test
    public void ensureThatProgramWorks() throws Exception {
        assertEquals("https://lubart-miniatures.com/shop/page/9/?login=email", Functions.increase("https://lubart-miniatures.com/shop/page/7/?login=email", 2));
    }

    @Test
    public void ensureThatAPICallReturnStatusCode200() throws Exception {
        int responseCode = Functions.getHTTPResponse("https://lubart-miniatures.com/shop/page/7/");
        assertEquals(200, responseCode);
    }

}
