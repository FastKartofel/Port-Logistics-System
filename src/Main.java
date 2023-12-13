
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
public static void main(String[] args){

        boolean startProgram =true;
         Scanner scannerOPT = new Scanner(System.in);
         Scanner scannerName = new Scanner(System.in);
         Scanner scannerDouble = new Scanner(System.in);
         Scanner scannerInt = new Scanner(System.in);


            List<Ship> ships2 = new ArrayList<>();
            Warehouse warehouses1 = null;
            Ship currentShip=null;
            Train train1 = null;
            Container currentContainer=null;
            
            


            while(startProgram)
            {
                System.out.println(currentShip ==null? "Current Ship : NONE" : "Current Ship : "+currentShip.toString());
                System.out.println(currentContainer ==null? "Current Container : NONE" : "Current Container : "+currentContainer.toString());
                System.out.println(train1 ==null? "Current Train : NONE" : "Current train : "+train1.toString());
                System.out.println(warehouses1 ==null? "Current warehouse : NONE" : "Warehouse: "+warehouses1.toString());

                

                System.out.println("[1] Ship");
                System.out.println("[2] Warehouse");
                System.out.println("[3] Container");
                System.out.println("[4] Train");
                if(currentShip !=null)
                {
                    System.out.println("[100] Show Ship Containers");
                }



                int opt = scannerOPT.nextInt();
                
                
                switch (opt)
                {
                     case 1:
                
                    System.out.println("[1] Add new ship");
                    System.out.println("[2] Show every ship");
                    System.out.println("[3] pick ship and add container to it");
                    System.out.println("[4] Load to warehouse");
                    System.out.println("[5] Load to train");
                    System.out.println("[6]Zaladuj konkretny kontener do magazynu"); 
                    System.out.println("[7]Zaladuj konkretny kontener do trian");
                    int new1 = scannerInt.nextInt();
                    {
                        switch (new1){
                            case 1:
                        System.out.println("Set max Explosive or toxic containers");
                        int maxContainersExploviveOrToxic = scannerInt.nextInt();
                        System.out.println("Set max heavy containers");
                        int maxContainersHeavy = scannerInt.nextInt();
                        System.out.println("Set max maxContainersRefriged");
                        int maxContainersRefriged = scannerInt.nextInt();
                        System.out.println("max containers all");
                        int maxContainersALL = scannerInt.nextInt();
                        System.out.println("max weight");
                        Double maxWeight = scannerDouble.nextDouble();
                        System.out.println("name");
                        String name = scannerName.nextLine();
                        System.out.println("port name");
                        String portName = scannerName.nextLine();
                        System.out.println("Transport origin");
                        String transportOrigin = scannerName.nextLine();
                        System.out.println("destionation");
                        String destination = scannerName.nextLine();
                        ships2.add(new Ship(maxContainersExploviveOrToxic,maxContainersHeavy,maxContainersRefriged,maxContainersALL,maxWeight,name,portName,transportOrigin,destination));
                        currentShip = new Ship(maxContainersExploviveOrToxic,maxContainersHeavy,maxContainersRefriged,maxContainersALL,maxWeight,name,portName,transportOrigin,destination);
                      
                        break;


                            case 2:
                        
                        int index = 0;
                        for (Ship ship:ships2)
                        {
                            System.out.println("["+index+"] "+ship.toString());
                            index++;
                        }
                        int shipIndex = scannerInt.nextInt();
                        System.out.println(ships2.get(shipIndex));

                        
                        
                        break;

                       


                        case 3:
                        int index1 =0;
                        for (Ship ship:ships2)
                        {
                            System.out.println("["+index1+"] "+ship.toString());
                            index1++;
                        }
                        int shipIndex1 = scannerInt.nextInt();
                     
                        
                        currentShip=ships2.get(shipIndex1);
                        
                        break;


                        case 4:
                        if(warehouses1!=null && currentShip !=null){
                            currentShip.StartTransportTo(warehouses1);

                        }
                        else{
                            System.out.println("Didint pick magazine or ship");
                        }
                        break;

                        case 5:
                        if(train1!=null && currentShip !=null){
                            currentShip.StartTransportTo(train1);

                        }
                        else{
                            System.out.println("Didint pick magazine or ship");
                        }
                            break;



                        
                        case 6:
                        if(currentShip==null ||  warehouses1==null || currentShip.containerList ==null ){
                           
                        for(int i=0; i<currentShip.containerList.size(); i++){
                            System.out.println("["+i+"]"+currentShip.containerList.get(i));

                        }
                        System.out.println("wybierz kontener");
                        int con = scannerInt.nextInt();

                        currentShip.transportTo(warehouses1, currentShip.containerList.get(con));
                    }
                        break;

                        default:
                        System.out.println("Blad zle liczby ");
                       break;
                    }
                    //mozliwe ze tu brake
             }
                break;

                  case 2:
                    System.out.println("[1] Create warehouse");
                    System.out.println("[2] add container to warehouse");
                    System.out.println("[3] show containers in warehouse");
                    int new2 = scannerInt.nextInt();
                        switch(new2){
                            case 1:
                         System.out.println("set warehouse name");
                        String name = scannerName.nextLine();
                        System.out.println("set warehouse max containers");
                        int max = scannerInt.nextInt();
                        warehouses1=(new Warehouse(name, max));
                        
                        break;

                        case 2:
                        
                        if(currentContainer==null){
                            System.out.println("no container was selected");
                        }
                        else{
                            warehouses1.Load(currentContainer);
                        }
                        
                        break;

                        case 3:
                       
                        if(warehouses1==null){
                            System.out.println("there is no magazine");
                        }
                        else{
                            warehouses1.showWarehouse();
                        }
                     

                        break;

                        default:
                        System.out.println("error bad numbers inserted ");
                        break;
                        }
                    break;
             case 3:
                        System.out.println("[1] create container");
                      System.out.println("[2] current containers");
                      
                      int new3 = scannerInt.nextInt();
                        switch(new3){
                            case 1:
                            System.out.println("[1] Container standard");
                            System.out.println("[2] Container heavy");      
                            System.out.println("[3] Container explosive");
                            System.out.println("[4] Container Toxic_Powdery");
                            System.out.println("[5] Container Toxic_Liquids");
                            System.out.println("[6] Container Refriged");
                            System.out.println("[7] Container Liquids");

                            System.out.println("[33] show containers on the ship");

                            int new4 = scannerInt.nextInt();
                                  switch(new4){

                                        case 1:
                                        System.out.println("Set sender name");
                                         
                                        String name = scannerName.nextLine();
                                        System.out.println("Set sender lastname");       
                                         
                                        String lastName = scannerName.nextLine();   
                                        System.out.println("set sender PESEL");


                                        String pesel= scannerName.nextLine();
                                        
                                        String birtDate = scannerName.nextLine();
                                        System.out.println("set senders birth date");
                                         

                                        Sender sender = new Sender(name, lastName, pesel, birtDate);
                                       
                                        
                                        System.out.println("set tare");
                                        double tare = scannerDouble.nextDouble();
                                        
                                       
                                        System.out.println("set net weight");
                                        double netWeight = scannerDouble.nextDouble();
                                       

                                        System.out.println("set gross weight");
                                        double grossWeight = scannerDouble.nextDouble();


                                        System.out.println("podaj typ sciany");
                                        String wallType = scannerName.nextLine(); 

                                       // ContainerStandard CS = new ContainerStandard(sender, tare, netWeight,grossWeight, wallType);
                                        //currentContainer = CS;

                                      
                                       ContainerStandard CS = new ContainerStandard(sender, tare, netWeight,grossWeight, wallType);
                                       currentContainer = CS;
                                       
                                       
                                           
                                  

                                       

                                    break;

                                        case 2:
                                        System.out.println("Set sender name");
                                         
                                        String name1 = scannerName.nextLine();
                                        System.out.println("Set sender lastname");       
                                         
                                       String lastName1 = scannerName.nextLine();   
                                       System.out.println("set sender PESEL");

                                       
                                         
                                        String PESEL= scannerName.nextLine();

                                        
                                        System.out.println("set senders birth date");
                                        String birtDate1 = scannerName.nextLine();

                                        
                                        Sender sender1 = new Sender(name1, lastName1, PESEL, birtDate1);
                                        
                                       
                                        System.out.println("set tare");
                                        double tare1 = scannerDouble.nextDouble();

                                        System.out.println("set net weight");
                                        double netWeight1 = scannerDouble.nextDouble();

                                        System.out.println("set gross weight");
                                        double grossWeight1 = scannerDouble.nextDouble();


                                        System.out.println("podaj typ sciany");
                                        String wallType1 = scannerName.nextLine(); 

                                        System.out.println("Set walls");
                                        int walls = scannerInt.nextInt();

                                        
                                        ContainerHeavy CH = new ContainerHeavy(sender1, tare1, netWeight1, grossWeight1, wallType1, walls);
                                        currentContainer = CH;
                                       

                                    break;


                                        case 3:
                                        System.out.println("Set sender name");
                                         
                                        String name3 = scannerName.nextLine();
                                        System.out.println("Set sender lastname");       
                                         
                                       String lastName3 = scannerName.nextLine();   
                                       System.out.println("set sender PESEL");
                                       String PESEL3= scannerName.nextLine();
                                         
                                       System.out.println("set senders birth date");
                                       String birtDate2 = scannerName.nextLine();

                                    
                                        Sender sender3 = new Sender(name3, lastName3, PESEL3, birtDate2);
                                       
                                        System.out.println("set tare");
                                        double tare3 = scannerDouble.nextDouble();

                                        System.out.println("set net weight");
                                        double netWeight3 = scannerDouble.nextDouble();

                                        System.out.println("set gross weight");
                                        double grossWeight3 = scannerDouble.nextDouble();


                                        System.out.println("podaj typ sciany");
                                        String wallType3 = scannerName.nextLine(); 

                                       
                                        

                                        System.out.println("Set walls");
                                        int walls3 = scannerInt.nextInt();

                                        System.out.println("Set certificates");
                                        int certificate = scannerInt.nextInt();



                                        ContainerExpolsive CE = new ContainerExpolsive(sender3, tare3, netWeight3, grossWeight3, wallType3, walls3, certificate);
                                        currentContainer = CE;

                                    break;

                                        case 4:

                                        System.out.println("Set sender name");
                                         
                                        String name4 = scannerName.nextLine();
                                        System.out.println("Set sender lastname");       
                                         
                                       String lastName4 = scannerName.nextLine();   
                                       System.out.println("set sender PESEL");
                                         
                                        String PESEL4= scannerName.nextLine();

                                        System.out.println("set senders birth date");
                                        String birtDate3 = scannerName.nextLine();

                                        Sender sender4 = new Sender(name4, lastName4, PESEL4, birtDate3);
                                       
                                        System.out.println("set tare");
                                        double tare4 = scannerDouble.nextDouble();

                                        System.out.println("set net weight");
                                        double netWeight4 = scannerDouble.nextDouble();

                                        System.out.println("set gross weight");
                                        double grossWeight4 = scannerDouble.nextDouble();


                                        System.out.println("podaj typ sciany");
                                        String wallType4 = scannerName.nextLine(); 

                                        System.out.println("Set walls");
                                        int walls4 = scannerInt.nextInt();

                                        System.out.println("Set powder amount");
                                        int powderAmount = scannerInt.nextInt();

                                        
                                        ContainerToxic_Powdery CTP = new ContainerToxic_Powdery(sender4, tare4, netWeight4, grossWeight4, wallType4, walls4, powderAmount);
                                        currentContainer= CTP;

                                    break;

                                        case 5:
                                        
                                        System.out.println("Set sender name");
                                         
                                        String name5 = scannerName.nextLine();
                                        System.out.println("Set sender lastname");       
                                         
                                        String lastName5 = scannerName.nextLine();   
                                        System.out.println("set sender PESEL");
                                         
                                        String pesel5= scannerName.nextLine();

                                        System.out.println("set senders birth date");
                                        String birtDate4 = scannerName.nextLine();

                                        Sender sender5 = new Sender(name5, lastName5, pesel5, birtDate4);
                                       
                                        System.out.println("set tare");
                                        double tare5 = scannerDouble.nextDouble();

                                        System.out.println("set net weight");
                                        double netWeight5 = scannerDouble.nextDouble();

                                        System.out.println("set gross weight");
                                        double grossWeight5 = scannerDouble.nextDouble();

                                        System.out.println("podaj typ sciany");
                                        String wallType5 = scannerName.nextLine(); 

                                        System.out.println("Set walls");
                                        int walls5 = scannerInt.nextInt();

                                        System.out.println("Set water Heat");
                                        int waterheat = scannerInt.nextInt();
                                        System.out.println("Set water amount");
                                        int waterAmount1 = scannerInt.nextInt();

                                        ContainerToxic_Liquids CTL = new ContainerToxic_Liquids(sender5, tare5, netWeight5, grossWeight5, wallType5, walls5, waterheat, waterAmount1);
                                        currentContainer= CTL;

                                        

                                    break;

                                        case 6:

                                        System.out.println("Set sender name");
                                         
                                        String name6 = scannerName.nextLine();
                                        System.out.println("Set sender lastname");       
                                         
                                       String lastName6 = scannerName.nextLine();   
                                       System.out.println("set sender PESEL");
                                         
                                        String PESEL6= scannerName.nextLine();


                                        System.out.println("set senders birth date");
                                        String birtDate7 = scannerName.nextLine();

                                        Sender sender6 = new Sender(name6, lastName6, PESEL6, birtDate7);
                                       
                                        System.out.println("set tare");
                                        double tare6 = scannerDouble.nextDouble();

                                        System.out.println("set net weight");
                                        double netWeight6 = scannerDouble.nextDouble();

                                        System.out.println("set gross weight");
                                        double grossWeight6 = scannerDouble.nextDouble();


                                        System.out.println("podaj typ sciany");
                                        String wallType6 = scannerName.nextLine(); 

                                        System.out.println("Set walls");
                                        int walls6 = scannerInt.nextInt();

                                        System.out.println("electricity needed");
                                        double electricity = scannerDouble.nextDouble();

                                        
                                        ContainerRefriged CR = new ContainerRefriged(sender6, tare6, netWeight6, grossWeight6, wallType6, walls6, electricity);
                                        currentContainer = CR;

                                    break;

                                        case 7:

                                       System.out.println("Set sender name");
                                         
                                        String name7 = scannerName.nextLine();
                                        System.out.println("Set sender lastname");       
                                         
                                       String lastName7 = scannerName.nextLine();   
                                       System.out.println("set sender PESEL");
                                         
                                        String PESEL7= scannerName.nextLine();

                                        System.out.println("set senders birth date");
                                        String birtDate8 = scannerName.nextLine();

                                        Sender sender7 = new Sender(name7, lastName7, PESEL7, birtDate8);
                                       
                                        System.out.println("set tare");
                                        double tare7 = scannerDouble.nextDouble();

                                       System.out.println("set net weight");
                                        double netWeight7 = scannerDouble.nextDouble();

                                        System.out.println("set gross weight");
                                       double grossWeight7 = scannerDouble.nextDouble();

                                     System.out.println("Water amount");
                                        int waterAmount = scannerInt.nextInt();

                                       System.out.println("Fresh water?");
                                       double freshWater = scannerDouble.nextDouble();




                                        ContainerLiquids  CL= new ContainerLiquids(sender7, tare7, netWeight7, grossWeight7, waterAmount, freshWater);
                                        currentContainer = CL; 
                                      

                                        

                                    break;
                                        
                                    default:
                                    System.out.println("You entered wrong number");

                                    break;
                                  
                                 } 
                                 

                                break;


                                 

                                 case 2:

                                 if(currentContainer==null){
                                    System.out.println("There is no container");
                                }
                                else{
                                    System.out.println(currentContainer);
                                }
                                
                             
        
                                break;

                                default:
                                System.out.println("something went wrong");

                                break;

                     }

                     break;

                     case 4:
                     System.out.println("[1] Create new train");
                      System.out.println("[2] Add container to train");
                      System.out.println("[3] Show containers on train");
                      
                      int new4 = scannerInt.nextInt();
                            switch(new4){
                                case 1:
                                System.out.println("set train name");
                                String name = scannerName.nextLine();
                                System.out.println("set train quantity");
                                int wagonQuantity = scannerInt.nextInt();
                                train1=(new Train(name, wagonQuantity));
                                break;

                                case 2:
                                if(currentContainer==null){
                                    System.out.println("no container avaiable");
                                }
                                else{
                                    train1.Load(currentContainer);
                                }
                                
                                break;

                                case 3:
                                if(train1==null){
                                    System.out.println("there are no containers on train");
                                }
                                else{
                                    train1.showTrain();
                                }

                                break;

                                default:
                                System.out.println("No containers on train");


                            }
                        

                            default:
                            System.out.println("You have entered a wrong number");

                            break;
            


                       }

            }
            scannerOPT.close();
            scannerName.close();  
            scannerDouble.close();
            scannerInt.close();
        
    }

  
    
}
