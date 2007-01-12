/*
 * File   : $Source: /alkacon/cvs/opencms/src-components/org/opencms/webdav/Attic/Messages.java,v $
 * Date   : $Date: 2007/01/12 17:24:42 $
 * Version: $Revision: 1.1.2.1 $
 *
 * This library is part of OpenCms -
 * the Open Source Content Mananagement System
 *
 * Copyright (C) 2005 Alkacon Software GmbH (http://www.alkacon.com)
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
 
package org.opencms.webdav;

import org.opencms.i18n.A_CmsMessageBundle;
import org.opencms.i18n.I_CmsMessageBundle;

/**
 * Convenience class to access the localized messages of this OpenCms package.<p> 
 * 
 * @author Peter Bonrad 
 * 
 * @version $Revision: 1.1.2.1 $ 
 * 
 */
public final class Messages extends A_CmsMessageBundle {

    /** Message constant for key in the resource bundle. */
    public static final String DIRECTORY_FILENAME_0 = "DIRECTORY_FILENAME_0";

    /** Message constant for key in the resource bundle. */
    public static final String DIRECTORY_LASTMODIFIED_0 = "DIRECTORY_LASTMODIFIED_0";

    /** Message constant for key in the resource bundle. */
    public static final String DIRECTORY_PARENT_1 = "DIRECTORY_PARENT_1";

    /** Message constant for key in the resource bundle. */
    public static final String DIRECTORY_SIZE_0 = "DIRECTORY_SIZE_0";

    /** Message constant for key in the resource bundle. */
    public static final String DIRECTORY_TITLE_1 = "DIRECTORY_TITLE_1";

    /** Message constant for key in the resource bundle. */
    public static final String EXISTING_RESOURCE_1 = "EXISTING_RESOURCE_1";

    /** Message constant for key in the resource bundle. */
    public static final String MISSING_RESOURCE_1 = "MISSING_RESOURCE_1";

    /** Name of the used resource bundle. */
    private static final String BUNDLE_NAME = "org.opencms.webdav.messages";

    /** Static instance member. */
    private static final I_CmsMessageBundle INSTANCE = new Messages();

    /**
     * Hides the public constructor for this utility class.
     * <p>
     */
    private Messages() {

        // hide the constructor
    }

    /**
     * Returns an instance of this localized message accessor.
     * <p>
     * 
     * @return an instance of this localized message accessor
     */
    public static I_CmsMessageBundle get() {

        return INSTANCE;
    }
    
    /**
     * Returns the bundle name for this OpenCms package.
     * <p>
     * 
     * @return the bundle name for this OpenCms package
     */
    public String getBundleName() {

        return BUNDLE_NAME;
    }
}
