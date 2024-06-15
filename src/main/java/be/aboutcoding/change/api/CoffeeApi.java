package be.aboutcoding.change.api;

import be.aboutcoding.change.processs.CoffeeMachine;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/coffee")
public class CoffeeApi {

    public int v;

    @PostMapping()
    public CoffeeCup getCupOfCoffee(@RequestBody CupOfCoffeeRequest request) {
        this.v = request.quantity();

        var coffeeMachine = new CoffeeMachine(request);

        // The coffee making process...

        coffeeMachine.addFilter();
        coffeeMachine.addCoffeeGrounds(50);
        coffeeMachine.turnOn();

        coffeeMachine.heatWater();
        var cupOfCoffee = coffeeMachine.percolate();
        coffeeMachine.turnOff();

        return cupOfCoffee;
    }
}
