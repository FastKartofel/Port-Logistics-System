public class ContainerLiquids extends Container{
    
    private int waterAmount;
    private double freshWater;

    public ContainerLiquids(Sender sender,double tare,double netWeight, double grossWeight, int waterAmount, double freshWater){

        super(sender,tare,netWeight,grossWeight);
        this.waterAmount = waterAmount;
        this.freshWater = freshWater;

    }

    public int getWaterAmount() {
        return waterAmount;
    }

    public double getFreshWater() {
        return freshWater;
    }

    @Override
    public String toString(){
        return "Liquids"+" "+getSender()+" "+getTare()+" "+getNetWeight()+" "+ getGrossWeight()+ " " + waterAmount+ " "+ freshWater;
    }
}
