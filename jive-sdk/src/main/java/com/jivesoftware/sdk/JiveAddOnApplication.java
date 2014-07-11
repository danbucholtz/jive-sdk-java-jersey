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

package com.jivesoftware.sdk;

import javax.inject.Singleton;

import org.glassfish.jersey.server.ResourceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jivesoftware.sdk.api.entity.AddOnConfigProvider;
import com.jivesoftware.sdk.api.entity.HealthStatusProvider;
import com.jivesoftware.sdk.api.entity.JiveInstanceProvider;
import com.jivesoftware.sdk.api.entity.StorageInstanceProvider;
import com.jivesoftware.sdk.api.entity.TileInstanceProvider;
import com.jivesoftware.sdk.api.entity.impl.memory.MemoryAddOnConfigProvider;
import com.jivesoftware.sdk.api.entity.impl.memory.MemoryHealthStatusProvider;
import com.jivesoftware.sdk.api.entity.impl.memory.MemoryJiveInstanceProvider;
import com.jivesoftware.sdk.api.entity.impl.memory.MemoryStorageInstanceProvider;
import com.jivesoftware.sdk.api.entity.impl.memory.MemoryTileInstanceProvider;

/**
 * Created by rrutan on 1/29/14.
 */
@Singleton
public abstract class JiveAddOnApplication extends ResourceConfig {
    private static final Logger log = LoggerFactory.getLogger(JiveAddOnApplication.class);

    public JiveAddOnApplication() {
    }
    
    public AddOnConfigProvider getAddOnConfigProvider() {
        if (log.isDebugEnabled()) { log.debug("getAddOnConfigProvider called.."); }
        return MemoryAddOnConfigProvider.getInstance();
    } // end getAddOnConfigProvider

    public HealthStatusProvider getHealthStatusProvider() {
        if (log.isDebugEnabled()) { log.debug("getHealthStatusProvider called.."); }
        return MemoryHealthStatusProvider.getInstance();
    } // end getHealthStatusProvider

    public JiveInstanceProvider getJiveInstanceProvider() {
        if (log.isDebugEnabled()) { log.debug("getJiveInstanceProvider called.."); }
        return MemoryJiveInstanceProvider.getInstance();
    } // end getJiveInstanceProvider

    public StorageInstanceProvider getStorageInstanceProvider() {
        if (log.isDebugEnabled()) { log.debug("getStorageInstanceProvider called.."); }
        return MemoryStorageInstanceProvider.getInstance();
    }
    public TileInstanceProvider getTileInstanceProvider() {
        if (log.isDebugEnabled()) { log.debug("getTileInstanceProvider called.."); }
        return MemoryTileInstanceProvider.getInstance();
    } 
}