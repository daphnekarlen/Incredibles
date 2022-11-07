public class Incredibles {

    //VARIABLE DECLARATION SECTION
    //Here's where you state which variables you are going to use.
    public String name;               //name of the hero
    public int xpos;                  //the x position
    public int ypos;                  //the y position
    public int dx;                    //the speed of the hero in the x direction
    public int dy;                    //the speed of the hero in the y direction
    public int width;                 //the width of the hero image
    public int height;                //the height of the hero image
    public boolean isAlive;           //a boolean to denote if the hero is alive or dead

    public Incredibles(String pName, int pXpos, int pYpos){
        name = pName;
        xpos = pXpos;
        ypos = pYpos;
        dx = 1;
        dy = 1;
        width = 50;
        height = 50;
        isAlive = true;
    }

    public void move() {
        xpos = xpos + dx;
        ypos = ypos + dy;
    }

    public void bounce(){
        xpos = xpos + dx;
        ypos = ypos + dy;
        // if/when alien hits the right side, reverse dx direction
        if(xpos==1000-width){
            dx = -dx;
        }
        if(ypos==700-width){
            dy=-dy;
        }
    }

    public void wrap(){
        xpos = xpos + dx;
        ypos = ypos + dy;

        if(ypos==800){
            ypos=0;
        }
    }










}
