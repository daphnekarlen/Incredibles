//Basic Game Application
//Graphics Libraries
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;


//*******************************************************************************
// Class Definition Section

public class RunIncrediblesProgram implements Runnable {

    //Variable Definition Section
    //Declare the variables used in the program
    //You can set their initial values too

    //Sets the width and height of the program window
    final int WIDTH = 1000;
    final int HEIGHT = 700;

    //Declare the variables needed for the graphics
    public JFrame frame;
    public Canvas canvas;
    public JPanel panel;

    public BufferStrategy bufferStrategy;

    public Image ednaPic;
    public Image jackjackPic;
    public Image angryJackPic;

    public Image mrIncrediblePic;
    public Image backgroundPic;

    public Image elasticPic;
// this section declares the names of my images

    //Declare the objects used in the program
    //These are things that are made up of more than one variable type
    public Incredibles edna;
    public Incredibles jackJack;
    public Incredibles angryJack;
    public Incredibles mrIncredible;
    public Incredibles elastigirl;
// these are all my characters that are part of the Incredibles

    public SoundFile junkCrash2;
    public SoundFile neighborhood; // these are the two sounds that I use







    // Main method definition
    // This is the code that runs first and automatically
    public static void main(String[] args) {
        RunIncrediblesProgram ex = new RunIncrediblesProgram();   //creates a new instance of the game
        new Thread(ex).start();                 //creates a threads & starts up the code in the run( ) method
    }


    // This section is the setup portion of the program
    // Initialize your variables and construct your program objects here.
    public RunIncrediblesProgram() { // BasicGameApp constructor

        setUpGraphics();

        //variable and objects
        //create (construct) the objects needed for the game and load up
        ednaPic = Toolkit.getDefaultToolkit().getImage("edna.png"); //load the picture
        edna = new Incredibles("edna",400,200, 0, 0, 200, 300); //construct edna


        jackjackPic = Toolkit.getDefaultToolkit().getImage("jackJack.png");
        jackJack = new Incredibles("jackJack", 800, 100, 5, 5, 130, 150);

        angryJackPic = Toolkit.getDefaultToolkit().getImage("angryjackJack.png");
        angryJack = new Incredibles("angryjackJack", 0, 400, 8, 8, 130, 150);

        mrIncrediblePic = Toolkit.getDefaultToolkit().getImage("mrIncredibles2.png");
        mrIncredible = new Incredibles ("mrIncredible", 600,50, 8, 8, 130, 150);

        elasticPic = Toolkit.getDefaultToolkit().getImage("elastic.png");
        elastigirl = new Incredibles("elastic", 800, 100, 1, 1, 200, 220);

        backgroundPic = Toolkit.getDefaultToolkit().getImage("ednaMansion.png");

        junkCrash2 = new SoundFile ("junkCrash2.wav");
        neighborhood = new SoundFile ("neighborhood.wav");
        neighborhood.play();


    } // end BasicGameApp constructor


//*******************************************************************************
//User Method Section
//
// put your code to do things here.

    // main thread
    public void run() {

        //for the moment we will loop things forever.
        while (true) {
            moveThings();  //move all the game objects
            crash();
            render();  // paint the graphics
            pause(20); // sleep for 10 ms
        }
    } // this code plays the game

    public void moveThings() {
        mrIncredible.bounce();
        jackJack.bounce();
       edna.wrap();
       elastigirl.wrap();
    } // these say what the characters are going to do once they reach the edge of the plane

    public void crash(){
        if(edna.rec.intersects(jackJack.rec) && edna.isCrashing== false){ // when they crash into each other
            System.out.println("CRASH");// if jackjack.isAlive is false, make it true // if it's true, make it false
            edna.isCrashing = true;
            if(jackJack.isAlive==true){
                System.out.println("CRASH");
                jackJack.isAlive=false;
                junkCrash2.play();
            } else{
                jackJack.isAlive = true;
            } // this causes jackJack's image to change when he and Edna collide and for a crash sound to play when jackjack turns angry
        }
        if(!edna.rec.intersects(jackJack.rec)){
            edna.isCrashing = false;
        } // reset astro.isCrashing to false when no longer intersecting

//
        if(mrIncredible.rec.intersects(edna.leftRec)) {
            mrIncredible.dx = -mrIncredible.dx;
        }
        if(mrIncredible.rec.intersects(edna.rightRec)) {
            mrIncredible.dx = -mrIncredible.dx;
        }

        if(mrIncredible.rec.intersects(edna.bottomRec)) {
            mrIncredible.dy = -mrIncredible.dy;
        }

        if(mrIncredible.rec.intersects(edna.topRec)) {
            mrIncredible.dy = -mrIncredible.dy;
        }
        // these if statements cause Mr. Incredible to bounce around Edna.





    }




    //Pauses or sleeps the computer for the amount specified in milliseconds
    public void pause(int time ) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
        }
    }

    //Graphics setup method
    private void setUpGraphics() {
        frame = new JFrame("Application Template");   //Create the program window or frame.  Names it.

        panel = (JPanel) frame.getContentPane();  //sets up a JPanel which is what goes in the frame
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));  //sizes the JPanel
        panel.setLayout(null);   //set the layout

        // creates a canvas which is a blank rectangular area of the screen onto which the application can draw
        // and trap input events (Mouse and Keyboard events)
        canvas = new Canvas();
        canvas.setBounds(0, 0, WIDTH, HEIGHT);
        canvas.setIgnoreRepaint(true);

        panel.add(canvas);  // adds the canvas to the panel.

        // frame operations
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //makes the frame close and exit nicely
        frame.pack();  //adjusts the frame and its contents so the sizes are at their default or larger
        frame.setResizable(false);   //makes it so the frame cannot be resized
        frame.setVisible(true);      //IMPORTANT!!!  if the frame is not set to visible it will not appear on the screen!

        // sets up things so the screen displays images nicely.
        canvas.createBufferStrategy(2);
        bufferStrategy = canvas.getBufferStrategy();
        canvas.requestFocus();
        System.out.println("DONE graphic setup");
    }

    //Paints things on the screen using bufferStrategy
    private void render() {
        Graphics2D g = (Graphics2D) bufferStrategy.getDrawGraphics();
        g.clearRect(0, 0, WIDTH, HEIGHT); // gets rid of old images in order to make a new one

        g.drawImage(backgroundPic, 0,0,WIDTH, HEIGHT, null);

        if(jackJack.isAlive==true){
            g.drawImage(jackjackPic, jackJack.xpos, jackJack.ypos, jackJack.width, jackJack.height, null);
        } else {
            g.drawImage(angryJackPic, jackJack.xpos, jackJack.ypos, angryJack.width/2, angryJack.height, null);
        }

        g.drawImage(ednaPic, edna.xpos, edna.ypos, edna.width, edna.height, null);
        g.drawRect(edna.rec.x, edna.rec.y, edna.rec.width, edna.rec.height);
        g.drawRect(edna.leftRec.x, edna.leftRec.y, edna.leftRec.width, edna.leftRec.height);
        g.drawRect(edna.rightRec.x, edna.rightRec.y, edna.rightRec.width, edna.rightRec.height);
        g.drawRect(edna.topRec.x, edna.topRec.y, edna.topRec.width, edna.topRec.height);
        g.drawRect(edna.bottomRec.x, edna.bottomRec.y, edna.bottomRec.width, edna.bottomRec.height);
        // the commented section above shows the different rectangles I created for Edna so that Mr. Incredible could bounce off all of her four sides

        g.drawImage(mrIncrediblePic, mrIncredible.xpos, mrIncredible.ypos, mrIncredible.width, mrIncredible.height,null);

        g.drawImage(elasticPic, elastigirl.xpos, elastigirl.ypos, elastigirl.width, elastigirl.height,null);


        g.dispose(); // done with image
        bufferStrategy.show(); // show everything that we've done
    }
}