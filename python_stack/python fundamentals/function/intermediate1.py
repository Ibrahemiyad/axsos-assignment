import random

def randInt(min=0, max=100):
    if min > max:
        return "Error: min cannot be greater than max."
    num = random.random() * (max - min) + min
    return round(num)

print(randInt())  # Should print a random integer between 0 to 100
print(randInt(max=50))  # Should print a random integer between 0 to 50
print(randInt(min=50))  # Should print a random integer between 50 to 100
print(randInt(min=50, max=500))  # Should print a random integer between 50 and 500
print(randInt(min=200, max=50))  # Should handle edge case: min > max
