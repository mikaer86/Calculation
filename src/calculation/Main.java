package calculation;
/**
author mikrek6
date: 2022-03-04
Steg 1: Hämta användardata för datum(dag/månad).
Steg 2: Hämta användardata för soluppgång (klockslag)
Steg 3: Hämta användardata för solnedgång (klockslag).
Steg 3.1 omformatera klockslag till två strängar.
Steg 3.2 Omformatera sträng till int data
Steg 3.3 Beräkna (subtrahera och addera minuter och timmar) för start och slut tid.
Steg 4: Beräkna el-produktion (Wh / m2 / timmar) x timmar
Steg 5: beräkna elkostad
*/
import java.util.Scanner;

 class Main
 {
         
     public static void main(String[] args ) 
     {
       //create scanner object
       Scanner scan = new Scanner(System. in).useDelimiter("[: - 0-9]");
      

       // declare string input variable date
       System.out.println("Enter today's date [mm-dd]");
       String date = scan.nextLine();

     try { // try method for catching exeption error
         
       // declare string input variable sunrise
       System.out.println("Enter time of sunrise [hh:mm]");
       String sunrise = scan.nextLine();
   
       // declare string input variable sunset
       System.out.println("Enter time of sunset [hh:mm]");
       String sunset = scan.nextLine();

       //Split the formated input value
        String[] convert1 = sunrise.split(":");
       
       // convert input from string to int (sunriseHours)
       int[] sunriseHours =  new int[convert1.length];
       
       for(int i = 0; i < convert1.length; i++)
       {

         sunriseHours[i] = Integer.parseInt(convert1[i]);
          
        
       }

         // Splitting the formated input value.
        String[] convert2 = sunset.split(":");
            // convert input from string to int (sunsetHours)
        int[] sunsetHours = new int[convert2.length];

            // convert input from string to int (sunriseHours)
           for(int i = 0; i < convert2.length; i++)
           {
             sunsetHours[i] = Integer.parseInt(convert2[i]);
            

           }  

             // if sunrise minuts are greater then sunset minuts subtract and add minuts to hours

              if(sunriseHours[1] > sunsetHours[1]) 
             {     
                   
                     int addMinuts = 60 / 60;
                     int addHour = 1;

                  int subtractMinuts = sunsetHours[1] - addMinuts;
                  int addHours = sunriseHours[0] + addHour;
                  int totalHours = subtractMinuts + sunsetHours[0];
                  int totalMinuts = sunsetHours[0] - addHours ;

                  System.out.printf("================================================" + "\n");
            
                  System.out.printf(" The sun Hours: " + totalHours + " Hours and " + totalMinuts + "Minuts");

                   // calculate Solar Radiation
                          
                  double Wh = 166;
                  double m2 = 44.20;
                  //Solar panel watts x average hours of sunlight x 75% = daily watt-hours
                  double ThermalEfficiency = 0.20;
                  double SolarRadiation = (Wh / m2 / totalHours) * ThermalEfficiency * m2 * totalHours;
                  
                  double calculatePrice = 0.9 / Wh;
                  double TotalPrice = calculatePrice * totalHours;
                 
                 
               System.out.printf(" The production on " + date + " is: " + String.format("%,.2f", SolarRadiation) + " kWh to a value of " + String.format("%,.2f",TotalPrice) + " SEK");

               } 

        
              // if sunrise minuts are less then sunset minuts subtract and add minuts to hours
               else if(sunriseHours[1] < sunsetHours[1])
               {
                   int addMinuts = 60 / 60;
                     int addHour = 1;

                  int subtractHours = sunsetHours[1] - addMinuts;
                  int addHours = sunriseHours[0] + addHour;
                  int totalHours = subtractHours + sunsetHours[0];
                  int totalMinuts = sunsetHours[0] - addHours ;

                  System.out.printf("================================================" + "\n");

                  System.out.printf(" The sun hours: " + totalHours + "." + totalMinuts + " hours " + "\n");  

                 // calculate Solar Radiation

                  int Wh = 166;
                  double m2 = 44.20;
                    //calculate solar radiation
                  double ThermalEfficiency = 0.20;
                  double SolarRadiation = (Wh / m2 / totalHours) * ThermalEfficiency * m2 * totalHours;
                  
                  //calculate price
                  double calculatePrice = 0.9 / Wh;
                  double TotalPrice = calculatePrice * totalHours;
               
                 System.out.printf(" The production on " + date + " is: " + String.format("%,.2f", SolarRadiation) + " kWh to a value of " + String.format("%,.2f",TotalPrice) + " SEK");
               
               }
             

       } catch (NumberFormatException e) 
       
       {
         
       System.out.printf("Error!");
         scan.nextLine();
       
       }

       
       // close scanner object
       scan.close();

         
     } 

     
 }
