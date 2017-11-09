public class TLBEntry {

    private final int virtualPageNumber;
    private final int validBit;
    private final int referenceBit;
    private final int dirtyBit;
    private final int pageFrameNumber;

    public TLBEntry(final int virtualPageNumber,
                    final int validBit,
                    final int referenceBit,
                    final int dirtyBit,
                    final int pageFrameNumber) {
        this.virtualPageNumber = virtualPageNumber;
        this.validBit = validBit;
        this.dirtyBit = dirtyBit;
        this.referenceBit = referenceBit;
        this.pageFrameNumber = pageFrameNumber;
    }


}
