import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.text.DecimalFormat;
public class Test3 {
    private static final int FRAME_WIDTH = 600;
    private static final int FRAME_HEIGHT = 600;
    private static final int rateMin=1;
    private static final int yearMin=1;
    private static final int principalMin=10000;
    private static JLabel rateLabel;
    private static JLabel principalLabel;
    private static JLabel yearLabel;
    private static JLabel displayLabel;
    private static JSlider rateSlider;
    private static JSlider principalSlider;
    private static JSlider yearSlider;
    private static JButton resetButton;
    private static int rate;
    private static int years;
    private static int principal;
    private static Double amount;
    private static DecimalFormat df=new DecimalFormat("#.00");
    public static void main(String[] args){
	JFrame frame = new JFrame("Payment Calculator");
	frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
	//frame.setLayout(new BorderLayout(20,20));
	//frame.setLayout(new FlowLayout());
	frame.setLayout(new GridLayout(5,2));
	rateLabel=new JLabel("Interest Rate:");
	principalLabel=new JLabel("Principal Amount");
	yearLabel = new JLabel("# of Years");
	displayLabel =new JLabel("Payment Amount: ");
	rateSlider=new JSlider(rateMin,10);
	principalSlider = new JSlider(principalMin,100000);
	yearSlider = new JSlider (yearMin, 20);
	resetButton = new JButton("Reset");
	rateSlider.addChangeListener(createSliderMonitor());
	principalSlider.addChangeListener(createSliderMonitor());
	yearSlider.addChangeListener(createSliderMonitor());
	resetButton.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
		    rateSlider.setValue(rateMin);
		    yearSlider.setValue(yearMin);
		    principalSlider.setValue(principalMin);
		}
	    });
	frame.add(rateLabel);
	frame.add(rateSlider);
	frame.add(yearLabel);
	frame.add(yearSlider);
	frame.add(principalLabel);
	frame.add(principalSlider);
	frame.add(resetButton);
	frame.add(displayLabel);	
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.pack();
	rateSlider.setValue(rateMin);
	yearSlider.setValue(yearMin);
	principalSlider.setValue(principalMin);
	//displayLabel.setText("Payment Amount: "+rateSlider.getValue()
	frame.setVisible(true);
    }

    public static ChangeListener createSliderMonitor(){
	return new ChangeListener(){
	    public void stateChanged(ChangeEvent e){
		rate=rateSlider.getValue();
		rateLabel.setText("Interest Rate: "+rate+"%");
		principal=principalSlider.getValue();
	        principalLabel.setText("Principal Amount: "+principal);
		years=yearSlider.getValue();
		yearLabel.setText("# of Years: "+years);
		amount=principal* Math.pow( (1.0+rate/100.0),years);
		displayLabel.setText("Payment Amount: "+df.format(amount));
	    };
	};
    }  
}    

