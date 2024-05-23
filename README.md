# a-tale-of-change

### The initial setup

The initial setup should be a simple Controller / API with one endpoint. Through this endpoint, we are going to let ‘customers’ 
order coffee. The endpoint dictates the amount of coffee and how strong it should be.

This controller holds the quantity of coffee as a public property. Obviously, this is bad, but that is a bit the point, 
right :D.

This api controller acts as the ‘user interface’ of the coffee machine.

The other class is the process class. It basically represents the coffee machine. This class is as poorly designed as 
the other one, on purpose.

The coffee machine starts out with a bunch of fields that might not all see relevant or maybe a bit far fetched. But it 
is just an example and I still think it helps with the purpose.


### The first scenario

Players should just try and finish the controller. They will face the pain of having to construct the different steps 
themselves. There is a lack of encapsulation that should become clear here. If only we could make it so that when we want 
trigger a process, we don’t need to know the details of the process. But that comes later.

Then the first change:

You are the new developer on this project. You see the variable in the controller… it is called v. That is an impossible name. Let’s change that.
< player makes the change, but not using the IDE ‘refactor’ functionality>
< players compiles the code>

Explanation:

The code doesn’t compile anymore. Big surprise! How come that the code doesn’t compile anymore?

Well, it is because of the changes the player just made. It turns out that there is some impact from one class on another 
due to connascence / coupling going on here, causing change to spread out.

I would explain what these concepts actually mean and why they have manifested (coffeemachine class using something from 
the controller means there is going to be impact). Point out the direction of dependency and the first ‘refactor’. 
