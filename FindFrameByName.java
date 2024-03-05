import java.util.ArrayList;
import java.util.List;

public class FindFrameByName implements FindFrame {

    @Override
    public List<Frame> find(List<Frame> frames, Frame prototype) {
        List<Frame> matchingFrames = new ArrayList<>();
        for (Frame frame : frames) {
            if (frame.matchesPrototypeByName(prototype)) {
                matchingFrames.add(frame);
            }
        }
        return matchingFrames;
    }

}
