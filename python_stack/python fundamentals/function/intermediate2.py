#1.......
x = [[5, 2, 3], [10, 8, 9]]
students = [
    {'first_name': 'Michael', 'last_name': 'Jordan'},
    {'first_name': 'John', 'last_name': 'Rosales'}
]
sports_directory = {
    'basketball': ['Kobe', 'Jordan', 'James', 'Curry'],
    'soccer': ['Messi', 'Ronaldo', 'Rooney']
}
z = [{'x': 10, 'y': 20}]

# 1.
x[1][0] = 15

# 2.
students[0]['last_name'] = 'Bryant'

# 3. 
sports_directory['soccer'][0] = 'Andres'

# 4. 
z[0]['y'] = 30

print(x)
print(students)
print(sports_directory)
print(z)



#2.................

def iterateDictionary(some_list):
    for dictionary in some_list:
        output = []
        for key, value in dictionary.items():
            output.append(f"{key} - {value}")
        print(", ".join(output))

students = [
    {'first_name': 'Michael', 'last_name': 'Jordan'},
    {'first_name': 'John', 'last_name': 'Rosales'},
    {'first_name': 'Mark', 'last_name': 'Guillen'},
    {'first_name': 'KB', 'last_name': 'Tonel'}
]
iterateDictionary(students)


#3.......
def iterateDictionary2(key_name, some_list):
    for dictionary in some_list:
        if key_name in dictionary:
            print(dictionary[key_name])

iterateDictionary2('first_name', students)
iterateDictionary2('last_name', students)   


#4..........

def printInfo(some_dict):
    for key, values in some_dict.items():
        print(f"{len(values)} {key.upper()}")
        for value in values:
            print(value)
        print()  

dojo = {
    'locations': ['San Jose', 'Seattle', 'Dallas', 'Chicago', 'Tulsa', 'DC', 'Burbank'],
    'instructors': ['Michael', 'Amy', 'Eduardo', 'Josh', 'Graham', 'Patrick', 'Minh', 'Devon']
}
printInfo(dojo)
