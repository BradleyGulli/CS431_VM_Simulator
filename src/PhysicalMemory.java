public class PhysicalMemory {

    private int[][] memory = new int[16][256];
    private VirtualPageTable pageTable = new VirtualPageTable();

    public void updatePageTable(final int virtualAddress, final int pageFrameNumber) {
        pageTable.updatePage(virtualAddress, pageFrameNumber);
    }

    public int readFromMemory(final int address) {
      return 0;
    }

    public int readFromPageTable(final int virtualAddress) {
        return pageTable.read(virtualAddress);
    }

    private void evict() {

    }

    public VirtualPageTable getPageTable() {
        return pageTable;
    }
}
