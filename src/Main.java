import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.geom.Path2D;

public class Main
{
    public static void main(String[] args)
    {
        new JFrameWindow();
    }
}

class JFrameWindow extends JFrame
{
    private static final long serialVersionUID = 1L;

    public JFrameWindow()
    {
        super("car picture");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setPreferredSize(new Dimension(1500, 900));

        this.setLocation(10, 10);

        this.add(new SnowMan());

        this.pack();

        this.setVisible(true);
    }
}

class SnowMan extends Canvas
{
    private static final int xo = 0;
    private Graphics gr;

    @Override
    public void paint(Graphics g)
    {
        super.paint(g);

        this.gr = g;

        this.setBackground(Color.LIGHT_GRAY);

        Graphics2D g2 = (Graphics2D) g;

        g2.setStroke(new BasicStroke(8));

        int[] points = new int[]{343, 709, 305, 645, 327, 620, 381, 497, 1006, 496, 1205, 638, 1189, 709};
        drawPolygon(points, Color.YELLOW, true);

        // shell
        drawCurve(343, 709, 302, 686, 305, 645, Color.YELLOW, true);
        drawCurve(327, 620, 338, 544, 381, 497, Color.YELLOW, true);
        drawCurve(381, 497, 659, 180, 1006, 496, Color.YELLOW, true);
        drawCurve(1006, 496, 1189, 531, 1205, 638, Color.YELLOW, true);
        drawCurve(1205, 638, 1216, 676, 1189, 709, Color.YELLOW, true);

        // shell wheels arcs
        gr.setColor(Color.LIGHT_GRAY);
        gr.fillArc(422, 709 - (621 - 422) / 2 - 15, (621 - 422), (621 - 422) + 30, 0, 180);
        gr.setColor(Color.LIGHT_GRAY);
        gr.fillArc(872, 709 - (1072 - 872) / 2 - 15, (1072 - 872), (1072 - 872) + 30, 0, 180);

        // back line
        gr.setColor(Color.BLACK);
        gr.drawLine(305, 645,327, 620);

        // shell
        drawCurve(343, 709, 302, 686, 305, 645, Color.BLACK, false);
        drawCurve(327, 620, 338, 544, 381, 497, Color.BLACK, false);
        drawCurve(381, 497, 659, 180, 1006, 496, Color.BLACK, false);
        drawCurve(1006, 496, 1189, 531, 1205, 638, Color.BLACK, false);
        drawCurve(1205, 638, 1216, 676, 1189, 709, Color.BLACK, false);

        // shell
        gr.setColor(Color.BLACK);
        gr.drawLine(872, 709, 621, 709);
        gr.setColor(Color.BLACK);
        gr.drawLine(1189, 709, 1072, 709);
        gr.setColor(Color.BLACK);
        gr.drawLine(422, 709, 341, 709);

        // shell wheels arcs
        gr.setColor(Color.BLACK);
        gr.drawArc(422, 709 - (621 - 422) / 2 - 15, (621 - 422), (621 - 422) + 30, 0, 180);
        gr.setColor(Color.BLACK);
        gr.drawArc(872, 709 - (1072 - 872) / 2 - 15, (1072 - 872), (1072 - 872) + 30, 0, 180);

        // window
        drawCurve(431, 496, 517, 397, 647, 380, Color.WHITE, true);
        drawCurve(682, 380, 847, 395, 949, 496, Color.WHITE, true);
        drawPolygon(new int[]{647, 380, 647, 496, 431, 496}, Color.WHITE, true);
        drawPolygon(new int[]{949, 496, 682, 496, 682, 380}, Color.WHITE, true);

        // window
        drawCurve(431, 496, 517, 397, 647, 380, Color.BLACK, false);
        drawCurve(682, 380, 847, 395, 949, 496, Color.BLACK, false);

        // windows
        gr.setColor(Color.BLACK);
        gr.drawLine(647, 380, 647, 496);
        gr.drawLine(647, 496, 431, 496);

        gr.setColor(Color.BLACK);
        gr.drawLine(949, 496, 682, 496);
        gr.drawLine(682, 496, 682, 380);

        // wheels
        g2.setStroke(new BasicStroke(1));

        int yo = 0;
        int x, y, r;

        x = 522; y = 695; r = 85;
        drawCircle(xo + x, yo + y, r, Color.BLACK, true);
        x = 522; y = 695; r = 35;
        drawCircle(xo + x, yo + y, r, Color.WHITE, true);

        x = 972; y = 695; r = 85;
        drawCircle(xo + x, yo + y, r, Color.BLACK, true);
        x = 972; y = 695; r = 35;
        drawCircle(xo + x, yo + y, r, Color.WHITE, true);

        // light
        g2.setStroke(new BasicStroke(8));
        drawCurve(1087, 562, 1148, 554, 1172, 610, Color.WHITE, true);
        drawCurve(1087, 562, 1148, 554, 1172, 610, Color.BLACK, false);

        drawCurve(1087, 562, 1104, 610, 1172, 610, Color.WHITE, true);
        drawCurve(1087, 562, 1104, 610, 1172, 610, Color.BLACK, false);

        // hand
        gr.setColor(Color.BLACK);
        gr.drawLine(693, 541, 746, 541);

    }

    private void drawCurve(int x1, int y1, int x2, int y2, int x3, int y3, Color color, boolean fill)
    {
        gr.setColor(color);
        Path2D path = new Path2D.Double();
        path.moveTo(x1, y1);
        path.quadTo(x2, y2, x3, y3);
        if (fill) {
            path.closePath();
            ((Graphics2D) gr).fill(path);
        } else {
            ((Graphics2D) gr).draw(path);
        }
    }

    private void drawCircle(int x, int y, int r, Color color, boolean fill)
    {
        gr.setColor(color);

        if (fill) {
            gr.fillOval(x - r, y - r, r * 2, r * 2);
        } else {
            gr.drawOval(x - r, y - r, r * 2, r * 2);
        }
    }

    private void drawPolygon(int[] poly, Color color, boolean fill)
    {
        int[] xp, yp;

        xp = new int[poly.length / 2];
        yp = new int[poly.length / 2];
        for (int i = 0; i < poly.length / 2; i++) {
            xp[i] = poly[i*2] + xo;
            yp[i] = poly[i*2 + 1];
        }

        gr.setColor(color);
        if (fill) {
            gr.fillPolygon(xp, yp, poly.length / 2);
        } else {
            gr.drawPolygon(xp, yp, poly.length / 2);
        }
    }
}
