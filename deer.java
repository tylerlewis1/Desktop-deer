import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.swing.JPanel;

public class deer extends JPanel implements MouseListener, KeyListener{
	private static final long serialVersionUID = 1L;
  private BufferedImage deer;
	private int FPS = 25;
	long startTime;
	long URDTimeMillis;
	long waitTime;
	int framecount = 0;
	int maxframecount = 25;
	int totaltime = 0;
	long targetTime = 1000 / FPS;
	Random ran = new Random();
	int my = 0, mx = 0, x = 0, y = 0, velx = 0, vely = 0;
	InputStream input;
	BufferedReader reader;
	public static void main(String args []) {		
		new deer();
	}
	
	public deer() {
		new Frame(this);
		this.requestFocusInWindow();
		this.addKeyListener(this);
		this.addMouseListener(this);
		try {
			deer = ImageIO.read(getClass().getResourceAsStream("src/deer.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		repaint();
		startTime = System.nanoTime();
		
		x += velx;
		y += vely;
		velx = (mx - x) /10;
		vely = (my - y) /10;
		
    if(MouseInfo.getPointerInfo().getLocation().x > x) {
			g.drawImage(deer, x + 100, y, -100, 100, null);	
		}else{
			g.drawImage(deer, x, y, 100, 100, null);	
		}
		
    //Limits FPS to reduce performance impact
		URDTimeMillis = (System.nanoTime() - startTime) / 1000000;
		waitTime = targetTime - URDTimeMillis;
		try {
			Thread.sleep(waitTime);
		}catch(Exception e){
			
		}
		totaltime += System.nanoTime() - startTime;
		framecount++;
		if(framecount == maxframecount) {
			framecount = 0;
			totaltime = 0;
		}
	}
	
	public void mouseClicked(MouseEvent e) {
		int sound = ran.nextInt(4) + 1;
		switch (sound) {
		case(1):
			sound1();	
			break;
		case(2):
			sound2();	
			break;
		case(3):
			sound3();
			break;
		case(4):
			sound4();
			break;
		}
}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}

	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_HOME) {
			 my = (MouseInfo.getPointerInfo().getLocation().y - 50);
		     mx = (MouseInfo.getPointerInfo().getLocation().x - 50);    
		}
	}
  public void keyReleased(KeyEvent e) {}

	
	public void keyTyped(KeyEvent e) {}
	//sounds 
	public void sound1() {
		try {
		    File file = new File("path to sound");
		    AudioInputStream stream;
		    AudioFormat format;
		    DataLine.Info info;
		    Clip clip;
		    stream = AudioSystem.getAudioInputStream(file);
		    format = stream.getFormat();
		    info = new DataLine.Info(Clip.class, format);
		    clip = (Clip) AudioSystem.getLine(info);
		    clip.open(stream);
		    clip.start();
		}
		catch (Exception e) {
			System.out.print(e);
		}
		
	}
	
	public void sound2() {
		try {
		    File file = new File("path to sound");
		    AudioInputStream stream;
		    AudioFormat format;
		    DataLine.Info info;
		    Clip clip;
		    stream = AudioSystem.getAudioInputStream(file);
		    format = stream.getFormat();
		    info = new DataLine.Info(Clip.class, format);
		    clip = (Clip) AudioSystem.getLine(info);
		    clip.open(stream);
		    clip.start();
		}
		catch (Exception e) {
			System.out.print(e);
		}
		
	}
	
	
	public void sound3() {
		try {
		    File file = new File("path to sound");
		    AudioInputStream stream;
		    AudioFormat format;
		    DataLine.Info info;
		    Clip clip;
		    stream = AudioSystem.getAudioInputStream(file);
		    format = stream.getFormat();
		    info = new DataLine.Info(Clip.class, format);
		    clip = (Clip) AudioSystem.getLine(info);
		    clip.open(stream);
		    clip.start();
		}
		catch (Exception e) {
			System.out.print(e);
		}
		
	}
	public void sound4() {
		try {
		    File file = new File("path to sound");
		    AudioInputStream stream;
		    AudioFormat format;
		    DataLine.Info info;
		    Clip clip;
		    stream = AudioSystem.getAudioInputStream(file);
		    format = stream.getFormat();
		    info = new DataLine.Info(Clip.class, format);
		    clip = (Clip) AudioSystem.getLine(info);
		    clip.open(stream);
		    clip.start();
		}
		catch (Exception e) {
			System.out.print(e);
		}	
	}	
}
