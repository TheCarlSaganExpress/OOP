import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

/** Class to make an Icon - you could instead use a pre-made image */
class myIcon implements Icon{
    private int width;

    private Color myColor;
    public myIcon(int aWidth, Color c)
    {
        width = aWidth;
        myColor = c;
    }
    
    public int getIconWidth()
    {
        return width;
    }
    public int getIconHeight()
    {
        return width;
    }
    public void setIconWidth(int w){
        width=w;
    }
  
    public void paintIcon(Component c, Graphics g, int x, int y){
        Graphics2D g2 = (Graphics2D) g;
        Ellipse2D.Double myC = new Ellipse2D.Double(0,0, width, width);
        g2.setColor(myColor);
        g2.fill(myC);
    }
}
