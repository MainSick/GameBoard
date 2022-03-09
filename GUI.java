/**
 * 
 */

/**
 * @author Reto Pircher
 *
 */

import java.awt.*;
import javax.swing.*;

public class GUI {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JFrame mainFrame = new JFrame("Test Window");
		mainFrame.setVisible(true);
		makeFrameFullSize(mainFrame);

	}
	
	private static void makeFrameFullSize(JFrame aFrame) {
	    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    aFrame.setSize(screenSize.width, screenSize.height);
	}
	
	
		GraphicsDevice vc;
		
	//Initialize the vc with the Screen Device
	public void FullScreen(){
		GraphicsEnvironment ge=GraphicsEnvironment.getLocalGraphicsEnvironment();
		vc=ge.getDefaultScreenDevice();
	}	

	//Set the Frame to Full Screen
	public void setFullScreen(DisplayMode dm, JFrame win){ //Displaymode is???

		//Remove the Title Bar, Maximization , Minimization Button...
		win.setUndecorated(true);

		// Can not be resized
		win.setResizable(false);

		//Make the win(JFrame) Full Screen
		vc.setFullScreenWindow(win);

		 //check low-level display changes are supported for this graphics device.
		if(dm!=null && vc.isDisplayChangeSupported()){
		        try{
		                vc.setDisplayMode(dm);
		        }
		        catch(Exception ex){
		            JOptionPane.showMessageDialog(null,ex.getMessage());
		        }
		}
	}
	
	//To Exit From Full Screen
	public void CloseFullScreen(){
		Window w=vc.getFullScreenWindow();
		if(w!=null){
			w.dispose();
		}
		vc.setFullScreenWindow(null);
	}	
} 