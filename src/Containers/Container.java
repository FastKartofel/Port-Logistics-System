public abstract class Container implements Comparable<Container> {
    private int ID;
    private static int NUMBER=1;
    private Sender sender;
    private double tare;
    public double netWeight;
    private double grossWeight;

    public Container(Sender sender,double tare,double netWeight, double grossWeight)
    {
        this.ID=NUMBER;
        NUMBER++;
        this.tare = tare;
        this.netWeight = netWeight;
        this.grossWeight = grossWeight;
        this.sender=sender;
    }

    public Sender getSender() {
        return sender;
    }

    public double getTare() {
        return tare;
    }

    public double getNetWeight() {
        return netWeight;
    }

    public double getGrossWeight() {
        return grossWeight;
    }

    public int getID() {
        return ID;
    }

    @Override
    public int compareTo(Container o)
    {
        if(netWeight<o.netWeight)
        {
            return -1;
        }
        else if(netWeight>o.netWeight)
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }

    @Override
    public String toString(){
        return "Container"+" "+getSender()+" "+getTare()+" "+getNetWeight()+" "+ getGrossWeight();
    }

}
