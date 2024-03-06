public class MakeFramePrototypeWithName implements MakeFramePrototype, Constants {

    @Override
    public Frame getPrototype() {
        Frame searchPrototype = Frame.getFramePrototype();
        searchPrototype.removeAllSlots();
        System.out.print("Введите название фрейма: ");
        String prototypeName = SCANNER.nextLine();
        searchPrototype.setName(prototypeName);
        return searchPrototype;
    }

}
