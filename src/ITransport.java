public interface ITransport {
    boolean canILoad(Container container);


     boolean Load(Container container);

     void unLoad(Container container);

     void StartTransportTo(ITransport type);



    default void transportTo(ITransport type,Container container)
    {
        if(type.Load(container))
            unLoad(container);
    }


}
