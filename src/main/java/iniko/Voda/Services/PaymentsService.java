package iniko.Voda.Services;

import iniko.Voda.DTO.Payments;
import iniko.Voda.Repos.PaymentsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentsService {

    @Autowired
    private PaymentsRepo paymentsRepo;

    private void CreatePayment(Payments payments)
    {
        paymentsRepo.save(payments);
    }

}
