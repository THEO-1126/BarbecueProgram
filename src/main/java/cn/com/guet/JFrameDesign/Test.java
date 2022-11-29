/*
 * Created by JFormDesigner on Mon Nov 28 17:38:19 CST 2022
 */

package cn.com.guet.JFrameDesign;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import info.clearthought.layout.*;

/**
 * @author 1
 */
public class Test extends JFrame {
    public Test() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        frame1 = new JFrame();
        menuBar1 = new JMenuBar();
        menu1 = new JMenu();
        menu2 = new JMenu();
        menu4 = new JMenu();
        menu3 = new JMenu();

        //======== frame1 ========
        {
            Container frame1ContentPane = frame1.getContentPane();
            frame1ContentPane.setLayout(new FlowLayout());

            //======== menuBar1 ========
            {

                //======== menu1 ========
                {
                    menu1.setText("\u9500\u552e\u7ba1\u7406");
                }
                menuBar1.add(menu1);

                //======== menu2 ========
                {
                    menu2.setText("\u5546\u54c1\u7ba1\u7406");
                }
                menuBar1.add(menu2);

                //======== menu4 ========
                {
                    menu4.setText("\u5e93\u5b58\u7ba1\u7406");
                }
                menuBar1.add(menu4);

                //======== menu3 ========
                {
                    menu3.setText("\u7528\u6237\u7ba1\u7406");
                }
                menuBar1.add(menu3);
            }
            frame1.setJMenuBar(menuBar1);
            frame1.pack();
            frame1.setLocationRelativeTo(frame1.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JFrame frame1;
    private JMenuBar menuBar1;
    private JMenu menu1;
    private JMenu menu2;
    private JMenu menu4;
    private JMenu menu3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
