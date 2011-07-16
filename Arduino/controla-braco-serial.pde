#include <Servo.h> 
 
Servo myservo1;
Servo myservo2; 
Servo myservo3; 
 
int pinServo1 = 10; 
int pinServo2 = 11; 
int pinServo3 = 9; 
int velocidade = 5;
int pos;
int entrada;
 
void setup() 
{ 
  myservo1.attach(pinServo1); 
  myservo2.attach(pinServo2); 
  myservo3.attach(pinServo3);
  
  myservo1.write(180);
  myservo2.write(0);
  myservo3.write(90);
  
  Serial.begin(9600);
} 
 
void loop() 
{ 
  if (Serial.available() > 0) {
    while (Serial.available()>0) {
      entrada = Serial.read();
      Serial.print(entrada);
      delay(1);
    }
      if (entrada == '1'){
  	sobe();
      } else if (entrada == '2'){
  	desce();
      } else if (entrada == '3'){
  	esquerda();
      } else if (entrada == '4'){
  	direita();
      } else if (entrada == '5'){
  	abre();
      } else if (entrada == '6'){
          fecha();
      } else {
            
      }
    
  }  
} 
void desce(){
  for(pos = 0; pos < 180; pos += velocidade) {                                  
    myservo1.write(pos); 
    delay(10);                      
  } 
} 
void sobe(){
  for(pos = 180; pos>=1; pos-= velocidade) {                                
    myservo1.write(pos);    
    delay(10);                       
  }  
} 
void esquerda(){
  for(pos = 0; pos < 180; pos += velocidade) {                                  
    myservo2.write(pos); 
    delay(10);                      
  } 
} 
void direita(){
  for(pos = 180; pos>=1; pos-= velocidade) {                                
    myservo2.write(pos);    
    delay(10);                       
  }  
} 
void abre(){
  for(pos = 0; pos < 90; pos += velocidade) {                                  
    myservo3.write(pos); 
    delay(10);                      
  } 
} 
void fecha(){
  for(pos = 90; pos>=1; pos-= velocidade) {                                
    myservo3.write(pos);    
    delay(10);                       
  }  
} 
