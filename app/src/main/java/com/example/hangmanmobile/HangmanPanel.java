//import java.awt.Dimension;
//import java.awt.Graphics;
//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.io.IOException;
//
//import javax.imageio.ImageIO;
//import javax.swing.JOptionPane;
//import javax.swing.JPanel;
//
//@SuppressWarnings("serial")
//public class HangmanPanel extends JPanel {
//
//	private BufferedImage image;
//	private int imageNumber;
//
//	public HangmanPanel() {
//		imageNumber = 0;
//		try {
//			updateHangman();
//		}
//		catch(LostTheGameException ex)
//		{
//			 JOptionPane.showMessageDialog(null, ex.getMessage(), "InfoBox: " + "End of Game", JOptionPane.INFORMATION_MESSAGE);
//		}
//		setPreferredSize(new Dimension(400, 300));
//	}
//
//	public void updateHangman() throws LostTheGameException
//	{
//		try {
//			image = ImageIO.read(new File("Level" + imageNumber + ".png"));
//		}
//		catch(IOException ex)
//		{
//			System.err.println("Couln't find requested image ");
//			System.exit(1);
//		}
//		imageNumber++;
//		repaint();
//		if(imageNumber > 9)
//		{
//			throw new LostTheGameException("You Lost!");
//		}
//	}
//
//	@Override
//	protected void paintComponent(Graphics g) {
//		super.paintComponent(g);
//		g.drawImage(image, 0, 0, this);
//	}
//
//}
