/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfazGrafica;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author titun
 */
public class JpanelImage extends JLabel {
    int x, y;
    String ruta;

    public JpanelImage(JPanel jPanel, String ruta) {
        this.ruta=ruta;
        this.x = jPanel.getWidth();
        this.y = jPanel.getHeight();
        this.setSize(x, y);
    }

    @Override
    public void paint(Graphics g) {
        ImageIcon Img = new ImageIcon(getClass().getResource(ruta));
        g.drawImage(Img.getImage(), 0, 0, x, y, null);
    }    

}

    

