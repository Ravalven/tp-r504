import fonctions as f

print("Hello, World!")

while True :
	a = int(input("Entrez un nombre :"))
	b = int(input("Entrez en un autre :"))
	res = f.puissance(a, b)
	print(res)