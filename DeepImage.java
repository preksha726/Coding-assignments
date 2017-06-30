/*
class for reading images into memory and accessing pixel values

a pixel is made up of four components: alpha, red, green, and blue
each component takes 8 bits of storage
therefore, a pixel takes 32 bits of storage

the first bit is at the rightmost side and is numbered 0
the last bit is at the leftmost side and is numbered 31
alpha take the leftmost 8 bits (numbered 24 - 31), followed by 
red (numbered 16 - 23), green (numbered 8 - 15), and blue (numbered 0 - 7)

origin is top left
x coordinate denote columns
y coordinate denote rows
pixels are specified by using (column, row) pair

*/

import java.io.File;
import java.io.IOException;
import java.util.TreeMap;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

import java.util.Map;
import java.util.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

public class DeepImage {
	public static int imageSize;
	public static double aM=0, rM=0, bM=0, gM=0;
	public static double aVar=0, rVar=0, bVar=0, gVar=0;
	public static int intensityMean = 0;

	public static void ImageDisplay(BufferedImage image) throws Exception 
    {
        SwingUtilities.invokeLater(new Runnable() 
        {
            public void run() 
            {
                JFrame editorFrame = new JFrame("Image Display");
                editorFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                ImageIcon imageIcon = new ImageIcon(image);
                JLabel jLabel = new JLabel();
                jLabel.setIcon(imageIcon);
                editorFrame.getContentPane().add(jLabel, BorderLayout.CENTER);
                editorFrame.pack();
                editorFrame.setLocationRelativeTo(null);
                editorFrame.setVisible(true);
            }
        });
    }

    public static void main(String args[]) {
    	

		// did the user provide correct number of command line arguments?
        // if not, print message and exit
        if (args.length != 1){
            System.err.println("Number of command line arguments must be 1");
            System.err.println("You have given " + args.length + " command line arguments");
            System.err.println("Incorrect usage. Program terminated");
            System.err.println("Correct usage: java ImageStatistics <image-input-file-name.jpg>");
            System.exit(1);
        }

        String imageFile = args[0];
        System.out.println("Input file name is: " + imageFile);

       
        TreeMap<Integer, Integer> pixelData = new TreeMap<Integer, Integer>( );
        //System.out.println("\n Test Here!!!\n");
        storePixel(pixelData, imageFile);
        TreeMap<Integer, Double> probData = new TreeMap<Integer, Double>( );
        computeProbability(pixelData, probData, imageSize);
        computeMean(probData);
        computeVariance(probData, 2);
        for (int i = 1; i < 4; i++) {
			System.out.println("enter moments between 0-2");
        	Scanner keyboard = new Scanner(System.in);
        	int n = keyboard.nextInt();
        	System.out.println("For moment "+n);
			nthMoment(probData, n);

		}
    }
	
	public static int getCount(Integer pixel, TreeMap<Integer, Integer> pixelData){
    	
    	if (pixelData.containsKey(pixel)){
    		// The pixel has occurred before, so get its count from the map
       		return pixelData.get(pixel); // Auto-unboxed
      	}
      	else{
      		// No occurrences of this pixel
         	return 0;
      	}
   }

	public static void storePixel(TreeMap<Integer, Integer> pixelData, String imageFile){
    	
    	Integer pixel;     // A pixel read from the file
      	Integer count;   // The number of occurrences of the pixel
      	BufferedImage image = null;
		File file = null;
	
		// read image file specified by args[0]
		try {
			file = new File(imageFile);
			image = ImageIO.read(file);
		} 
		catch (IOException e) {
			System.out.println(e);
		}	

		// get image width and height
		int width = image.getWidth();
		int height = image.getHeight();
		imageSize=width*height;
		System.out.println("Image dimensions are:");
		System.out.println("Width:	"+ width);
		System.out.println("Height:	"+ height);
		System.out.println("Image Size:	"+imageSize+"\n");
		

		for(int i=0; i<height; i++){         
        	for(int j=0; j<width; j++){

				// get pixel value at col and row using the getRGB()
				pixel = image.getRGB(j, i);
				// Get the current count of this pixel, add one, and then store the new count:
          		count = getCount(pixel, pixelData) + 1;
          		pixelData.put(pixel, count);
			}
		}
	}  

	public static void computeProbability(TreeMap<Integer, Integer> pixelData, TreeMap<Integer, Double> probData, int n ){
		
		double probability = 0;
		double totalProbability = 0;
 	    
 	    for(Integer pixel : pixelData.keySet( )){
        	Integer count = pixelData.get(pixel);
            probability = (double)count/imageSize;
     	    probData.put(pixel,probability);
        	totalProbability += probability;
        }
      	
      	System.out.println("Total Probability is "+totalProbability+"\n");
	} 

	public static void computeMean(TreeMap<Integer, Double> probData){
		double probability;
		
		for(Integer pixel : probData.keySet()){
      		probability = probData.get(pixel);
      		int alpha = extractAlpha(pixel);
          	aM += alpha*probability;
          	int red = extractRed(pixel);
          	rM += red*probability;
          	int blue = extractBlue(pixel);
          	bM += blue*probability;
          	int green = extractGreen(pixel);
          	gM += green*probability;
      	}
      	System.out.println("Mean:	");
    	System.out.println("Alpha Mean:	"+(int)aM);
   		System.out.println("Red Mean:	"+(int)rM);
    	System.out.println("Blue Mean:	"+(int)bM);
    	System.out.println("Green Mean:	"+(int)gM+"\n");
    

		

	}
	
	public static void computeVariance(TreeMap<Integer, Double> probData, int n){
		double probability;
		aVar=0;
		rVar=0;
		gVar=0;
		bVar=0;
		for(Integer pixel : probData.keySet()){
			probability = probData.get(pixel);
			int alpha = extractAlpha(pixel);
			aVar += (Math.pow(alpha - aM, n) *probability);			
			int red = extractRed(pixel);
			rVar += (Math.pow(red - rM, n) * probability);			
			int green =extractGreen(pixel);
			gVar += (Math.pow(green - gM, n) * probability);			
			int blue = extractBlue(pixel);
			bVar += (Math.pow(blue - bM, n) * probability);
        }

       
        	System.out.println("Variance:	");
    		System.out.println("Alpha Variance:	"+(int)aVar);
    		System.out.println("Red Variance:	"+(int)rVar);
    		System.out.println("Blue Variance:	"+(int)bVar);
    		System.out.println("Green Variance:	"+(int)gVar+"\n");
    	
	}

	public static void nthMoment(TreeMap<Integer, Double> probData, int n){
		
		
		computeVariance(probData,n);

	}

	public static  int extractAlpha( int pixel){
		// extract alpha
		// right shift the 32 bits of the pixel by 24 positions
		// and then do bitwise ADD with 0xFF
		int a = (pixel >> 24) & 0xff;
		return a;
	}
	public static int extractRed( int pixel){
		// extract red
		// right shift the 32 bits of the pixel by 16 positions
		// and then do bitwise ADD with 0xFF
		int r = (pixel >> 16) & 0xff;
		return r;
	}
	
	public static int extractGreen( int pixel){
		// extract green
		// right shift the 32 bits of the pixel by 8 positions
		// and then do bitwise ADD with 0xFF
		int g = (pixel >> 8) & 0xff;
		return g;
	}
	public static int extractBlue( int pixel){
		// extract blue
		// blue bits already occupy the rightmost 8 bits
		// no need to perform shift, only bitwise ADD is required
		int b = pixel & 0xff;
		return b;
	}
	

}   
