package com.project.usermanagement.creditcard;

import com.project.usermanagement.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CreditCardController {
    @Autowired
    private CreditCardService creditCardService;

    @RequestMapping("/users/{userEmail}/creditcards")
    public List<CreditCard> getAllCreditCards(@PathVariable String userEmail) {
        return creditCardService.getAllCreditCards(userEmail);
    }
    @RequestMapping("/users/{userEmail}/creditcards/{id}")
    public CreditCard getCreditCard(@PathVariable String id) {
        return creditCardService.getCreditCard(id);
    }
    @RequestMapping(method = RequestMethod.POST, value = "/users/{userEmail}/creditcards")
    public void addCreditCard(@RequestBody CreditCard creditCard, @PathVariable String userEmail) {
        creditCard.setUser(new User(userEmail, "", ""));
        creditCardService.addCreditCard(creditCard);
    }
    @RequestMapping(method = RequestMethod.PUT, value = "/users/{userEmail}/creditcards/{id}")
    public void updateCreditCard(@RequestBody CreditCard creditCard, @PathVariable String userEmail, @PathVariable String id) {
        creditCard.setUser(new User(userEmail, "", ""));
        creditCardService.updateCreditCard(id, creditCard);
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "/users/{userEmail}/creditcards/{id}")
    public void deleteCreditCard(@PathVariable String id) {
        creditCardService.deleteCreditCard(id);
    }
}
