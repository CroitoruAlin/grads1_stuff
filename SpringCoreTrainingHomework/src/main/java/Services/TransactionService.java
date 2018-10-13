package Services;

import com.sun.tracing.dtrace.ArgsAttributes;
import model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repositories.TransactionRepository;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;
    @Transactional
    public List<Transaction> getTransactionOrderedByAmount(String pan)
    {
        return transactionRepository.getTransactionOrderedByAmount(pan);
    }
}
