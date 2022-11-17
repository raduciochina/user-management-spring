package com.project.usermanagement.creditcard;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CreditCardRepository extends CrudRepository<CreditCard, String> {

    public List<CreditCard> findCreditCardsByUserEmail(String userEmail);

}
