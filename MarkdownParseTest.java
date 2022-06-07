import static org.junit.Assert.*;
import org.junit.*;
import java.util.List;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
public class  MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void getLinks() throws IOException{
        List result = List.of("https://something.com", "some-thing.html");
        Path fileName = Path.of("test-file.md");
        String content = Files.readString(fileName);
        assertEquals(result, MarkdownParse.getLinks(content));
    }

    @Test
    public void getLinks1() throws IOException{
        List result = List.of("`google.com","google.com","ucsd.edu");
        Path fileName = Path.of("Snippet1.md");
        String content = Files.readString(fileName);
        assertEquals(result,MarkdownParse.getLinks(content));
    }

    @Test
    public void getLinks2() throws IOException{
        List result = List.of("a.com","a.com(())", "example.com");
        Path fileName = Path.of("Snippet2.md");
        String content = Files.readString(fileName);
        assertEquals(result,MarkdownParse.getLinks(content));
    }

    @Test
    public void getLinks3() throws IOException{
        List result = List.of("https://sites.google.com/eng.ucsd.edu/cse-15l-spring-2022/schedule");
        Path fileName = Path.of("Snippet3.md");
        String content = Files.readString(fileName);
        assertEquals(result,MarkdownParse.getLinks(content));
    }
}
