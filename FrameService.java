import java.util.ArrayList;
import java.util.List;

public class FrameService implements Constants {
    private static FrameService frameService;
    private List<Frame> frames;

    private FrameService() {
    }

    public static FrameService getService() {
        if (frameService == null) {
            return frameService = new FrameService();
        }
        return frameService;
    }

    public void loadFrames() {
        LoadFrame lf = new LoadFrameFromDirectory();
        if (lf.load() == null) {
            frames = new ArrayList<>();
        } else {
            frames = lf.load();
        }
    }

    public void saveFrames() {
        SaveFrame sf = new SaveFrameInDirectory();
        sf.save(frames);
    }

    public void displayAllFrames() {
        if (frames.isEmpty()) {
            System.out.println("Список пуст");
        } else {
            System.out.println("\nНачало списка\n");
            for (Frame fr : frames) {
                System.out.println(fr.toString());
            }
            System.out.println("\nКонец списка\n");

        }
    }

    public List<Frame> getFrames() {
        return frames;
    }

    public List<Frame> findFramesBySlot(List<Frame> frames, Frame prototype) {
        FindFrame ff = new FindFrameBySlot();
        return ff.find(frames, prototype);
    }

    public List<Frame> findFramesByName(List<Frame> frames, Frame prototype) {
        FindFrame ff = new FindFrameByName();
        return ff.find(frames, prototype);
    }

    public void addFrame() {
        System.out.print("Введите название фрейма: ");
        String frameName = SCANNER.nextLine();
        Frame frame = new Frame(frameName);
        System.out.print("Введите количество слотов: ");
        int slotsCount = SCANNER.nextInt();
        SCANNER.nextLine(); // очистка буфера после ввода числа
        for (int i = 0; i < slotsCount; i++) {
            System.out.print("Введите название слота: ");
            String slotName = SCANNER.nextLine();
            System.out.print("Введите значение слота: ");
            String slotValue = SCANNER.nextLine();
            frame.addSlot(slotName, slotValue);
        }
        frames.add(frame);
        System.out.println("Фрейм успешно добавлен.");
    }

    public void searchFrame() {
        Frame searchPrototype = Frame.getFramePrototype();
        System.out.print("Введите количество слотов в поисковом образце: ");
        int slotsCount = SCANNER.nextInt();
        SCANNER.nextLine(); // очистка буфера после ввода числа
        for (int i = 0; i < slotsCount; i++) {
            System.out.print("Введите название слота: ");
            String slotName = SCANNER.nextLine();
            System.out.print("Введите значение слота: ");
            String slotValue = SCANNER.nextLine();
            searchPrototype.addSlot(slotName, slotValue);
        }

        List<Frame> matchingFrames = findFramesBySlot(frames, searchPrototype);
        System.out.println("Найденные фреймы:");
        for (Frame frame : matchingFrames) {
            System.out.println(frame.toString());

        }

    }
}
