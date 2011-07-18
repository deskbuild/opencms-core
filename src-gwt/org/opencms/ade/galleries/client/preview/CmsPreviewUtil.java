/*
 * This library is part of OpenCms -
 * the Open Source Content Management System
 *
 * Copyright (c) Alkacon Software GmbH (http://www.alkacon.com)
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
 * For further information about Alkacon Software, please see the
 * company website: http://www.alkacon.com
 *
 * For further information about OpenCms, please see the
 * project website: http://www.opencms.org
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */

package org.opencms.ade.galleries.client.preview;

import org.opencms.gwt.client.util.CmsJSONMap;
import org.opencms.util.CmsStringUtil;

import java.util.Map;
import java.util.Map.Entry;

import com.google.gwt.core.client.JsArrayString;

/**
 * Utility class for resource preview.<p>
 * 
 * @since 8.0.0
 */
public final class CmsPreviewUtil {

    /** The dialog OK function key. */
    static final String KEY_DIALOG_OK_FUNCTION = "dialogOk";

    /** The enable dialog OK function key. */
    static final String KEY_ENABLE_DIALOG_OK_FUNCTION = "enableDialogOk";

    /** The get image info function key. */
    static final String KEY_GET_IMAGE_INFO_FUNCTION = "getImageInfo";

    /** The has enhanced image options function key. */
    static final String KEY_HAS_ENHANCED_IMAGE_OPTIONS = "hasEnhancedImageOptions";

    /** The close gallery dialog function key. */
    static final String KEY_SET_DATA_IN_EDITOR_FUNCTION = "setDataInEditor";

    /** The set image function key. */
    static final String KEY_SET_IMAGE_FUNCTION = "setImage";

    /** The set image link function key. */
    static final String KEY_SET_IMAGE_LINK_FUNCTION = "setImageLink";

    /** The set link function key. */
    static final String KEY_SET_LINK_FUNCTION = "setLink";

    /** The close dialog function key. */
    static final String KEY_DIALOG_CLOSE_FUNCTION = "closeDialog";

    /**
     * Constructor.<p>
     */
    private CmsPreviewUtil() {

        // hiding the constructor
    }

    /**
     * Triggers the dialog OK action.<p>
     */
    public static native void closeDialog() /*-{
      $wnd[@org.opencms.ade.galleries.client.preview.CmsPreviewUtil::KEY_DIALOG_CLOSE_FUNCTION]
            ();
    }-*/;

    /**
     * Enables the dialog OK button within the rich text editor (FCKEditor, CKEditor, ...).<p>
     * 
     * @param enabled <code>true</code> to enable the button
     */
    public static native void enableEditorOk(boolean enabled)/*-{
      $wnd[@org.opencms.ade.galleries.client.preview.CmsPreviewUtil::KEY_ENABLE_DIALOG_OK_FUNCTION]
            (enabled);
    }-*/;

    /**
     * Exports the functions of {@link org.opencms.ade.galleries.client.preview.I_CmsResourcePreview}
     * to the window object for use via JSNI.<p> 
     * 
     * @param previewName the preview name 
     * @param preview the preview
     */
    public static native void exportFunctions(String previewName, I_CmsResourcePreview preview) /*-{
      var listKey = @org.opencms.ade.galleries.client.preview.I_CmsResourcePreview::KEY_PREVIEW_PROVIDER_LIST;
      if (!$wnd[listKey]) {
         $wnd[listKey] = {};
      }
      $wnd[listKey][previewName] = {};
      $wnd[listKey][previewName][@org.opencms.ade.galleries.client.preview.I_CmsResourcePreview::KEY_OPEN_PREVIEW_FUNCTION] = function(
            mode, path, parentElementId) {
         preview.@org.opencms.ade.galleries.client.preview.I_CmsResourcePreview::openPreview(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)(mode, path, parentElementId);
      };
      $wnd[listKey][previewName][@org.opencms.ade.galleries.client.preview.I_CmsResourcePreview::KEY_SELECT_RESOURCE_FUNCTION] = function(
            mode, path, title) {
         preview.@org.opencms.ade.galleries.client.preview.I_CmsResourcePreview::selectResource(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)(mode, path, title);
      };
      $wnd[@org.opencms.ade.galleries.client.preview.CmsPreviewUtil::KEY_SET_DATA_IN_EDITOR_FUNCTION] = function() {
         return preview.@org.opencms.ade.galleries.client.preview.I_CmsResourcePreview::setDataInEditor()();
      };
    }-*/;

    /**
     * Returns the xml-content field id.<p>
     * 
     * @return the field id
     */
    public static native String getFieldId() /*-{
      return $wnd[@org.opencms.ade.galleries.shared.I_CmsGalleryProviderConstants::KEY_FIELD_ID];
    }-*/;

    /**
     * Returns the available image format names for gallery widget mode.<p>
     * 
     * @return the available image formats
     */
    public static native String getFormatNames()/*-{
      var id = $wnd[@org.opencms.ade.galleries.shared.I_CmsGalleryProviderConstants::KEY_HASH_ID];
      var additional = $wnd.parent['cms_additional_' + id];
      if (additional) {
         return additional['imageFormatNames'];
      }
      return null;
    }-*/;

    /**
     * Returns the available image formats for gallery widget mode.<p>
     * 
     * @return the available image formats
     */
    public static String[] getFormats() {

        JsArrayString tempArr = nativeGetFormats();
        if ((tempArr == null) || (tempArr.length() == 0)) {
            return null;
        }
        String[] result = new String[tempArr.length()];
        for (int i = 0; i < tempArr.length(); i++) {
            result[i] = tempArr.get(i);
        }
        return result;
    }

    /**
     * Returns all available information of the selected image tag, or null, if no image is selected.<p>
     * 
     * @return a map with the following keys:<p>
     *          alt, class, height, hspace, linkPath, linkTarget, longDesc, style, title, vspace, width<p>
     * 
     *          all keys represent a tag attribute by the same name, only linkPath and linkTarget contain
     *          information on an surrounding link tag
     */
    public static native CmsJSONMap getImageInfo() /*-{
      return $wnd[@org.opencms.ade.galleries.client.preview.CmsPreviewUtil::KEY_GET_IMAGE_INFO_FUNCTION]
            ();
    }-*/;

    /**
     * Returns the availability of enhanced image options.<p>
     * 
     * @return <code>true</code> if enhanced image options are available
     */
    public static native boolean hasEnhancedImageOptions() /*-{
      return $wnd[@org.opencms.ade.galleries.client.preview.CmsPreviewUtil::KEY_HAS_ENHANCED_IMAGE_OPTIONS]
            ();
    }-*/;

    /**
     * Returns if the image format selector should be shown within gallery widget mode.<p>
     * 
     * @return <code>true</code> if format selector should be shown
     */
    public static native boolean isShowFormats()/*-{
      var id = $wnd[@org.opencms.ade.galleries.shared.I_CmsGalleryProviderConstants::KEY_HASH_ID];
      var additional = $wnd.parent['cms_additional_' + id];
      if (additional) {
         return additional['useFormats'];
      }
      return false;
    }-*/;

    /**
     * Returns the available image formats for gallery widget mode.<p>
     * 
     * @return the available image formats
     */
    public static native JsArrayString nativeGetFormats()/*-{
      var id = $wnd[@org.opencms.ade.galleries.shared.I_CmsGalleryProviderConstants::KEY_HASH_ID];
      var additional = $wnd.parent['cms_additional_' + id];
      if (additional) {
         return additional['imageFormats'];
      }
      return null;
    }-*/;

    /**
     * Triggers the dialog OK action.<p>
     */
    public static native void setDataAndCloseDialog() /*-{
      $wnd[@org.opencms.ade.galleries.client.preview.CmsPreviewUtil::KEY_DIALOG_OK_FUNCTION]
            ();
    }-*/;

    /**
     * Sets the image tag within the rich text editor (FCKEditor, CKEditor, ...).<p>
     * 
     * @param path the image path
     * @param attributes the image tag attributes
     */
    public static void setImage(String path, Map<String, String> attributes) {

        CmsJSONMap attributesJS = CmsJSONMap.createJSONMap();
        for (Entry<String, String> entry : attributes.entrySet()) {
            attributesJS.put(entry.getKey(), entry.getValue());
        }
        nativeSetImage(path, attributesJS);
    }

    /**
     * Sets the image link within the rich text editor (FCKEditor, CKEditor, ...).<p>
     * 
     * @param path the image path
     * @param attributes the image tag attributes
     * @param linkPath the link path
     * @param target the link target attribute
     */
    public static void setImageLink(String path, Map<String, String> attributes, String linkPath, String target) {

        CmsJSONMap attributesJS = CmsJSONMap.createJSONMap();
        for (Entry<String, String> entry : attributes.entrySet()) {
            attributesJS.put(entry.getKey(), entry.getValue());
        }
        nativeSetImageLink(path, attributesJS, linkPath, target);
    }

    /**
     * Sets the resource link within the rich text editor (FCKEditor, CKEditor, ...).<p>
     * 
     * @param path the link path
     * @param title the link title
     * @param target the link target attribute
     */
    public static void setLink(String path, String title, String target) {

        nativeSetLink(path, CmsStringUtil.escapeHtml(title), target);
    }

    /**
     * Sets the path of the selected resource in the input field of the xmlcontent.<p>
     * 
     * Widget mode: Use this function inside the xmlcontent. 
     * 
     * @param path the path to the selected resource
     */
    public static native void setResourcePath(String path) /*-{
      //the id of the input field in the xml content
      var fieldId = $wnd[@org.opencms.ade.galleries.shared.I_CmsGalleryProviderConstants::KEY_FIELD_ID];

      if (fieldId != null && fieldId != "") {
         var inputField = $wnd.parent.document.getElementById(fieldId);
         inputField.setAttribute('value', path);
         inputField.value = path;
         try {
            // toggle preview icon if possible
            $wnd.parent.checkPreview(fieldId);
         } catch (e) {
         }
      }
      $wnd.parent.cmsCloseDialog(fieldId);
    }-*/;

    /**
    * Calls the integrator's set image function to set the image tag within the rich text editor (FCKEditor, CKEditor, ...).<p>
    * 
    * @param path the image path
    * @param attributes the image tag attributes
    */
    private static native void nativeSetImage(String path, CmsJSONMap attributes)/*-{
      if ($wnd[@org.opencms.ade.galleries.client.preview.CmsPreviewUtil::KEY_SET_IMAGE_FUNCTION] != null) {
         $wnd[@org.opencms.ade.galleries.client.preview.CmsPreviewUtil::KEY_SET_IMAGE_FUNCTION]
               (path, attributes);
      }

    }-*/;

    /**
     * Calls the integrator's set image link function to set the image link within the rich text editor (FCKEditor, CKEditor, ...).<p>
     * 
     * @param path the image path
     * @param attributes the image tag attributes
     * @param linkPath the link path
     * @param target the link target attribute
     */
    private static native void nativeSetImageLink(String path, CmsJSONMap attributes, String linkPath, String target)/*-{
      $wnd[@org.opencms.ade.galleries.client.preview.CmsPreviewUtil::KEY_SET_IMAGE_LINK_FUNCTION]
            (path, attributes, linkPath, target);
    }-*/;

    /**
     * Calls the integrator's set link function to set the resource link within the rich text editor (FCKEditor, CKEditor, ...).<p>
     * 
     * @param path the link path
     * @param title the link title
     * @param target the link target attribute
     */
    private static native void nativeSetLink(String path, String title, String target)/*-{
      $wnd[@org.opencms.ade.galleries.client.preview.CmsPreviewUtil::KEY_SET_LINK_FUNCTION]
            (path, title, target);
    }-*/;
}