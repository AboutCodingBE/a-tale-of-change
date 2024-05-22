package be.aboutcoding.change.api;

import be.aboutcoding.change.processs.CoffeeMachine;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/coffee")
public class CoffeeApi {

    public int amountOfCoffee;

    @PostMapping()
    public CoffeeCup getCupOfCoffee(@RequestBody CupOfCoffeeRequest request) {
        this.amountOfCoffee = request.requestedQuantity();

        var coffeeMachine = new CoffeeMachine(this);

        // Let the gamer figure out what to do with the coffee machine class. Because there is no encapsulation
        // the implementer of the class needs to figure out the right order of operations. For coffee this is easy,
        // we all know the concept of making coffee. But what if it was a business process you are not familiar with?

        return new CoffeeCup(request.requestedQuantity());
    }
}
