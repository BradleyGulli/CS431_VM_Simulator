public class ClockList {

    private ClockEntry head;
    private ClockEntry tail;
    private ClockEntry hand;

    public void add(final ClockEntry clockEntry) {

        if (head == null) {
            head = clockEntry;
            tail = clockEntry;
            tail.setNext(head);
            hand = head;
        } else {
            tail.setNext(clockEntry);
            tail = clockEntry;
            tail.setNext(head);
        }
    }

    public ClockEntry get(final int pageFrameNumber) {
        ClockEntry cursor = head;
        while (cursor.getPageFrameNumber() != pageFrameNumber) {
            cursor = cursor.getNext();
        }
        return cursor;
    }

    public void clockTick() {
        hand = hand.getNext();
    }

    public PageEntry getPointedPage() {
        return hand.getPageEntry();
    }
}
