package circularmotionanimation;

import javax.swing.*;
import java.awt.*;

public class CircularMotionAnimation extends JPanel {

    private final int centerX;
    private final int centerY;
    private final int radius;
    private double angle;

    // Constructor (the __init__)
    public CircularMotionAnimation() {
        this.centerX = 200;  // X-coordinate of the center of the circle
        this.centerY = 200;  // Y-coordinate of the center of the circle
        this.radius = 100;   // Radius of the circle
        this.angle = 0;      // Initial angle

        moveDot();

    }

    public void moveDotWhile() {
        boolean running = true;

        while (running) {
            angle += 0.02;
            repaint();
        }
    }

    public void moveDot() {

        // Create a timer to update the animation
        Timer timer = new Timer(10, e -> {
            angle += 0.02;  // Increment the angle for rotation
            repaint();     // Repaint the panel // call the function paintComponent
        });
        timer.start();  // Start the animation

    }

    //@Override //??????
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Clear the panel
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());

        // Calculate the position of the moving point
        int x = (int) (centerX + radius * Math.cos(angle));
        int y = (int) (centerY + radius * Math.sin(angle));

        // Draw the circle
        g.setColor(Color.BLUE);
        g.drawOval(centerX - radius, centerY - radius, radius * 2, radius * 2);

        // Draw the moving point
        g.setColor(Color.RED);
        g.fillOval(x - 5, y - 5, 10, 10);
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("Circular Motion Animation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.getContentPane().add(new CircularMotionAnimation());
        frame.setVisible(true);
        //F SwingUtilities
//        .invokeLater(() -> {
//
//        });

    }

}
