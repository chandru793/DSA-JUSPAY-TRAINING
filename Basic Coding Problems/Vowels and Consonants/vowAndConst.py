s="Chandru"
s=s.lower()
vowels="aeiou"
cons=vow=0

for st in s:
    if st in vowels:
        vow+=1
    else:
        cons+=1

print("Consonants: ",cons)
print("Vowels : ",vow)