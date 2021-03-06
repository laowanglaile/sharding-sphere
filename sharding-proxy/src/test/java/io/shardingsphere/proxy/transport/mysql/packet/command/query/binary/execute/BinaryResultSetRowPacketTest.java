/*
 * Copyright 2016-2018 shardingsphere.io.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * </p>
 */

package io.shardingsphere.proxy.transport.mysql.packet.command.query.binary.execute;

import io.shardingsphere.proxy.transport.mysql.constant.ColumnType;
import io.shardingsphere.proxy.transport.mysql.packet.MySQLPacketPayload;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public final class BinaryResultSetRowPacketTest {
    
    @Mock
    private MySQLPacketPayload payload;
    
    @Test
    @Ignore
    public void assertWrite() {
        BinaryResultSetRowPacket actual = new BinaryResultSetRowPacket(1, 2, Arrays.<Object>asList("value", null), Arrays.asList(ColumnType.MYSQL_TYPE_STRING, ColumnType.MYSQL_TYPE_STRING));
        assertThat(actual.getSequenceId(), is(1));
        assertThat(actual.getData(), is(Arrays.<Object>asList("value", null)));
        actual.write(payload);
        verify(payload, times(2)).writeInt1(0x00);
        verify(payload).writeStringLenenc("value");
    }
}
