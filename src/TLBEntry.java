public class TLBEntry {

    private int virtualPageNumber;
    private int validBit;
    private int referenceBit;
    private int dirtyBit;
    private int pageFrameNumber;

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

    public int getVirtualPageNumber() {
        return virtualPageNumber;
    }

    public void setVirtualPageNumber(final int virtualPageNumber) {
        this.virtualPageNumber = virtualPageNumber;
    }

    public int getValidBit() {
        return validBit;
    }

    public void setValidBit(final int validBit) {
        this.validBit = validBit;
    }

    public int getReferenceBit() {
        return referenceBit;
    }

    public void setReferenceBit(final int referenceBit) {
        this.referenceBit = referenceBit;
    }

    public int getDirtyBit() {
        return dirtyBit;
    }

    public void setDirtyBit(final int dirtyBit) {
        this.dirtyBit = dirtyBit;
    }

    public int getPageFrameNumber() {
        return pageFrameNumber;
    }

    public void setPageFrameNumber(final int pageFrameNumber) {
        this.pageFrameNumber = pageFrameNumber;
    }
}
