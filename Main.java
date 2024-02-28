import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final String FILENAME = "frames.ser";

    public static void main(String[] args) {
        List<Frame> frames = loadFrames();
        if (frames == null) {
            frames = new ArrayList<>();
        }
        // Создание нескольких фреймов
        Frame personFrame = new Frame("Person");
        Frame carFrame = new Frame("Car");

        // Добавление слотов
        personFrame.addSlot("Name", "John");
        personFrame.addSlot("Age", "30");
        carFrame.addSlot("Brand", "Toyota");
        carFrame.addSlot("Model", "Camry");

        // Формирование связи между фреймами
        personFrame.addLinkedFrame(carFrame);

        // Отображение информации о фреймах
        personFrame.display();
        carFrame.display();

        // Изменение слота
        personFrame.updateSlot("Age", "35");
        personFrame.display();

        // Удаление слота
        // carFrame.removeSlot("Brand");
        carFrame.display();

        frames.add(personFrame);
        frames.add(carFrame);

        Frame searchPrototype = Frame.getFramePrototype();
        searchPrototype.addSlot("Brand", "Toyota");
        searchPrototype.addSlot("Model", "Camry");
        searchPrototype.setName("Car");

        System.out.println(searchPrototype.getName());

        for (int i = 0; i < 10; i++) {
            System.out.println();
        }

        List<Frame> matchingFramesBySlot = findFramesBySlot(frames, searchPrototype);
        List<Frame> matchingFramesByName = findFramesByName(frames, searchPrototype);

        System.out.println("Matching Frames By Slot: ");
        for (Frame frame : matchingFramesBySlot) {
            frame.display();
        }

        System.out.println("Matching Frames By Name: ");
        for (Frame frame : matchingFramesByName) {
            frame.display();
        }

        System.out.println("Frames Quantity: " + frames.size());

        saveFrames(frames);
    }

    @SuppressWarnings("unchecked")
    private static List<Frame> loadFrames() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILENAME))) {
            return (List<Frame>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static void saveFrames(List<Frame> frames) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILENAME))) {
            oos.writeObject(frames);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<Frame> findFramesBySlot(List<Frame> frames, Frame prototype) {
        List<Frame> matchingFrames = new ArrayList<>();
        for (Frame frame : frames) {
            if (frame.matchesPrototypeBySlot(prototype)) {
                matchingFrames.add(frame);
            }
        }
        return matchingFrames;
    }

    private static List<Frame> findFramesByName(List<Frame> frames, Frame prototype) {
        List<Frame> matchingFrames = new ArrayList<>();
        for (Frame frame : frames) {
            if (frame.matchesPrototypeByName(prototype)) {
                matchingFrames.add(frame);
            }
        }
        return matchingFrames;
    }

}