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
package org.jemmy.control;

import java.lang.annotation.*;
import org.jemmy.interfaces.TypeControlInterface;

/**
 * This annotation should be used to annotate methods which turn a wrap
 * into a control interface. It is, then, used in <code>Wrap.as(*)</code> and
 * <code>Wrap.is(*)</code> methods and in <code>*Dock.as*()</code> methods.
 * @see Wrap#as(java.lang.Class)
 * @see Wrap#as(java.lang.Class, java.lang.Class)
 * @see Wrap#is(java.lang.Class)
 * @see Wrap#is(java.lang.Class, java.lang.Class)
 * @author shura
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface As {
    /**
     * This should point out what is the encapsulated type for
     * <code>TypeControlInterface</code>
     * @see TypeControlInterface
     * @return
     */
    Class value() default Void.class;
}
