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

/**
 * @author yang
 */
public class SyncKey extends Jsonable {

    /**
     * Target client id
     */
    private String clientId;

    /**
     * Repo info ex: name[tag]
     */
    private String repo;

    public SyncKey() {
    }

    public SyncKey(String clientId, String repo) {
        this.clientId = clientId;
        this.repo = repo;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getRepo() {
        return repo;
    }

    public void setRepo(String repo) {
        this.repo = repo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        SyncKey syncKey = (SyncKey) o;

        if (!clientId.equals(syncKey.clientId)) {
            return false;
        }
        return repo.equals(syncKey.repo);
    }

    @Override
    public int hashCode() {
        int result = clientId.hashCode();
        result = 31 * result + repo.hashCode();
        return result;
    }
}
