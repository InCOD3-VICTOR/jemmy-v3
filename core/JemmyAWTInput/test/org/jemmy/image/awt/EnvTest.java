/*
 * Copyright (c) 2007, 2017, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation. Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
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
package org.jemmy.image.awt;

import org.jemmy.env.Environment;
import org.jemmy.image.ImageCapturer;
import org.jemmy.image.ImageComparator;
import org.jemmy.image.awt.AWTRobotCapturer;
import org.jemmy.image.awt.BufferedImageComparator;
import org.jemmy.image.pixel.PixelEqualityRasterComparator;
import org.jemmy.image.pixel.RasterComparator;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

/**
 *
 * @author shura
 */
public class EnvTest {

    public EnvTest() {
    }

    @Test
    public void testRaster() {
        Environment.getEnvironment().setProperty(RasterComparator.class, new PixelEqualityRasterComparator(1));
        Environment.getEnvironment().setProperty(ImageCapturer.class, new AWTRobotCapturer());
        ImageComparator comp = Environment.getEnvironment().getProperty(ImageComparator.class);
        assertTrue(comp instanceof BufferedImageComparator);
        assertTrue(((BufferedImageComparator)comp).getRasterComparator() instanceof PixelEqualityRasterComparator);
    }
}
