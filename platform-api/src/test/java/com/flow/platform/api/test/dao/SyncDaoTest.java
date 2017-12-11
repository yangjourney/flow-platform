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

package com.flow.platform.api.test.dao;

import com.flow.platform.api.domain.sync.SyncItem;
import com.flow.platform.api.domain.sync.SyncStatus;
import com.flow.platform.api.test.TestBase;
import com.flow.platform.core.util.ThreadUtil;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author yang
 */
public class SyncDaoTest extends TestBase {

    @Test
    public void should_save_sync_data() {
        // given:
        final String clientId = "default#node";
        final String repo = "hello[v1.5]";

        // when:
        SyncItem syncItem = new SyncItem(clientId, repo);
        syncDao.save(syncItem);

        // then:
        SyncItem loaded = syncDao.get(syncItem.getKey());
        Assert.assertEquals(clientId, loaded.getKey().getClientId());
        Assert.assertEquals(repo, loaded.getKey().getRepo());
        Assert.assertEquals(SyncStatus.PENDING, loaded.getStatus());
        Assert.assertNotNull(loaded.getSyncTime());
    }

    @Test
    public void should_list_sync_items_by_client() {
        // given:
        final String clientId = "default#node";

        // when:
        syncDao.save(new SyncItem(clientId, "hello[1.5]"));
        ThreadUtil.sleep(1000);
        syncDao.save(new SyncItem(clientId, "hello[1.6]"));
        ThreadUtil.sleep(1000);
        syncDao.save(new SyncItem(clientId, "hello[1.7]"));

        // then:
        List<SyncItem> items = syncDao.listByClient(clientId);
        Assert.assertEquals(3, items.size());
        Assert.assertEquals("hello[1.5]", items.get(0).getKey().getRepo());
        Assert.assertEquals("hello[1.6]", items.get(1).getKey().getRepo());
        Assert.assertEquals("hello[1.7]", items.get(2).getKey().getRepo());
    }
}
