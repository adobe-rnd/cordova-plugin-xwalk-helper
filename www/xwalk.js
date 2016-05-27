/*
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 *
 */
var exec = require('cordova/exec');

var XWalkPlugin = {

    /**
     * Enables remote debugging. Controls the crosswalk preference that enables remote debugging via chrome.
     * see https://crosswalk-project.org/apis/embeddingapidocs/reference/org/xwalk/core/XWalkPreferences.html#REMOTE_DEBUGGING
     * @param {boolean} enable Set to true to enable remote debugging.
     */
    setRemoteDebuggingEnabled: function (enable) {
        exec(null, null, "XWalkPlugin", "setRemoteDebugging", [enable]);
    },

    /**
     * Checks if remote debugging is enabled.
     * @param {function} successCallback Function that is called when the invocation succeeds.
     *                                   The argument contains the flag.
     * @param {function} errorCallback   Function that is called when the invocation fails.
     */
    getRemoteDebuggingEnabled: function (successCallback, errorCallback) {
        exec(successCallback, errorCallback, "XWalkPlugin", "getRemoteDebugging", []);
    },

    /**
     * Returns the crosswalk version.
     * @param {function} successCallback Function that is called when the invocation succeeds.
     *                                   The argument contains the version.
     * @param {function} errorCallback   Function that is called when the invocation fails.
     */
    getVersion: function (successCallback, errorCallback) {
        exec(successCallback, errorCallback, "XWalkPlugin", "getVersion", []);
    }

};

module.exports = XWalkPlugin;
