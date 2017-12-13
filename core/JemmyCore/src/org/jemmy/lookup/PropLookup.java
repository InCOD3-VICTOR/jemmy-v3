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

package org.jemmy.lookup;

import org.jemmy.control.Wrap;
import org.jemmy.control.Wrapper;

/**
 *
 * @param <CONTROL>
 * @author shura
 */
public class PropLookup<CONTROL> implements LookupCriteria<CONTROL> {

    String propName;
    Wrapper wrapper;
    Object value;

    /**
     *
     * @param propName
     * @param value
     */
    public PropLookup(String propName, Object value) {
        this(Wrap.getWrapper(), propName, value);
    }
    /**
     *
     * @param wrapper
     * @param propName
     * @param value
     */
    public PropLookup(Wrapper wrapper, String propName, Object value) {
        this.propName = propName;
        this.wrapper = wrapper;
        this.value = value;
    }

    public boolean check(CONTROL control) {
        return wrapper.wrap(Object.class, control).getProperty(propName).equals(value);
    }

}
