package nl.hanze.web.rdw.service.webservice;

import nl.hanze.web.rdw.service.*;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.JAXBElement;

@WebService()
public class Thesaurus {

    ObjectFactory factory;

    public Thesaurus() {
        factory = new ObjectFactory();
    }

    @WebMethod
    @WebResult(name="info")
    public Info getInfo(@WebParam(name="kenteken") String kentekenString) {
        Info info = factory.createInfo();

        Kenteken kenteken = factory.createKenteken();
        kenteken.setKenteken("10-ab-22");

        Model model = factory.createModel();
        model.setMerkNaam("Opel");
        model.setMotorInhoud(2940.0f);
        model.setTypeAanduiding("2CV");
        model.setTypeMotor("D");

        if(kentekenString.equals(kenteken.getKenteken())) {
            info.setStatusInfoAanvraag("OK");
            info.setKenteken(kentekenString);
            info.setBsn(9281396);
            info.setModel(model);
            info.setChassisNummer("18908-12398-1");
            info.setKleur("Rood");
        }
        else {
            info.setStatusInfoAanvraag("NOT FOUND");
            info.setKenteken(kentekenString);
        }

        return info;
    }

}
