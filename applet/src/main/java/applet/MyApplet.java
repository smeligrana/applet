package applet;

import java.io.File;

import javax.swing.JApplet;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class MyApplet extends JApplet {
    public void init () {
               // Create this JApplet's GUI on the event-dispatching thread:
               try {
                  SwingUtilities.invokeAndWait( this::createGUI );
               } catch ( Exception e ) {
                  System.err.println("createGUI didn't successfully complete");
               }
            }

    private void createGUI() {
        JLabel label = new JLabel();
        add(label);

        // The following code causes a security exception in an applet,
        // even if signed, if it runs in the "sandbox". However, the
        // user can grant a signed applet extra (all) permissions; in fact,
        // that is the default for signed applets since Java 7U10.

        try {
            File file = new File(".");
            label.setText("The current directory is " + file.getAbsolutePath());
            
            File fileWrite = new File("C:\\FINA\\pippo.txt");
            
            if (fileWrite.createNewFile()){
                System.out.println("File is created!");
              }else{
                System.out.println("File already exists.");
              }
        } catch (Exception e) {
            e.printStackTrace();
            label.setText("Security exception while attempting access to current directory");
        }
    }
}
