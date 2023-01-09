import java.awt.*;

public class Incredibles {

    //VARIABLE DECLARATION SECTION
    public String name;               //name of the hero
    public int xpos;                  //the x position
    public int ypos;                  //the y position
    public int dx;                    //the speed of the hero in the x direction
    public int dy;                    //the speed of the hero in the y direction
    public int width;                 //the width of the hero image
    public int height;                //the height of the hero image
    public boolean isAlive; //a boolean to denote if the hero is alive or dead

    public boolean up;
    public boolean down;
    public boolean right;
    public boolean left;

    public boolean isCrashing = false;
    public Rectangle rec;
   // these are the rectangles that all the characters use
    public Rectangle leftRec;
    public Rectangle rightRec;
    public Rectangle topRec;
    public Rectangle bottomRec;
    // these are all of Edna's rectangles

    public Incredibles(String pName, int pXpos, int pYpos, int pDx, int pDy, int pW, int pH){
        name = pName;
        xpos = pXpos;
        //xpos= (int)(Math.random()*400+100);
        ypos = pYpos;
       // ypos = (int)(Math.random()*150+50);
        dx = pDx;
        dy = pDy;
        width = pW;
        height = pH;
        isAlive = true;
        rec = new Rectangle(xpos, ypos, width, height);

    }


    public void bounce(){

        xpos = xpos + dx;
        ypos = ypos + dy;
        // if/when incredible hits the right side, reverse dx direction
        if(xpos>=1000-width||xpos<=0){
            dx = -dx;
        }
        if(ypos>=700-width||ypos<=0){
            dy=-dy;
        } // if/when incredible hits side, reverse dy direction



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
        } // these statements show how the Incredible will wrap the screen once it goes enough out of the screen
        rec=new Rectangle(xpos,ypos,width,height);
        rec=new Rectangle(xpos,ypos,width,height);
        leftRec = new Rectangle(xpos, ypos+10, 10, height-10);
        rightRec = new Rectangle(xpos+width-10, ypos+10, 10, height-10);
        topRec = new Rectangle(xpos+10, ypos, width-20, 10);
        bottomRec = new Rectangle(xpos+10,ypos+height, width-20, 10 );

    }

    public void moveWithKeys() {
        if(right){
            xpos = xpos +dx;
            if(xpos>1000-width){
                xpos = 1000-width;
            }
        }

        if(down){
            ypos = ypos +dy;
            if(ypos>700-height){
                ypos = 700-height;
            }
        }

        if(left){
            xpos=xpos-dy;
            if(xpos<0){
                xpos=0;
            }
        }

        if(up){
            ypos=ypos-dy;
            if(ypos<0){
                ypos=0;
            }
        }
    }

}
