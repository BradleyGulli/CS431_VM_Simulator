import java.util.Scanner;
import java.util.stream.IntStream;

public class OperatingSystem {

    private CPU cpu = new CPU();
    private PhysicalMemory physicalMemory = new PhysicalMemory();
    private ClockList clockList = new ClockList();

    public OperatingSystem() {
        initClock();
    }

    public void clockTick() {
        clockList.clockTick();
    }

    public void readFromDisk(final String filePathToDisk, final int pageNumber) {
        String pathToPage = filePathToDisk + pageNumber;
        Scanner scanner = new Scanner(pathToPage);
        int[] data = new int[256];
        IntStream.range(0,256).forEach(i -> data[i] = scanner.nextInt());
        int emptyFrame = physicalMemory.nextAvailableFrame();
        if (emptyFrame != -1) {
           updatePageInformation(data, pageNumber, emptyFrame);
        } else {
            emptyFrame = evictFromMemory();
            updatePageInformation(data, pageNumber, emptyFrame);
        }
    }

    private void updatePageInformation(final int[] data, final int pageNumber, final int emptyFrame) {
        physicalMemory.insertPage(emptyFrame, data);
        physicalMemory.getPageTable().updatePage(pageNumber, emptyFrame);
        clockList.get(emptyFrame).setPageEntry(physicalMemory.getPageTable().getPages()[pageNumber]);
    }


    private int evictFromMemory() {
        PageEntry pointedPage = clockList.getPointedPage();
        while (pointedPage.getReferenceBit() != 1) {
            clockList.clockTick();
            pointedPage = clockList.getPointedPage();
        }
        physicalMemory.evict(pointedPage.getPageFrameNumber());
        pointedPage.setValidBit(0);
        return pointedPage.getPageFrameNumber();
    }

    private void initClock() {
        IntStream.range(0,16).forEach(i -> clockList.add(new ClockEntry(i)));
    }

}
