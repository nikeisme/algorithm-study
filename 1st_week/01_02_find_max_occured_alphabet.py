def find_max_occurred_alphabet(string):

    alphabet_occurrence_array = [0]*26

    for char in string:
        if not char.isalpha():   # 알파벳이 아니면
            continue
        arr_index = ord(char) - ord ('a') # 해당 문자열 -> 인덱스로 치환
        alphabet_occurrence_array[arr_index] += 1

    max_occurrence = 0
    max_alphabet_index=0

    for index in range(len(alphabet_occurrence_array)):
        alphabet_occurrence = alphabet_occurrence_array[index]

        if alphabet_occurrence > max_occurrence:
            max_occurrence = alphabet_occurrence
            max_alphabet_index = index

    print("max_alphabet_index is " , max_alphabet_index)

    return chr(max_alphabet_index + ord('a'))

