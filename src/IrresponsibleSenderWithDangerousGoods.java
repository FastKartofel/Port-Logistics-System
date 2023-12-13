import java.time.LocalDate;


public class IrresponsibleSenderWithDangerousGoods extends Exception {
    public IrresponsibleSenderWithDangerousGoods(Container container, LocalDate arrivalDate,LocalDate disposalDate)
    {
        super("Error arrival date "+arrivalDate+" of this" +container+", disposal date "+disposalDate);
        container.getSender().addWarning(); 

       
    }

    
}

