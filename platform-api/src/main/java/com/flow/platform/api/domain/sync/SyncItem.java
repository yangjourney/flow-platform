/*
 * Copyright 2017 flow.ci
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.flow.platform.api.domain.sync;

import com.flow.platform.domain.Jsonable;
import java.time.ZonedDateTime;

/**
 * @author yang
 */
public class SyncItem extends Jsonable {

    private SyncKey key;

    /**
     * Sync status
     */
    private SyncStatus status = SyncStatus.PENDING;

    /**
     * Time to start sync
     */
    private ZonedDateTime syncTime;

    public SyncItem() {
    }

    public SyncItem(String clientId, String repo) {
        this.key = new SyncKey(clientId, repo);
    }

    public SyncItem(String clientId, String repo, SyncStatus status) {
        this(clientId, repo);
        this.status = status;
    }

    public SyncKey getKey() {
        return key;
    }

    public void setKey(SyncKey key) {
        this.key = key;
    }

    public SyncStatus getStatus() {
        return status;
    }

    public void setStatus(SyncStatus status) {
        this.status = status;
    }

    public ZonedDateTime getSyncTime() {
        return syncTime;
    }

    public void setSyncTime(ZonedDateTime syncTime) {
        this.syncTime = syncTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        SyncItem syncItem = (SyncItem) o;

        return key.equals(syncItem.key);
    }

    @Override
    public int hashCode() {
        return key.hashCode();
    }
}
