import java.io.InputStream;

public class Mainclass {
    public static void main(String[] args) throws Exception {
    
        ReadAndWriteIO io = new ReadAndWriteIO();

        String luettava = "zipinput.zip";

        io.readAndWrite(luettava);    
    }
}
