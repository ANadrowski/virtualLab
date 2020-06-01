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
package br.com.anadrowski.virtuallab.menus;

import br.com.anadrowski.virtuallab.windows.AboutWindow;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 * Top menu.
 *
 * @author Aislan Nadrowski(aislan.nadrowski@gmail.com)
 * @since 0.0.1
 */
public class TopMenu extends JMenuBar {

    JMenu fileMenu;
    JMenu submenu;
    JMenuItem menuItem;

    public TopMenu() {
        init();
    }

    public void init() {
        fileMenu = new JMenu("File");
        add(fileMenu);

        //close JMenuItems
        menuItem = new JMenuItem("Close");
        menuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeMenuItemActionPerformed(evt);
            }
        });

        fileMenu.add(menuItem);

        //Submenu
//        submenu = new JMenu("Submenu");
//
//        menuItem = new JMenuItem("An item in the submenu");
//        submenu.add(menuItem);
//
//        menuItem = new JMenuItem("Another item");
//        submenu.add(menuItem);
//        fileMenu.add(submenu);

        //Converters menu.
        fileMenu = new JMenu("Converters");
        this.add(fileMenu);

        //Mechanics menu.
        fileMenu = new JMenu("Mechanics");
        this.add(fileMenu);

        //Wave menu.
        fileMenu = new JMenu("Wave");
        this.add(fileMenu);

        //Thermology menu.
        fileMenu = new JMenu("Thermology");
        this.add(fileMenu);

        //Electrical menu.
        fileMenu = new JMenu("Electrical");
        this.add(fileMenu);

        //Help menu.
        fileMenu = new JMenu("Help");
        this.add(fileMenu);

        menuItem = new JMenuItem("About");
        menuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(menuItem);
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

}
