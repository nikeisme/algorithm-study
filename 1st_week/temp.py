def find_max_num(array):
    max_num = array[0] # 연산 1번 실행
    for number in array:  # array의 길이 만큼 아래 연산이 실행
        if number > max_num: # 비교 연산 1번 실행
            max_num = number # 대입 연산 1번 실행

    return max_num


print("정답 = 6 / 현재 풀이 값 = ", find_max_num([3, 5, 6, 1, 2, 4]))
print("정답 = 6 / 현재 풀이 값 = ", find_max_num([6, 6, 6]))
print("정답 = 1888 / 현재 풀이 값 = ", find_max_num([6, 9, 2, 7, 1888]))