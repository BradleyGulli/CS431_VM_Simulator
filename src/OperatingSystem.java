public class OperatingSystem {

    private CPU cpu = new CPU();
    private PhysicalMemory physicalMemory = new PhysicalMemory();
    private ClockList clockList = new ClockList();

    private void clockTick() {
        clockList.clockTick();
    }

}
