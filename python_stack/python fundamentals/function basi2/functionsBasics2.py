
def countdown(num):
    list = []
    for i in range(num ,-1 ,-1):
        list.append(i)
    return list

print(countdown(5))


def printReturn(nums):
    print(nums[0])
    return nums[1]


print(printReturn([1,2]))


def plusLength(nums):
    return len(nums)+nums[0]

print(plusLength([10,5,4,7]))


def greaterThanSecond(nums):
    if len(nums) < 2: return False
    
    list=[]
    
    for i in range(len(nums)):
        if nums[i]>nums[1]:
            list.append(nums[i])
    
    print(len(list))
    return list

print(greaterThanSecond([4,5,6,3,2,6,8,9]))

def thisThat(size,value):
    list=[]
    for i in range(size):
        list.append(value)
    return list


print(thisThat(5,6))


