/*
       Licensed to the Apache Software Foundation (ASF) under one
       or more contributor license agreements.  See the NOTICE file
       distributed with this work for additional information
       regarding copyright ownership.  The ASF licenses this file
       to you under the Apache License, Version 2.0 (the
       "License"); you may not use this file except in compliance
       with the License.  You may obtain a copy of the License at

         http://www.apache.org/licenses/LICENSE-2.0

       Unless required by applicable law or agreed to in writing,
       software distributed under the License is distributed on an
       "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
       KIND, either express or implied.  See the License for the
       specific language governing permissions and limitations
       under the License.
*/
package org.crosswalk.cordova;

import android.util.Log;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.xwalk.core.XWalkPreferences;
import org.xwalk.core.XWalkView;

/**
 * Implements the cordova plugin that handles to the client javascript bindings.
 */
public class XWalkCordovaPlugin extends CordovaPlugin {

    private static final String TAG = "XWalkCordovaPlugin";

    private static final String CMD_SET_REMOTE_DEBUGGING = "setRemoteDebugging";

    private static final String CMD_GET_REMOTE_DEBUGGING = "getRemoteDebugging";

    private static final String CMD_GET_VERSION = "getVersion";

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        try {
            if (CMD_GET_REMOTE_DEBUGGING.equals(action)) {
                boolean isDebuggable = XWalkPreferences.getValue(XWalkPreferences.REMOTE_DEBUGGING);
                Log.d(TAG, "isDebuggable(): " + isDebuggable);
                callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, isDebuggable));
                return true;

            } else if (CMD_SET_REMOTE_DEBUGGING.equals(action)) {
                boolean isDebuggable = args.getBoolean(0);
                Log.d(TAG, "setDebuggable(" + isDebuggable + ")");
                XWalkPreferences.setValue(XWalkPreferences.REMOTE_DEBUGGING, isDebuggable);
                return true;

            } else if (CMD_GET_VERSION.equals(action)) {
                String version = "n/a";
                Object view = this.webView.getEngine().getView();
                if (view instanceof XWalkView) {
                    version = ((XWalkView) view).getXWalkVersion();
                }
                Log.d(TAG, "getVersion(): " + version + " (class=" + view.getClass().getName() + ")");
                callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, version));
                return true;
            }
        } catch(Exception e) {
            Log.e(TAG, "Error in action handling.", e);
        }
        return false;
    }
}