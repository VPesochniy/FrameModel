import java.util.Map;

public class MatchFramePrototypeBySlot implements MatchFramePrototype {

    @Override
    public boolean matchPrototype(Frame frame, Frame prototype) {
        for (Map.Entry<Object, String> entry : prototype.getSlots().entrySet()) {
            Object slotName = entry.getKey();
            String slotValue = entry.getValue();
            if (!frame.getSlots().containsKey(slotName) || !frame.getSlots().get(slotName).contains(slotValue)) {
                return false;
            }
        }
        return true;
    }

}
