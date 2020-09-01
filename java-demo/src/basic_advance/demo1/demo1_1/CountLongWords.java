package basic_advance.demo1.demo1_1;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 * @author ljj
 * @description
 * @date 2020-08-31
 */
public class CountLongWords
{
    public static void main(String[] args) throws IOException {
        String contents = new String(Files.readAllBytes(Paths.get("J:\\项目\\keep\\java-demo\\src\\basic_advance\\demo1\\alice.txt")), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(contents.split("\\PL+"));
        long count =0;
        for (String word : words) {
            if (word.length() > 12) {
                count++;
            }
        }

        System.out.println(count);

        long count1 = words.stream().filter(w -> w.length() > 12).count();
        System.out.println(count1);

        long count2 = words.parallelStream().filter(w -> w.length() > 12).count();
        System.out.println(count2);
    }
}
