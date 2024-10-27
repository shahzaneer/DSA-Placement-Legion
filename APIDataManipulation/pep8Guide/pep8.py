
# ! 1.  4 spaces rule
# def function_name(
#         variable_one, variable_two, variable_three,
#         variable_four):
#     print(variable_one)

# grow = function_name(variable_one, variable_two,
#                      variable_three, variable_four)    


# def shah(
#         a,b,c,d,
#         e,f):
#     print("a")


# ! 2. Use DocStrings : tells what a function does.
# def exam():
#     """This is single line docstring"""

#     """This is
#     a
#     multiline comment"""


# print(exam.__doc__)

# ! 3. Wrap lines that exceeds 79 characters 
# normal
# with open('/path/from/where/you/want/to/read/file') as file_one, open('/path/where/you/want/the/file/to/be/written', 'w') as file_two:
#     file_two.write(file_one.read())

# # after Wrapping - using forward slash
# with open('/path/from/where/you/want/to/read/file') as file_one, \
#      open('/path/where/you/want/the/file/to/be/written', 'w') as file_two:
#     file_two.write(file_one.read()) 

#! 4. comments 
increment = 0;
increment = increment+1 #Increment
increment+= 1 # The value is incremented by 1

#! 5. use of trailing commas
who_am_i = ["SWE","Student","Brother","Provider"]
shahz = tuple(who_am_i) #normal
shah = tuple(who_am_i,) # pep8 guide



#! 7. use of spaces
sum = (3,7)+(8,9) #normal
sum = (3, 7) + (8, 9) #pep8 

#! 8. + 11 + 12
class APIRequestProblem:  #camelCase For class
    def call_API(self, aqib_ball, baz_ball): #snakecase and allCaps for (abbreviation)
        pass
    def call_shahzaneer(self, shah_ball): #snakecase for methods
        pass    


#! 9. Characters that should not be used in naming variables
l = 1;
O = 0;
I = 1;  #as these looks similar and hinders readability

#! 13. Strong typing

def calculate_sum(data: list, weight: int) -> int:
    """Accepts data parameter as List and weight as int and return sum in the form of int
    by adding weight and data items """

    sum = 0
    for data_item in data:
        sum+=data_item
    sum+=weight
    return sum    

print(calculate_sum(data=[1,2,3,4,5],weight=6)) 
print(calculate_sum([1,2,3,4,5],7)) 