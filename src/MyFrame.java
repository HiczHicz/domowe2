import java.awt.*;
import java.awt.event.*;//to też
import javax.swing.*;
public class MyFrame extends JFrame{
    public MyFrame(){
        super("Rysowanie");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,400);
        setVisible(true);
        MyPanel p = new MyPanel();
        add(p);
}
}