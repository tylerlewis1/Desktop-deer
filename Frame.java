import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class Frame {

	public Frame(deer deer){
		JFrame f = new JFrame();
		f.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		f.setAlwaysOnTop(true);
		f.add(deer);
		f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
		f.setUndecorated(true);
		f.setBackground(new Color(0, 0, 0, 0));
		deer.setOpaque(false);
		f.setVisible(true);
	}

}
