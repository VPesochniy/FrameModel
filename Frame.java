import java.io.Serializable;
import java.util.*;

class Frame implements Serializable {
    private static final long serialVersionUID = 1L;

    private static Frame prototypeInstance;

    private String name;
    private Map<Object, String> slots;
    private List<Frame> linkedFrames;

    private Frame() {
        this.slots = new HashMap<>();
    }

    public Frame(String name) {
        this.name = name;
        this.slots = new HashMap<>();
        this.linkedFrames = new ArrayList<>();
    }

    public void addSlot(Object slotName, String value) {
        slots.put(slotName, value);
    }

    public void removeSlot(Object slotName) {
        slots.remove(slotName);
    }

    public void removeAllSlots() {
        slots.clear();
    }

    public void updateSlot(Object slotName, String value) {
        slots.put(slotName, value);
    }

    public void addLinkedFrame(Frame frame) {
        linkedFrames.add(frame);
    }

    public void removeLinkedFrame(Frame frame) {
        linkedFrames.remove(frame);
    }

    public String getName() {
        if (name == null) {
            return "Prototype instance";
        } else
            return name;
    }

    public static Frame getFramePrototype() {
        if (prototypeInstance == null) {
            prototypeInstance = new Frame();
        }
        return prototypeInstance;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Frame [name=" + name + ", slots=" + slots + ", linkedFrames=" + linkedFrames + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((slots == null) ? 0 : slots.hashCode());
        result = prime * result + ((linkedFrames == null) ? 0 : linkedFrames.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Frame other = (Frame) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (slots == null) {
            if (other.slots != null)
                return false;
        } else if (!slots.equals(other.slots))
            return false;
        if (linkedFrames == null) {
            if (other.linkedFrames != null)
                return false;
        } else if (!linkedFrames.equals(other.linkedFrames))
            return false;
        return true;
    }

    public Map<Object, String> getSlots() {
        return slots;
    }

}
