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
recommend you to read it. There is also a book written by **Edward Yourdon and Larry Constatine** with the same name. 

To put it differently, coupling is a metric that tries to measure the interdependence between modules and routines 
and the strength of that interdependence. As you probably figured out already, coupling and connascence are very related
concepts. 

___






Fixing this particular problem is rather easy: we also make the name changes everywhere this parameter is used
in other classes, in our case