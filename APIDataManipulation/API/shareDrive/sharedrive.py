import sys
import requests

def get_commission_month(driver_joining_date: str, trip_date: str)-> str:
    """ It get the commission month status as String. """

    joining_month: int = get_month(driver_joining_date)
    trip_month: int = get_month(trip_date)

    if(trip_month - joining_month == 0):
        return "joining_month"
    elif(trip_month - joining_month == 1):
        return "first_month"
    elif(trip_month - joining_month >= 2):
        return "next_months"
    
    
def get_month(date: str) -> int:
    """ It extracts the month from a date in string format DD/MM/YY. """

    month: int = int(date.split("/")[-2])
    return month

def get_commission(driver_joining_date: str, trip_date: str, fare:int) -> float:
    """ It gets comission on the fare of trip depending upon the month. """

    commission_month = get_commission_month(driver_joining_date, trip_date)
    if(commission_month == "joining_month"):
        return 0 
    elif(commission_month == "first_month"):
        return (fare * 0.1)
    elif(commission_month == "next_months"):
        return (fare * 0.2) 
    

def get_rides(rides: list, driver_id: int) -> list:
    """it is used to filer the rides of that particular driver """

    driver_rides = [ride for ride in rides if ride['driver_id'] == driver_id]
    return driver_rides
    

def get_payments(payments: list, driver_id: int) -> list:
    """It  filters the payments of that particular driver. """

    driver_payments = [payment for payment in payments if payment['driver_id'] == driver_id]
    return driver_payments


def calculate_balance(rides: list, payments: list, driver_id:int, driver_joining_date: str) -> float:
    """ It  calculates the balance that is payable to company if positive and if negative then the amount payable by driver. """

    driver_rides:list = get_rides(rides, driver_id)
    driver_payments:list = get_payments(payments, driver_id)

    total_paid_amount:float = 0
    total_payable_amount:float = 0

    for i in range(len(driver_payments)):
        total_paid_amount += float(driver_payments[i]['amount'])

    for i in range(len(driver_rides)):
        fare: int = int(driver_rides[i]['trip_details']['fare'])
        trip_date: str = str(driver_rides[i]['trip_date'])
        comission: float = get_commission(driver_joining_date, trip_date, fare)
        total_payable_amount += comission

    balance = total_paid_amount - total_payable_amount
    return balance    


if __name__ == '__main__':
    file_path = sys.argv[1]
    
    rides_api = "https://www.jsonkeeper.com/b/DM5F"
    payment_api = "https://www.jsonkeeper.com/b/9QRZ" 

    rides = requests.get( rides_api,verify= False).json()
    payments = requests.get(payment_api, verify=False).json()
    
    with open(file_path, 'r') as file:
        test_cases: int = int(file.readline().strip())
        for i in range(test_cases):
            driver_details: list = list(file.readline().strip().split(","))
            driver_id = int(driver_details[0])
            driver_joining_date = str(driver_details[1])

            balance = calculate_balance(rides, payments, driver_id, driver_joining_date)
            print(f"{balance:.1f}")
            



    