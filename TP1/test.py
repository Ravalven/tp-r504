import pytest
import fonctions as f

def test_1():
  assert f.puissance(2,3) == 8
  assert f.puissance(2,2) == 4

def test_2():
  assert f.puissance(-1,2) == 1
  assert f.puissance(-1,3) == -1
  assert f.puissance(-1,-1) == -1
  assert f.puissance(-1,-2) == 1
  assert f.puissance(-2,-1) == -0.5

def test_3():
  assert f.puissance(0,1) == 0
  assert f.puissance(0,10) == 0
  assert f.puissance(0,100) == 0
  assert f.puissance(0,1000) == 0

  assert f.puissance(0,0) == 1

  with pytest.raises(ValueError):
    assert f.puissance(0,-1)
    assert f.puissance(0,-10)
    assert f.puissance(0,-100)
    assert f.puissance(0,-1000)

  assert f.puissance(2, 1.2) == pytest.approx(2.29739671)
  assert f.puissance(2,-1.2) == pytest.approx(0.435275282)
  assert f.puissance(-2, 1.2) == pytest.approx(-1.8586329812062954-1.3503759047997619j)
  assert f.puissance(-2,-1.2) == pytest.approx(-0.35214510008462396 + 0.25584839124018344j)

  assert f.puissance(3.2,5.8) == pytest.approx(850.883053659)
  assert f.puissance(3.2,-5.8) == pytest.approx(0.00117525)
  assert f.puissance(-3.2,5.8) == pytest.approx(688.3788506359343 - 500.1365103664572j)
  assert f.puissance(-3.2,-5.8) == pytest.approx(0.0009507969290207401 + 0.0006907944044304632j)
