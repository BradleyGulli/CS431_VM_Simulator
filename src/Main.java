import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        String testFileName = args[0];


        copyToWorkingDirectory();
        creatingOutput();

        CPU cpu = new CPU();
        cpu.read(testFileName);

    }

    private static void copyToWorkingDirectory(){

        String pageFilesDir = "Project2_test_and_page_files/page_files/";
        String workingDir = "Working_Directory/page_files/";

        File[] files = new File(pageFilesDir).listFiles();


        try {
            Files.createDirectories(Paths.get(workingDir));
            for(File file : files) {
                Files.createFile(Paths.get(workingDir+file.getName()));
            }

        } catch (Exception e){

        }

        for(File file : files) {
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

    private static void creatingOutput() {

        final String HEADER = "Address, Read/Write, SoftMiss, HardMiss, AHit, PageFault, ReadIn/WriteOut\n";
        final String fileName = "Working_Directory/outputs.csv";

        File file = new File(fileName);

        if (file.exists()){
            file.delete();
        }

        try {
            Path destination = Paths.get(fileName);
            Files.createFile(destination);
        } catch (IOException e){ }

        writeToCSV(HEADER);
    }

    public static void writeToCSV(String content){
        final String fileName = "Working_Directory/outputs.csv";

        try {
            FileWriter fw = new FileWriter(fileName, true);
            fw.append(content);
            fw.close();
        } catch (IOException e) {
            System.out.print("Write Error\n");
        }
    }







}
