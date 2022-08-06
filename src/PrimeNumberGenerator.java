import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class PrimeNumberGenerator extends NumberGenerator{
    @Override
    int getNumber(int position) {
        String line = "";
        try (Stream<String> lines = Files.lines(Paths.get("/Users/admin/IdeaProjects/recursive_self_inverting_pattern/primes"))) {
            if(lines.skip(position).findFirst().isPresent()) {
                line = lines.skip(position).findFirst().get();
            }
            System.out.println(line);
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
        return Integer.parseInt(line);
    }
}
