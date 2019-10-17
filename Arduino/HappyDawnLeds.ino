#include <FastLED.h>

#define num_leds 60
#define pin 6
#define brightness 5   // can set 0-255
#define sensitivity 0     // can set 0-10, recommended at 5

CRGB leds[num_leds];

void setup() {
  FastLED.addLeds<WS2811, pin, GRB>(leds, num_leds);
  FastLED.setBrightness(brightness);
}

void loop() {

   for (int z = num_leds; z > 0; z--) {
    leds[z] =  CRGB::White ;;
  }
  FastLED.show();
  delay(3000); 
}
