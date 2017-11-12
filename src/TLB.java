import java.util.ArrayList;

public class TLB {

    private TLBEntry[] tlbEntries = new TLBEntry[8];

    public int read(final int pageNumber) {
        TLBEntry correctEntry = null;
        for (TLBEntry entry : tlbEntries) {
            if (entry.getVirtualPageNumber() == pageNumber) {
                return entry.getPageFrameNumber();
            }
        }
        return -1;
    }
}
