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

package com.jivesoftware.sdk.event;

import javax.inject.Singleton;
import java.io.Serializable;
import java.util.Map;

/**
 * Created by rrutan on 2/1/14.
 */
@Singleton
public class TileInstanceEvent extends AbstractEvent implements Serializable {

    public enum Type {
        Unregister(false),
        RegisterSuccess(false),
        RegisterFailed(true);

        private boolean isError = false;

        Type(boolean isError) {
              this.isError = isError;
        } // end constructor

    } // end enum

    private Type type;
    private String tileName;

    public TileInstanceEvent() {
        super();
    } // end constructor

    public TileInstanceEvent(Type type, String tileName) {
        this();
        this.type = type;
        this.tileName = tileName;
    } // end constructor

    public TileInstanceEvent(Type type, String tileName, Map<String,Object> data) {
        this(type,tileName);
        this.data = data;
    } // end constructor

    public Type getType() {
        return type;
    }
    public void setType(Type type) {
        this.type = type;
    }

    public String getTileName() { return tileName; }
    public void setTileName(String tileName) { this.tileName = tileName; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TileInstanceEvent that = (TileInstanceEvent) o;

        if (data != null ? !data.equals(that.data) : that.data != null) return false;
        if (type != that.type) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + (data != null ? data.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TileInstanceEvent{" +
                "type=" + type +
                ", data=" + data +
                '}';
    }

} // end class