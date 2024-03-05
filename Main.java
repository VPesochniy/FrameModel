public class Main implements Constants {

    public static void main(String[] args) {

        FrameService fs = FrameService.getService();
        fs.loadFrames();
        boolean exit = false;
        while (!exit) {
            System.out.println("Меню:");
            System.out.println("1. Добавить фрейм");
            System.out.println("2. Поиск фрейма");
            System.out.println("3. Вывести все фреймы");
            System.out.println("q. Выход");
            System.out.print("Выберите действие: ");
            String choice = SCANNER.nextLine();

            switch (choice) {
                case "1":
                    fs.addFrame();
                    break;
                case "2":
                    fs.searchFrame();
                    break;
                case "3":
                    fs.displayAllFrames();
                    break;
                case "q":
                    System.out.println("Выход из программы...");
                    fs.saveFrames();
                    exit = true;
                    break;
                default:
                    System.out.println("Неверный ввод. Пожалуйста, выберите действие из меню.");
            }
        }
        SCANNER.close();
    }

}