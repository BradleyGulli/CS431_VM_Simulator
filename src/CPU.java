import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CPU {

    private final MMU mmu = new MMU();

    private void read(final String fileName) throws FileNotFoundException {

        Scanner scanner = new Scanner(new File(fileName));

        while (scanner.hasNext()) {

            int operationToDo = scanner.nextInt();

            if (operationToDo == 0) {
                String virtualAddress = scanner.nextLine();
                int pageNumber = Integer.parseInt(virtualAddress.substring(0, 1), 16);
                int offset = Integer.parseInt(virtualAddress.substring(2,3), 16);
                mmu.read(pageNumber, offset);
             } else {
                mmu.write(Integer.parseInt(scanner.nextLine(), 16), scanner.nextInt());
            }
        }

    }
}

