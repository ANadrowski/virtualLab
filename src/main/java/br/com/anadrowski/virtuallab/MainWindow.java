/*
BSD 3-Clause License

Copyright (c) 2020, Aislan Nadrowski
All rights reserved.

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions are met:

1. Redistributions of source code must retain the above copyright notice, this
   list of conditions and the following disclaimer.

2. Redistributions in binary form must reproduce the above copyright notice,
   this list of conditions and the following disclaimer in the documentation
   and/or other materials provided with the distribution.

3. Neither the name of the copyright holder nor the names of its
   contributors may be used to endorse or promote products derived from
   this software without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package br.com.anadrowski.virtuallab;

import br.com.anadrowski.virtuallab.windows.AboutWindow;
import br.com.anadrowski.virtuallab.windows.Acceleration;
import br.com.anadrowski.virtuallab.windows.AverageAcceleration;
import br.com.anadrowski.virtuallab.windows.AverageSpeed;
import br.com.anadrowski.virtuallab.windows.Current;
import br.com.anadrowski.virtuallab.windows.ElectricPower;
import br.com.anadrowski.virtuallab.windows.FinalVelocity;
import br.com.anadrowski.virtuallab.windows.Force;
import br.com.anadrowski.virtuallab.windows.Mass;
import br.com.anadrowski.virtuallab.windows.Momentum;
import br.com.anadrowski.virtuallab.windows.Power;
import br.com.anadrowski.virtuallab.windows.Resistance;
import br.com.anadrowski.virtuallab.windows.Voltage;
import br.com.anadrowski.virtuallab.windows.Weight;
import br.com.anadrowski.virtuallab.windows.Work;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import java.awt.event.ActionEvent;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Aislan Nadrowski (aislan.nadrowski@gmail.com)
 * @since 0.0.1
 */
public final class MainWindow implements Runnable {
    
    private JFrame jFrame;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new MainWindow());
    }
    
    @Override
    public void run() {
        lookAndFeelLoader();
        init();
    }
 
    public void init() {
        this.jFrame = new JFrame();
        this.jFrame.setTitle("VirtualLab");
        this.jFrame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        this.jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        menu();
        this.jFrame.setVisible(true);
    }

    public void menu() {
        JMenuBar jMenuBar = new JMenuBar();
        JMenu fileMenu;
        JMenu submenu;
        JMenuItem menuItem;

        fileMenu = new JMenu("File");
        jMenuBar.add(fileMenu);

        //close JMenuItems
        menuItem = new JMenuItem("Close");
        menuItem.addActionListener((java.awt.event.ActionEvent evt) -> {
            closeMenuItemActionPerformed(evt);
        });

        fileMenu.add(menuItem);

        //Converters menu.
        fileMenu = new JMenu("Converters");
        jMenuBar.add(fileMenu);

        //Mechanics menu.
        fileMenu = new JMenu("Mechanics");
        jMenuBar.add(fileMenu);

        //Kinematics JMenuItems
        submenu = new JMenu("Kinematics");

        menuItem = new JMenuItem("Average Speed");
        menuItem.addActionListener((evt) -> {
            averageSpeedMenuItemActionPerformed(evt);
        });
        submenu.add(menuItem);

        menuItem = new JMenuItem("Instantaneous Speed");
        menuItem.addActionListener((evt) -> {
            JOptionPane.showMessageDialog(null, "It does not work yet.");
        });
        submenu.add(menuItem);
        fileMenu.add(submenu);

        menuItem = new JMenuItem("Average Acceleration");
        menuItem.addActionListener((evt) -> {
            averageAccelerationMenuItemActionPerformed(evt);
        });
        submenu.add(menuItem);
        fileMenu.add(submenu);
        
        menuItem = new JMenuItem("Final Velocity");
        menuItem.addActionListener((evt) -> {
            finalVelocityMenuItemActionPerformed(evt);
        });
        submenu.add(menuItem);
        fileMenu.add(submenu);

        //Dynamics JMenuItems
        submenu = new JMenu("Dynamics");
        menuItem = new JMenuItem("Force");
        menuItem.addActionListener((evt) -> {
            forceMenuItemActionPerformed(evt);
        });
        submenu.add(menuItem);
        menuItem = new JMenuItem("Mass");
        menuItem.addActionListener((evt) -> {
            massMenuItemActionPerformed(evt);
        });
        submenu.add(menuItem);
        menuItem = new JMenuItem("Acceleration");
        menuItem.addActionListener((evt) -> {
            accelerationMenuItemActionPerformed(evt);
        });
        submenu.add(menuItem);
        fileMenu.add(submenu);
        menuItem = new JMenuItem("Work");
        menuItem.addActionListener((evt) -> {
            workMenuItemActionPerformed(evt);
        });
        submenu.add(menuItem);
        fileMenu.add(submenu);
        menuItem = new JMenuItem("Momentum");
        menuItem.addActionListener((evt) -> {
            momentumMenuItemActionPerformed(evt);
        });
        submenu.add(menuItem);
        fileMenu.add(submenu);
        menuItem = new JMenuItem("Weight");
        menuItem.addActionListener((evt) -> {
            weightMenuItemActionPerformed(evt);
        });
        submenu.add(menuItem);
        fileMenu.add(submenu);
        menuItem = new JMenuItem("Power");
        menuItem.addActionListener((evt) -> {
            powerMenuItemActionPerformed(evt);
        });
        submenu.add(menuItem);
        fileMenu.add(submenu);
        
        //Wave menu.
        fileMenu = new JMenu("Wave");
        jMenuBar.add(fileMenu);

        //Thermology menu.
        fileMenu = new JMenu("Thermology");
        jMenuBar.add(fileMenu);

        //Electrical menu.
        fileMenu = new JMenu("Electrical");
        jMenuBar.add(fileMenu);

        //Electrostatic JMenuItems
        submenu = new JMenu("Electrostatic");
        menuItem = new JMenuItem("--");
        submenu.add(menuItem);
        fileMenu.add(submenu);

        //Electrodynamics JMenuItems
        submenu = new JMenu("Electrodynamics");
        menuItem = new JMenuItem("Current");
        menuItem.addActionListener((evt) -> {
            electricCurrentMenuItemActionPerformed(evt);
        });
        submenu.add(menuItem);
        menuItem = new JMenuItem("Resistance");
        menuItem.addActionListener((evt) -> {
            resistanceMenuItemActionPerformed(evt);
        });
        submenu.add(menuItem);
        menuItem = new JMenuItem("Voltage");
        menuItem.addActionListener((evt) -> {
            voltageMenuItemActionPerformed(evt);
        });
        submenu.add(menuItem);
        menuItem = new JMenuItem("Electric Power");
        menuItem.addActionListener((evt) -> {
            electricPowerMenuItemActionPerformed(evt);
        });
        submenu.add(menuItem);
        fileMenu.add(submenu);

        //Electromagnetism JMenuItems
        submenu = new JMenu("Electromagnetism");
        menuItem = new JMenuItem("--");
        submenu.add(menuItem);
        fileMenu.add(submenu);
        
        //Simulations menu.
        fileMenu = new JMenu("Simulations");
        jMenuBar.add(fileMenu);

        //Help menu.
        fileMenu = new JMenu("Help");
        jMenuBar.add(fileMenu);

        menuItem = new JMenuItem("About");
        menuItem.addActionListener((evt) -> {
            aboutMenuItemActionPerformed(evt);
        });
        fileMenu.add(menuItem);

        this.jFrame.setJMenuBar(jMenuBar);
    }

    private static void lookAndFeelLoader() {
        try {
        UIManager.setLookAndFeel(new FlatLightLaf());
        UIManager.getLookAndFeelDefaults().put("defaultFont", new Font("Segoe UI", Font.PLAIN, 12));
        } catch (UnsupportedLookAndFeelException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void closeMenuItemActionPerformed(ActionEvent evt) {
        int dialogResult = JOptionPane.showConfirmDialog(null, "Do you really want to close it?", "Close the software", JOptionPane.YES_OPTION);

        if (dialogResult == 0) {
            System.exit(0);
        }
    }

    private void aboutMenuItemActionPerformed(ActionEvent evt) {
        AboutWindow about = new AboutWindow();
    }

    private void averageSpeedMenuItemActionPerformed(ActionEvent evt) {
        this.jFrame.setContentPane(new AverageSpeed());
        this.jFrame.revalidate();
    }
    
    private void averageAccelerationMenuItemActionPerformed(ActionEvent evt) {
        this.jFrame.setContentPane(new AverageAcceleration());
        this.jFrame.revalidate();
    }
    
    private void finalVelocityMenuItemActionPerformed(ActionEvent evt) {
        this.jFrame.setContentPane(new FinalVelocity());
        this.jFrame.revalidate();
    }
    
    private void forceMenuItemActionPerformed(ActionEvent evt) {
        this.jFrame.setContentPane(new Force());
        this.jFrame.revalidate();
    }
    
    private void massMenuItemActionPerformed(ActionEvent evt) {
        this.jFrame.setContentPane(new Mass());
        this.jFrame.revalidate();
    }
    
    private void accelerationMenuItemActionPerformed(ActionEvent evt) {
        this.jFrame.setContentPane(new Acceleration());
        this.jFrame.revalidate();
    }
    
    private void workMenuItemActionPerformed(ActionEvent evt) {
        this.jFrame.setContentPane(new Work());
        this.jFrame.revalidate();
    }
    
    private void momentumMenuItemActionPerformed(ActionEvent evt) {
        this.jFrame.setContentPane(new Momentum());
        this.jFrame.revalidate();
    }
    
    private void weightMenuItemActionPerformed(ActionEvent evt) {
        this.jFrame.setContentPane(new Weight());
        this.jFrame.revalidate();
    }
    
    private void powerMenuItemActionPerformed(ActionEvent evt) {
        this.jFrame.setContentPane(new Power());
        this.jFrame.revalidate();
    }
        
    private void electricCurrentMenuItemActionPerformed(ActionEvent evt) {
        this.jFrame.setContentPane(new Current());
        this.jFrame.revalidate();
    }
        
    private void resistanceMenuItemActionPerformed(ActionEvent evt) {
        this.jFrame.setContentPane(new Resistance());
        this.jFrame.revalidate();
    }
            
    private void voltageMenuItemActionPerformed(ActionEvent evt) {
        this.jFrame.setContentPane(new Voltage());
        this.jFrame.revalidate();
    }
    
    private void electricPowerMenuItemActionPerformed(ActionEvent evt) {
        this.jFrame.setContentPane(new ElectricPower());
        this.jFrame.revalidate();
    }
}
