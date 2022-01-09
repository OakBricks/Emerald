/*
 * Decompiled with CFR 0.152.
 */
package creativeintor.game;

import creativeintor.game.GamePanel;

import java.awt.*;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class GameFrame extends JFrame {
    private static final long serialVersionUID = 1L;
    public static String version = "v1.7.0";
    public static int secondsPassed;
    public static int minutesPassed;
    public static int tSecondsPassed;

    public GameFrame() {
        this.add(new GamePanel());
        this.setTitle("Get The Apple! " + version);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setResizable(true);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        Image icon = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/icons/02.png"))).getImage();
        this.setIconImage(icon);
        Timer timer = new Timer();
        TimerTask task = new TimerTask(){
            @Override
            public void run() {
                ++secondsPassed;
            }
        };
        timer.scheduleAtFixedRate(task, 1000L, 1000L);
        Timer tTimer = new Timer();
        TimerTask tTask = new TimerTask(){
            @Override
            public void run() {
                ++tSecondsPassed;
            }
        };
        tTimer.scheduleAtFixedRate(tTask, 1000L, 1000L);
    }
}

