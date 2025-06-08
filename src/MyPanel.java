import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {
    int PUNKTY = 1000000;
    double EPSILON = 1e-6;
    private Complex PIERWIASTEK1 = new Complex(1, 0);
    private Complex PIERWIASTEK2 = new Complex(-0.5, Math.sqrt(3) / 2);
    private Complex PIERWIASTEK3 = new Complex(-0.5, -Math.sqrt(3) / 2);


    public void paintComponent(Graphics g) {
        super.paintComponent(g);



        java.util.stream.Stream.generate(() -> {
            double x = Math.random() * 3.0 - 1.5;
            double y = Math.random() * 3.0 - 1.5;
            return new double[]{x, y};
        }).limit(PUNKTY).forEach(point -> {
            double x = point[0];
            double y = point[1];
            Complex z = new Complex(x, y);
            Complex result = newtonComplex(z);
            int colorIndex = findClosestRootIndex(result);
            Color c = switch (colorIndex) {
                case 0 -> Color.RED;
                case 1 -> Color.GREEN;
                case 2 -> Color.BLUE;
                default -> Color.BLACK;
            };

            int px = (int) ((x + 1.5) / 3.0 * getWidth());
            int py = (int) ((1.5 - y) / 3.0 * getHeight());

            g.setColor(c);
            g.fillRect(px, py, 1, 1);
        });
    }

    private int findClosestRootIndex(Complex z) {
        double dist1 = z.minus(PIERWIASTEK1).abs();
        double dist2 = z.minus(PIERWIASTEK2).abs();
        double dist3 = z.minus(PIERWIASTEK3).abs();

        if (dist1 <= dist2 && dist1 <= dist3) return 0;
        if (dist2 <= dist1 && dist2 <= dist3) return 1;
        return 2;
    }

    private Complex newtonComplex(Complex z) {
        while (true) {
            Complex z2 = z.times(z);
            Complex z3 = z2.times(z);
            Complex f = z3.minus(new Complex(1, 0));
            Complex df = z2.scale(3);

            if (df.abs() == 0) return z;

            Complex zNext = z.minus(f.divides(df));

            if (zNext.minus(z).abs() < EPSILON) {
                return zNext;
            }
            z = zNext;
        }
    }
}
