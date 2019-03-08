package io.vertx.launcher;

import io.micrometer.core.instrument.Metrics;
import io.micrometer.core.instrument.composite.CompositeMeterRegistry;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;
import io.vertx.core.Launcher;
import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import io.vertx.core.json.JsonObject;
import io.vertx.micrometer.MicrometerMetricsOptions;
import io.vertx.micrometer.VertxJmxMetricsOptions;
import io.vertx.micrometer.VertxPrometheusOptions;
import io.vertx.micrometer.backends.BackendRegistries;

public class MyLauncher extends Launcher {

  public static void main(String[] args) {
    // IMPORTANT
    // This is required to use our custom launcher.
    new MyLauncher().dispatch(args);
  }


  @Override
  public void beforeStartingVertx(VertxOptions options) {

//    Metrics.addRegistry(new SimpleMeterRegistry());
//    CompositeMeterRegistry registry = (CompositeMeterRegistry) BackendRegistries.getDefaultNow();



    // Customize the options
    options.setWorkerPoolSize(20);

    options.setMetricsOptions(
      new MicrometerMetricsOptions()
//        .setPrometheusOptions(new VertxPrometheusOptions().setEnabled(true))
//        .setJmxMetricsOptions(new Pro
//          .setEnabled(true))
        .setEnabled(true));
  }

  @Override
  public void afterStartingVertx(Vertx vertx) {

//        JmxMeterRegistry registry = (JmxMeterRegistry) BackendRegistries.getDefaultNow();
//    Metrics.addRegistry(new SimpleMeterRegistry());
//    CompositeMeterRegistry registry = (CompositeMeterRegistry) BackendRegistries.getDefaultNow();

//    registry.config().meterFilter(new MeterFilter() {
//      @Override
//      public DistributionStatisticConfig configure(Meter.Id id, DistributionStatisticConfig config) {
//        return DistributionStatisticConfig.builder()
//          .percentiles(0.50, 0.90, 0.95, 0.99)
//          .percentilesHistogram(true)
//          .build()
//          .merge(config);
//      }
//    });
  }

  @Override
  public void afterConfigParsed(JsonObject config) {
    // Inject a specific config
    config.put("message", "Bonjour, Hello");
  }
}
