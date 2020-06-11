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
package br.com.anadrowski.virtuallab.windows;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Average Speed JPanel.
 *
 * @author Aislan Nadrowski (aislan.nadrowski@gmail.com)
 * @since 0.0.1
 */
public final class AverageSpeed extends JPanel {
    
    private JLabel distanceJLabel;
    private JLabel timeJLabel;
    private JLabel resultJLabel;
    private JTextField distanceJTextField;
    private JTextField timeJTextField;
    private JButton calculateJButton;
    private FormLayout formLayout;
    private CellConstraints cc;
    
    public AverageSpeed() {
        configWindowDimensions();
        initComponents();
        addsComponents();
    }
    
    public void configWindowDimensions() {
        this.setPreferredSize(new Dimension(300, 300));
        this.setBackground(Color.WHITE);
    }
    
    public void initComponents() {
        this.cc = new CellConstraints();
        this.formLayout = new FormLayout("right:40dlu, 5dlu, pref:grow, 5dlu, pref:grow",
                "pref, 5dlu, pref, 5dlu, pref, 5dlu, pref");
        this.setLayout(formLayout);
        
        this.distanceJLabel = new JLabel("Distance:");
        this.timeJLabel = new JLabel("Time:");
        this.resultJLabel = new JLabel();
        this.distanceJTextField = new JTextField();
        this.timeJTextField = new JTextField();
        this.calculateJButton = new JButton("Calculate");
    }
    
    public void addsComponents() {
        this.add(this.distanceJLabel, cc.xy(1, 1));
        this.add(this.distanceJTextField, cc.xy(3, 1));
        this.add(this.timeJLabel, cc.xy(1, 3));
        this.add(this.timeJTextField, cc.xy(3, 3));
    }
}
