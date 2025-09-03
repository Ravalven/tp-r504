import fonctions as f

print("Hello, World!")

while True :
	try :
		a = int(input("Entrez un nombre :"))
		b = int(input("Entrez en un autre :"))
		res = f.puissance(a, b)
		print(res)
	except ValueError :
		break
	except TypeError :
		break

