package org.example;

import com.pi4j.Pi4J;
import com.pi4j.io.gpio.digital.DigitalOutput;
import com.pi4j.platform.Platform;
import com.pi4j.platform.Platforms;
import com.pi4j.provider.Providers;
import com.pi4j.registry.Registry;
import com.pi4j.util.Console;

public class GettingStartedExample {

  public static void main(String[] args) throws Exception {

    final var console = new Console();

    console.title("<-- The Pi4J Project -->", "Getting Started Example");

    var pi4j = Pi4J.newAutoContext();

    Platforms platforms = pi4j.platforms();

    console.box("Pi4J PLATFORMS");
    platforms.describe().print(System.out);
    console.println();

    Platform platform = pi4j.platform();

    console.box("Pi4J DEFAULT PLATFORM");

    try {
      platform.describe().print(System.out);
    } catch (NullPointerException e) {
      console.println("Platform object not found");
    }
    console.println();

    Providers providers = pi4j.providers();
    console.box("Pi4J PROVIDERS");
    providers.describe().print(System.out);
    console.println();

    Registry registry = pi4j.registry();

    DigitalOutput output = pi4j.dout().create(1, "my-digital-output-1");

    console.box("Pi4J REGISTRY");
    registry.describe().print(System.out);
    console.println();

    pi4j.shutdown();
  }
}
