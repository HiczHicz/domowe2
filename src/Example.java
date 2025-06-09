import java.awt.EventQueue;
public class Example {
    public static void main(String[] arg) {
        EventQueue.invokeLater(
                new Runnable() { //dlaczego to jest na szaro
                    public void run() {
                        new MyFrame();
                    }
                }
        );
    }
}