package _Duel;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Instant;
import javax.swing.Timer;
import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.DimensionUIResource;


public class Duel extends JFrame {

    public String player1 = new String("");
    public String player2 = new String("");
    public String cplayer = new String("");
    public String s = new String("");
    public int score1 = 0;
    public int score2 = 0;
    public int t = 0;
    public int diff = 0;
    public int timerDel = 0;
    public int timerDel1 = 0;
    public int ammo1 = 2;
    public int ammo2 = 2;

//----------------------------------------------------------------------
// создание объектов
    private JPanel panel1 = new JPanel();
    private JPanel panel2 = new JPanel();
    private JPanel panel3 = new JPanel();
    private JPanel panel4 = new JPanel();
    private JTextArea p1 = new JTextArea("");
    private JTextArea p2 = new JTextArea("");
    private JLabel label1 = new JLabel("Игрок 1");
    private JLabel label2 = new JLabel("Игрок 2");
    private JButton ready = new JButton("Готовы");
    private JRadioButton d1 = new JRadioButton("Легко") ;
    private JRadioButton d2 = new JRadioButton("Нормально");
    private JRadioButton d3 = new JRadioButton("Сложно");
    private JButton Start = new JButton("OK, Let's do this");
    private JLabel label3 = new JLabel("К Барьеру"+cplayer);
    private JLabel label4 = new JLabel("3");
    private JButton fire = new JButton("И тут я начинаю шмалять");
    private JLabel label5 = new JLabel("");
    private JLabel label6 = new JLabel("");
    private JLabel labelE = new JLabel("");
    private JLabel labelI = new JLabel("<html> <br>"+"Попадание в сердце - 15 очков, в голову - 8, в живот - 5 <br>"
            +"Размер окрестности попадания: легко - 300мс, нормально - 200мс, сложно - 100мс <br></html>");

    private ButtonGroup butg = new ButtonGroup();
    private Timer timer;
    private Timer timer1;

    // конструктор
    public Duel() {

        // инициализация компонентов
        initMenu();
        //initDiff();
        //initDuel();
        //initScore();
        TimeClass tc = new TimeClass();
        int timerStep = 1;
        timer = new Timer(timerStep, tc);

        TimeClass1 tc1 = new TimeClass1();
        timer1 = new Timer(1000, tc1);

    }

    // метод инициализации компонентов формы
    private void initMenu() {
        getContentPane().removeAll();
        getContentPane().revalidate();

        // положение на экране
        setBounds(200, 150, 500, 250);
        // контейнер для размещения компонентов формы
        Container container = getContentPane();

        // окна для ввода
        p1.setBounds(75, 50, 150, 25);
        p2.setBounds(275, 50, 150, 25);
        // окна с текстом
        label1.setBounds(200, 20, 100, 25);
        label2.setBounds(400, 20, 100, 25);
        labelE.setBounds(100, 120, 300, 25);
        labelE.setHorizontalTextPosition(JLabel.CENTER);

        //кнопки
        ready.setBounds(200,85, 100, 25);

        // зарегистрировать экземпляр класса обработчика события
        ActionListener actionListener = new readyEvent();
        ready.addActionListener(actionListener);

        // панели
        panel1.setLayout(null);
        panel1.setBorder(new CompoundBorder(new EmptyBorder(5, 5, 5, 5), new TitledBorder("Start menu")));
        panel1.setPreferredSize(new Dimension(480, 230));
        panel1.add(p1);
        panel1.add(p2);
        panel1.add(label1);
        panel1.add(label2);
        panel1.add(ready);
        panel1.add(labelE);
        container.add(panel1);

    }
    private void initDiff()
    {
        getContentPane().removeAll();
        getContentPane().revalidate();

        setBounds(200, 150, 500, 250);
        Container container = getContentPane();

        labelI.setBounds(50, 100, 400, 100);

        d1.setMnemonic(KeyEvent.VK_B);
        d1.setActionCommand("1");
        d1.setSelected(true);

        d2.setMnemonic(KeyEvent.VK_C);
        d2.setActionCommand("2");

        d3.setMnemonic(KeyEvent.VK_D);
        d3.setActionCommand("3");

        butg.add(d1);
        butg.add(d2);
        butg.add(d3);

        Start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (d1.isSelected()){
                    diff = 300;
                    //System.out.println(diff);
                    initDuel();
                }else if (d2.isSelected())
                {
                    diff = 200;
                    //System.out.println(diff);
                    initDuel();
                }else if (d3.isSelected())
                {
                    diff = 100;
                    //System.out.println(diff);
                    initDuel();
                }
                System.out.println(diff);
                timerDel = 3;
                timer1.start();
                timer1.setRepeats(true);
            }
        });


        d1.setBounds(75,30, 100, 25);
        d2.setBounds(75,65, 100, 25);
        d3.setBounds(75,100, 100, 25);

        Start.setBounds(200,65, 150, 25);

        panel2.setLayout(null);
        panel2.setBorder(new CompoundBorder(new EmptyBorder(5, 5, 5, 5), new TitledBorder("Difficulty")));
        panel2.setPreferredSize(new Dimension(600, 440));
        panel2.add(d1);
        panel2.add(d2);
        panel2.add(d3);
        panel2.add(labelI);
        panel2.add(Start);

        container.add(panel2);
    }

    private void initDuel()
    {

        getContentPane().removeAll();
        getContentPane().revalidate();
        cplayer = player1;
        setBounds(200, 150, 500, 250);
        Container container = getContentPane();

        ActionListener actionListener = new fireEvent();
        fire.addActionListener(actionListener);


        label3.setBounds(150, 50, 150, 25);
        label4.setBounds(325, 50, 25, 25);

        fire.setBounds(140, 80, 200, 25);
        fire.setVisible(false);

        panel3.setLayout(null);
        panel3.setBorder(new CompoundBorder(new EmptyBorder(5, 5, 5, 5), new TitledBorder("Duel")));
        panel3.setPreferredSize(new Dimension(600, 440));
        panel3.add(label3);
        panel3.add(label4);
        panel3.add(fire);

        container.add(panel3);


    }

    private void initScore()
    {
        getContentPane().removeAll();
        getContentPane().revalidate();

        setBounds(200, 150, 500, 250);
        Container container = getContentPane();

        label5.setBounds(200, 50, 150, 25);
        label6.setBounds(200, 90, 150, 25);

        panel4.setLayout(null);
        panel4.setBorder(new CompoundBorder(new EmptyBorder(5, 5, 5, 5), new TitledBorder("Score")));
        panel4.setPreferredSize(new Dimension(600, 440));
        panel4.add(label5);
        panel4.add(label6);

        container.add(panel4);
        label5.setText(player1 + "   "+score1);
        label6.setText(player2 + "   "+score2);

    }


//----------------------------------------------------------------------

    public class TimeClass implements ActionListener {
        public TimeClass() {
            t = 0;
        }

        // время пошло , не работает все время срабатывает следующий класс
        @Override
        public void actionPerformed(ActionEvent ts) {
            t++;
            System.out.println(t);
        }
    }

    public class TimeClass1 implements ActionListener {
        public TimeClass1() {
            timerDel = 3;
        }

        // время пошло , не работает все время срабатывает следующий класс
        @Override
        public void actionPerformed(ActionEvent ts1) {
            label3.setText("К Барьеру,   " + cplayer);
            label4.setText("" + timerDel);
            timerDel--;
            System.out.println(timerDel);
            if (timerDel == -1){
                label4.setText("!");
                timer1.stop();
                fire.setVisible(true);
                timer.start();
                timer.setRepeats(true);
            }
        }
    }


    // клас имплементации события нажатия старт
    public class readyEvent implements ActionListener {

        @Override
        // обработка события нажатия на button готовы
        public void actionPerformed(ActionEvent e) {
            player1 = p1.getText();
            player2 = p2.getText();
            cplayer = player1;
            if (player1.isEmpty() || player2.isEmpty()){
                labelE.setText("Не все поля для имени игроков заполнены");
            }else if (player1.equals(player2))
            {
                labelE.setText("Имена не должны совпадать");
            }
            else
            {
                initDiff();
            }
        }
    }

    public class fireEvent implements ActionListener {

        @Override
        // обработка события нажатия на button готовы
        public void actionPerformed(ActionEvent e) {
            timer.stop();
            if (t <= 15000 + diff && t >=15000-diff)
            {
                //System.out.println("инфаркт");
                if (cplayer == player1) {
                    score1 += 15;
                    ammo1--;
                }else if (cplayer == player2)
                {
                    score2 +=15;
                    ammo2--;
                }
                timer.restart();
                t = 0;
            }else if (t <= 8000 + diff && t >=8000-diff)
            {
                //System.out.println("беды с башкой");
                if (cplayer == player1) {
                    score1 += 8;
                    ammo1--;
                }else if (cplayer == player2)
                {
                    score2 += 8;
                    ammo2--;
                }
                timer.restart();
                t = 0;
            }else if (t <= 5000 + diff && t >=5000-diff)
            {
                //System.out.println("маслину поймал");
                if (cplayer == player1) {
                    score1 += 5;
                    ammo1--;
                }else if (cplayer == player2)
                {
                    score2 += 5;
                    ammo2--;
                }
                timer.restart();
                t = 0;
            }else {
                if (cplayer == player1 && ammo2 !=0)
                {
                    ammo1--;
                    timer.stop();
                    t = 0;
                    timer1.start();
                    timerDel=3;
                    fire.setVisible(false);
                    cplayer = player2;
                    //System.out.println("player 2");
                }else if (cplayer == player2 && ammo1 !=0)
                {
                    ammo2--;
                    timer.stop();
                    t = 0;
                    timer1.start();
                    timerDel=3;
                    fire.setVisible(false);
                    cplayer = player1;
                    //System.out.println("player 1");
                }else if (cplayer == player1 && ammo2 ==0)
                {
                    ammo1--;
                    timer.stop();
                    t = 0;
                    timer1.start();
                    timerDel=3;
                    fire.setVisible(false);
                }else if (cplayer == player2 && ammo1 ==0)
                {
                    ammo2--;
                    timer.stop();
                    t = 0;
                    timer1.start();
                    timerDel=3;
                    fire.setVisible(false);
                }
                else if (ammo1-1 == 0 && ammo2 == 0 && cplayer == player1)
                {
                    timer.stop();
                    t = 0;
                    initScore();
                }
                else if (ammo1 == 0 && ammo2-1 == 0 && cplayer == player2)
                {
                    timer.stop();
                    t = 0;
                    initScore();
                }
            }
            if (cplayer == player1 && ammo1 == 0 && ammo2!=0)
            {
                timer.stop();
                t=0;
                timer1.start();
                timerDel=3;
                fire.setVisible(false);
                cplayer = player2;
            }else if (cplayer == player2 && ammo2 == 0 && ammo1!=0)
            {
                timer.stop();
                t=0;
                timer1.start();
                timerDel=3;
                fire.setVisible(false);
                cplayer = player1;
            }else if (ammo1==0 && ammo2==0)
            {
                timer.stop();
                timer1.stop();
                w();
                initScore();

            }
        }
    }

    public void w() {

        try(FileWriter writer = new FileWriter("result.txt", false))
        {
            String text1 = ("* \n"+ player1 +"\n"+score1+"\n");
            String text2 = ("* \n"+ player2 +"\n"+score2+"\n");
            writer.write(text1);
            writer.write(text2);

            writer.close();
            writer.flush();

        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
/*
    public void r() {

        try(FileReader reader = new FileReader("result.txt"))
        {
            // читаем посимвольно
            int c;
            while((c=reader.read())!=-1){

                System.out.print((char)c);
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
*/


    public static void main(String[] args) {

        // объект графической формы
        Duel graphic = new Duel();
        // закрытие формы
        graphic.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // визуализация формы
        graphic.setVisible(true);
    }


}
