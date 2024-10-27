# PEP-8 Coding Conventions
1. use `4 spaces` instead of tabs while writing arguments
2. use `docStrings`
3. `Wrap lines so that they don’t exceed 79 characters`. The Python standard library is conservative and requires limiting lines to 79 characters. The lines can be wrapped using parenthesis, brackets, and braces. They should be used in preference to backslashes.
4.  Use of `regular and updated comments` are valuable to both the coders and users.
5. Use of `trailing commas` : This is not mandatory except while making a tuple.
6. Use `Python’s default UTF-8` or `ASCII encodings` and not any fancy encodings, if it is meant for international environment.
7. Use `spaces around operators` and after commas, but not directly inside bracketing constructs.
8. 7. `Naming Conventions` : There are few naming conventions that should be followed in order to make the program less complex and more readable. At the same time, the naming conventions in Python is a bit of mess, but here are few conventions that can be followed easily.
There is an overriding principle that follows that the names that are visible to the user as public parts of API should follow conventions that reflect usage rather than implementation.
Here are few other naming conventions:
``` python
b (single lowercase letter)

B (single upper case letter)

lowercase

lower_case_with_underscores

UPPERCASE

UPPER_CASE_WITH_UNDERSCORES
```
CapitalizedWords (or CamelCase). This is also sometimes known as StudlyCaps.
Note: While using abbreviations in CapWords, capitalize all the letters 
of the abbreviation. Thus `HTTPServerError` is better than `HttpServerError`.

mixedCase (differs from CapitalizedWords by initial lowercase character!)

Capitalized_Words_With_Underscores
In addition to these few leading or trailing underscores are also considered.
Examples:
`single_leading_underscore:` weak “internal use” indicator. E.g. from M import * does not import objects whose name starts with an underscore.

`single_trailing_underscore_:` used to avoid conflicts with Python keyword.
Example:
```python
Tkinter.Toplevel(master, class_='ClassName')
```
`__double_leading_underscore: when naming a class attribute, invokes name mangling.`
(inside class FooBar, __boo becomes _FooBar__boo;).

`__double_leading_and_trailing_underscore__`: “magic” objects or attributes that live in user-controlled namespaces. E.g. __init__, __import__ or __file__. Only use them as documented.
9. `Characters that should not be used for identifiers` : ‘l’ (lowercase letter el), ‘O’ (uppercase letter oh), or ‘I’ (uppercase letter eye) as single character variable names as these are similar to the numerals one and zero.
10. Don’t use `non-ASCII characters in identifiers` if there is only the slightest chance people speaking a `different language` will read or maintain the code.
11. `Name your classes and functions consistently` : The convention is to `use CamelCase for classes` and `lower_case_with_underscores for functions and methods`. 
12. Always `use self as the name for the first method argument`.
13. Use `Strong Typing` mention return type for methods and explicitly mention the type of arguments.


