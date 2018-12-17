import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.io.PrintStream;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Game extends javax.swing.JFrame implements java.awt.event.MouseListener, java.awt.event.ActionListener
{
    static final int windowsizeX = 800;
    static final int windowsizeY = 800;
    static JTextField enterAnswer = new JTextField("");
    static JPanel answerField = new JPanel();
    static Questions test = new Questions();
    static Game run = new Game();

    static String question;
    static int penalty = 0;
    static int reward = 0;
    static int penaltyTimer = 0;

    static int difficulty = 1;
    static int questionNum; static int correct; static int difficultyCounter; static int errorCounter = 0;

    static double percent;
    static long startedTime;
    static long estamitedTime;
    static long second = 1000000000L;
    static long timer = 60L * second;
    static long remainingtimer = timer;

    static int menu = 0;
    static int highscore = 0;
    static int playing = 0;

    static boolean one = false;
    static boolean two = false;
    static boolean three = false;
    static boolean four = false;
    static boolean five = false;
    static boolean six = false;
    static boolean seven = false;
    static boolean eight = false;
    static boolean nine = false;
    static boolean ten = false;
    static boolean eleven = false;


    public Game()
    {
        enterAnswer.setPreferredSize(enterAnswer.getPreferredSize());
        answerField.setLayout(null);
        answerField.setSize(800, 800);
        answerField.setLocation(0, 0);
        enterAnswer.setLocation(250, 550);
        enterAnswer.setSize(300, 25);
        enterAnswer.addActionListener(new java.awt.event.ActionListener()
        {

            public void actionPerformed(ActionEvent event)
            {
                enter();
            }

        });
        answerField.add(enterAnswer);


        setSize(800, 800);
        setBackground(Color.ORANGE);
        setLocationRelativeTo(null);
        setUndecorated(false);
        addMouseListener(this);
        setDefaultCloseOperation(3);
        add(answerField);


        setVisible(true);
    }

    public void mainMenuGraphic(Graphics g) {
        Graphics2D text = (Graphics2D)g;
        Font font = getFont("font/direktora.ttf", 68);
        Font timerFont = getFont("font/direktor.ttf", 150);
        Font questionFont = getFont("font/direktorlight.ttf", 24);
        Font buttonFont = getFont("font/direktor.ttf", 48);



        text.setFont(font);
        text.setColor(Color.WHITE);
        FontMetrics fm = g.getFontMetrics();
        Rectangle2D rect = fm.getStringBounds("Computer Science:", text);
        text.drawString("Computer Science:", (int)((800.0D - rect.getWidth()) / 2.0D), 120);
        rect = fm.getStringBounds("Number Systems", text);
        text.drawString("Number Systems", (int)((800.0D - rect.getWidth()) / 2.0D), 190);
        text.setFont(timerFont);
        fm = g.getFontMetrics();
        if (penalty == 1) {
            text.setColor(new Color(255, 51, 0));
        } else if (reward == 1) {
            text.setFont(questionFont);
            text.drawString("+10", 550, 280);
            text.setFont(timerFont);
        }

        rect = fm.getStringBounds(timer / 1000000000L + "", text);
        text.drawString(timer / 1000000000L + "", (int)((800.0D - rect.getWidth()) / 2.0D), 400);
        text.setColor(Color.WHITE);
        text.setFont(questionFont);
        fm = g.getFontMetrics();
        rect = fm.getStringBounds(question, text);
        text.drawString(question, (int)((800.0D - rect.getWidth()) / 2.0D), 500);

        g.drawRect(275, 650, 250, 75);
        text.setFont(buttonFont);
        text.drawString("Submit", 310, 700);
    }

    public void actualMainMenuGraphic(Graphics g) { Graphics2D text = (Graphics2D)g;
        text.setRenderingHint(java.awt.RenderingHints.KEY_ANTIALIASING, java.awt.RenderingHints.VALUE_ANTIALIAS_ON);
        Font font = getFont("font/direktora.ttf", 68);
        Font font2 = getFont("font/direktora.ttf", 100);
        Font timerFont = getFont("font/direktor.ttf", 150);
        Font questionFont = getFont("font/direktorlight.ttf", 24);
        Font buttonFont = getFont("font/direktor.ttf", 48);

        text.setColor(Color.BLACK);
        text.setFont(buttonFont);
        FontMetrics fm = g.getFontMetrics();
        Rectangle2D rect = fm.getStringBounds("Start", text);
        text.drawString("Start", (int)((800.0D - rect.getWidth()) / 2.0D), 375);
        fm = g.getFontMetrics();
        rect = fm.getStringBounds("Options", text);
        text.drawString("Options", (int)((800.0D - rect.getWidth()) / 2.0D), 500);

        text.setFont(font);
        fm = g.getFontMetrics();
        rect = fm.getStringBounds("Computer Science", text);
        text.drawString("Computer Science", (int)((800.0D - rect.getWidth()) / 2.0D), 100);
        text.setFont(font2);
        fm = g.getFontMetrics();
        rect = fm.getStringBounds("Review Game", text);
        text.drawString("Review Game", (int)((800.0D - rect.getWidth()) / 2.0D), 200);


        text.setFont(questionFont);
        fm = g.getFontMetrics();
        rect = fm.getStringBounds("Written by: Diego Gonzalez :)", text);
        text.drawString("Written by: Diego Gonzalez :)", (int)((800.0D - rect.getWidth()) / 2.0D), 650);



        text.drawRect(275, 320, 250, 75);
        text.drawRect(275, 445, 250, 75);
    }

    public void optionMenuGraphic(Graphics g) {
        Graphics2D text = (Graphics2D)g;
        Font font = getFont("font/direktora.ttf", 90);
        Font questionFont = getFont("font/direktorlight.ttf", 40);
        Font buttonFont = getFont("font/direktor.ttf", 48);

        text.setFont(font);
        text.setColor(Color.WHITE);
        FontMetrics fm = g.getFontMetrics();
        Rectangle2D rect = fm.getStringBounds("Game Options", text);
        text.drawString("Game Options", (int)((800.0D - rect.getWidth()) / 2.0D), 150);

        text.setFont(questionFont);
        text.drawString("Enable Binary", 250, 250);
        text.drawString("Enable Hexadecimal", 250, 350);
        text.drawString("Enable Octal", 250, 450);

        text.setFont(buttonFont);
        fm = g.getFontMetrics();
        rect = fm.getStringBounds("Main Menu", text);
        text.drawString("Main Menu", (int)((800.0D - rect.getWidth()) / 2.0D), 600);

        text.drawRect(225, 545, 350, 75);
        text.drawRect(150, 210, 50, 50);
        text.drawRect(150, 310, 50, 50);
        text.drawRect(150, 410, 50, 50);


        if (test.isBinary())
            text.fillRect(162, 222, 25, 25);
        if (test.isHexadecimal())
            text.fillRect(162, 322, 25, 25);
        if (test.isOctal())
            text.fillRect(162, 422, 25, 25);
    }

    public void highscoreMenuGraphic(Graphics g) { Graphics2D text = (Graphics2D)g;
        Font font = getFont("font/direktora.ttf", 90);
        Font questionFont = getFont("font/direktorlight.ttf", 40);
        Font buttonFont = getFont("font/direktor.ttf", 48);

        text.setFont(font);
        text.setColor(Color.WHITE);
        FontMetrics fm = g.getFontMetrics();
        Rectangle2D rect = fm.getStringBounds("Game Over", text);
        text.drawString("Game Over", (int)((800.0D - rect.getWidth()) / 2.0D), 350);

        text.setFont(questionFont);
        fm = g.getFontMetrics();
        rect = fm.getStringBounds("Highscore: " + highscore, text);
        text.drawString("Highscore: " + highscore, (int)((800.0D - rect.getWidth()) / 2.0D), 450);

        text.setFont(buttonFont);
        fm = g.getFontMetrics();
        rect = fm.getStringBounds("Main Menu", text);
        text.drawString("Main Menu", (int)((800.0D - rect.getWidth()) / 2.0D), 600);

        text.drawRect(225, 545, 350, 75);
    }


    public void mouseEntered(MouseEvent e) {}

    public void mouseExited(MouseEvent e) {}

    public void mouseClicked(MouseEvent e)
    {
        System.out.println("Click");
        if (menu == 0) {
            if (collision(e.getX(), e.getY(), 1, 1, 275, 320, 250, 75)) {
                start();
                menu = 1;
            }
            if (collision(e.getX(), e.getY(), 1, 1, 275, 445, 250, 75)) {
                menu = 2;
            }
        }
        if ((menu == 1) &&
                (collision(e.getX(), e.getY(), 1, 1, 275, 650, 250, 75))) {
            enter();
        }

        if (menu == 2) {
            if (collision(e.getX(), e.getY(), 1, 1, 225, 545, 350, 75)) {
                menu = 0;
            }
            if (collision(e.getX(), e.getY(), 1, 1, 150, 210, 50, 50)) {
                if (test.isBinary() == true) if (((!test.isHexadecimal()) && (!test.isOctal()) ? 1 : 0) == 0) {
                    test.setBinary(false);
                }
                test.setBinary(true);
            }

            label240:
            if (collision(e.getX(), e.getY(), 1, 1, 150, 310, 50, 50)) {
                if (test.isHexadecimal() == true) if (((!test.isBinary()) && (!test.isOctal()) ? 1 : 0) == 0) {
                    test.setHexadecimal(false);
                }
                test.setHexadecimal(true);
            }
            label320:
            if (collision(e.getX(), e.getY(), 1, 1, 150, 410, 50, 50)) {
                if (test.isOctal() == true) if (((!test.isHexadecimal()) && (!test.isBinary()) ? 1 : 0) == 0) {
                    test.setOctal(false);
                }
                test.setOctal(true);
            }
        }
        label400:
        if (menu == 3) {
            System.out.println("Menu=3");
            if (collision(e.getX(), e.getY(), 1, 1, 225, 545, 350, 75)) {
                menu = 0;
                System.out.println("Return to main menu");
                setBackground(Color.ORANGE);
            }
        }
    }


    public void mouseReleased(MouseEvent e) {}


    public void mousePressed(MouseEvent e) {}


    public void actionPerformed(ActionEvent e) {}


    public void paint(Graphics g)
    {
        super.paint(g);
        if (menu == 0) {
            actualMainMenuGraphic(g);
        } else if (menu == 1) {
            mainMenuGraphic(g);
        } else if (menu == 2) {
            optionMenuGraphic(g);
        } else if (menu == 3) {
            highscoreMenuGraphic(g);
        }
    }

    public void run() {
        if ((menu == 0) || (menu == 3)) {
            enterAnswer.setVisible(false);
        } else if (menu == 1) {
            enterAnswer.setVisible(true);
        }



        if ((penalty == 1) && (penaltyTimer < 2000000)) {
            penaltyTimer += 1;
        } else if ((penalty == 1) && (penaltyTimer == 2000000)) {
            penalty = 0;
            penaltyTimer = 0;
        }
        if ((reward == 1) && (penaltyTimer < 2000000)) {
            penaltyTimer += 1;
        } else if ((reward == 1) && (penaltyTimer == 2000000)) {
            reward = 0;
            penaltyTimer = 0;
        }




        if (playing == 1) {
            timer = remainingtimer - estamitedTime;

            if (difficultyCounter == 5) {
                difficultyCounter = 0;
                difficulty += 1;
            }
            if ((errorCounter > 3) && (difficulty > 1)) {
                difficulty -= 1;
            }
            estamitedTime = System.nanoTime() - startedTime;

            if (timer / 1000000000L > 100L) {
                setBackground(new Color(0, 153, 51));
            }
            else if ((timer / 1000000000L < 100L) && (timer / 1000000000L > 25L)) {
                setBackground(Color.ORANGE);
            } else if (timer / 1000000000L < 25L) {
                setBackground(new Color(153, 0, 0));
            }


            if ((timer / 1000000000L < 11L) && (!eleven)) {
                eleven = true;
                Toolkit.getDefaultToolkit().beep();
            }

            if (timer / 1000000000L > 11L) {
                eleven = false;
            }
            if ((timer / 1000000000L < 10L) && (!ten)) {
                ten = true;
                Toolkit.getDefaultToolkit().beep();
            }

            if (timer / 1000000000L > 10L) {
                ten = false;
            }
            if ((timer / 1000000000L < 9L) && (!nine)) {
                Toolkit.getDefaultToolkit().beep();
                nine = true;
            }
            if (timer / 1000000000L > 9L) {
                nine = false;
            }
            if ((timer / 1000000000L < 8L) && (!eight)) {
                Toolkit.getDefaultToolkit().beep();
                eight = true;
            }
            if (timer / 1000000000L > 8L) {
                eight = false;
            }
            if ((timer / 1000000000L < 7L) && (!seven)) {
                Toolkit.getDefaultToolkit().beep();
                seven = true;
            }
            if (timer / 1000000000L > 7L) {
                seven = false;
            }
            if ((timer / 1000000000L < 6L) && (!six)) {
                Toolkit.getDefaultToolkit().beep();
                six = true;
            }
            if (timer / 1000000000L > 6L) {
                six = false;
            }
            if ((timer / 1000000000L < 5L) && (!five)) {
                Toolkit.getDefaultToolkit().beep();
                five = true;
            }
            if (timer / 1000000000L > 5L) {
                five = false;
            }
            if ((timer / 1000000000L < 4L) && (!four)) {
                Toolkit.getDefaultToolkit().beep();
                four = true;
            }
            if (timer / 1000000000L > 4L) {
                four = false;
            }
            if ((timer / 1000000000L < 3L) && (!three)) {
                Toolkit.getDefaultToolkit().beep();
                three = true;
            }
            if (timer / 1000000000L > 3L) {
                three = false;
            }
            if ((timer / 1000000000L < 2L) && (!two)) {
                Toolkit.getDefaultToolkit().beep();
                two = true;
            }
            if (timer / 1000000000L > 2L) {
                two = false;
            }
            if ((timer / 1000000000L < 1L) && (!one)) {
                Toolkit.getDefaultToolkit().beep();
            }

            if (timer / 1000000000L > 1L) {
                one = false;
            }
        }


        repaint();


        if (timer / 1000000000L < 0L) {
            gameover();
        }
    }

    public boolean collision(int x, int y, int width, int height, int x2, int y2, int width2, int height2)
    {
        java.awt.Shape Main = new java.awt.geom.Rectangle2D.Float(x, y, width, height);
        java.awt.Shape Enemy = new java.awt.geom.Rectangle2D.Float(x2, y2, width2, height2);

        Area mainArea = new Area(Main);
        mainArea.intersect(new Area(Enemy));

        return !mainArea.isEmpty();
    }

    public void enter() {
        System.out.println("" + enterAnswer.getText());
        System.out.println(test.checkAnswer(enterAnswer.getText()));
        if (test.checkAnswer(enterAnswer.getText().replaceFirst("^0+(?!$)", "")) == true) {
            correct += 1;
            remainingtimer += 10L * second;
            difficultyCounter += 1;
            errorCounter = 0;
            reward = 1;
            penalty = 0;
            penaltyTimer = 0;
        } else {
            errorCounter += 1;
            remainingtimer -= 5L * second;
            penalty = 1;
            reward = 0;
            penaltyTimer = 0;
        }

        questionNum += 1;
        percent = correct / questionNum;
        System.out.println(difficulty);
        question = test.genQuestion(difficulty);

        enterAnswer.setText("");
    }

    public void start() {
        question = test.genQuestion(difficulty);
        startedTime = System.nanoTime();
        playing = 1;
    }

    public void gameover() {
        highscore = correct * 10;
        menu = 3;
        remainingtimer = 60L * second;
        timer = remainingtimer;
        playing = 0;
    }

    public static Font getFont(String name, int size) {
        try {
            Font font = Font.createFont(0, new java.io.File(name));
            font = font.deriveFont(0, size);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();

            ge.registerFont(font);

            JLabel l = new JLabel("The quick brown fox jumped over the lazy dog. 0123456789");

            l.setFont(font);

            return font;
        } catch (Exception e) {}
        return new Font("", 0, 20);
    }



    public static void main(String[] args)
    {
        startedTime = System.nanoTime();
        question = test.genQuestion(difficulty);

        for (;;)
        {
            run.run();
        }
    }
}