def sigma(k):
    if(k == 1):
	        return k
    else :
        return sigma + sigma(k-1)

print("Recursion Example Results:")
sigma(6)
