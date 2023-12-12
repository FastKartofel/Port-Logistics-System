import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Warehouse implements ITransport {

    public int maxContainers;
    public int currentContainers;

    public static int ContainerExpolsive_Validity = 5;
    public static int ContainerToxic_Liquids_Validity = 10;
    public static int ContainerToxic_Powdery_Validity = 14;

    public static int sender_Max_Warnings = 2;

    public String WarehouseName;

    public LocalDate currentDate;

    public int daysPassed = 0;

    public Thread flowOfTime;

    public List<InfoContainer> containerList;


    public Warehouse(String WarehouseName, int maxContainers) {
        this.containerList = new ArrayList<>();
        this.maxContainers = maxContainers;
        this.WarehouseName = WarehouseName;
        this.currentDate = LocalDate.now();
        setupThread();
        flowOfTime.start();
    }

    private void setupThread() {
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                boolean start = true;
                while (start) {
                    try {
                        Thread.sleep(5000);

                        nextDay();

                        checkDate();

                    } catch (InterruptedException e) {
                        System.err.println("Bład");
                    }

                }
            }
        };
        flowOfTime = thread1;
    }

    private void nextDay() {
        daysPassed++;
        currentDate = LocalDate.now().plusDays(daysPassed);
    }

    private void checkDate() {
        List<InfoContainer> toDisposal = new ArrayList<>();
        for (InfoContainer container : containerList) {
            if (container.validityCheck()) {
                toDisposal.add(container);
                currentContainers--;
            }
        }
        for (InfoContainer disposal : toDisposal) {
            try {
                throw new IrresponsibleSenderWithDangerousGoods(disposal.container, disposal.arrivalDate, currentDate);
            } catch (IrresponsibleSenderWithDangerousGoods e) {
                System.err.println(e.getMessage());
            }
            containerList.remove(disposal);
        }
    }

    public void showWarehouse() {
        System.out.println("Warehouse state " + WarehouseName);

        for (InfoContainer container : containerList) {
            System.out.println(container.container);
            System.out.println(container.arrivalDate);
            if (container.container.getClass().equals(ContainerExpolsive.class)) 
                System.out.println(ContainerExpolsive_Validity - Duration.between(currentDate.atStartOfDay(), container.arrivalDate.atStartOfDay()).toDays());
            System.out.println();
            if (container.container.getClass().equals(ContainerToxic_Powdery.class))
                System.out.println(ContainerToxic_Powdery_Validity - Duration.between(currentDate.atStartOfDay(), container.arrivalDate.atStartOfDay()).toDays());
            System.out.println();
            if (container.container.getClass().equals(ContainerToxic_Liquids.class))
                System.out.println(ContainerToxic_Liquids_Validity - Duration.between(currentDate.atStartOfDay(), container.arrivalDate.atStartOfDay()).toDays());
            System.out.println();

        }
    }


    public void disposal(Container container) {
        InfoContainer container1 = null;

        for (InfoContainer a : containerList) {
            if (a.container.getID() == container.getID()) {
                container1 = a;
            }
        }

        if (container1 != null) {
            try {
                throw new IrresponsibleSenderWithDangerousGoods(container1.container, container1.arrivalDate, currentDate);
            } catch (IrresponsibleSenderWithDangerousGoods e) {
                System.err.println(e.getMessage());
            }
            currentContainers--;
            containerList.remove(container1);
        }

    }

    @Override
    public boolean canILoad(Container container) {
        if (container.getSender().warnings > 2)
            return false;
        return maxContainers >= currentContainers + 1;
    }


    @Override
    public boolean Load(Container container) {
        if (canILoad(container)) {
            containerList.add(new InfoContainer(container, currentDate));
            currentContainers++;
            return true;
        }
        return false;
    }

    @Override
    public void unLoad(Container container) {
        containerList.removeIf(InfoContainer -> InfoContainer.container.getID() == container.getID());
        currentContainers--;
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
                if(!train.Load(containerList.get(index).container)) 
                {
                    while(train.stockChange.isAlive()) 
                    {
                        
                    }
                    train.Load(containerList.get(index).container);
                    index++;
                }
                else
                {
                    forUnLoad.add(containerList.get(index).container);
                    index++;
                }
            }
            for(Container container : forUnLoad)
            {
                unLoad(container);
            }
            if(train.isTrainFull())
            {
                System.out.println("Train is now full");
                System.out.println(containerList.size());
            }
            train.showTrain();


        }
        else
        {
            List<Container> forUnLoad = new ArrayList<>();
            for(InfoContainer container : containerList)
            {
                if(type.Load(container.container)) 
                {
                    forUnLoad.add(container.container);
                }
            }
            for(Container container: forUnLoad)
            {
                unLoad(container);
            }
        }
    }





    public void sortContainer()
    {
        containerList.sort(new Comparator<InfoContainer>() {
            @Override
            public int compare(InfoContainer o1, InfoContainer o2) {
                if(o1.arrivalDate.compareTo(o2.arrivalDate) == 0)
                {
                    return o1.container.getSender().getName().compareTo(o2.container.getSender().getName());
                }
                else
                {
                    return o1.arrivalDate.compareTo(o2.arrivalDate);
                }
            }
        });
        containerList.forEach(e-> System.out.println(e.arrivalDate+" "+e.container.getSender().getName()));
    }




    private class InfoContainer {
        Container container;
        LocalDate arrivalDate;

        private InfoContainer(Container container, LocalDate arrivalDate) {
            this.container = container;
            this.arrivalDate = arrivalDate;
        }

        public boolean validityCheck() {
            
            long days = Duration.between(arrivalDate.atStartOfDay(), currentDate.atStartOfDay()).toDays();
            if (container.getClass().equals(ContainerExpolsive.class)) {
                return days > ContainerExpolsive_Validity; 
            }

            if (container.getClass().equals(ContainerToxic_Powdery.class)) {
                return days > ContainerToxic_Powdery_Validity;
            }
            if (container.getClass().equals(ContainerToxic_Liquids.class)) {
                return days > ContainerToxic_Liquids_Validity;
            }
            return false; 

        }


    }





    public void setContainer() {
    }
}






