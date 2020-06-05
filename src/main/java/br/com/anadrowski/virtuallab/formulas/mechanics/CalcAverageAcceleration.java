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
package br.com.anadrowski.virtuallab.formulas.mechanics;

import br.com.anadrowski.virtuallab.formulas.Formula;

/**
 * Calculates the average acceleration.
 *
 * Aavg = vf - vi / tf - ti 
 * 
 * vf: final velocity 
 * vi: initial velocity 
 * tf: final time 
 * ti: initial time
 *
 * @author Aislan Nadrowski (aislan.nadrowski@gmail.com)
 * @since 0.0.1
 */
public class CalcAverageAcceleration implements Formula {

    private final double finalVelocity;
    private final double initialVelocity;
    private final double finalTime;
    private final double initialTime;

    /**
     * Constructor with parameters.
     *
     * @param finalVelocity
     * @param initialVelocity
     * @param finalTime
     * @param initialTime
     */
    public CalcAverageAcceleration(final double finalVelocity,
        final double initialVelocity,
        final double finalTime,
        final double initialTime) {

        this.finalVelocity = finalVelocity;
        this.initialVelocity = initialVelocity;
        this.finalTime = finalTime;
        this.initialTime = initialTime;
    }

    /**
     * Calculates the average acceleration.
     *
     * @return Average acceleration (m/s2).
     */
    @Override
    public double calc() {
        return (this.finalVelocity - this.initialVelocity) / (this.finalTime - this.initialTime);
    }
}
