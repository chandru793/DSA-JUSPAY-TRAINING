num1,num2,n=10,15,1

if num1!=num2:
    while n!=0:
        n=num1%num2
        if n!=0:
            num1=num2
            num2=n
    print("HCF : ",num2)
else:
    print("Invalid input")