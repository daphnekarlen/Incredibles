import java.awt.*;

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
    public boolean isAlive; //a boolean to denote if the hero is alive or dead

    public boolean isCrashing = false;
    public Rectangle rec;
    public Rectangle leftRec;
    public Rectangle rightRec;
    public Rectangle topRec;
    public Rectangle bottomRec;

    public Incredibles(String pName, int pXpos, int pYpos){
        name = pName;
        xpos = pXpos;
        //xpos= (int)(Math.random()*400+100);
        ypos = pYpos;
       // ypos = (int)(Math.random()*150+50);
        dx = -5;
        dy = 5;
        width = 100;
        height = 100;
        isAlive = true;
        rec = new Rectangle(xpos, ypos, width, height);


    }

    public void move() {
        xpos = xpos + dx;
        ypos = ypos + dy;
        rec=new Rectangle(xpos,ypos,width,height);
        leftRec = new Rectangle(xpos, ypos+10, 10, height-10);
        rightRec = new Rectangle(xpos+width-10, ypos+10, 10, height-10);
        topRec = new Rectangle(xpos+10, ypos, width-20, 10);
        bottomRec = new Rectangle(xpos+10,ypos+height, width-20, 10 );

    }

    public void bounce(){

        xpos = xpos + dx;
        ypos = ypos + dy;
        // if/when alien hits the right side, reverse dx direction
        if(xpos>=1000-width||xpos<=0){
            dx = -dx;
        }
        if(ypos>=700-width||ypos<=0){
            dy=-dy;
        }

        rec=new Rectangle(xpos,ypos,width,height);
        rec=new Rectangle(xpos,ypos,width,height);
        leftRec = new Rectangle(xpos, ypos+10, 10, height-10);
        rightRec = new Rectangle(xpos+width-10, ypos+10, 10, height-10);
        topRec = new Rectangle(xpos+10, ypos, width-20, 10);
        bottomRec = new Rectangle(xpos+10,ypos+height, width-20, 10 );
    }

    public void wrap() {
        xpos = xpos + dx;
        ypos = ypos + dy;
        if (xpos >= 1000 && dx>0) { // right wall
            xpos = 0-width;
        }
        if(xpos<=0-width && dx<0){ // left wall
            xpos=1000;
        }

        if(ypos<=0-height && dy<0) { // top wall
            ypos = 700;
        }

        if(ypos>=700 && dy>0){ // bottom wall
            ypos=-height;
        }
        rec=new Rectangle(xpos,ypos,width,height);
        rec=new Rectangle(xpos,ypos,width,height);
        leftRec = new Rectangle(xpos, ypos+10, 10, height-10);
        rightRec = new Rectangle(xpos+width-10, ypos+10, 10, height-10);
        topRec = new Rectangle(xpos+10, ypos, width-20, 10);
        bottomRec = new Rectangle(xpos+10,ypos+height, width-20, 10 );

    }

    public void sizeMinus(){
        width=width+dx;
        height=height+dy;
        rec=new Rectangle(xpos,ypos,width,height);
        rec=new Rectangle(xpos,ypos,width,height);
        leftRec = new Rectangle(xpos, ypos+10, 10, height-10);
        rightRec = new Rectangle(xpos+width-10, ypos+10, 10, height-10);
        topRec = new Rectangle(xpos+10, ypos, width-20, 10);
        bottomRec = new Rectangle(xpos+10,ypos+height, width-20, 10 );
    }


}
