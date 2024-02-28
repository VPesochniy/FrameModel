
public class Main {
    public static void main(String[] args) {
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
        carFrame.removeSlot("Brand");
        carFrame.display();
    }
}