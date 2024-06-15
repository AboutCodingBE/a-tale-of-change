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
Connascence is a term invented by Meilir Page-Jones and he writes about it in his 
book '[What every programmer should know about Object Oriented design](https://www.amazon.com.be/-/en/Meilir-Page-Jones/dp/0932633315)'.

_“Two code components are connascent if a change to one component would also force a change to the other component in 
order to guarantee the correct working of the program”(1)."_

Let this sink in. If a change to one component would also force a change to the other. 
That is connascence. And I love the simplicity of this. That is exactly what happened here. 