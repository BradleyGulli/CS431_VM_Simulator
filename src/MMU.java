public class MMU {

    private TLB tlb = new TLB();
    private PhysicalMemory physicalMemory = new PhysicalMemory();

    public void read(final int virtualPageNumber, final int offset) {
        int pageFrameNumber = tlb.read(virtualPageNumber);
        int physicalAddress;
        if (pageFrameNumber != -1) {
            physicalAddress = pageFrameNumber + offset;
            physicalMemory.readFromMemory(physicalAddress);
        } else {
            pageFrameNumber = physicalMemory.readFromPageTable(virtualPageNumber);

        }
    }

    public void write(final int address, final int valueToWrite) {

    }
}
