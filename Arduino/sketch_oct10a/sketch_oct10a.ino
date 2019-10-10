#include <FastLED.h>

#define num_leds 5
#define pin 6
#define brightness 50     // can set 0-255
#define sensitivity 5     // can set 0-10, recommended at 5
CRGB leds[num_leds];

void setup() {
  FastLED.addLeds<WS2811, pin>(leds, num_leds);
  FastLED.setBrightness(brightness);
}

void loop() {
  for(int i = 0; i < num_leds-1; i++) { 
    leds[i] = CRGB(255,255,255); 
  }
  delay(1000);
}
