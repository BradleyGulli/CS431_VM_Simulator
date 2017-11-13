import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) {
        String testFileName = args[0];

        copyToWorkingDirectory();

    }

    private static void copyToWorkingDirectory(){
        String pageFilesDir = "Project2_test_and_page_files/page_files/";
        String workingDir = "Working_Directory/page_files/";

        File[] files = new File(pageFilesDir).listFiles();


        try {
            Files.createDirectories(Paths.get(workingDir));
            for(File file : files){
                Files.createFile(Paths.get(workingDir+file.getName()));
            }

        } catch (Exception e){

        }

        for(File file : files){
            Path source = Paths.get(file.getPath());
            Path dest = Paths.get(workingDir+file.getName());
            List<String> data = new ArrayList<>();

            try {
                data = Files.readAllLines(source);
            }catch (Exception e){ }


            try {
                Files.write(dest,data);
            }catch (Exception e){
                System.out.print("Write Error\n");

            }
        }
    }


}
