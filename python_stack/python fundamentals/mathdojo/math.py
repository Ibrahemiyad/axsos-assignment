class MathDojo:
    def __init__(self):
        self.result = 0

    def add(self, num, *nums):
        self.result += num + sum(nums)
        return self

    def subtract(self, num, *nums):
        self.result -= num + sum(nums)
        return self

# create an instance:
md = MathDojo()

# to test:
x = md.add(2).add(2, 5, 1).subtract(3, 2).result
print(x)  # should print 5

# Example of running the methods further:
y = md.add(10).subtract(4, 1).add(3).result
print(y)  # will print the updated result