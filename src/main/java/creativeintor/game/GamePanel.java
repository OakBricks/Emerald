/*
 * Decompiled with CFR 0.152.
 */
package creativeintor.game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener {
    private static final long serialVersionUID = 1L;
//    static final int SCREEN_WIDTH = 1080;
//    static final int SCREEN_HEIGHT = 720;
    static final int SCREEN_WIDTH = 800;
    static final int SCREEN_HEIGHT = 600;
    static int UNIT_SIZE = 45;
    static int GAME_UNITS = 777600 / (UNIT_SIZE * UNIT_SIZE);
    static int DELAY;
    int[] x = new int[GAME_UNITS];
    int[] y = new int[GAME_UNITS];
    int bodyParts = 3;
    static int applesEaten;
    int appleX;
    int appleY;
    int second;
    int minute;
    int deathCounter;
    int direction = 82;
    static boolean running;
    static boolean titleScreen;
    static boolean dMode;
    static boolean gameOver;
    static boolean stPage;
    static boolean paused;
    Timer timer;
    Random random;
    long lastTime = System.nanoTime();
    long fpsTimer = System.currentTimeMillis();
    final double ns = 1.6666666666666666E7;
    double delta = 0.0;
    int frames = 0;
    static JButton playAgainButton;
    static JButton menuButton;
    static JButton startButton;
    static JButton quitButton;
    static JButton dMOffButton;
    static JButton dMOnButton;
    static JButton stBackButton;
    static JButton resumeButton;
    static JButton pausedMenuButton;
//
//    static {
//        running = false;
//    }

    GamePanel() {
        playAgainButton = new JButton();
        playAgainButton.addActionListener(this);
        playAgainButton.setText("Play Again");
        playAgainButton.setFont(new Font(Font.SANS_SERIF, 1, 30));
        playAgainButton.setFocusable(false);
        menuButton = new JButton();
        menuButton.addActionListener(this);
        menuButton.setText("Menu");
        menuButton.setFont(new Font(Font.SANS_SERIF, 1, 20));
        menuButton.setFocusable(false);
        startButton = new JButton();
        startButton.addActionListener(this);
        startButton.setText("Start");
        startButton.setFont(new Font(Font.SANS_SERIF, 1, 20));
        startButton.setFocusable(false);
        quitButton = new JButton();
        quitButton.addActionListener(this);
        quitButton.setText("Quit");
        quitButton.setFont(new Font(Font.SANS_SERIF, 1, 20));
        quitButton.setFocusable(false);
        dMOffButton = new JButton();
        dMOffButton.addActionListener(this);
        dMOffButton.setText("Off");
        dMOffButton.setFont(new Font(Font.SANS_SERIF, 1, 20));
        dMOffButton.setFocusable(false);
        dMOnButton = new JButton();
        dMOnButton.addActionListener(this);
        dMOnButton.setText("On");
        dMOnButton.setFont(new Font(Font.SANS_SERIF, 1, 20));
        dMOnButton.setFocusable(false);
        stBackButton = new JButton();
        stBackButton.addActionListener(this);
        stBackButton.setText("Back");
        stBackButton.setFont(new Font(Font.SANS_SERIF, 1, 20));
        stBackButton.setFocusable(false);
        resumeButton = new JButton();
        resumeButton.addActionListener(this);
        resumeButton.setText("Resume");
        resumeButton.setFont(new Font(Font.SANS_SERIF, 1, 20));
        resumeButton.setFocusable(false);
        pausedMenuButton = new JButton();
        pausedMenuButton.addActionListener(this);
        pausedMenuButton.setText("Exit Game");
        pausedMenuButton.setFont(new Font(Font.SANS_SERIF, 1, 15));
        pausedMenuButton.setFocusable(false);
        this.random = new Random();
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        this.add(playAgainButton);
        this.add(menuButton);
        this.add(startButton);
        this.add(quitButton);
        this.add(dMOffButton);
        this.add(dMOnButton);
        this.add(stBackButton);
        this.add(resumeButton);
        this.add(pausedMenuButton);
        this.menuScreen();
    }

    public void menuScreen() {
        titleScreen = true;
        gameOver = false;
        running = false;
        stPage = false;
    }

    public void startGame() {
        this.newApple();
        DELAY = 100;
        running = true;
        this.timer = new Timer(DELAY, this);
        this.timer.start();
    }

    public void update() {
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.draw(g);
    }

    public void draw(Graphics g) {
        if (running) {
            titleScreen = false;
            gameOver = false;
            dMOffButton.setVisible(false);
            g.setColor(Color.RED);
            g.fillRect(this.appleX, this.appleY, 38, 38);
            int i = 0;
            while (i < this.bodyParts) {
                if (i == 0) {
                    g.setColor(Color.GREEN);
                    g.fillRect(this.x[i], this.y[i], 43, 43);
                } else {
                    g.setColor(new Color(0, 210, 0));
                    g.fillRect(this.x[i], this.y[i], 43, 43);
                }
                if (GameFrame.tSecondsPassed >= 2) {
                    this.checkCollisions();
                }
                if (GameFrame.tSecondsPassed < 2) {
                    if (i == 0) {
                        g.setColor(Color.RED);
                        g.fillRect(this.x[i], this.y[i], 43, 43);
                    } else {
                        g.setColor(new Color(210, 0, 0));
                        g.fillRect(this.x[i], this.y[i], 43, 43);
                    }
                }
                ++i;
            }
            long now = System.nanoTime();
            this.delta += (double)(now - this.lastTime) / ns;
            this.lastTime = now;
            while (this.delta >= 1.0) {
                this.update();
                this.delta -= 1.0;
            }
            this.render();
            ++this.frames;
            g.setColor(Color.WHITE);
            g.setFont(new Font(Font.SANS_SERIF, 1, 30));
            FontMetrics metrics = this.getFontMetrics(g.getFont());
            g.drawString("Score: " + applesEaten, (SCREEN_WIDTH - metrics.stringWidth("Score: " + applesEaten)) / 1, g.getFont().getSize());
            g.setColor(Color.WHITE);
            g.setFont(new Font(Font.SANS_SERIF, 1, 20));
            g.drawString(String.valueOf("Deaths: " + this.deathCounter), 3, 40);
            if (GameFrame.secondsPassed == 60) {
                GameFrame.secondsPassed = 0;
                ++GameFrame.minutesPassed;
            }
            if (GameFrame.secondsPassed <= 9) {
                g.setColor(Color.WHITE);
                g.setFont(new Font(Font.SANS_SERIF, 1, 25));
                g.drawString(String.valueOf("Time: " + GameFrame.minutesPassed + ":" + "0" + GameFrame.secondsPassed), 3, 23);
            } else {
                g.setColor(Color.WHITE);
                g.setFont(new Font(Font.SANS_SERIF, 1, 25));
                g.drawString(String.valueOf("Time: " + GameFrame.minutesPassed + ":" + GameFrame.secondsPassed), 3, 23);
            }
            if (GameFrame.minutesPassed == 60) {
                GameFrame.minutesPassed = 0;
            }
            if (GameFrame.tSecondsPassed <= 1) {
                paused = false;
            }
        }
        if (titleScreen) {
            g.setColor(Color.GREEN);
            g.setFont(new Font(Font.SANS_SERIF, 1, 60));
            g.drawString(String.valueOf("Get The"), 330, 95);
            g.setColor(Color.RED);
            g.setFont(new Font(Font.SANS_SERIF, 1, 60));
            g.drawString(String.valueOf("Apple!"), 570, 95);
            startButton.setBounds(450, 300, 200, 50);
            quitButton.setBounds(478, 500, 145, 30);
            playAgainButton.setVisible(false);
            menuButton.setVisible(false);
            startButton.setVisible(true);
            quitButton.setVisible(true);
            gameOver = false;
            dMOffButton.setVisible(false);
            dMOnButton.setVisible(false);
            stBackButton.setVisible(false);
            resumeButton.setVisible(false);
            paused = false;
            pausedMenuButton.setVisible(false);
        }
        if (dMode) {
            if (System.currentTimeMillis() - this.fpsTimer > 1000L) {
                this.fpsTimer += 1000L;
                this.frames = 0;
            }
            if (GameFrame.tSecondsPassed != 0) {
                g.setColor(Color.WHITE);
                g.setFont(new Font(Font.SANS_SERIF, 1, 20));
                g.drawString(String.valueOf("Fps: " + this.fpsTimer), 875, 50);
                g.setColor(Color.WHITE);
                g.setFont(new Font("", 0, 30));
                g.drawString(String.valueOf(GameFrame.version), 5, 715);
            }
        }
        if (gameOver) {
            g.setColor(Color.GREEN);
            g.setFont(new Font(Font.SANS_SERIF, 1, 40));
            FontMetrics metrics1 = this.getFontMetrics(g.getFont());
            g.drawString("Score: " + applesEaten, (SCREEN_WIDTH - metrics1.stringWidth("Score: " + applesEaten)) / 2, g.getFont().getSize());
            g.setColor(Color.red);
            g.setFont(new Font(Font.SANS_SERIF, 1, 75));
            FontMetrics metrics2 = this.getFontMetrics(g.getFont());
            g.drawString("Game Over", (SCREEN_WIDTH - metrics2.stringWidth("Game Over")) / 2, 240);
            if (GameFrame.secondsPassed <= 9) {
                g.setColor(Color.GREEN);
                g.setFont(new Font(Font.SANS_SERIF, 1, 25));
                g.drawString(String.valueOf("Time: " + GameFrame.minutesPassed + ":" + "0" + GameFrame.secondsPassed), 480, 65);
            } else {
                g.setColor(Color.GREEN);
                g.setFont(new Font(Font.SANS_SERIF, 1, 25));
                g.drawString(String.valueOf("Time: " + GameFrame.minutesPassed + ":" + GameFrame.secondsPassed), 480, 65);
            }
            if (GameFrame.minutesPassed == 60) {
                GameFrame.minutesPassed = 0;
            }
            playAgainButton.setVisible(true);
            playAgainButton.setBounds(450, 400, 200, 50);
            menuButton.setVisible(true);
            menuButton.setBounds(500, 500, 100, 30);
            stPage = false;
            dMOnButton.setVisible(false);
            stBackButton.setVisible(false);
            resumeButton.setVisible(false);
            paused = false;
            running = false;
            pausedMenuButton.setVisible(false);
            startButton.setVisible(false);
            quitButton.setVisible(false);
        }
        if (stPage) {
            dMOffButton.setVisible(true);
            dMOffButton.setBounds(350, 250, 90, 20);
            dMOnButton.setVisible(true);
            dMOnButton.setBounds(350, 200, 90, 20);
            startButton.setVisible(false);
            quitButton.setVisible(false);
            stBackButton.setVisible(true);
            stBackButton.setBounds(500, 550, 100, 30);
            pausedMenuButton.setVisible(false);
            resumeButton.setVisible(false);
            paused = false;
            g.setColor(Color.RED);
            g.setFont(new Font(Font.SANS_SERIF, 1, 50));
            g.setColor(Color.WHITE);
            g.setFont(new Font(Font.SANS_SERIF, 1, 30));
            g.drawString(String.valueOf("Debug Mode"), 480, 250);
        }
        if (paused) {
            g.setColor(Color.WHITE);
            g.setFont(new Font(Font.SANS_SERIF, 1, 60));
            g.drawString(String.valueOf("Game Paused"), 355, 220);
            running = false;
            resumeButton.setVisible(true);
            resumeButton.setBounds(455, 400, 200, 50);
            pausedMenuButton.setVisible(true);
            pausedMenuButton.setBounds(500, 500, 110, 30);
        }
    }

    private void render() {
    }

    public void newApple() {
        this.appleX = this.random.nextInt(SCREEN_WIDTH / UNIT_SIZE) * UNIT_SIZE;
        this.appleY = this.random.nextInt(SCREEN_HEIGHT / UNIT_SIZE) * UNIT_SIZE;
    }

    public void move() {
        int i = this.bodyParts;
        while (i > 0) {
            this.x[i] = this.x[i - 1];
            this.y[i] = this.y[i - 1];
            --i;
        }
        switch (this.direction) {
            case 'U': {
                this.y[0] = this.y[0] - UNIT_SIZE;
                break;
            }
            case 'D': {
                this.y[0] = this.y[0] + UNIT_SIZE;
                break;
            }
            case 'L': {
                this.x[0] = this.x[0] - UNIT_SIZE;
                break;
            }
            case 'R': {
                this.x[0] = this.x[0] + UNIT_SIZE;
            }
        }
    }

    public void checkApple() {
        if (this.x[0] == this.appleX && this.y[0] == this.appleY) {
            ++this.bodyParts;
            ++applesEaten;
            this.newApple();
        }
        int i = this.bodyParts;
        while (i > 0) {
            if (this.x[i] == this.appleX && this.y[i] == this.appleY) {
                this.newApple();
            }
            --i;
        }
    }

    public void autoTurn() {
        if (this.x[0] < 0) {
            this.direction = (char)82;
        }
        if (this.x[0] > SCREEN_WIDTH) {
            this.direction = (char)76;
        }
        if (this.y[0] < 0) {
            this.direction = (char)68;
        }
        if (this.y[0] > SCREEN_HEIGHT) {
            this.direction = (char)85;
        }
    }

    public void checkCollisions() {
        int i = this.bodyParts;
        while (i > 0) {
            if (this.x[0] == this.x[i] && this.y[0] == this.y[i]) {
                running = false;
                gameOver = true;
            }
            --i;
        }
        if (this.x[0] < 0) {
            running = false;
            gameOver = true;
        }
        if (this.x[0] > SCREEN_WIDTH) {
            running = false;
            gameOver = true;
        }
        if (this.y[0] < 0) {
            running = false;
            gameOver = true;
        }
        if (this.y[0] > SCREEN_HEIGHT) {
            running = false;
            gameOver = true;
        }
        if (!running) {
            this.timer.stop();
        }
    }

    public void gameOver() {
    }

    public void stPage() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (running) {
            this.move();
            this.autoTurn();
            this.checkApple();
            playAgainButton.setVisible(false);
            menuButton.setVisible(false);
            startButton.setVisible(false);
            quitButton.setVisible(false);
            stPage = false;
            dMOnButton.setVisible(false);
            resumeButton.setVisible(false);
            pausedMenuButton.setVisible(false);
        }
        this.repaint();
        if (e.getSource() == playAgainButton) {
            this.startGame();
            this.bodyParts = 3;
            applesEaten = 0;
            GameFrame.secondsPassed = 0;
            GameFrame.minutesPassed = 0;
            GameFrame.tSecondsPassed = 1;
            ++this.deathCounter;
        }
        if (e.getSource() == menuButton) {
            this.menuScreen();
            GameFrame.tSecondsPassed = 0;
        }
        if (e.getSource() == quitButton) {
            GameFrame.tSecondsPassed = 0;
            JFrame exit = new JFrame("Exit");
            if (JOptionPane.showConfirmDialog(exit, "Are You Sure You Want To Exit?", "Exit Game?", 0) == 0) {
                System.exit(0);
            }
        }
        if (e.getSource() == startButton) {
            this.startGame();
            this.bodyParts = 3;
            applesEaten = 0;
            GameFrame.secondsPassed = 0;
            GameFrame.minutesPassed = 0;
            GameFrame.tSecondsPassed = 1;
        }
        if (e.getSource() == stBackButton) {
            this.menuScreen();
            GameFrame.tSecondsPassed = 0;
        }
        if (e.getSource() == dMOnButton) {
            dMode = true;
            GameFrame.tSecondsPassed = 1;
        }
        if (e.getSource() == dMOffButton) {
            dMode = false;
        }
        if (e.getSource() == resumeButton) {
            running = true;
            paused = false;
        }
        if (e.getSource() == pausedMenuButton) {
            this.menuScreen();
            GameFrame.tSecondsPassed = 0;
            this.timer.stop();
        }
    }

    public void debugMode() {
    }

    public void pauseScreen() {
        paused = true;
    }

    public class MyKeyAdapter
    extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case 37: {
                    if (GamePanel.this.direction == 'R') break;
                    GamePanel.this.direction = (char)76;
                    break;
                }
                case 39: {
                    if (GamePanel.this.direction == 'L') break;
                    GamePanel.this.direction = (char)82;
                    break;
                }
                case 38: {
                    if (GamePanel.this.direction == 'D') break;
                    GamePanel.this.direction = (char)85;
                    break;
                }
                case 40: {
                    if (GamePanel.this.direction == 'U') break;
                    GamePanel.this.direction = (char)68;
                    break;
                }
                case 27: {
                    GamePanel.this.pauseScreen();
                    break;
                }
                case 114: {
                    dMode = true;
                    break;
                }
                case 115: {
                    dMode = false;
                    break;
                }
                case 65: {
                    if (GamePanel.this.direction == 'R') break;
                    GamePanel.this.direction = (char)76;
                    break;
                }
                case 68: {
                    if (GamePanel.this.direction == 'L') break;
                    GamePanel.this.direction = (char)82;
                    break;
                }
                case 87: {
                    if (GamePanel.this.direction == 'D') break;
                    GamePanel.this.direction = (char)85;
                    break;
                }
                case 83: {
                    if (GamePanel.this.direction == 'U') break;
                    GamePanel.this.direction = (char)68;
                }
            }
        }
    }
}

