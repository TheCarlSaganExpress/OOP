import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import java.util.*;

/**
   An Icon
*/
public class MySquareIcon implements Icon, Comparator<MySquareIcon>{
    private int size;

    public MySquareIcon(int size ) {
	this.size=size;
    }
    public int getIconWidth() {
	return size;
    }

    public int getIconHeight() {
	return size;
    }
    public int compare(MySquareIcon s1, MySquareIcon s2){
	return s1.size-s2.size;
    }

    public void paintIcon(Component c, Graphics g, int x, int y){
	Graphics2D g2 = (Graphics2D) g;
	Rectangle2D.Double rect = new Rectangle2D.Double(x, y, size, size);
	g2.setColor(Color.BLUE);
	g2.fill(rect);
    }
}

class TestSquareIcon {
    public static void main(String[] args) {
	MySquareIcon icn=new MySquareIcon(Integer.parseInt(args[0]));
	MySquareIcon icn2= new MySquareIcon(Integer.parseInt(args[1]));
	Icon smallIcon, bigIcon;
	int bigSize, smallSize;
	if(icn.compare(icn,icn2)>0){
	    smallIcon=icn2;
	    bigIcon=icn;
	    smallSize=Integer.parseInt(args[1]);
	    bigSize=Integer.parseInt(args[0]);
	}
	else {
	    smallIcon=icn;
	    bigIcon=icn2;
	    smallSize=Integer.parseInt(args[0]);
	    bigSize=Integer.parseInt(args[1]);
	}
	   
	    JOptionPane.showMessageDialog(null,"This is small icon with size "+smallSize,"Small Icon", JOptionPane.INFORMATION_MESSAGE, smallIcon);
	
	    JOptionPane.showMessageDialog(null,"This is the larger icon with size "+bigSize,"Large Icon", JOptionPane.INFORMATION_MESSAGE, bigIcon);
    }
}
