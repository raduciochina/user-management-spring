package com.project.usermanagement.creditcard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CreditCardService {
    @Autowired
    private CreditCardRepository creditCardRepository;

    public List<CreditCard> getAllCreditCards(String userEmail) {
        List<CreditCard> creditCards = new ArrayList<>();
        creditCardRepository.findCreditCardsByUserEmail(userEmail).forEach(creditCards::add);
        return creditCards;
    }
    public CreditCard getCreditCard(String id) {
        return creditCardRepository.findById(id).orElse(null);
    }
    public void addCreditCard(CreditCard creditCard) {
        creditCardRepository.save(creditCard);
    }
    public void updateCreditCard(String id, CreditCard creditCard) {
        creditCardRepository.save(creditCard);
    }
    public void deleteCreditCard(String id) {
        creditCardRepository.deleteById(id);
    }
}
