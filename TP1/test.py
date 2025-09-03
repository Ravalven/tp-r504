import pytest
import fonctions as f

def test_1():
	assert f.puissance(2,3) == 8
	assert f.puissance(2,2) == 4

def test_2():
	assert f.puissance(-1, 2) == 1
	assert f.puissance(-1, 3) == -1
	assert f.puissance(-1, -1) == -1
	assert f.puissance(-1, -2) == 1
	assert f.puissance(-2, -1) == -0.5

def tes_3():
	assert f.puissance(0, 3) == 0
	assert f.puissance(0, 200) == 0
	assert f.puissance(0, 3000) == 0

	assert f.puissance(0, 0) == 1
	with pytest.raises(Valuerror):
		assert f.puissance(0, -1)
		assert f.puissance(0, -100)
		assert f.puissance(0, -1200)

