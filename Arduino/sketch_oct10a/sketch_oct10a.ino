#include <FastLED.h>

#define num_leds 60
#define pin 6
#define brightness 50     // can set 0-255
#define sensitivity 1     // can set 0-10, recommended at 5
CRGB leds[num_leds];

void setup() {
  FastLED.addLeds<WS2811, pin, GRB>(leds, num_leds);
  FastLED.setBrightness(brightness);
}

void loop() {
  // Turn the first led red for 1 second
  leds[0] = CRGB::Red; 
  FastLED.show();
  delay(1000);
  
  // Set the first led back to black for 1 second
  leds[0] = CRGB::Black;
  FastLED.show();
  delay(1000);
}
