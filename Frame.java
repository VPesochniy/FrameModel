import java.io.Serializable;
import java.util.*;

class Frame implements Serializable {
    private static final long serialVersionUID = 1L;

    private static Frame prototypeInstance;

    private String name;
    private Map<String, String> slots;
    private List<Frame> linkedFrames;

    private Frame() {
        this.slots = new HashMap<>();
    }

    public Frame(String name) {
        this.name = name;
        this.slots = new HashMap<>();
        this.linkedFrames = new ArrayList<>();
    }

    public void addSlot(String slotName, String value) {
        slots.put(slotName, value);
    }

    public String getSlotValue(String slotName) {
        return slots.get(slotName);
    }

    public void removeSlot(String slotName) {
        slots.remove(slotName);
    }

    public void removeAllSlots() {
        slots.clear();
    }

    public void updateSlot(String slotName, String value) {
        slots.put(slotName, value);
    }

    public void addLinkedFrame(Frame frame) {
        linkedFrames.add(frame);
    }

    public void removeLinkedFrame(Frame frame) {
        linkedFrames.remove(frame);
    }

    // Метод для отображения информации о фрейме
    public void display() {
        System.out.println("Frame: " + name);
        System.out.println("Slots:");
        for (Map.Entry<String, String> entry : slots.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println("Linked Frames:");
        for (Frame frame : linkedFrames) {
            System.out.println(frame.getName());
        }
        System.out.println();
    }

    public String getName() {
        if (name == null) {
            return "Instance of prototype";
        } else
            return name;
    }

    public boolean matchesPrototypeByName(Frame prototype) {
        return name == prototype.name;
    }

    public boolean matchesPrototypeBySlot(Frame prototype) {
        for (Map.Entry<String, String> entry : prototype.slots.entrySet()) {
            String slotName = entry.getKey();
            String slotValue = entry.getValue();
            if (!slots.containsKey(slotName) || !slots.get(slotName).contains(slotValue)) {
                return false;
            }
        }
        return true;
    }

    public static Frame getFramePrototype() {
        if (prototypeInstance == null) {
            return new Frame();
        } else
            return prototypeInstance;
    }

    public void setName(String name) {
        this.name = name;
    }
}
