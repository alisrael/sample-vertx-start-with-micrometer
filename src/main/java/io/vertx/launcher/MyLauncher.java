package io.vertx.launcher;

import io.vertx.core.Launcher;
import io.vertx.core.VertxOptions;
import io.vertx.core.json.JsonObject;
import io.vertx.micrometer.MicrometerMetricsOptions;
import io.vertx.micrometer.VertxJmxMetricsOptions;

public class MyLauncher extends Launcher {

  public static void main(String[] args) {
    // IMPORTANT
    // This is required to use our custom launcher.
    new MyLauncher().dispatch(args);
  }


  @Override
  public void beforeStartingVertx(VertxOptions options) {
    // Customize the options
    options.setWorkerPoolSize(20);

    options.setMetricsOptions(
      new MicrometerMetricsOptions()
        .setJmxMetricsOptions(new VertxJmxMetricsOptions()
          .setDomain("localhost")
          .setStep(5)
          .setEnabled(true))
        .setEnabled(true));
  }

  @Override
  public void afterConfigParsed(JsonObject config) {
    // Inject a specific config
    config.put("message", "Bonjour, Hello");
  }
}
