/*
 * Copyright (c) 2007, 2017 Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */
package org.jemmy.image.pixel;

import org.jemmy.Dimension;
import org.jemmy.image.Image;
import org.jemmy.image.pixel.Raster.Component;

/**
 *
 * @author shura
 */
public class PixelEqualityRasterComparator extends BaseCountingRasterComparator {

    /**
     *
     * @param treshold
     */
    public PixelEqualityRasterComparator(double treshold) {
        super(treshold);
    }

    /**
     *
     * @param comps1
     * @param colors1
     * @param comps2
     * @param colors2
     * @return
     */
    @Override
    protected boolean compare(Raster.Component[] comps1, double[] colors1,
            Raster.Component[] comps2, double[] colors2) {
        if (colors1.length == colors2.length) {
            for (int i = 0; i < colors1.length; i++) {
                if (colors1[i] != colors2[PixelImageComparator.arrayIndexOf(comps2, comps1[i])]) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    /**
     *
     * @return
     */
    public String getID() {
        return PixelEqualityRasterComparator.class.getName() + ":" + getThreshold();
    }
}