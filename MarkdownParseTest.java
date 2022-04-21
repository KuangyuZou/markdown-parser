import static org.junit.Assert.*;
import org.junit.*;
import java.util.List;
public class  MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void getLinks(){
        List result = List.of("https://something.com", "some-page.html");
        assertEquals(result, MarkdownParse.getLinks("test-file.md"));
    }
    
}
