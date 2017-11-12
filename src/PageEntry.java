public class PageEntry {

    private int validBit;
    private int referenceBit;
    private int dirtyBit;
    private int pageFrameNumber;


    public PageEntry(final int validBit,
                     final int referenceBit,
                     final int dirtyBit,
                     final int pageFrameNumber) {
        this.validBit = validBit;
        this.referenceBit = referenceBit;
        this.dirtyBit = dirtyBit;
        this.pageFrameNumber = pageFrameNumber;
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
