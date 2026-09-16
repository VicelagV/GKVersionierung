import model.GewinnModel;
import view.GewinnView;
import controller.GewinnController;
public class Main {
    public static void main(String[] args) {
        GewinnModel model = new GewinnModel();
        GewinnView view = new GewinnView();
        GewinnController controller = new GewinnController(model, view);
        view.setVisible(true);
    }
}