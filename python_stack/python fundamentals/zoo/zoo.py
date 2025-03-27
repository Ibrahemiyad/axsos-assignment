class Animal:
    def __init__(self, name):
        self.name = name

    def display(self):
        print(f"Animal: {self.name}")

class Tiger(Animal):
    def __init__(self, name):
        super().__init__(name)  

class Lion(Animal):
    def __init__(self, name):
        super().__init__(name)  

class Zoo:
    def __init__(self, zoo_name):
        self.animals = []
        self.name = zoo_name

    def add_lion(self, name):
        self.animals.append(Lion(name))

    def add_tiger(self, name):
        self.animals.append(Tiger(name))

    def print_all_info(self):
        print("-" * 30, self.name, "-" * 30)
        for animal in self.animals:
            animal.display()  

zoo1 = Zoo("John's Zoo")
zoo1.add_lion("Nala")
zoo1.add_lion("Simba")
zoo1.add_tiger("Rajah")
zoo1.add_tiger("Shere Khan")
zoo1.print_all_info()
