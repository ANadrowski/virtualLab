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

import br.com.anadrowski.virtuallab.formulas.Formula;
import br.com.anadrowski.virtuallab.formulas.mechanics.kinematics.CalcAverageSpeed;
import br.com.anadrowski.virtuallab.utils.ApplyRegex;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;
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

    private JLabel titleJLabel;
    private JLabel distanceJLabel;
    private JLabel timeJLabel;
    private JLabel resultJLabel;
    private JTextField distanceJTextField;
    private JTextField timeJTextField;
    private JButton calculateJButton;
    private FormLayout formLayout;
    private CellConstraints cc;
    DecimalFormat decimalFormat;
    private Font font;

    public AverageSpeed() {
        initComponents();
        addsComponents();
        applyRegex();
    }

    public void initComponents() {
        this.cc = new CellConstraints();
        this.formLayout = new FormLayout("right:50dlu, 5dlu, pref:grow, 5dlu, pref:grow",
                "5dlu, pref, 5dlu, pref, 5dlu, pref, 5dlu, pref, 5dlu, pref, 5dlu");
        this.setLayout(formLayout);
        this.decimalFormat = new DecimalFormat("0.00");

        this.font = new Font("Dialog", 1, 12);
        this.titleJLabel = new JLabel("Average Speed");
        this.titleJLabel.setFont(font);
        this.distanceJLabel = new JLabel("Distance (m):");
        this.timeJLabel = new JLabel("Time (s):");
        this.resultJLabel = new JLabel("Insert the values and click on 'Calculate' button.");
        this.distanceJTextField = new JTextField();
        this.timeJTextField = new JTextField();
        this.calculateJButton = new JButton("Calculate");
        this.calculateJButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calculateActionPerformed(evt);
            }

            private void calculateActionPerformed(ActionEvent evt) {
                Formula averageSpeed = new CalcAverageSpeed(Double.valueOf(distanceJTextField.getText()), Double.valueOf(timeJTextField.getText()));
                resultJLabel.setText(String.valueOf("Result: " + decimalFormat.format(averageSpeed.calc())) + "m/s");
            }
        });
        
    }

    public void addsComponents() {
        this.add(this.titleJLabel, cc.xy(3, 2));
        this.add(this.distanceJLabel, cc.xy(1, 4));
        this.add(this.distanceJTextField, cc.xy(3, 4));
        this.add(this.timeJLabel, cc.xy(1, 6));
        this.add(this.timeJTextField, cc.xy(3, 6));
        this.add(this.calculateJButton, cc.xy(3, 8));
        this.add(this.resultJLabel, cc.xy(3, 10));
    }
    
    public void applyRegex() {
        ApplyRegex applyRegex = new ApplyRegex();
        applyRegex.number(this.distanceJTextField);
        applyRegex.number(this.timeJTextField);
    }
}
