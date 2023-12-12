public class ContainerExpolsive extends ContainerHeavy{
    
    private int certificate;
    public ContainerExpolsive(Sender sender, double tare, double netWeight, double grossWeight, String wallType, int walls,int certificate)
    {
        super(sender, tare, netWeight, grossWeight, wallType ,walls);
        this.certificate=certificate;
    }
    
    
    public int getCertificate() {
        return certificate;
    }


    

    @Override
    public String toString(){
        return "Explosive,"+" "+getSender()+" "+getTare()+" "+getNetWeight()+" "+ getGrossWeight()+" " + getWallType()+" "+ getwalls() + " "+ getCertificate();
    
}
    
}
