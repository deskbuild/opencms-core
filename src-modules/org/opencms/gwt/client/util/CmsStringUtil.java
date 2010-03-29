/*
 * File   : $Source: /alkacon/cvs/opencms/src-modules/org/opencms/gwt/client/util/Attic/CmsStringUtil.java,v $
 * Date   : $Date: 2010/03/29 06:39:40 $
 * Version: $Revision: 1.5 $
 *
 * This library is part of OpenCms -
 * the Open Source Content Management System
 *
 * Copyright (c) 2002 - 2009 Alkacon Software GmbH (http://www.alkacon.com)
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * For further information about Alkacon Software GmbH, please see the
 * company website: http://www.alkacon.com
 *
 * For further information about OpenCms, please see the
 * project website: http://www.opencms.org
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */

package org.opencms.gwt.client.util;

/**
 * Client side implementation for {@link org.opencms.util.CmsStringUtil}.<p>
 * 
 * @author Michael Moossen 
 * 
 * @version $Revision: 1.5 $ 
 * 
 * @since 8.0.0
 * 
 * @see org.opencms.util.CmsStringUtil
 */
public final class CmsStringUtil {

    /**
     * Prevent instantiation.<p> 
     */
    private CmsStringUtil() {

        // empty
    }

    /**
     * Returns the exception message.<p>
     * 
     * @param t the exception to get the message for
     * 
     * @return the exception message
     */
    public static String getMessage(Throwable t) {

        String message = t.getLocalizedMessage();
        if (message == null) {
            message = t.getMessage();
        }
        if (message == null) {
            message = t.getClass().getName();
        }
        return message;
    }

    /**
     * Returns the stack trace of the Throwable as a string.<p>
     * 
     * @param t the Throwable for which the stack trace should be returned
     * @param separator the separator between the lines of the stack trace 
     * 
     * @return a string representing a stack trace 
     */
    public static String getStackTrace(Throwable t, String separator) {

        String result = "";
        for (StackTraceElement elem : t.getStackTrace()) {
            result += elem.toString();
            result += separator;
        }
        return result;
    }

    /**
     * Returns <code>true</code> if the provided String is either <code>null</code>
     * or the empty String <code>""</code>.<p> 
     * 
     * @param value the value to check
     * 
     * @return true, if the provided value is null or the empty String, false otherwise
     */
    public static boolean isEmpty(String value) {

        return (value == null) || (value.length() == 0);
    }

    /**
     * Returns <code>true</code> if the provided String is either <code>null</code>
     * or contains only white spaces.<p> 
     * 
     * @param value the value to check
     * 
     * @return true, if the provided value is null or contains only white spaces, false otherwise
     */
    public static boolean isEmptyOrWhitespaceOnly(String value) {

        return isEmpty(value) || (value.trim().length() == 0);
    }

    /**
     * Same as {@link org.opencms.util.CmsStringUtil#splitAsArray(String, String)}.<p>
     * 
     * @param str the string to split
     * @param splitter the splitter string
     * 
     * @return the splitted string
     */
    public static native String[] splitAsArray(String str, String splitter) /*-{
        return str.split(splitter);
    }-*/;
}