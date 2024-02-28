import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String FILENAME = "frames.ser";
    private static List<Frame> frames;

    public static void main(String[] args) {
        frames = loadFrames();
        if (frames == null) {
            frames = new ArrayList<>();
        }
        boolean exit = false;
        while (!exit) {
            System.out.println("Меню:");
            System.out.println("1. Добавить фрейм");
            System.out.println("2. Поиск фрейма");
            System.out.println("3. Вывести все фреймы");
            System.out.println("4. Выход");
            System.out.print("Выберите действие: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // очистка буфера после ввода числа

            switch (choice) {
                case 1:
                    addFrame();
                    break;
                case 2:
                    searchFrame();
                    break;
                case 3:
                    displayAllFrames();
                    break;
                case 4:
                    exit = true;
                    System.out.println("Выход из программы...");
                    saveFrames(frames);
                    break;
                default:
                    System.out.println("Неверный ввод. Пожалуйста, выберите действие из меню.");
            }
        }
        scanner.close();
    }

    private static void displayAllFrames() {
        System.out.println("Все фреймы:");
        for (Frame frame : frames) {
            frame.display();
        }
    }

    private static void searchFrame() {
        Frame searchPrototype = Frame.getFramePrototype();
        System.out.print("Введите количество слотов в поисковом образце: ");
        int slotsCount = scanner.nextInt();
        scanner.nextLine(); // очистка буфера после ввода числа
        for (int i = 0; i < slotsCount; i++) {
            System.out.print("Введите название слота: ");
            String slotName = scanner.nextLine();
            System.out.print("Введите значение слота: ");
            String slotValue = scanner.nextLine();
            searchPrototype.addSlot(slotName, slotValue);
        }
        List<Frame> matchingFrames = findFramesBySlot(frames, searchPrototype);
        System.out.println("Найденные фреймы:");
        for (Frame frame : matchingFrames) {
            frame.display();
        }
    }

    private static void addFrame() {
        System.out.print("Введите название фрейма: ");
        String frameName = scanner.nextLine();
        Frame frame = new Frame(frameName);
        System.out.print("Введите количество слотов: ");
        int slotsCount = scanner.nextInt();
        scanner.nextLine(); // очистка буфера после ввода числа
        for (int i = 0; i < slotsCount; i++) {
            System.out.print("Введите название слота: ");
            String slotName = scanner.nextLine();
            System.out.print("Введите значение слота: ");
            String slotValue = scanner.nextLine();
            frame.addSlot(slotName, slotValue);
        }
        frames.add(frame);
        System.out.println("Фрейм успешно добавлен.");
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