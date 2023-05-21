package Frame;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.SwingUtilities;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */



/**
 *
 * @author kiano
 */
public class Frame {
    public static void main(String[] args) {
        new LoginFrame();
        new MainFrame();
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                BuildInfoFrame buildInfoFrame = new BuildInfoFrame("건물 이름", "건물 설명");
                Image buildingImage = loadImage("Frame/src/image/campus-img00.jpg");
                buildInfoFrame.setBuildingImage(buildingImage);
            }
        });
    }

    private static Image loadImage(String imagePath) {
        try {
            return ImageIO.read(new File(imagePath));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}

