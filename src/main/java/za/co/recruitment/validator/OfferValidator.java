package za.co.recruitment.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.co.recruitment.dao.impl.OfferDAOImpl;
import java.util.Objects;

@Component
public class OfferValidator {

    @Autowired
    OfferDAOImpl offerDAOImpl;

    public boolean isValidJobTitle(String jobTitle){
        return Objects.isNull(offerDAOImpl.getOfferByJobTitle(jobTitle));
    }

}
