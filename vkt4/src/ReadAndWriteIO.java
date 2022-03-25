import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

public class ReadAndWriteIO {
    public void readAndWrite(String s2){
        try {
           //BufferedReader br = new BufferedReader(new FileReader(s1));
            //BufferedWriter bw = new BufferedWriter(new FileWriter(s2)); 
            ZipFile zipFile = new ZipFile(s2);

            FileInputStream input = new FileInputStream(s2);
            ZipInputStream zip = new ZipInputStream(input);
            ZipEntry entry = zip.getNextEntry();

            InputStream text = zipFile.getInputStream(entry);
            BufferedReader br = new BufferedReader(new InputStreamReader(text));
            String output = "";
            while((output = br.readLine()) != null){
                System.out.println(output.trim());
            }

            br.close();
            
        } catch (IOException e) {
            e.printStackTrace();}
        }
}
