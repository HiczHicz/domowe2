import java.awt.EventQueue;
public class Example {
    public static void main(String[] arg) {
        EventQueue.invokeLater(
                new Runnable() {
                    public void run() {
                        new MyFrame();
                    }
                }
        );
    }
}