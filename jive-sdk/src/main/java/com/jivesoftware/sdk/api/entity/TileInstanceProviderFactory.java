/*
 *
 *  * Copyright 2013 Jive Software
 *  *
 *  *    Licensed under the Apache License, Version 2.0 (the "License");
 *  *    you may not use this file except in compliance with the License.
 *  *    You may obtain a copy of the License at
 *  *
 *  *       http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  *    Unless required by applicable law or agreed to in writing, software
 *  *    distributed under the License is distributed on an "AS IS" BASIS,
 *  *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  *    See the License for the specific language governing permissions and
 *  *    limitations under the License.
 *
 */

package com.jivesoftware.sdk.api.entity;

import com.jivesoftware.sdk.JiveAddOnApplication;
import org.glassfish.hk2.api.Factory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;

/**
 * Created by rrutan on 2/6/14.
 */
public class TileInstanceProviderFactory implements Factory<TileInstanceProvider> {
    private static final Logger log = LoggerFactory.getLogger(TileInstanceProviderFactory.class);

    @Context
    private Application application;

    public TileInstanceProviderFactory() {
        if (log.isTraceEnabled()) { log.trace("constructor called..."); }
    } // end class

    @Override
    public TileInstanceProvider provide() {
        log.debug("provide called...");
        if (application != null) {

            if (application instanceof JiveAddOnApplication) {
                log.debug("Found Application, getting tileInstanceProvider");
                return ((JiveAddOnApplication)application).getTileInstanceProvider();
            } else {
                log.warn("Unable to locate tileInstanceProvider, application is not a JiveAddOnApplication");
            } // end if

        } // end if

        log.debug("application is null");

        return null;
    } // end provide

    @Override
    public void dispose(TileInstanceProvider instance) {
        log.debug("dispose called...");
        if (instance != null) {
            instance.dispose();
        } // end if
        instance = null;
    } // end dispose

} // end class
