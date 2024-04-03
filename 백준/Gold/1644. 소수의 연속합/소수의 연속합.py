from collections import deque

# 소수 판별 함수
def is_prime(num):
    if num < 2:
        return False
    if num in (2, 3):
        return True
    if num % 2 == 0:
        return False
    for i in range(3, int(num**0.5) + 1, 2):
        if num % i == 0:
            return False
    return True

# 연속된 소수의 합으로 표현될 수 있는 방법의 수를 찾는 함수
def prime_sum_ways(N):
    # 소수 리스트 생성
    prime_list = [i for i in range(2, N+1) if is_prime(i)]

    count = 0  # 방법의 수
    left, right = 0, 0  # 투 포인터 초기화
    total = 0  # 현재 합계

    # 투 포인터 알고리즘 적용
    while True:
        if total >= N:
            total -= prime_list[left]
            left += 1
        else:
            if right == len(prime_list):
                break
            total += prime_list[right]
            right += 1
        
        if total == N:
            count += 1

    return count

# 주어진 수 N에 대해 연속된 소수의 합으로 나타낼 수 있는 경우의 수를 계산합니다.
N = int(input())
print(prime_sum_ways(N))