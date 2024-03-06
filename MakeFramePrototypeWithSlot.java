public class MakeFramePrototypeWithSlot implements MakeFramePrototype, Constants {

    @Override
    public Frame getPrototype() {
        Frame searchPrototype = Frame.getFramePrototype();
        searchPrototype.removeAllSlots();
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
        return searchPrototype;

    }

}
