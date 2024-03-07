import java.util.ArrayList;
import java.util.Iterator;
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
        if (!frames.isEmpty()) {
            System.out.println("\n\n\t\tНачало списка\n\n");
            for (Frame fr : frames) {
                System.out.println(fr.toString());
            }
            System.out.println("\n\n\t\tКонец списка\n\n");
        } else {
            System.out.println("Список пуст");
        }
    }

    public void displayAllFrames(boolean isCount) {
        if (!frames.isEmpty()) {
            System.out.println("\n\n\t\tНачало списка\n\n");
            int counter = 1;
            for (Frame fr : frames) {
                if (isCount) {

                    System.out.println(counter + ". " + fr.toString());
                    counter++;
                } else {

                    System.out.println(fr.toString());
                }

            }
            System.out.println("\n\n\t\tКонец списка\n\n");
        } else {
            System.out.println("Список пуст");
        }
    }

    public List<Frame> getFrames() {
        return frames;
    }

    public void addFrame() {
        frames.add(MakeFrame.getFrame());
        System.out.println("\n\nФрейм успешно добавлен\n\n");
    }

    public void searchFrameBySlot() {
        MakeFramePrototype mfp = new MakeFramePrototypeWithSlot();
        Frame searchPrototype = mfp.getPrototype();

        FindFrame ff = new FindFrameBySlot();
        List<Frame> matchingFrames = ff.find(frames, searchPrototype);
        if (!matchingFrames.isEmpty()) {
            System.out.println("\n\nНайденные фреймы:\n\n");
            for (Frame frame : matchingFrames) {
                System.out.println(frame.toString());
            }

        } else {
            System.out.println("\n\nСписок пуст\n\n");
        }

    }

    public void searchFrameByName() {
        MakeFramePrototype mfp = new MakeFramePrototypeWithName();
        Frame searchPrototype = mfp.getPrototype();

        FindFrame ff = new FindFrameByName();
        List<Frame> matchingFrames = ff.find(frames, searchPrototype);
        if (!matchingFrames.isEmpty()) {
            System.out.println("\n\nНайденные фреймы:\n\n");
            for (Frame frame : matchingFrames) {
                System.out.println(frame.toString());
            }

        } else {
            System.out.println("\n\nСписок пуст\n\n");
        }

    }

    public void updateFrame() {

    }

    public void deleteFrame() {
        displayAllFrames(true);
        System.out.print("\n\nВведите номер фрейма для удаления: ");
        while (!SCANNER.hasNextInt()) {
            System.out.println("Ошибка! Пожалуйста, введите целое число:");
            SCANNER.next(); // Очистка буфера ввода
        }
        int frameNumber = SCANNER.nextInt();
        SCANNER.nextLine(); // очистка буфера после ввода числа

    }
}
