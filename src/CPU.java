import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CPU {

    private PhysicalMemory physicalMemory = new PhysicalMemory();
    private final MMU mmu = new MMU(this, physicalMemory);
    private final OperatingSystem operatingSystem = new OperatingSystem(physicalMemory);

    public void read(final String fileName) throws FileNotFoundException {

        Scanner scanner = new Scanner(new File(fileName));

        while (scanner.hasNext()) {

            int operationToDo = scanner.nextInt();

            if (operationToDo == 0) {
                String virtualAddress = scanner.next();
                int pageNumber = Integer.parseInt(virtualAddress.substring(0, 2), 16);
                int offset = Integer.parseInt(virtualAddress.substring(2,4), 16);
                Main.writeToCSV(virtualAddress + ',');
                Main.writeToCSV("0,");
                if (!mmu.read(pageNumber, offset)) {
                    Main.writeToCSV("\n" + virtualAddress + "," + "0,");
                    mmu.read(pageNumber, offset);
                    Main.writeToCSV("\n");
                }
             } else {
                mmu.write(Integer.parseInt(scanner.next(), 16), scanner.nextInt());
            }
            operatingSystem.incrementCpuTime();
        }

    }

    public OperatingSystem getOperatingSystem() {
        return operatingSystem;
    }
}

