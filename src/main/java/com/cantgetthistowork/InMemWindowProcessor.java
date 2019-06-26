package com.cantgetthistowork;

import org.apache.kafka.streams.processor.Processor;
import org.apache.kafka.streams.processor.ProcessorContext;
import org.apache.kafka.streams.state.WindowStore;

public class InMemWindowProcessor implements Processor<String, String> {

  private ProcessorContext context;
  private WindowStore<String, String> windowStore;

  @Override
  public void init(ProcessorContext context) {
    this.context = context;

    windowStore = (WindowStore<String, String>) context.getStateStore("my-win-store");
  }

  @Override
  public void process(String key, String value) {
  }

  @Override
  public void close() {
  }

}
