import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class RSIP {


    public static void main(String[] args) {
        RSIP out = new RSIP();
        NumberGenerator numGen = new IntegerNumberGenerator();
        Pattern p;
        try {
            p = new Pattern("01");
            //System.out.println(p);
            for(int i = 0; i < 4; i++) {
                System.out.println("Iteration: " + (i+1) + " (i=" + i + ")");
                p=p.iterate();
                System.out.println(p);
                System.out.println("Size: " + p.size());
                System.out.println();
            }

        } catch (ErroneousPatternException e) {
            throw new RuntimeException(e);
        }

        int sum = 0;
        for(int i = 0; i < 65536; i++) {
            if(Boolean.TRUE.equals(p.poll())) {
                sum -= numGen.getNumber(i);
            } else {
                sum += numGen.getNumber(i);
            }
            System.out.println(sum);
            out.writeToFile(sum);
        }

    }
        private FileOutputStream fO;

        public RSIP(){
            try {
                this.fO = new FileOutputStream("int_sums");
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        public void writeToFile(Integer i) {
            try {
                String toWrite = "";
                toWrite+=i.toString();
                toWrite+="\n";
                this.fO.write(toWrite.getBytes());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

}

