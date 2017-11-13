import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.stream.IntStream;

public class OperatingSystem {

    private int cpuTime = 0;
    private PhysicalMemory physicalMemory;
    private ClockList clockList = new ClockList();

    public OperatingSystem(final PhysicalMemory physicalMemory) {
        initClock();
        this.physicalMemory = physicalMemory;
    }

    public void clockTick() {
        clockList.clockTick();
    }

    public void readFromDisk(final String filePathToDisk, final int pageNumber) throws FileNotFoundException {
        String pageNumberFileName = Integer.toHexString(pageNumber).toUpperCase();
        if (pageNumberFileName.length() == 1) {
            pageNumberFileName = '0' + pageNumberFileName;
        }
        String pathToPage = filePathToDisk + '/' + pageNumberFileName + ".pg";
        Scanner scanner = new Scanner(new File(pathToPage));
        int[] data = new int[256];
        for (int i = 0; i < 256; i++) {
            int val = scanner.nextInt();
            data[i] = val;
        }
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
        while (pointedPage.getReferenceBit() == 1) {
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

    public void incrementCpuTime() {
        cpuTime++;
        if (cpuTime % 5 == 0) {
            for (int i = 0; i < 16; i++) {
                if (clockList.get(i).getPageEntry() != null) {
                    clockList.get(i).getPageEntry().setReferenceBit(0);
                }
            }
        }
    }

}
