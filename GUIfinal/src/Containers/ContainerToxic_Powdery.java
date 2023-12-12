public class ContainerToxic_Powdery extends ContainerHeavy{
   
   
    private int powderAmount;
    public ContainerToxic_Powdery(Sender sender, double tare, double netWeight, double grossWeight, String wallType, int walls, int powderAmount){
        
        
        super(sender, tare, netWeight, grossWeight, wallType, walls);
        this.powderAmount = powderAmount;
    }

    public int getPowderAmount() {
        return powderAmount;
    }


    @Override
    public String toString(){
        return "Toxic with powdery,"+" "+getSender()+" "+getTare()+" "+getNetWeight()+" "+ getGrossWeight() +""+ getWallType() +""+ getwalls() + " "+ getPowderAmount();
    }
}