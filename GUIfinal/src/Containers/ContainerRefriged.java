public class ContainerRefriged extends ContainerHeavy{

    private double electricityNeeded;
    public ContainerRefriged(Sender sender, double tare, double netWeight, double grossWeight, String wallType, int walls, double electricityNeeded)
    {
        super(sender, tare, netWeight, grossWeight , wallType, walls);
        this.electricityNeeded = electricityNeeded;
    }
    public double isElectricityNeeded() {
        return electricityNeeded;
    }
    

    @Override
    public String toString(){
        return "Refriged,"+" "+getSender()+" "+getTare()+" "+getNetWeight()+" "+ getGrossWeight()+" " + getWallType()+" "+ getwalls()+ " "+ electricityNeeded;
    
}

}
