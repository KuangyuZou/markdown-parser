//https://howtodoinjava.com/java/io/java-read-file-to-string-examples/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {

    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then read link upto next )
        int currentIndex = 0;
        int line = 1;
        while(currentIndex < markdown.length()) {
            System.out.println(currentIndex);
            int openBracket = markdown.indexOf("[", currentIndex);
            int closeBracket = markdown.indexOf("]", openBracket);
            int openParen = markdown.indexOf("(", closeBracket);
            int closeParen = markdown.indexOf(")", openParen);
            if((openParen < 0) || (closeParen > markdown.length())){
                break;
            }
            if(markdown.substring(openBracket + 1, closeBracket).equals("Image")){
                break;
            }
            // if(openBracket == 0){
            //     toReturn.add(markdown.substring(openParen + 1, closeParen));
            //     return toReturn;
            // }
            else{
                toReturn.add(markdown.substring(openParen + 1, closeParen));
                currentIndex = closeParen + 1;
            }

        }

        return toReturn;
    }


    public static void main(String[] args) throws IOException {
        List result = List.of("https://sites.google.com/eng.ucsd.edu/cse-15l-spring-2022/schedule");
        Path fileName = Path.of("Snippet3.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = getLinks(content);
        System.out.println(links);
        // Path fileName = Path.of(args[0]);
        // String content = Files.readString(fileName);
        // ArrayList<String> links = getLinks(content);
	    // System.out.println(links);
        // System.out.println("good day");

    }
}
