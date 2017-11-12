public class ClockList {

    private ClockEntry head;
    private ClockEntry tail;
    private ClockEntry hand;

    public void add(final ClockEntry clockEntry) {
        if (head == null) {
            head = clockEntry;
            tail = clockEntry;
            tail.setNext(head);
        } else {
            tail.setNext(clockEntry);
            tail = clockEntry;
            tail.setNext(head);
        }
    }

    public void clockTick() {
        hand = hand.getNext();
    }
}
