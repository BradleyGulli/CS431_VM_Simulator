import java.util.stream.IntStream;

public class VirtualPageTable {

    private static final int SIZE = 256;
    private final PageEntry[] pages = new PageEntry[SIZE];

    public VirtualPageTable() {
        IntStream.range(0, SIZE)
                .forEach(i -> pages[i] = new PageEntry(0,0,0,-1));
    }

    public void updatePage(final int virtualAddress, final int pageFrameNumber) {
        PageEntry pageEntry = pages[virtualAddress];
        pageEntry.setValidBit(1);
        pageEntry.setPageFrameNumber(pageFrameNumber);
        pageEntry.setReferenceBit(0);
        pageEntry.setDirtyBit(0);
    }

    public int read(final int virtualAddress) {
        PageEntry pageEntry = pages[virtualAddress];
        if (pageEntry.getValidBit() == 1) {
            return pageEntry.getPageFrameNumber();
        } else {
            return -1;
        }
    }

    public void setReferenceBit(final int virtualAddress) {
        pages[virtualAddress].setReferenceBit(1);
    }

    public PageEntry[] getPages() {
        return pages;
    }
}
