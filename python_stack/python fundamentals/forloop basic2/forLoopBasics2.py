

def biggie(nums):
    for i in range(len(nums)):
        if nums[i] > 0:
            nums[i] = "big"
    return nums

print(biggie([-4,-3,0,6,4,7,-7]))


def countPos(nums):
    counter =0
    for i in range(len(nums)):
        if nums[i] > 0:
            counter += 1
    
    nums[len(nums)-1] = counter
    return nums

print(countPos([-1,1,1,1]))

def sum(nums):
    sum =0
    for i in range(len(nums)):
        sum+=nums[i]
    return sum

print(sum([1,2,3,4,5,6,7]))

def average(nums):
    sum =0
    for i in range(len(nums)):
        sum+=nums[i]
    return sum/len(nums)

print(average([1,2,3,4,5,6,7]))

def minimum(nums):
    min =nums[0]
    for i in range(len(nums)):
        if nums[i] <= min:
            min=nums[i]
    return min

print(minimum([9,4,5,6,2,3,1]))

def maximum(nums):
    max =nums[0]
    for i in range(len(nums)):
        if nums[i] >= max:
            max=nums[i]
    return max

print(maximum([0,5,9,5,4,7,5,6,3,6,8]))

def Ultimate(nums):
    list = []
    list.append(sum(nums))
    list.append(average(nums))
    list.append(minimum(nums))
    list.append(maximum(nums))
    return list

print(Ultimate([5,7,8,55,4,3,21,90]))

def reverse(nums):
    list=[]
    for i in range(len(nums)-1,-1,-1):
        list.append(nums[i])
        
    return list

print(reverse([1,2,3,4,5,6]))