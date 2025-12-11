def puissance(a, b):
    if type(a) is not float and type(a) is not int:
        raise TypeError("Only float and int are allowed")
    if type(b) is not float and type(b) is not int:
        raise TypeError("Only float and int are allowed")
    if a == 0 and b < 0:
        raise ValueError("0 cannot be raised to a negative power")
    
    if type(a) is int and type(b) is int:
      if b == 0:
        return 1
      
      res = 1
      for i in range(abs(b)):
        res *= a
      if b > 0:
        return res
      if b < 0:
        return 1 / res
    
    return a ** b
