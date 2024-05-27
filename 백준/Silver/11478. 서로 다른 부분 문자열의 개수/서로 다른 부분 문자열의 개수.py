word = input()
length = 1
storage = set()
while length <= len(word):
    for i in range(len(word)-length+1):
        storage.add(word[i:i+length])
    length += 1
print(len(storage))