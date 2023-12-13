import java.util.ArrayList;
import java.util.List;



public class Ship implements ITransport, Comparable<Ship>
{


    private int maxContainersExploviveOrToxic=3;
    private int currentContainersExplosiveOrToxic;

    private int maxContainersHeavy;
    private int currentContainersHeavy;

    private int maxContainersRefriged;
    private int currentContainersRefriged;

    private int maxContainersALL;
    private int currentContainersALL;

    private double maxWeight;
    private double currentWeight;


    private String name;
    private int ID;
    private static int NUMBER =1;
    private String portName;
    private String transportOrigin;
    private String destination;

   

    public List<Container> containerList = new ArrayList<>();

    public Ship(int maxContainersExploviveOrToxic, int maxContainersHeavy, int maxContainersRefriged, int maxContainersALL,
            double maxWeight, String name, String portName, String transportOrigin, String destination) {
        this.maxContainersExploviveOrToxic = currentContainersExplosiveOrToxic;
        this.maxContainersHeavy = maxContainersHeavy;
        this.maxContainersRefriged = maxContainersRefriged;                   
        this.maxContainersALL = maxContainersALL;
        this.maxWeight = maxWeight;
        this.setName(name);
        this.portName = portName;
        this.transportOrigin = transportOrigin;
        this.destination = destination;
        
        this.ID=NUMBER;
        NUMBER++;

    }

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getID() {
        return ID;
    }
    public String getPortName() {
        return portName;
    }
    public String getTransportOrigin() {
        return transportOrigin;
    }
    public String getDestination() {
        return destination;
    }

    
    @Override
    public boolean canILoad(Container container){


        if(container.getClass().equals(ContainerExpolsive.class)){
                if(currentContainersExplosiveOrToxic+1>maxContainersExploviveOrToxic){

                    System.out.println("Error to many toxic and explosive containers");                                  
                    return false;

                }
                else{
                    currentContainersExplosiveOrToxic++;
                    return true;
                }
            }

        if(container.getClass().equals(ContainerToxic_Liquids.class)){
            if(currentContainersExplosiveOrToxic+1>maxContainersExploviveOrToxic){

                System.out.println("Error to many toxic and explosive containers");                                  
                return false;

            }
            else{
                currentContainersExplosiveOrToxic++;
                return true;
            }

        }
        if(container.getClass().equals(ContainerToxic_Powdery.class)){
            if(currentContainersExplosiveOrToxic+1>maxContainersExploviveOrToxic){

                System.out.println("Error to many toxic and explosive containers");                                  
                return false;

            }
            else{
                currentContainersExplosiveOrToxic++;
                return true;
            }
        }


        if(container.getClass().equals(ContainerHeavy.class))
        {
            if(currentContainersHeavy+1>maxContainersHeavy){
                System.out.println("To many heavy containers");
                return false;
            }
            else
            {
                currentContainersHeavy++;
                return true;
            }
        }
        if(container.getClass().equals(ContainerRefriged.class)){
            if(currentContainersRefriged+1>maxContainersRefriged){
                System.out.println("to many refriged containers");
            }
            else{
                currentContainersRefriged++;
            }
        }
              
        if(container.getGrossWeight()+currentWeight>maxWeight){
                return false;

            }
            return false;




    }

    @Override
    public boolean Load(Container container)
    {
        if(canILoad(container)){
            System.out.println("load");
            containerList.add(container);
            return true;
        }else{

            return false;
        }
    }
    @Override
    public void unLoad(Container container)
    {
        containerList.remove(container);
        if(container.getClass().equals(ContainerRefriged.class))
        {
            currentContainersRefriged--;
            currentContainersALL--;
        }
        if(container.getClass().equals(ContainerHeavy.class)){
            currentContainersHeavy--;
            currentContainersALL--;
            
        }
        if(container.getClass().equals(ContainerExpolsive.class) || container.getClass().equals(ContainerToxic_Liquids.class) || container.getClass().equals(ContainerToxic_Powdery.class) ){
            currentContainersExplosiveOrToxic--;
            currentContainersALL--;
        }

    }

    @Override
    public int compareTo(Ship o)
    {
        return getName().compareTo(o.getName());
    }

    @Override
    public void StartTransportTo(ITransport type) 
    {
        if(type.getClass().equals(Train.class))
        {
            Train train = (Train) type;
            int index = 0;
            List<Container> forUnLoad = new ArrayList<>();
            while(index<containerList.size() && !train.isTrainFull())
            {
                if(!train.Load(containerList.get(index))) 
                {
                    while(train.stockChange.isAlive()) 
                    {
                            
                    }
                    train.Load(containerList.get(index));
                    index++;
                }
                else
                {
                    forUnLoad.add(containerList.get(index));
                    index++;
                }
            }
            for(Container container : forUnLoad)
            {
                unLoad(container);
            }
            if(train.isTrainFull())
            {
                System.out.println("The train is now full");
                System.out.println(containerList.size());
            }
            train.showTrain();


        }
        else
        {
            List<Container> forUnLoad = new ArrayList<>();
            for(Container container : containerList)
            {
                if(type.Load(container)) 
                {
                    forUnLoad.add(container);
                }
            }
            for(Container container: forUnLoad)
            {
                unLoad(container);
            }
        }
    }
    @Override
    public String toString() {
      return maxContainersExploviveOrToxic+" "+ maxContainersHeavy +" "+maxContainersRefriged+" "+maxContainersALL+" "+maxWeight+" "+ name+" "+ portName+" "+ transportOrigin+" "+destination;
    }

}

    
