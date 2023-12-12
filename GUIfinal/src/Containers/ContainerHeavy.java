public class ContainerHeavy extends ContainerStandard{


    private int walls;                                                     
    public ContainerHeavy(Sender sender, double tare, double netWeight, double grossWeight, String wallType, int walls)
    {
        super(sender, tare, netWeight, netWeight, wallType);
        this.walls = walls;
       
        

    }
    public int getwalls() {
        return walls;
    }
    
    
   
    @Override
        public String toString(){
            return "Heavy,"+" "+getSender()+" "+getTare()+" "+getNetWeight()+" "+ getGrossWeight()+" " + getWallType()+" "+ walls;
        
    }
    
}
