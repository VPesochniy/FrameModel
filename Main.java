public class Main implements Constants {

    public static void main(String[] args) {

        FrameService fs = FrameService.getService();
        fs.loadFrames();
        boolean exit = false;

        while (!exit) {
            System.out.println("\n\nМеню:");
            System.out.println("1. Вывести все фреймы");
            System.out.println("2. Поиск фрейма по имени");
            System.out.println("3. Поиск фрейма по слотам");
            System.out.println("4. Добавить фрейм");
            System.out.println("5. Изменить фрейм");
            System.out.println("6. Удалить фрейм");
            System.out.println("q. Выход");
            System.out.print("\n\nВыберите действие: ");
            String choice = SCANNER.nextLine();

            switch (choice) {
                case "1":
                    fs.displayAllFrames();
                    break;
                case "2":
                    fs.searchFrameByName();
                    break;
                case "3":
                    fs.searchFrameBySlot();
                    break;
                case "4":
                    fs.addFrame();
                    break;
                case "5":
                    fs.updateFrame();
                    System.out.println("пока пусто");
                    break;
                case "6":
                    fs.deleteFrame();
                    break;
                case "q":
                    System.out.println("\n\nВыход из программы...");
                    fs.saveFrames();
                    exit = true;
                    break;
                default:
                    System.out.println("\n\nНеверный ввод. Пожалуйста, выберите действие из меню\n\n");
            }
        }
        SCANNER.close();
    }
}