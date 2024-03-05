import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class SaveFrameInDirectory implements SaveFrame {

    @Override
    public void save(List<Frame> frames) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(Constants.FILENAME))) {
            oos.writeObject(frames);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
