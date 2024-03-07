public class MatchFramePrototypeByName implements MatchFramePrototype {

    @Override
    public boolean matchPrototype(Frame frame, Frame prototype) {
        return frame.getName().equals(prototype.getName());
    }

}
