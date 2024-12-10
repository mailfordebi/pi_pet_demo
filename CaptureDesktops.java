/**
https://www.teamdev.com/jxcapture
 */


public class CaptureDesktops {
    public static void main(String[] args) throws Exception {
        ImageCapture imageCapture = ImageCapture.create();

        int numberOfDisplays = Desktop.getNumberOfDisplays();
        for (int i = 0; i < numberOfDisplays; i++) {
            imageCapture.setImageSource(new Desktop(i));
            long before = System.currentTimeMillis();
            Dimension size = imageCapture.getImageSource().getSize();
            File f=new File("Desktop[" + i + "], size[Width=" + size.width + ",Height=" + size.height + "].png");
            imageCapture.
                    takeSnapshot()
                    .save(f, ImageFormat.PNG);

            
            long after = System.currentTimeMillis();
            System.out.println("File:"+f.getName());
            System.out.println("Operation took " + (after - before) + " milliseconds.");
        }

        imageCapture.release();
        
    }
}
