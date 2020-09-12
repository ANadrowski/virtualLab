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
import br.com.anadrowski.virtuallab.windows.FinalVelocity;
import br.com.anadrowski.virtuallab.windows.Force;
import br.com.anadrowski.virtuallab.windows.Mass;
import br.com.anadrowski.virtuallab.windows.Momentum;
import br.com.anadrowski.virtuallab.windows.Power;
import br.com.anadrowski.virtuallab.windows.Resistance;
import br.com.anadrowski.virtuallab.windows.Voltage;
import br.com.anadrowski.virtuallab.windows.Weight;
import br.com.anadrowski.virtuallab.windows.Work;
import com.github.weisj.darklaf.DarkLaf;
import com.github.weisj.darklaf.LafManager;
import com.github.weisj.darklaf.theme.DarculaTheme;
import com.github.weisj.darklaf.theme.IntelliJTheme;
import com.github.weisj.darklaf.theme.SolarizedDarkTheme;
import com.github.weisj.darklaf.theme.SolarizedLightTheme;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author Aislan Nadrowski (aislan.nadrowski@gmail.com)
 * @since 0.0.1
 */
public final class MainWindow extends JFrame {

    public MainWindow() {
        lookAndFeelLoader();
        menu();
        init();
    }

    public void init() {
        this.setVisible(true);
        this.setTitle("VirtualLab");
        this.setSize(new Dimension(800, 600));
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        menuItem.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeMenuItemActionPerformed(evt);
            }
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
        menuItem.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                averageSpeedMenuItemActionPerformed(evt);
            }
        });
        submenu.add(menuItem);

        menuItem = new JMenuItem("Instantaneous Speed");
        menuItem.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JOptionPane.showMessageDialog(null, "It does not work yet.");
            }
        });
        submenu.add(menuItem);
        fileMenu.add(submenu);

        menuItem = new JMenuItem("Average Acceleration");
        menuItem.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                averageAccelerationMenuItemActionPerformed(evt);
            }
        });
        submenu.add(menuItem);
        fileMenu.add(submenu);
        
        menuItem = new JMenuItem("Final Velocity");
        menuItem.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finalVelocityMenuItemActionPerformed(evt);
            }
        });
        submenu.add(menuItem);
        fileMenu.add(submenu);

        //Dynamics JMenuItems
        submenu = new JMenu("Dynamics");
        menuItem = new JMenuItem("Force");
        menuItem.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                forceMenuItemActionPerformed(evt);
            }
        });
        submenu.add(menuItem);
        menuItem = new JMenuItem("Mass");
        menuItem.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                massMenuItemActionPerformed(evt);
            }
        });
        submenu.add(menuItem);
        menuItem = new JMenuItem("Acceleration");
        menuItem.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accelerationMenuItemActionPerformed(evt);
            }
        });
        submenu.add(menuItem);
        fileMenu.add(submenu);
        menuItem = new JMenuItem("Work");
        menuItem.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                workMenuItemActionPerformed(evt);
            }
        });
        submenu.add(menuItem);
        fileMenu.add(submenu);
        menuItem = new JMenuItem("Momentum");
        menuItem.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                momentumMenuItemActionPerformed(evt);
            }
        });
        submenu.add(menuItem);
        fileMenu.add(submenu);
        menuItem = new JMenuItem("Weight");
        menuItem.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                weightMenuItemActionPerformed(evt);
            }
        });
        submenu.add(menuItem);
        fileMenu.add(submenu);
        menuItem = new JMenuItem("Power");
        menuItem.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                powerMenuItemActionPerformed(evt);
            }
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
        menuItem.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                electricCurrentMenuItemActionPerformed(evt);
            }
        });
        submenu.add(menuItem);
        menuItem = new JMenuItem("Resistance");
        menuItem.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resistanceMenuItemActionPerformed(evt);
            }
        });
        submenu.add(menuItem);
        menuItem = new JMenuItem("Voltage");
        menuItem.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltageMenuItemActionPerformed(evt);
            }
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
        menuItem.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(menuItem);

        this.setJMenuBar(jMenuBar);
    }

    private static void lookAndFeelLoader() {
        try {
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            LafManager.setTheme(new DarculaTheme());
            //LafManager.setTheme(new IntelliJTheme());
            //LafManager.setTheme(new SolarizedDarkTheme());
            //LafManager.setTheme(new SolarizedLightTheme());
            UIManager.setLookAndFeel(DarkLaf.class.getCanonicalName());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void closeMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
        int dialogResult = JOptionPane.showConfirmDialog(null, "Do you really want to close it?", "Close the software", JOptionPane.YES_OPTION);

        if (dialogResult == 0) {
            System.exit(0);
        }
    }

    private void aboutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
        AboutWindow about = new AboutWindow();
    }

    private void averageSpeedMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
        this.setContentPane(new AverageSpeed());
        this.revalidate();
    }
    
    private void averageAccelerationMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
        this.setContentPane(new AverageAcceleration());
        this.revalidate();
    }
    
    private void finalVelocityMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
        this.setContentPane(new FinalVelocity());
        this.revalidate();
    }
    
    private void forceMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
        this.setContentPane(new Force());
        this.revalidate();
    }
    
    private void massMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
        this.setContentPane(new Mass());
        this.revalidate();
    }
    
    private void accelerationMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
        this.setContentPane(new Acceleration());
        this.revalidate();
    }
    
    private void workMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
        this.setContentPane(new Work());
        this.revalidate();
    }
    
    private void momentumMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
        this.setContentPane(new Momentum());
        this.revalidate();
    }
    
    private void weightMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
        this.setContentPane(new Weight());
        this.revalidate();
    }
    
    private void powerMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
        this.setContentPane(new Power());
        this.revalidate();
    }
        
    private void electricCurrentMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
        this.setContentPane(new Current());
        this.revalidate();
    }
        
    private void resistanceMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
        this.setContentPane(new Resistance());
        this.revalidate();
    }
            
    private void voltageMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
        this.setContentPane(new Voltage());
        this.revalidate();
    }
}
