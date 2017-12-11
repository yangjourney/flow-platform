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

package com.flow.platform.api.dao;

import com.flow.platform.api.domain.sync.SyncItem;
import com.flow.platform.api.domain.sync.SyncKey;
import com.flow.platform.core.dao.AbstractBaseDao;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * @author yang
 */
@Repository
public class SyncDaoImpl extends AbstractBaseDao<SyncKey, SyncItem> implements SyncDao {

    @Override
    protected Class<SyncItem> getEntityClass() {
        return SyncItem.class;
    }

    @Override
    protected String getKeyName() {
        return "key";
    }

    @Override
    public List<SyncItem> listByClient(String clientId) {
        return execute(session -> session
            .createQuery("from SyncItem where key.clientId = :clientId order by syncTime", SyncItem.class)
            .setParameter("clientId", clientId)
            .list());
    }
}
