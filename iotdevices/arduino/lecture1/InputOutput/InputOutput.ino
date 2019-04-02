void setup()
{
  Serial.begin(9600);
  pinMode(12, INPUT);
  pinMode(13, OUTPUT);
  pinMode(9, OUTPUT);
}

int active = 0;
int pushhandled = 0;
byte brightness = 0;
byte debug = 0;

void loop()
{
  int btn = digitalRead(12);

  if ((btn == HIGH) && (!pushhandled)) {
    
    pushhandled = 1;
    active = 1 - active;
    
    if (active)
      digitalWrite(13, HIGH);
    else {
      digitalWrite(13, LOW);
      analogWrite(9, 0);
    }
  }

  if (btn == LOW)
    pushhandled = 0;

  int potval = analogRead(A0);
  int photoval = analogRead(A1);

  if ((photoval < potval) && active) {

    brightness = min(potval - photoval, 255);
    analogWrite(9, brightness);

  } else {

    brightness = 0;
    analogWrite(9, 0);

  }

  // debugging control via serial
  if (Serial.available() > 0) {

     byte input = Serial.read();
     debug = (input == 49);
     
  }

  // debugging output via serial
  if (debug) {
    Serial.print(photoval);
    Serial.print("<");
    Serial.print(potval);
    Serial.print(":");
    Serial.print(brightness);
    Serial.println();
  }

}
