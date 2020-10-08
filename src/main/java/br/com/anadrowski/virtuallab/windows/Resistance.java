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
import br.com.anadrowski.virtuallab.formulas.electrical.CalcResistance;
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
 * Resistance JPanel.
 *
 * @author Aislan Nadrowski (aislan.nadrowski@gmail.com)
 * @since 0.0.1
 */
public final class Resistance extends JPanel {

    private JLabel titleJLabel;
    private JLabel formulaJLabel;
    private JLabel voltageJLabel;
    private JLabel currentJLabel;
    private JLabel resultJLabel;
    private JTextField voltageJTextField;
    private JTextField currentJTextField;
    private JButton calculateJButton;
    private FormLayout formLayout;
    private CellConstraints cc;
    private DecimalFormat decimalFormat;
    private Font font;

    public Resistance() {
        initComponents();
        addsComponents();
        applyRegex();
    }

    public void initComponents() {
        this.cc = new CellConstraints();
        this.formLayout = new FormLayout("right:70dlu, 5dlu, pref:grow, 5dlu, pref:grow",
                "5dlu, pref, 5dlu, pref, 5dlu, pref, 5dlu, pref, 5dlu, pref, 5dlu, pref, 5dlu");
        this.setLayout(formLayout);
        this.decimalFormat = new DecimalFormat("0.00");
        
        this.font = new Font("Segoe UI", 1, 12);
        this.titleJLabel = new JLabel("Resistance");
        this.titleJLabel.setFont(font);
        this.font = new Font("Segoe UI", 0, 12);
        this.formulaJLabel = new JLabel("resistance = voltage / current");
        this.formulaJLabel.setFont(font);
        this.voltageJLabel = new JLabel("Voltage (V):");
        this.currentJLabel = new JLabel("Current (A):");
        this.resultJLabel = new JLabel("Insert the values and click on 'Calculate' button.");
        this.voltageJTextField = new JTextField();
        this.currentJTextField = new JTextField();
        this.calculateJButton = new JButton("Calculate");
        this.calculateJButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calculateActionPerformed(evt);
            }

            private void calculateActionPerformed(ActionEvent evt) {
                Formula resistance = new CalcResistance(Double.valueOf(voltageJTextField.getText()), Double.valueOf(currentJTextField.getText()));
                resultJLabel.setText(String.valueOf("Result: " + decimalFormat.format(resistance.calc())) + "Ω");
            }
        });
        
    }

    public void addsComponents() {
        this.add(this.titleJLabel, cc.xy(3, 2));
        this.add(this.formulaJLabel, cc.xy(3, 4));
        this.add(this.voltageJLabel, cc.xy(1, 6));
        this.add(this.voltageJTextField, cc.xy(3, 6));
        this.add(this.currentJLabel, cc.xy(1, 8));
        this.add(this.currentJTextField, cc.xy(3, 8));
        this.add(this.calculateJButton, cc.xy(3, 10));
        this.add(this.resultJLabel, cc.xy(3, 12));
    }
    
    public void applyRegex() {
        ApplyRegex applyRegex = new ApplyRegex();
        applyRegex.number(this.voltageJTextField);
        applyRegex.number(this.currentJTextField);
    }
}
