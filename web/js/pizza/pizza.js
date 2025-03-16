function pizzaOven(crust, sauce, cheeses, toppings) {
    return {
        crust: crust,
        sauce: sauce,
        cheeses: cheeses,
        toppings: toppings
    };
}
var pizza1 = pizzaOven("deep dish", "traditional", ["mozzarella"], ["pepperoni", "sausage"]);
console.log(pizza1);

var pizza2 = pizzaOven("hand tossed", "marinara", ["mozzarella", "feta"], ["mushrooms", "olives", "onions"]);
console.log(pizza2);

var pizza3 = pizzaOven("thin crust", "pesto", ["cheddar", "parmesan"], ["chicken", "spinach", "basil"]);
console.log(pizza3);

var pizza4 = pizzaOven("gluten-free", "alfredo", ["mozzarella"], ["bacon", "pineapple", "jalapeños"]);
console.log(pizza4);

var crust = ["deep dish", "hand tossed", "thin crust", "stuffed crust"];
var sauce = ["traditional", "marinara", "pesto", "alfredo"];
var cheese = ["mozzarella", "cheddar", "parmesan", "feta", "ricotta"];
var topping = ["pepperoni", "sausage", "mushrooms", "onions", "olives", "bacon", "pineapple", "chicken", "spinach", "jalapeños"];
function getRandomItems(arr, count) {
    const x = arr.sort(() => 0.5 - Math.random());
    return x.slice(0, count);
}

return pizzaOven(
    crust[Math.floor(Math.random() * crust.length)],
    sauce[Math.floor(Math.random() * sauce.length)],
    getRandomItems(cheese, Math.floor(Math.random() * cheese.length + 1)),
    getRandomItems(topping, Math.floor(Math.random() * topping.length + 1))
);


var randomPizza1 = randomPizza();
console.log(randomPizza1);
findIndex
