for x in range(0,151,1):
    print(x)


for val in range (5,1001,5):
    print(val)


for i in range(1,101,1):
    if i % 10 == 0:
        print("Coding Dojo")
    elif i % 5 ==0:
        print("Coding")
    else:
        print(i)

sum=0
for number in range(1,500000,1):
    sum+=number
print(sum)


for i in range(2018,0,-4):
    print(i)


lowNum=2
highNum=9
mult=3
for number in range(lowNum, highNum + 1):
    if number % mult == 0:
        print(number)
