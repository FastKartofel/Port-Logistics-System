//import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;

public class Train implements ITransport
{
    public String name;

    public int wagonQuantity;

    public List<Wagon> wagonList; 

    public int currentStock; 

    public boolean isStockChanging;

    public Thread stockChange;

    public Train(String name, int wagonQuantity)
    {
        this.name=name;
        this.wagonQuantity=wagonQuantity;
        this.wagonList=new ArrayList<>();
        this.currentStock=0;
        this.isStockChanging=false;
        for (int i = 1; i <= wagonQuantity; i++) {
            wagonList.add(new Wagon(i));
        }

        this.stockChange=stockThread();
    }

    public Thread stockThread()
    {

        Thread a = new Thread()
        {
            @Override
            public void run()
            {
                System.out.println("Stock changing now ..");
                try {
                    Thread.sleep(30000);
                } catch (InterruptedException e) {
                    System.err.println(e.getMessage());
                }
                System.out.println("Stock is changed");
                currentStock++;
                stockChange=stockThread();
            }
        };
        return a;
    }
    public boolean isTrainFull()
    {
        for(Wagon wagon: wagonList)
        {
            if(!wagon.isFull())
                return false;
        }
        return true;
    }



    @Override
    public boolean canILoad(Container container)
    {
        if(isTrainFull())
            return false;

        if(wagonList.get(currentStock).isFull() && !stockChange.isAlive())  
        {
            stockChange.start();
            return false;
        }
        if(stockChange.isAlive()) 
        {
            return false;
        }
        return true;
    }

    @Override
    public boolean Load(Container container)
    {
        if(canILoad(container))
        {
            wagonList.get(currentStock).loadOnWagon(container);
            return true;
        }
        else
        {
            return false;
        }
    }
    public void showTrain()
    {
        for (Wagon wagon: wagonList)
        {
            System.out.println(wagon.containerList1.size());
        }
    }

    @Override
    public void unLoad(Container container)
    {
        // we dont use that here
    }

    @Override
    public void StartTransportTo(ITransport type) {

        // we dont use that here
    }


    private class Wagon
    {
        public List<Container> containerList1;
        public int nrWagonu;

        private Wagon(int nrWagonu)
        {
            this.nrWagonu=nrWagonu;
            containerList1 = new ArrayList<>();
        }
      
        public int getNrWagonu() {
            return nrWagonu;
        }
        

        public boolean isFull()
        {
            if(containerList1.size()<10)
                return false;
            else
                return true;
        }

        public boolean loadOnWagon(Container container)
        {
            if(!isFull())
            {
                containerList1.add(container);
                return true;
            }
            else
            {
                System.out.println("Wagon is full");
                return false;
            }
        }
    }
}
