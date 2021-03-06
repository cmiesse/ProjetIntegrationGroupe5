#include <Adafruit_NeoPixel.h>
#include <Arduino.h>
#include <SPI.h>
#include <SD.h>
//#include "Adafruit_BLE.h"
//#include "Adafruit_BluefruitLE_SPI.h"
//#include "Adafruit_BluefruitLE_UART.h"
//#include <ArduinoJson.h>
//#include <Volume.h>
//#include <SimpleSDAudio.h>
#define SD_ChipSelectPin 10  //using digital pin 4 on arduino nano 328, can use other pins
#include <TMRpcm.h>           //  also need to include this library...


//#include "BluefruitConfig.h"

#if SOFTWARE_SERIAL_AVAILABLE
#include <SoftwareSerial.h>
#endif
#define PIN 6
/*=========================================================================
    APPLICATION SETTINGS

      FACTORYRESET_ENABLE       Perform a factory reset when running this sketch
     
                                Enabling this will put your Bluefruit LE module
                              in a 'known good' state and clear any config
                              data set in previous sketches or projects, so
                                running this at least once is a good idea.
     
                                When deploying your project, however, you will
                              want to disable factory reset by setting this
                              value to 0.  If you are making changes to your
                                Bluefruit LE device via AT commands, and those
                              changes aren't persisting across resets, this
                              is the reason why.  Factory reset will erase
                              the non-volatile memory where config data is
                              stored, setting it back to factory default
                              values.
         
                                Some sketches that require you to bond to a
                              central device (HID mouse, keyboard, etc.)
                              won't work at all with this feature enabled
                              since the factory reset will clear all of the
                              bonding data stored on the chip, meaning the
                              central device won't be able to reconnect.
    MINIMUM_FIRMWARE_VERSION  Minimum firmware version to have some new features
    MODE_LED_BEHAVIOUR        LED activity, valid options are
                              "DISABLE" or "MODE" or "BLEUART" or
                              "HWUART"  or "SPI"  or "MANUAL"
    -----------------------------------------------------------------------*/
#define FACTORYRESET_ENABLE         0
#define MINIMUM_FIRMWARE_VERSION    "0.6.6"
#define MODE_LED_BEHAVIOUR          "MODE"
/*=========================================================================*/

// Create the bluefruit object, either software serial...uncomment these lines
Adafruit_NeoPixel strip = Adafruit_NeoPixel(33, PIN, NEO_GRB + NEO_KHZ800);
//SoftwareSerial bluefruitSS = SoftwareSerial(BLUEFRUIT_SWUART_TXD_PIN, BLUEFRUIT_SWUART_RXD_PIN);

//Adafruit_BluefruitLE_UART ble(bluefruitSS, BLUEFRUIT_UART_MODE_PIN,
//                      BLUEFRUIT_UART_CTS_PIN, BLUEFRUIT_UART_RTS_PIN);


/* ...or hardware serial, which does not need the RTS/CTS pins. Uncomment this line */
// Adafruit_BluefruitLE_UART ble(Serial1, BLUEFRUIT_UART_MODE_PIN);

/* ...hardware SPI, using SCK/MOSI/MISO hardware SPI pins and then user selected CS/IRQ/RST */
//Adafruit_BluefruitLE_SPI ble(BLUEFRUIT_SPI_CS, BLUEFRUIT_SPI_IRQ, BLUEFRUIT_SPI_RST);

/* ...software SPI, using SCK/MOSI/MISO user-defined SPI pins and then user selected CS/IRQ/RST */
//Adafruit_BluefruitLE_SPI ble(BLUEFRUIT_SPI_SCK, BLUEFRUIT_SPI_MISO,
//                             BLUEFRUIT_SPI_MOSI, BLUEFRUIT_SPI_CS,
//                             BLUEFRUIT_SPI_IRQ, BLUEFRUIT_SPI_RST);


// A small helper
void error(const __FlashStringHelper*err) {
  Serial.println(err);
  while (1);
}

// Global variables
TMRpcm tmrpcm;
boolean debug = false;
char state = 'z';
long alarmDelay = 24;
long colorHSV = 61000;
int maxLights = 255;  // Max value = 255
const int SCHEDULE = 6; //normal value = 60

int maxSound = 150;
boolean startedLoop = false;
int duree = 30 ;
boolean initSdPlay = false;

String fileSoundS;
char fileSound[50]  ;  //  default  "oiseaux1.wav"

String msg ;
// Plug your speaker into the default pin for your board type:

void setup(void)
{


  Serial.begin(9600);

  tmrpcm.speakerPin = 9;
  if (!SD.begin(SD_ChipSelectPin)) {  // see if the card is present and can be initialized:
    Serial.println("SD fail");
    return;   // don't do anything more if not

  }
  else {
    Serial.println("SD ok");
  }

  turnOffLights();


  //  pinMode(5, OUTPUT);//buzzer
  changeState('z');
  strip.begin();
  strip.show();
  while (!Serial);  // required for Flora & Micro
  delay(500);


  Serial.println(F("during setup"));

  /*
    Serial.begin(115200);
    Serial.println(F("Adafruit Bluefruit Command Mode Example"));
    Serial.println(F("---------------------------------------"));
  */
  /* Initialise the module */
  //Serial.print(F("Initialising the Bluefruit LE module: "));
  /*
    if ( !ble.begin(VERBOSE_MODE) )
    {
      error(F("Couldn't find Bluefruit, make sure it's in CoMmanD mode & check wiring?"));
    }
    Serial.println( F("OK!") );
  */
  /*
    if ( FACTORYRESET_ENABLE )
    {
      /* Perform a factory reset to make sure everything is in a known state
      Serial.println(F("Performing a factory reset: "));
      if ( ! ble.factoryReset() ){
        error(F("Couldn't factory reset"));
      }
    }

    /* Disable command echo from Bluefruit */
  //  ble.echo(false);

  //Serial.println("Requesting Bluefruit info:");
  /* Print Bluefruit information */
  // ble.info();

  //Serial.println(F("Please use Adafruit Bluefruit LE app to connect in UART mode"));
  //Serial.println(F("Then Enter characters to send to Bluefruit"));
  //Serial.println();

  //  ble.verbose(false);  // debug info is a little annoying after this point!

  /* Wait for connection */
  /*
    while (! ble.isConnected()) {
      delay(500);
    }


    // LED Activity command is only supported from 0.6.6
    if ( ble.isVersionAtLeast(MINIMUM_FIRMWARE_VERSION) )
    {
    // Change Mode LED Activity
    Serial.println(F("******************************"));
    Serial.println(F("Change LED activity to " MODE_LED_BEHAVIOUR));
    ble.sendCommandCheckOK("AT+HWModeLED=" MODE_LED_BEHAVIOUR);
    Serial.println(F("******************************"));
    }
  */

  /*
      StaticJsonDocument<256> doc;
    char sampleMsg[] = "{\"Key1\":30,\"Key2\":\"subKey21\":\"a\",\"subKey21\":61000}}";
    DeserializationError errorD = deserializeJson(doc, sampleMsg);

    // Test if parsing succeeds.
    if (errorD) {
      Serial.print(F("deserializeJson() failed: "));
      Serial.println(errorD.c_str());
      return;
    }
    // JsonObject root = doc.as<JsonObject>();
    String key1 = doc["Key1"];
    Serial.println(key1);
  */

}


boolean parseJson(String json) {

  /*
    StaticJsonDocument<240> doc;


    DeserializationError error = deserializeJson(doc, json);

    // Test if parsing succeeds.
    if (error) {
      Serial.print(F("deserializeJson() failed: "));
      Serial.println(error.c_str());
      return false;
    }

    // Fetch values.
    //
    // Most of the time, you can rely on the implicit casts.
    // In other case, you can do doc["time"].as<long>();
    colorHSV = doc["l"]["c"];
    alarmDelay = doc["t"];

    Serial.print("alarmDelay [sec] ");
    Serial.println(alarmDelay);

    maxLights = doc["l"]["M"];
    maxSound = doc["s"]["M"];
    fileSound = doc["s"]["f"];
    duree = doc["l"]["d"];
  */
  printConsole("initial json", msg);
  msg = msg.substring(1, msg.length() - 2);
  printConsole("cleaned json", msg);

  int indexL = 0;
  int indexR = msg.indexOf(',');
  alarmDelay = parseValue(getValue(msg.substring(indexL, indexR), "t", false));
  printConsole("alarmDelay", alarmDelay);
  indexL = indexR + 5;
  indexR = msg.indexOf(',', indexL);
  colorHSV = parseValue(getValue(msg.substring(indexL, indexR), "c", false));
  printConsole("colorHSV", colorHSV);
  indexL = indexR + 1;
  indexR = msg.indexOf(',', indexL);
  maxLights = parseValue(getValue(msg.substring(indexL, indexR), "M", false));
  printConsole("maxLights", maxLights);
  indexL = indexR + 1;
  indexR = msg.indexOf('}', indexL);
  duree = parseValue(getValue(msg.substring(indexL, indexR), "d", false));
  printConsole("duree", duree);
  indexL = indexR + 6;
  indexR = msg.indexOf(',', indexL);
  fileSoundS = getValue(msg.substring(indexL, indexR), "f", true);
  printConsole("fileSoundS", fileSoundS);
  //fileSound = fileSounds.c_str();
  // fileSoundS = string2char(fileSoundS);
  fileSoundS.toCharArray(fileSound, fileSoundS.length()+1);
  //fileSound[fileSoundS.length()+1] = '\0';

  printConsole("fileSound", fileSound);
  indexL = indexR + 1;
  indexR = msg.indexOf('}', indexL);
  maxSound =  parseValue(getValue(msg.substring(indexL, indexR), "M", false));
  printConsole("maxSound", maxSound);

  // pas vraiment de validation JSON
  return true;
}



void printConsole(String champ, String valeur) {
  if (debug) {
    Serial.print(champ);
    Serial.print(" ");
    Serial.println(valeur);
  }
}


char* string2char(String command) {
  if (command.length() != 0) {
    char *p = const_cast<char*>(command.c_str());
    return p;
  }
}


void printConsole(String champ, int valeur) {
  if (debug) {
    Serial.print(champ);
    Serial.print(" ");
    Serial.println(valeur);
  }
}

void printConsole(String champ, char* valeur) {
  if (debug) {
    Serial.print(champ);
    Serial.print(" ");
    int i = 0;
    while (valeur[i]) {
      Serial.print(valeur[i]);
      i++;
    }
    Serial.println("");
  }
}


int parseValue(String value) {
  return value.toInt();
}

String getValue(String frag, String key, boolean guillemets) {

  int points2 = frag.indexOf(':');
  if (guillemets) {
    return frag.substring(1 + points2+1,frag.length()-1);
  } else {
    return frag.substring(1 + points2);
  }

}

/**************************************************************************/
/*!
    @brief  Constantly poll for new command or response data
*/
/**************************************************************************/
void loop(void)
{
  if (!startedLoop) {
    Serial.println("first iter in loop");
    startedLoop = true;
  }


  if (state == 'z') {

    // Check for user input
    /*
      char inputs[BUFSIZE+1];

      if ( getUserInputs(inputs, BUFSIZE) )
      {
      // Send characters to Bluefruit
      Serial.print("[Send] ");
      Serial.println(inputs);

      ble.print("AT+BLEUARTTX=");
      ble.println(inputs);

      // check response stastus
      if (! ble.waitForOK() ) {
        Serial.println(F("Failed to send?"));
      }
      }
    */

    // Check for incoming characters from Bluefruit
    /*
      ble.println("AT+BLEUARTRX");
      ble.readline();
      if (strcmp(ble.buffer, "OK") == 0) {
      // no data
      return;
      }*/
    // Some data was found, its in the buffer
    if (Serial.available() > 0) {
      String msgFromApp = Serial.readString();
      msgFromApp.replace("\n", "");
      msgFromApp.replace("\r", "");
      if (msgFromApp.length() > 0) {
        Serial.print(F("[Recv] "));
        Serial.println(msgFromApp);
      }
      //Serial.println(ble.buffer);
      msg = msg + msgFromApp;
      if (msgFromApp.endsWith(".")) {
        msg = msg.substring(0, msg.length() - 1);
        msgFromApp = "";
        boolean parsingOK = parseJson(msg);
        msg = "";

        if (parsingOK) {
          changeState('s');
          //state = 's';

        }

      }
      msgFromApp = "";
    }


    //Serial.print(F("[leds] "));  Serial.println(leds);

    //  ble.waitForOK();
  }

  if (state == 's') {
    if (alarmDelay > SCHEDULE) {
      //Serial.println("sleeping ... sec");
      Serial.print('.');
      delay(SCHEDULE * 1000);

      alarmDelay = alarmDelay - SCHEDULE;
      //Serial.println(alarmDelay);


    }
    if ((alarmDelay <= SCHEDULE) && (alarmDelay >= 0)) {
      changeState('r');
      //state = 'r';
      alarmDelay = -1;
    }
  }
  if (state == 'r') {
    brighten();
    turnOffLights();
    changeState('z');
    //state = 'z';
  }
}

void changeState(char newState) {
  state = newState;
  Serial.print("new state is now ");
  Serial.println(state);
}

void brighten() {

  Serial.print("duree : ");
  Serial.println(duree);



  long deltaTime = (((long)duree) * 1000) / maxLights;
  Serial.print("deltatime : ");
  Serial.println(deltaTime);
  uint16_t i, j;
  uint64_t a, b , c;
  a = 61000 ;
  b = 255;
  c = 0;

  // for (j = 0; j < 255; j++) {
  for (c ; c < maxLights; c++) {
    uint32_t rgbcolor = strip.ColorHSV(colorHSV, b, c);
    for (i = 0; i < strip.numPixels(); i++) {

      strip.fill(rgbcolor);
    }
    strip.show();
    delay(deltaTime); // to put 1000
  }

  // Serial.println("starting sound");

  //  String fileSoundStr = String(fileSound);
  //  int singNumber = fileSoundStr.toInt();

  // sing(singNumber);
  //tone(440, 15);

  Serial.print("starting sound ");
  Serial.println(fileSoundS);
  tmrpcm.play(fileSound);
  // turnOffLights();
  /*
    if (!initSdPlay) {
    Serial.println("starting init sound");
    SdPlay.setSDCSPin(10); // sd card cs pin

    if (!SdPlay.init(SSDA_MODE_FULLRATE | SSDA_MODE_MONO | SSDA_MODE_AUTOWORKER))
    {
      longDelay();
    }

    initSdPlay = true;
    Serial.println("stopping init sound");
    }

    if (!SdPlay.setFile(fileSound)) // music name file
    {
    longDelay();
    //while (1);

    }

    Serial.println("starting playing sound");

    SdPlay.play();
    SdPlay.play();
  */

  delay(1000);

}

void longDelay() {
  Serial.println("starting longDelay");
  delay(30000);
  Serial.println("longDelay stopped");
}

//
void turnOffLights() {
  uint32_t rgbcolorOff = strip.ColorHSV(0, 0, 0);
  for (int i = 0; i < strip.numPixels(); i++) {

    strip.fill(rgbcolorOff);
  }
  strip.show();
}


/**************************************************************************/
/*!
    @brief  Checks for user input (via the Serial Monitor)
*/
/**************************************************************************/

/*
  bool getUserInputs(char buffer[], uint8_t maxSize)
  {
  // timeout in 100 milliseconds
  //TimeoutTimer timeout(100);

  memset(buffer, 0, maxSize);
  while( (!Serial.available()) && !timeout.expired() ) { delay(1); }

  // if ( timeout.expired() ) return false;

  delay(2);
  uint8_t count=0;
  do
  {
    count += Serial.readBytes(buffer+count, maxSize);
    delay(2);
  } while( (count < maxSize) && (Serial.available()) );

  return true;
  }
*/
