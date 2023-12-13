import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Sender {

    private String name;
    private String lastName;
    private String PESEL;
    private String BirthDate;
    public List<Certificates> certificates = new ArrayList<>();

    public int warnings;
    public Sender(String name, String lastName, String PESEL, String BirthDate) {
        this.warnings=0;
        this.name = name;
        this.lastName = lastName;
        this.PESEL=PESEL;
        this.BirthDate=BirthDate;
    }

    
    public String getName() {
        return name;
    }
    public String getLastName() {
        return lastName;
    }

    public void addWarning()
    {
        warnings++;
    }
    public String getBirthDate() {
        return BirthDate;
    }


    public void addCertificate(Certificates certificates){
        certificates.add(certificates);
   }


    @Override
    public String toString() {
        return name +" "+ lastName+ " "+ getBirthDate();
    }

}
