import java.util.ArrayList;
import java.util.List;

public class FindFrameByName implements FindFrame {

    @Override
    public List<Frame> find(List<Frame> frames, Frame prototype) {
        List<Frame> matchingFrames = new ArrayList<>();
        MatchFramePrototype mfp = new MatchFramePrototypeByName();
        for (Frame fr : frames) {
            if (mfp.matchPrototype(fr, prototype)) {
                matchingFrames.add(fr);
            }
        }
        return matchingFrames;
    }

}
