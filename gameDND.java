import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.Box;
import java.awt.*;
//import javax.swing.*;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.Container;
import java.awt.Dimension;




public class gameDND{
    int playerhp;
    int monhp;
    String playerweapon,playerPosition;

    JFrame window;
    Container contain;
    JPanel titleName,mainTextPanel,choiceButtonPanel,playerPanel,startButtonPanel;
    JLabel titleLabel,a;
    JLabel HPLabel, HP, weaponlabel, weaponName;
    JLabel subtitle;
    JButton startButton,choiceButton1,choiceButton2,choiceButton3;
    JTextArea mainTextArea;
    Font titleFont = new Font("Ariel",Font.BOLD,80);
    Font subtitleFont = new Font("Ariel",Font.PLAIN,25);

    secondScreen screenOne = new secondScreen();
    playerHandler pHandler = new playerHandler();
     public static void main(String args[]){
         
         new gameDND();
     }
     public gameDND(){
         //.
         //from here
         window = new JFrame();
         window.setSize(800,600);
         window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         window.getContentPane().setBackground(Color.black);
         window.setLayout(null);
         
         contain = window.getContentPane();

         titleName = new JPanel();
         titleName.setBounds(250, 100, 600, 300);
         titleName.setBackground(Color.BLACK);
         titleLabel = new JLabel("<html><center>The Howling Bog</center></html>");
         titleLabel.setForeground(Color.WHITE);
         titleLabel.setFont(titleFont);
         titleName.add(titleLabel);
         subtitle = new JLabel("A Fantasy RPG ");
         subtitle.setFont(subtitleFont);
         subtitle.setText(
             "<html><center>A Fantasy RPG <br> Inspired By Critical Role</center></html>"
         );

         startButtonPanel =new JPanel();
         startButtonPanel.setBounds(300, 400, 200, 100);
         startButtonPanel.setBackground(Color.BLACK);
         startButton = new JButton("Start");
         startButton.setBounds(400, 900, 100, 40);
         startButton.setBackground(Color.BLACK);
         startButton.setForeground(Color.WHITE);
         startButton.setFont(subtitleFont);
         startButton.addActionListener(screenOne);
         
         titleLabel.setForeground(Color.WHITE);
         contain.add(titleName);
         titleName.add(subtitle);
         //window.add(a);
         titleName.setLayout(new BoxLayout(titleName, BoxLayout.Y_AXIS));
         titleLabel.setFont(subtitleFont);
         titleName.add(Box.createRigidArea(new Dimension(0,10)));
         
         contain.add(startButtonPanel);
         startButtonPanel.add(startButton);

         window.add(new JLabel(new ImageIcon("dungeon.jpg")));
         //paintIcon();
         //ImageIcon img= new ImageIcon(this.getClass().getResource("")).getImage();
         
        
        
         window.setVisible(true);

     }
     
     public void createGameScreen(){
         titleName.setVisible(false);
         startButton.setVisible(false);
        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100, 100, 600, 250);
        mainTextPanel.setBackground(Color.BLACK);
        contain.add(mainTextPanel);

        mainTextArea = new JTextArea(
            "Welcome to the Dwarvern City of KragHammer.You are invited to visit the Mayor of the city Lord ThunderBrand " 
        );
        mainTextArea.setBounds(100, 100, 600, 250);
        mainTextArea.setLineWrap(true);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextPanel.add(mainTextArea);
        mainTextArea.setFont(subtitleFont);

        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(250, 350, 300, 150);
        choiceButtonPanel.setBackground(Color.GREEN);
        choiceButtonPanel.setLayout(new GridLayout(3,1));
        contain.add(choiceButtonPanel);

        choiceButton1= new JButton("Choice 1");
        choiceButton1.setBackground(Color.BLACK);
        choiceButton1.setForeground(Color.WHITE);
        choiceButton1.setFont(subtitleFont);
        choiceButton1.setActionCommand("c1");
        choiceButton1.addActionListener(pHandler);
        choiceButtonPanel.add(choiceButton1);

        choiceButton2= new JButton("Choice 2");
        choiceButton2.setBackground(Color.BLACK);
        choiceButton2.setForeground(Color.WHITE);
        choiceButton2.setFont(subtitleFont);
        choiceButton2.setActionCommand("c2");
        choiceButton2.addActionListener(pHandler);
        choiceButtonPanel.add(choiceButton2);

        choiceButton3= new JButton("Choice 3");
        choiceButton3.setBackground(Color.BLACK);
        choiceButton3.setForeground(Color.WHITE);
        choiceButton3.setFont(subtitleFont);
        choiceButton3.setActionCommand("c3");
        choiceButton3.addActionListener(pHandler);
        choiceButtonPanel.add(choiceButton3);

        /* choiceButton4= new JButton("Choice 4");
        choiceButton4.setBackground(Color.BLACK);
        choiceButton4.setForeground(Color.WHITE);
        choiceButton4.setFont(subtitleFont);
        choiceButton4.setActionCommand("c4");
        choiceButton4.addActionListener(pHandler);
        choiceButtonPanel.add(choiceButton4); */

        playerPanel = new JPanel();
        playerPanel.setBounds(100,15,600,50);
        playerPanel.setLayout(new GridLayout(1,4));
        playerPanel.setBackground(Color.green);
        contain.add(playerPanel);

         HPLabel = new JLabel("HP:");
         HPLabel.setFont(subtitleFont);
         HPLabel.setForeground(Color.white);
         playerPanel.add(HPLabel);

         HP = new JLabel();
         HP.setFont(subtitleFont);
         HP.setForeground(Color.white);
         playerPanel.add(HP);

         weaponlabel = new JLabel("Weapon:");
         weaponlabel.setFont(subtitleFont);
         weaponlabel.setForeground(Color.white);
         playerPanel.add(weaponlabel);

         weaponName = new JLabel();
         weaponName.setFont(subtitleFont);
         weaponName.setForeground(Color.white);
         playerPanel.add(weaponName);

         playerSetup();
        

     }
     
     
     public void playerSetup(){
         playerhp =20;
         monhp=20;
         playerweapon ="Dagger";
         weaponName.setText(playerweapon);
         HP.setText(""+playerhp);
         startScreen();
         
     }
     public void startScreen(){
        playerPosition ="startScreen";
         mainTextArea.setText(
        "You arrive at the great city of Emon. You are invited \n meet the mayor of the city Lord Uriel");
        choiceButton1.setText("Visit Lord Uriel");
        choiceButton2.setText("");
        choiceButton3.setText("");
        //choiceButton4.setText(""); 
     }

     public void mayorHouse(){
         playerPosition ="mayorHouse";
         mainTextArea.setText(
        "Lord Uriel: \n Welcome Adventurer. I have a quest for you. \n Are you upto  it?");
        choiceButton1.setText("Accept Quest");
        choiceButton2.setText("Decline Quest");
        choiceButton3.setText("");
        //choiceButton4.setText("");
     }

     public void acceptQuest(){
        playerPosition ="acceptQuest";
        mainTextArea.setText("Lord Uriel: Thats the spirit!");
        choiceButton1.setText("Continue");
        choiceButton2.setText("");
        choiceButton3.setText("");
       //choiceButton4.setText("");

    }
    public void declineQuest(){
        playerPosition="declineQuest";
        mainTextArea.setText(
        "Lord Uriel:I thought better of you");
        choiceButton1.setText("Accept");
        choiceButton2.setText("");
        choiceButton3.setText("");
        //choiceButton4.setText("");
    }
    public void continueQuest(){
        playerPosition="continueQuest";
        mainTextArea.setText(
        "Lord Uriel:You are to retrieve a precious artifact for me. \n 'The Necklace Of  The Thousand Moons' found only in the Shademirk Bog." );
        choiceButton1.setText("Continue");
        choiceButton2.setText("");
        choiceButton3.setText("");
        //choiceButton4.setText("");
    }
    public void continue1Quest(){
       playerPosition="continue1Quest";
       mainTextArea.setText(
       "Lord Uriel:You will face many challenges but I'm sure you will emerge successful. \nSafe travel's adventurer!" );
       choiceButton1.setText("Go to Shademirk Bog");
       choiceButton2.setText("");
       choiceButton3.setText("");
       //choiceButton4.setText("");
    }
    public void continue2Quest(){
       playerPosition="continue2Quest";
       playerhp =20;
       monhp=20;
       mainTextArea.setText(
       "You arrive at Shademirk Bog.\n The road diverges in front of you. \n What do you do?" );
       choiceButton1.setText("Go Left");
       choiceButton2.setText("Go Right");
       choiceButton3.setText("");
       //choiceButton4.setText("");
    }
    public void leftQuest(){
       playerPosition="leftQuest";
       mainTextArea.setText(
       "You found a healing potion. \nWhat do you do?" );
       playerhp=playerhp+20;
       HP.setText(""+playerhp);
       choiceButton1.setText("Drink potion and Go");
       choiceButton2.setText("Run away");
       choiceButton3.setText("");
       //choiceButton4.setText("");
    }
    public void DrinkQuest(){
       playerPosition="fight";
       
       mainTextArea.setText(
       "Oh no! You encountered a Goblin. \nWhat do you do?" );
       choiceButton1.setText("Attack");
       choiceButton2.setText("Run away");
       choiceButton3.setText("");
       //choiceButton4.setText("");
    }
    public void RunQuest(){
       playerPosition="RunQuest";
       mainTextArea.setText(
       "Lord Uriel: I thought you were braver. You ran away! \n                   QUEST FAILED!          ");
       choiceButton1.setText("Try Again");
       choiceButton2.setText("");
       choiceButton3.setText("");
      // choiceButton4.setText("");
    }
    public void RightQuest(){//ATTACKKK SEQUENCE NEEDED AFTRT THIS 
       playerPosition="fight";
       mainTextArea.setText(
       "Oh no! You encountered a Goblin. \nWhat do you do?" );
       choiceButton1.setText("Attack");
       choiceButton2.setText("Run away");
       choiceButton3.setText("");
      // choiceButton4.setText("");
    }
   
    public void AttackQuest(){
       playerPosition="AttackQuest";
       mainTextArea.setText(
       "The Goblin dropped 'The Neckalce Of The Thousand Moons'!." );
       choiceButton1.setText("Pick it up");
       choiceButton2.setText("Pick and search cave");
       choiceButton3.setText("");
      // choiceButton4.setText("");
    }
    public void PickQuest(){
       playerPosition="PickQuest";
       mainTextArea.setText(
       "You found the artifact!" );
       choiceButton1.setText("Go back to Emon");
       choiceButton2.setText("");
       choiceButton3.setText("");
      // choiceButton4.setText("");
    }
    public void searchQuest(){
       playerPosition="searchQuest";
       mainTextArea.setText(
       "You found a great Sword!" );
       choiceButton1.setText("Equip");
       choiceButton2.setText("");
       choiceButton3.setText("");
      // choiceButton4.setText("");
    }
    public void equipQuest(){
     playerPosition="equipQuest";
     mainTextArea.setText(
     "You found the artifact!" );
     choiceButton1.setText("Go back to Emon");
     choiceButton2.setText("");
     choiceButton3.setText("");
    // choiceButton4.setText("");
     playerweapon ="GreatSword";  
     weaponName.setText(playerweapon);
  }
    public void backQuest(){
       playerPosition="backQuest";
       mainTextArea.setText(
       "Lord Uriel: Welcome back adventurer! \nI see you found the necklace.I knew I could trust you. \nExcellent job!" );
       choiceButton1.setText("End Game");
       choiceButton2.setText("");
       choiceButton3.setText("");
      // choiceButton4.setText("");
    }
    public void restartGame(){
        playerPosition="restartGame";
       mainTextArea.setText(
       "You will start from Shademirk Bog.Do you want to try again?" );
       choiceButton1.setText("Yes");
       choiceButton2.setText("");
       choiceButton3.setText("");
      // choiceButton4.setText("");

    }

    public void endGame(){
        playerPosition="endGame";
       mainTextArea.setText(
       "QUEST COMPLETED" );
       choiceButton1.setText("");
       choiceButton1.setEnabled(false);
       choiceButton2.setEnabled(false);
       choiceButton3.setEnabled(false);
      // choiceButton4.setEnabled(false);


    }

    public void fight()
    {
      playerPosition="fight";
      mainTextArea.setText("Monster HP: "+monhp+"\n\n What do you do? ");
      choiceButton1.setText("Attack!");
       choiceButton2.setText("Run away");
       choiceButton3.setText("");
      // choiceButton4.setText("");
       
    }


    public void playerAttack()
    {
       playerPosition="playerAttack";
       
       int playerd=0;

       playerd=new java.util.Random().nextInt(8);


       mainTextArea.setText("You attacked the Goblin and dealt "+ playerd+" damage ");

       monhp=monhp - playerd;

       choiceButton1.setText("Continue Attacking");
       choiceButton2.setText("Run away");
       choiceButton3.setText("");
      // choiceButton4.setText("");


    }
    public void monsterAttack()
    {
       playerPosition="mon";

       int mond=0;
       mond=new java.util.Random().nextInt(6);
       mainTextArea.setText("The Goblin attacked! You recieve "+ mond+"  damage");
       
       playerhp=playerhp-mond;
      HP.setText(""+playerhp);

      choiceButton1.setText("Continue Attacking");
       choiceButton2.setText("Run away");
       choiceButton3.setText("");
      // choiceButton4.setText("");


    }

    public void win()
    {
      playerPosition="DrinkQuest";
      mainTextArea.setText(" You killed the Goblin!");
      choiceButton1.setText("Continue");
       choiceButton2.setText("Run away");
       choiceButton3.setText("");
      // choiceButton4.setText("");
    }

    public void lose()
    {
      
      playerPosition="restartGame";
      mainTextArea.setText("You Died! \n \n <GAME OVER>");

      choiceButton1.setText("Try Again");
       choiceButton2.setText("Run away");
       choiceButton3.setText("");
      // choiceButton4.setText("");
    }
   public class secondScreen implements ActionListener {
    
        public void actionPerformed(ActionEvent event){
            createGameScreen();
        }
    }
    public class playerHandler implements ActionListener{
        public void actionPerformed(ActionEvent event){
            String yourChoice = event.getActionCommand();

            switch(playerPosition)
            {
                case "startScreen":
                
                    switch(yourChoice){
                        case "c1": mayorHouse(); break;
                        case "c2":  break;
                        case "c3": break;
                      //  case "c4": break;   
                }
                break;
                case "mayorHouse":
                 switch(yourChoice){
                     case "c1": acceptQuest(); break;
                     case "c2": declineQuest(); break;
                     case "c3": playerAttack() ;break;
                   //  case "c4": break;
                 }
                 break;
                 case "declineQuest":
                 switch(yourChoice){
                    case "c1": acceptQuest(); break;
                    case "c2": break;
                    case "c3": break;
                   // case "c4": break;
                 }
                 break;
                 case "acceptQuest":
                 switch(yourChoice){
                    case "c1": continueQuest(); break;
                    case "c2": break;
                    case "c3": break;
                  //  case "c4": break;

                }
                break;
                case "continueQuest":
                 switch(yourChoice){
                    case "c1": continue1Quest(); break;
                    case "c2": break;
                    case "c3": break;
                  //  case "c4": break;
                 }
                 break;
                case "continue1Quest":
                 switch(yourChoice){
                    case "c1": continue2Quest(); break;
                    case "c2": break;
                    case "c3": break;
                   // case "c4": break;
                 }
                 break;
                case "continue2Quest":
                 switch(yourChoice){
                    case "c1": leftQuest(); break;
                    case "c2": RightQuest(); break;
                    case "c3": break;
                  //  case "c4": break;
                 }
                 break;
                case "leftQuest":
                 switch(yourChoice){
                    case "c1": DrinkQuest(); break;
                    case "c2": RunQuest(); break;
                    case "c3": break;
                  //  case "c4": break;
                 }
                 break;
                case "DrinkQuest":
                 switch(yourChoice){
                    case "c1": AttackQuest(); break;
                    case "c2": RunQuest(); break;
                    case "c3": break;
                  //  case "c4": break;
                 }
                 break;
                 case "RunQuest":
                 switch(yourChoice){
                    case "c1": restartGame(); break;
                    case "c2": break;
                    case "c3": break;
                   // case "c4": break;
                 }
                 break;
                case "RightQuest":
                 switch(yourChoice){
                    case "c1": RightQuest(); break;
                    case "c2": RunQuest(); break;
                    case "c3": break;
                  //  case "c4": break;
                 }
                 break;
                case "AttackQuest":
                 switch(yourChoice){
                    case "c1": PickQuest(); break;
                    case "c2": searchQuest(); break;
                    case "c3": break;
                  //  case "c4": break;
                 }
                 break;
                 case "PickQuest":
                 switch(yourChoice){
                    case "c1": backQuest(); break;
                    case "c2": searchQuest(); break;
                    case "c3": break;
                  //  case "c4": break;
                 }
                 break;
                 case "searchQuest":
                 switch(yourChoice){
                    case "c1": equipQuest(); break;
                    case "c2": backQuest(); break;
                    case "c3": break;
                   // case "c4": break;
                 }
                 break;
                 case "equipQuest":
                 switch(yourChoice){
                    case "c1": backQuest(); break;
                    case "c2": break;
                    case "c3": break;
                  //  case "c4": break;
                 }
                 break;
                 case "restartGame":
                 switch(yourChoice){
                    case "c1": continue2Quest(); break;
                    case "c2": break;
                    case "c3": break;
                  //  case "c4": break;
                 }
                 break;
                 case "backQuest":
                 switch(yourChoice){
                    case "c1": endGame(); break;
                    case "c2": break;
                    case "c3": break;
                   // case "c4": break;
                 }
                 break;
                 case "fight":
                 switch(yourChoice)
                 {
                    case "c1" : playerAttack(); break;
                    case "c2" : break;

                 }
                 break;
                 case "playerAttack" :
                 
                    switch(yourChoice)
                   { 
                      case "c1" : 
                      if(monhp<1)
                      {
                         win();
                      }
                      else
                      {
                        monsterAttack();

                      }
                      break;

                    }
                    break;
                   


                    case "mon" :

                    switch(yourChoice)
                    {
                       case "c1": 
                       if(playerhp<1)
                       {
                          lose();
                       }
                       else
                       {
                        fight(); 
                       }
                       
                    }
                    break;

            }

        }
    }
    
   
 }
