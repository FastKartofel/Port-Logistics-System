public class ContainerStandard extends Container{

  
    private String wallType;

    public ContainerStandard(Sender sender,double tare,double netWeight, double grossWeight,String wallType)
    {
        super(sender, tare, netWeight, grossWeight);
        this.wallType=wallType;
    }

    public String getWallType() {
        return wallType;
    }
   

    @Override
    public String toString(){
        return "Standard,"+" "+getSender()+" "+getTare()+" "+getNetWeight()+" "+ getGrossWeight()+" " + getWallType();
    }
}
