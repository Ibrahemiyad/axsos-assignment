import unittest
def add (a,b):
    return a+b

class test_add_number(unittest.TestCase):
    def add_test(self):
        self.assertEqual(add(2,3),5)

    def testtwo(self):
        self.assertEqual(add(-2,-5))

    




if __name__=="__main__":
    unittest.main()