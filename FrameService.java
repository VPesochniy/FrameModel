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
            System.out.println("\n\n\t\tНачало списка\n\n");
            for (Frame fr : frames) {
                System.out.println(fr.toString());
            }
            System.out.println("\n\n\t\tКонец списка\n\n");

        }
    }

    public List<Frame> getFrames() {
        return frames;
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
        System.out.println("Фрейм успешно добавлен\n\n");
    }

    public void searchFrameBySlot() {
        MakeFramePrototype mfp = new MakeFramePrototypeWithSlot();
        Frame searchPrototype = mfp.getPrototype();

        FindFrame ff = new FindFrameBySlot();
        List<Frame> matchingFrames = ff.find(frames, searchPrototype);
        System.out.println("\n\nНайденные фреймы:\n\n");
        for (Frame frame : matchingFrames) {
            System.out.println(frame.toString());
        }

    }

    public void searchFrameByName() {
        MakeFramePrototype mfp = new MakeFramePrototypeWithName();
        Frame searchPrototype = mfp.getPrototype();

        FindFrame ff = new FindFrameByName();
        List<Frame> matchingFrames = ff.find(frames, searchPrototype);
        System.out.println("\n\nНайденные фреймы:\n\n");
        for (Frame frame : matchingFrames) {
            System.out.println(frame.toString());
        }

    }
}
