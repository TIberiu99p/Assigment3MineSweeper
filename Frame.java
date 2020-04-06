import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.util.List;

public class Frame extends JFrame implements ActionListener {

    boolean isGameRunning = false;

    JButton[] buttons;
    JFrame window = new JFrame("Chasing-bombs-tp371");

    
    // panels
    JPanel panel_01 = new JPanel();
    JPanel panel_02 = new JPanel();
    JPanel panel_03 = new JPanel();
    JPanel panel_inside_02 = new JPanel();
    JPanel panel_inside_03 = new JPanel();


    //menu
    JButton start, exit;

    //difficuly
    JButton easy, medium , hard;

    //randomiser variables
    int changeableValue = 3;
    Random rand = new Random();
    boolean fieldIsBomb = false;

    // buttons that will be bombs
    List<String> bombs = new ArrayList<>();

    // This is used for debug
    List<String> identifiedBombs = new ArrayList<>();

    boolean methodHasrun = false;

    public Frame() {

        String[] btn = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };
        buttons = new JButton[10];

        window.setLayout(new GridLayout(0, 3));
        panel_02.setBackground(Color.GRAY);
        panel_03.setBackground(Color.LIGHT_GRAY);

        panel_01.setLayout(new GridLayout(2, 5));

        
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton(btn[i]);
            buttons[i].setBackground(Color.BLACK);
            buttons[i].setForeground(Color.BLACK);
            panel_01.add(buttons[i]);
            
            
        }
        
        /**
         * TODO:
         * -[x] create menu for start and exit
         * -[x] create menu for difficulty 
         */

        
        start = new JButton("Start");
        exit = new JButton("Exit");

        panel_inside_02.setLayout(new GridLayout(2,1));
        panel_inside_02.add(start);
        
        panel_inside_02.add(exit);
        panel_02.add(panel_inside_02);
       
        easy = new JButton("Easy");
        medium = new JButton("Medium");
        hard= new JButton("Hard");

        panel_inside_03.setLayout(new GridLayout(3,1));
        panel_inside_03.add(easy);
        easy.addActionListener(this);
        panel_inside_03.add(medium);
        medium.addActionListener(this);
        panel_inside_03.add(hard);
        hard.addActionListener(this);
        panel_03.add(panel_inside_03);

        

        window.add(panel_01, BorderLayout.WEST);
        window.add(panel_02, BorderLayout.CENTER);
        window.add(panel_03, BorderLayout.EAST);

        window.setSize(400, 400);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);

        
        randomiser();
        
        
       
    }

    

    public void randomiser(){
        //FIXME: Get the actual number of random items that the difficulty is set on
        
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent event) {
                    JButton pressedButton = (JButton)event.getSource();
                    if(pressedButton.getText().equals("bomb")){
                        pressedButton.setBackground(Color.RED);
                    }
                    else{
                        pressedButton.setBackground(Color.GREEN);
                    }
                }
            });
        }

        


        for (int j = 0; j < changeableValue; j++) {
            int random = (int) (Math.random() * 10);
            bombs.add(buttons[random].getText());
            buttons[random].setText("bomb");
        }
        System.out.println(bombs);
         
        
        /* this is for later debbuging 
        for (int x = 0; x < buttons.length; x++) {

            identifiedBombs.add(buttons[x].getText());
        }
        System.out.println(identifiedBombs);*/
    }

    

    public static void main(String[] args) {
        Frame game = new Frame();
    }


    public void startGame(){
        start.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent eventStart){
                
            }

        });
    }
    
    public void difficultySet(){

        easy.addActionListener(new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent easyEvent) {
                if(easyEvent.getSource() == easy){
                    if(!medium.isEnabled() && !hard.isEnabled()){
                        changeableValue = 5;
                    }
                }
               
            }
        });
        medium.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent mediumEvent) {
                if(mediumEvent.getSource() == medium){
                    if(!easy.isEnabled() && !hard.isEnabled()){
                        changeableValue = 7;
                    }
                }
            }
        });
        hard.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent hardEvent) {
                if(hardEvent.getSource() == easy){
                    if(!easy.isEnabled() && !medium.isEnabled()){
                        changeableValue = 9;
                    }
                }
            }
        });

        methodHasrun = true;
    }

    public void gameOver(){

    }

    public void exitGame(){
        exit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent eventExit){

            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent event) {

        
    }
    
}


