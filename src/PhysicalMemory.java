import java.util.stream.IntStream;

public class PhysicalMemory {

    private int[][] memory = new int[16][256];
    private VirtualPageTable pageTable = new VirtualPageTable();

    public PhysicalMemory() {
        for (int[] frame : memory) {
            frame[0] = -1;
        }
    }

    public void updatePageTable(final int virtualAddress, final int pageFrameNumber) {
        pageTable.updatePage(virtualAddress, pageFrameNumber);
    }

    public int readFromMemory(final int frame, final int offset) {
      return memory[frame][offset];
    }

    public int readFromPageTable(final int virtualAddress) {
        return pageTable.read(virtualAddress);
    }

    public void evict(final int frameNumber) {
        IntStream.range(0,256).forEach(i -> memory[frameNumber][i] = -1);
    }

    public void insertPage(final int frameNumber, final int[] data) {
        memory[frameNumber] = data;

    }

    public VirtualPageTable getPageTable() {
        return pageTable;
    }

    public int nextAvailableFrame() {
        for (int i = 0; i < 16; i++) {
            if (memory[i][0] == -1) {
                return i;
            }
        }
        return -1;
    }

}
