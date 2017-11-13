public class ClockEntry {

    private PageEntry pageEntry;
    private ClockEntry next;
    private int pageFrameNumber;

    public ClockEntry(final int pageFrameNumber) {
        this.pageFrameNumber = pageFrameNumber;
    }

    public ClockEntry getNext() {
        return next;
    }

    public void setNext(final ClockEntry next) {
        this.next = next;
    }

    public PageEntry getPageEntry() {
        return pageEntry;
    }

    public void setPageEntry(final PageEntry pageEntry) {
        this.pageEntry = pageEntry;
    }

    public int getPageFrameNumber() {
        return pageFrameNumber;
    }

    public void setPageFrameNumber(final int pageFrameNumber) {
        this.pageFrameNumber = pageFrameNumber;
    }
}
