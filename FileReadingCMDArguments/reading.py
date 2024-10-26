import sys

if __name__ == '__main__':
    script_name = sys.argv[0]
    if(sys.argv.__len__()>=1):
        input_file_path = sys.argv[1]
    print(f"the script Name is :  {script_name}")
    print(f"The file is : {input_file_path}")   

    with open(input_file_path, 'r') as file:
        # for line in file:
        #     print(line, end='')     
        first_name = file.readline()
        second_name = file.readline()
        age = int(file.readline())
        college = (file.readline()).split()

        print(f"the first name is {first_name} second name is {second_name}, age is {age} ")
        print(f"College is {college[0]} {college[1]} {college[2]}")
