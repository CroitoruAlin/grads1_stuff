package main.controller;


import main.model.Transaction;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1")//se adauga la toate caile din clasa
public class ControllerTransaction {

    @GetMapping(value="/transaction")
    public Transaction retrieveTransaction()
    {
        return new Transaction("1",2.3);
    }
    @GetMapping("transactions")
    public List<Transaction> retrieveTransactions(){
        Transaction transaction = new Transaction("2",200.5);
        Transaction transaction1 = new Transaction("4",202.5);
        return Arrays.asList(transaction,transaction1);

    }
    @GetMapping("/transactions/{transactionNo}")
    public Transaction retrieveTransaction(@PathVariable("transactionNo") String transaction)
    {
        return new Transaction(transaction,890.2);

    }
    @GetMapping("/retrieve/transaction")
    public Transaction retrieveAnotherSpecialTransaction(@RequestParam("transaction") String t)
    {
        return new Transaction(t,56.43);
    }
}
