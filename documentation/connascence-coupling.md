# Introduction to connascence and coupling.

So you broke the code base! Don't feel bad, you can always tell people I made you do it ;). 

But what happened? Why does the code base no longer compile? 

The reason is because you changed the name of variable. But another class, in this case the 
[CoffeeMachine](src/main/java/be/aboutcoding/change/processs/CoffeeMachine.java) class was using this
variable. This class was depending on a variable named 'v' in the `CoffeeApi` class. 

We changed the original name of the variable and thus now the `CoffeeMachine` class cannot find it anymore. That is a 
problem. 

What we experience here is called **Connascence**. What is connascence? 

---
### Connascence
Connascence is a term invented by Meilir Page-Jones and he writes about it in his 
book '[What every programmer should know about Object Oriented design](https://www.amazon.com.be/-/en/Meilir-Page-Jones/dp/0932633315)'.

_“Two code components are connascent if a change to one component would also force a change to the other component in 
order to guarantee the correct working of the program”(1)."_

Let this sink in. If a change to one component would also force a change to the other. 
That is connascence. And I love the simplicity of this. That is exactly what happened here. Well, we didn't change any other class
yet. But we will get to that soon. 

There is a lot more to know about connascence. You can start [here](https://connascence.io/) for a quick overview. 

---

This is not the full story. The phenomenon we just experienced is also known as **coupling**. What is coupling? 

---
### Coupling

Originally, coupling was defined as following:

_“Coupling is the measure of the strength of association established by a connection from one module to another. Strong 
coupling complicates a system since a module is harder to understand, change, or correct by itself if it is highly 
interrelated with other modules.”_ 

The quote was taken from the paper “Structured design” by **W. P. Stevens, G. J. Myers, and L. L. Constantine**. I would 
recommend you to read it. There is also a book written by **Edward Yourdon and Larry Constantine** with the same name. 

To put it differently, coupling is a metric that tries to measure the interdependence between modules and routines 
and the strength of that interdependence. As you probably figured out already, coupling and connascence are very related
concepts. 

___


Fixing this particular problem looks rather easy: we also make the name changes everywhere this parameter is used
in other classes. In our case that would be the `CoffeeMachine` class. 

Would that fix be a good fix? Let's see. 

---
**[This is where you step in]**
---
- Fix the [CoffeeMachine](src/main/java/be/aboutcoding/change/processs/CoffeeMachine.java) class by also changing the old name of the variable to the new one. 
- Now change the name of the variable in the `CoffeeApi` class again... 
---

So even though it is quite easy to make our program compile again, we didn't fix the real problem. We don't want to have to 
change the `CoffeeMachine` class every time we need to change the `CoffeeApi` class. 

The real problem is that the `CoffeeMachine`class seems to depend on the `CoffeeApi` class. This is exactly the effect of coupling on code: 
a change to one component affects another. 

To fix this problem, we need to make sure that the `CoffeeMachine` class no longer depends on the `CoffeeApi` class. 


---
**[This is where you step in]**
---
- We can break coupling between the api can the `CoffeeMachine` class by making sure they do not depend on each other. So in the [CoffeeMachine](src/main/java/be/aboutcoding/change/processs/CoffeeMachine.java) class
erase the reference to the variable belonging to the `CoffeeApi`. 
- Now we need to find a way to pass the wanted amount of coffee to the `CofffeeMachine` class. The `CupOfCoffeeRequest` holds the
requested volume. Instead of passing the `CoffeeApi` in the constructor of the `CoffeeMachine` class, we can pass in the request.
- In the `CoffeeMachine` class, create a global variable called `volume`. 
- In the constructor of the `CoffeeMachine` class, initiate the `volume` using the `CupOfCoffeeRequest`.
- Make sure to also adjust the methods in  the `CoffeeMachine` class that used the variable from the api. 
---

If you are not sure you did it correctly, you can check out the solution branch: `level1-introducing-coupling-solution`. 
The above solution fixes our dependency problem between the `CoffeeApi` class and the `CoffeeMachine` class. But it is not a great fix. 

Can you guess why?

