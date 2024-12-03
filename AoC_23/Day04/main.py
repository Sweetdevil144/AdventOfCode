import math


def process_data(file_path):
    with open(file_path, 'r') as file:
        lines = file.readlines()

    result = []
    for line in lines:
        parts = line.split('|')
        if len(parts) == 2:
            before_numbers = [int(n) for n in parts[0].split(':')[1].strip().split()]
            after_numbers = [int(n) for n in parts[1].strip().split()]

            # Append the before and after numbers separately to the result list
            result.append(before_numbers)
            result.append(after_numbers)

    return result


def getCommonPairs(list1, list2):
    c = 0
    for num in list1:
        if num in list2:
            if c == 0:
                c = 1
            else:
                c = c + 1
    return c


def main():
    # Path to the data file
    # file_path = 'data.txt'
    file_path = 'data.txt'

    # Process the data and get the result
    processed_data = process_data(file_path)
    total_sum_one = 0
    arr_len = len(processed_data) // 2
    arr = [1] * arr_len
    x = 0
    for i in range(0, len(processed_data) - 1, 2):
        list1 = processed_data[i]
        list2 = processed_data[i + 1]
        # PartOne
        total_pairs = getCommonPairs(list1, list2)
        # Part Two
        if total_pairs > 0:
            # alpha = max(i // 2 - 1, 0)
            for j in range(x + 1, x + 1 + total_pairs):
                if j < arr_len:
                    arr[j] = arr[j] + arr[x]
                else:
                    break
        total_sum_one += total_pairs
        print(f"Common pairs in Card deck {x+1} = {total_pairs}")
        x += 1

    # print(total_sum_one)
    # number of cards of each scratchcard
    print(arr)
    total_sum = sum(arr)
    print(total_sum)


if __name__ == "__main__":
    main()
