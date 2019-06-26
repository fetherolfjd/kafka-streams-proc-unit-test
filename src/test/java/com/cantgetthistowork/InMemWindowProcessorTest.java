package com.cantgetthistowork;

import java.time.Duration;
import java.time.Instant;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.processor.MockProcessorContext;
import org.apache.kafka.streams.state.Stores;
import org.apache.kafka.streams.state.WindowStore;
import org.junit.Before;
import org.junit.Test;

public class InMemWindowProcessorTest {

  InMemWindowProcessor processor = null;
  MockProcessorContext context = null;

  @Before
  public void setup() {
    processor = new InMemWindowProcessor();
    context = new MockProcessorContext();

    WindowStore<String, String> store =
      Stores.windowStoreBuilder(
        Stores.inMemoryWindowStore(
          "my-win-store",
          Duration.ofMinutes(10),
          Duration.ofSeconds(10),
          false
        ),
        Serdes.String(),
        Serdes.String()
      )
      .withLoggingDisabled()
      .build();
    store.init(context, store);
    context.register(store, null);
    processor.init(context);
  }

  @Test
  public void testThings() {
    Instant baseTime = Instant.now();
    context.setTimestamp(baseTime.toEpochMilli());
    context.setTopic("topic-name");
    processor.process("key1", "value1");
  }

}
