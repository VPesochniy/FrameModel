import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class LoadFrameFromDirectory implements LoadFrame {

    @SuppressWarnings("unchecked")
    @Override
    public List<Frame> load() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(Constants.FILENAME))) {
            return (List<Frame>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

}
