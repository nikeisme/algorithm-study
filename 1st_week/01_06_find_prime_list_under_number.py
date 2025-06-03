input = 20


def find_prime_list_under_number(number):
    prime_list = []

    for n in range(2, number + 1):  # 2~ number 까지 찿아서 이것들이 소수인가? 소수이면 prime_list 에 넣어라
        # 2~20까지 찿아서 이것들이 소수인가? 소수이면 prime_list 에 넣어라
        for i in prime_list: # 2~ n-1 까지를 i 에 들어가는 것을 반복해라
            if n % i == 0 and i * i <= n: # 소수가 아닐때의 조건 / N의 제곱근보다 크지 않은 어떤 소수로도 나누어 떨어지지 않는다.
                break
        else: # 아무일도 안일어나면 primelist 에 넣어라
            prime_list.append(n)

    return prime_list


result = find_prime_list_under_number(input)
print(result)