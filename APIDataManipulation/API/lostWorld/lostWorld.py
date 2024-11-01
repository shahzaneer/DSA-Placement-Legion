import sys
import requests


def timelines_group_by_masked_values(timelines: list, masks: list) -> dict:
    """
    Groups the timelines by mask values and returns a dictionary with the mask values
    as keys and lists of timelines as values.
    """
    grouped_timelines: dict = {}

    for i in range(len(timelines)):
        grouped_timelines.setdefault(masks[i], [])

    for i in range(len(timelines)):
        current_mask: str = masks[i]
        current_timeline: int = timelines[i]
        grouped_timelines[current_mask].append(current_timeline)

    return grouped_timelines


def perform_sub_operations_on_masked_labeled_data(grouped_timelines: dict, sub_operations: dict) -> dict:
    """
    Performs sub-operations on the grouped timelines based on the mask values.
    """
    data: dict = {'data': []}

    for key, value in grouped_timelines.items():
        if key not in sub_operations:
            data['data'].append(0)
            continue

        if sub_operations[key] == "BAR":
            result: int = min(value)
        elif sub_operations[key] == "FOX":
            result: int = max(value)
        elif sub_operations[key] == "FOO":
            result: int = sum(value)

        data['data'].append(result)

    return data


def final_operation(operation: str, data: list) -> int:
    """
    Performs the final operation (FOO, FOX, BAR) on the data.
    """
    if operation == "FOO":
        result: int = sum(data)
    elif operation == "FOX":
        result: int = max(data)
    elif operation == "BAR":
        result: int = min(data)

    return result


if __name__ == '__main__':
    input_file = sys.argv[1]

    with open(input_file, 'r') as file:
        trip_id = file.readline().strip()

    base_api = "https://jsonkeeper.com/"
    api_url = f"{base_api}{trip_id}"

    try:
        timelines_data = requests.get(api_url, verify=False).json()
        timelines = timelines_data['data']['timelines']
        masks = timelines_data['data']['masks']
        action_plan = timelines_data['data']['action_plan']
        action_plan_operation = action_plan['operation']
        action_plan_sub_operations = action_plan['sub_operations']

        grouped_timelines = timelines_group_by_masked_values(timelines, masks)
        data = perform_sub_operations_on_masked_labeled_data(grouped_timelines, action_plan_sub_operations)['data']
        result = final_operation(action_plan_operation, data)

        print(result)

    except requests.exceptions.RequestException as e:
        print(f'Something went wrong while fetching the file: {e}')
