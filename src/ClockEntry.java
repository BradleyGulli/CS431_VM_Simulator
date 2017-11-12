public class ClockEntry {

    private int pageFrameNumber;
    private PageEntry pageEntry;
    private ClockEntry next;

    public ClockEntry(final int pageFrameNumber, final ClockEntry next, final PageEntry pageEntry) {
        this.pageFrameNumber = pageFrameNumber;
        this.next = next;
        this.pageEntry = pageEntry;
    }

    public int getPageFrameNumber() {
        return pageFrameNumber;
    }

    public void setPageFrameNumber(final int pageFrameNumber) {
        this.pageFrameNumber = pageFrameNumber;
    }

    public ClockEntry getNext() {
        return next;
    }

    public void setNext(final ClockEntry next) {
        this.next = next;
    }
}
