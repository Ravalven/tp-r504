def puissance(a, b):
	if type(a) is not int or type(b) is not int :
		raise TypeError("Un entier stp.")
	if a == 0 and b < 0 :
		raise ValueError("Impossible mathématiquement.")

	for n in range (1, b):
		a *= a

	return a
