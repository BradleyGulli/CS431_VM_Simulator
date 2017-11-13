import java.io.FileNotFoundException;
import java.util.Scanner;

public class MMU {

    private TLB tlb = new TLB();
    private PhysicalMemory physicalMemory;
    private CPU cpu;

    public MMU(final CPU cpu, final PhysicalMemory physicalMemory) {
        this.cpu = cpu;
        this.physicalMemory = physicalMemory;
    }

    public boolean read(final int virtualPageNumber, final int offset) throws FileNotFoundException {
        int pageFrameNumber = tlb.read(virtualPageNumber);
        int physicalAddress;
        if (pageFrameNumber != -1) {
            Main.writeToCSV("0,0,1");
            physicalMemory.readFromMemory(pageFrameNumber, offset - 1);
            return true;
        } else {
            Main.writeToCSV("1,");
            pageFrameNumber = physicalMemory.readFromPageTable(virtualPageNumber);
            if (pageFrameNumber != -1) {
                Main.writeToCSV("0,0");
                System.out.println(physicalMemory.readFromMemory(pageFrameNumber, offset));
                return true;
            } else {
                cpu.getOperatingSystem().readFromDisk("Working_Directory/page_files", virtualPageNumber);
                return false;

            }
        }
    }

    public void write(final int address, final int valueToWrite) {

    }
}
