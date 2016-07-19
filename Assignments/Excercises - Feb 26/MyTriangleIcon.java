import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

/**
   A triangle Icon
*/
public class MyTriangleIcon implements Icon {
    private int size;
    public MyTriangleIcon(int x){
	size=x;
    }
    public int getIconWidth() {
	return size;
    }

    public int getIconHeight() {
	return size;
    }

    public void paintIcon(Component c, Graphics g, int x, int y){
	Graphics2D g2 = (Graphics2D) g;
	int[] p={0,size/2,size};
	int[] q={size,0,size};
	Polygon tri = new Polygon(p,q, 3);
	g2.setColor(Color.YELLOW);
	g2.fill(tri);
//	g2.fill(rect);
    }
}

class TestTriangleIcon {
    public static void main(String[] args) {
	MyTriangleIcon icn=new MyTriangleIcon(Integer.parseInt(args[0]));
	JOptionPane.showMessageDialog(null,"Hello World!","Message", JOptionPane.INFORMATION_MESSAGE, icn);
    }
}
