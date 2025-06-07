import java.awt.*;
import javax.swing.*;
import java.util.Random;
import java.util.stream.*;
public class MyPanel extends JPanel{
    public Random r=new Random();
        public class Punkt{
            public int x;
            public int y;
            public Punkt(int a, int b){x=a; y=b;}
        }
    public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Stream.generate(() -> new Punkt(r.nextInt(getWidth()), r.nextInt(getHeight()))).limit(20000).forEach(p -> {
        g.setColor(new Color(p.x % 255, p.y % 255, 90));
        g.fillOval(p.x, p.y, 10, 10);
        });
    }
}
