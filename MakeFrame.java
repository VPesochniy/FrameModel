public class MakeFrame implements Constants {
    public static Frame getFrame() {
        System.out.print("\n\nВведите название фрейма: ");
        String frameName = SCANNER.nextLine();
        Frame frame = new Frame(frameName);
        System.out.print("Введите количество слотов: ");
        while (!SCANNER.hasNextInt()) {
            System.out.println("Ошибка! Пожалуйста, введите целое число:");
            SCANNER.next(); // Очистка буфера ввода
        }
        int slotsCount = SCANNER.nextInt();
        SCANNER.nextLine(); // очистка буфера после ввода числа
        for (int i = 0; i < slotsCount; i++) {
            System.out.print("Введите название слота: ");
            String slotName = SCANNER.nextLine();
            System.out.print("Введите значение слота: ");
            String slotValue = SCANNER.nextLine();
            frame.addSlot(slotName, slotValue);
        }
        return frame;
    }
}