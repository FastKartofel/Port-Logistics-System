public class ContainerToxic_Liquids extends ContainerHeavy{

    private int waterHeat;
    private int waterAmount; 


    public ContainerToxic_Liquids(Sender sender, double tare, double netWeight, double grossWeight, String wallType, int walls, int waterHeat, int waterAmount){
        
        super(sender, tare, netWeight, grossWeight, wallType, walls);
        this.waterHeat=waterHeat;
        this.waterAmount=waterAmount;

    }

    public int getWaterHeat() {
        return waterHeat;
    }

    public int getWaterAmount() {
        return waterAmount;
    }


    @Override
    public String toString(){
        return "Toxic with Liquids,"+" "+getSender()+" "+getTare()+" "+getNetWeight()+" "+ getGrossWeight()+" "+ getwalls()+ " "+ waterHeat+" "+ waterAmount;
    }
}