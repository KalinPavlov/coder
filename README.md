#Coder PRO

## Lesson 1
Is valid binary tree?

Code:
```
class Node(object):
  def __init__(self, val, left=None, right=None):
    self.val = val
    self.left = left
    self.right = right

class Solution(object):
  def _isValidBSTHelper(self, n, low, high):
    if not n:
      return True
    val = n.val
    if ((val > low and val < high) and
        self._isValidBSTHelper(n.left, low, n.val) and
        self._isValidBSTHelper(n.right, n.val, high)):
        return True
    return False

  def isValidBST(self, n):
    return self._isValidBSTHelper(n, float('-inf'), float('inf'))
```

Examples:
```
#   5
#  / \
# 4   7
node = Node(5)
node.left = Node(4)
node.right = Node(7)
print(Solution().isValidBST(node))

#   5
#  / \
# 4   7
#    /
#   2
node = Node(5)
node.left = Node(4)
node.right = Node(7)
node.right.left = Node(2)
print(Solution().isValidBST(node))
# False
```

Solution:
```
Complexity:
Time: O(n)
Space: O(n)
```

## Lesson 2
Given array of characters and a word find if the word can be formed out of the letters in the array.
One letter from the array cannot be used twice.

Code:
```
from collections import defaultdict

class Solution(object):
  def canSpell(self, magazine, note):
    letters = defaultdict(int)
    for c in magazine:
      letters[c] += 1

    for c in note:
      if letters[c] <= 0:
        return False
      letters[c] -= 1

    return True

print(Solution().canSpell(['a', 'b', 'c', 'd', 'e', 'f'], 'bed'))
# True

print(Solution().canSpell(['a', 'b', 'c', 'd', 'e', 'f'], 'cat'))
# False
```

## Lesson 3
Add two numbers ad linked list

Code:
```
class Node(object):
  def __init__(self, x):
    self.val = x
    self.next = None


class Solution:
  def addTwoNumbers(self, l1, l2):
    return self.addTwoNumbersRecursive(l1, l2, 0)
    # return self.addTwoNumbersIterative(l1, l2)

  def addTwoNumbersRecursive(self, l1, l2, c):
    val = l1.val + l2.val + c
    c = val // 10
    ret = Node(val % 10)

    if l1.next != None or l2.next != None:
      if not l1.next:
        l1.next = Node(0)
      if not l2.next:
        l2.next = Node(0)
      ret.next = self.addTwoNumbersRecursive(l1.next, l2.next, c)
    elif c:
      ret.next = Node(c)
    return ret

  def addTwoNumbersIterative(self, l1, l2):
    a = l1
    b = l2
    c = 0
    ret = current = None

    while a or b:
      val = a.val + b.val + c
      c = val // 10
      if not current:
        ret = current = Node(val % 10)
      else:
        current.next = Node(val % 10)
        current = current.next

      if a.next or b.next:
        if not a.next:
          a.next = Node(0)
        if not b.next:
          b.next = Node(0)
      elif c:
        current.next = Node(c)
      a = a.next
      b = b.next
    return ret

l1 = Node(2)
l1.next = Node(4)
l1.next.next = Node(3)

l2 = Node(5)
l2.next = Node(6)
l2.next.next = Node(4)

answer = Solution().addTwoNumbers(l1, l2)
while answer:
  print(answer.val, end=' ')
  answer = answer.next
# 7 0 8
```

## Lesson 4
Two sum. Given an array of numbers and a target find the unique combinations of numbers from the
array which sum to the target and return their indeces.

Code:
```
class Solution(object):
  def twoSum(self, nums, target):
    for i1, a in enumerate(nums):
      for i2, b in enumerate(nums):
        if a == b:
          continue
        if a + b == target:
          return [i1, i2]
    return []

  def twoSumB(self, nums, target):
    values = {}
    for i, num in enumerate(nums):
      diff = target - num
      if diff in values:
        return [i, values[diff]]
      values[num] = i
    return []


print(Solution().twoSumB([2, 7, 11, 15], 18))
# [[1, 2]]
```

## Lesson 5
Find first and last indeces of an element in a sorted array.

Code:
```
class Solution:
  def getRange(self, arr, target):
    first = self.binarySearchIterative(arr, 0, len(arr) - 1, target, True)
    last = self.binarySearchIterative(arr, 0, len(arr) - 1, target, False)
    return [first, last]

  def binarySearch(self, arr, low, high, target, findFirst):
    if high < low:
      return -1
    mid = low + (high - low) // 2
    if findFirst:
      if (mid == 0 or target > arr[mid - 1]) and arr[mid] == target:
        return mid
      if target > arr[mid]:
        return self.binarySearch(arr, mid + 1, high, target, findFirst)
      else:
        return self.binarySearch(arr, low, mid - 1, target, findFirst)
    else:
      if (mid == len(arr)-1 or target < arr[mid + 1]) and arr[mid] == target:
        return mid
      elif target < arr[mid]:
        return self.binarySearch(arr, low, mid - 1, target, findFirst)
      else:
        return self.binarySearch(arr, mid + 1, high, target, findFirst)

  def binarySearchIterative(self, arr, low, high, target, findFirst):
    while True:
      if high < low:
        return -1
      mid = low + (high - low) // 2
      if findFirst:
        if (mid == 0 or target > arr[mid - 1]) and arr[mid] == target:
          return mid
        if target > arr[mid]:
          low = mid + 1
        else:
          high = mid - 1
      else:
        if (mid == len(arr)-1 or target < arr[mid + 1]) and arr[mid] == target:
          return mid
        elif target < arr[mid]:
          high = mid - 1
        else:
          low = mid + 1

arr = [1, 3, 3, 5, 7, 8, 9, 9, 9, 15]
x = 9
print(Solution().getRange(arr, 9))
# [6, 8]
```

## Lesson 6
Permutations. Given an array of random numbers find all possible 
permutations of these numbers.

Code:
```
class Solution(object):
  def _permuteHelper(self, nums, start=0):
    if start == len(nums) - 1:
      return [nums[:]]

    result = []
    for i in range(start, len(nums)):
      nums[start], nums[i] = nums[i], nums[start]
      result += self._permuteHelper(nums, start + 1)
      nums[start], nums[i] = nums[i], nums[start]
    return result

  def permute(self, nums):
    return self._permuteHelper(nums)

  def permute2(self, nums, values=[]):
    if not nums:
      return [values]
    result = []
    for i in range(len(nums)):
      result += self.permute2(nums[:i] + nums[i+1:], values + [nums[i]])
    return result

  def permute2Iterative(self, nums):
    results = []
    stack = [(nums, [])]
    while len(stack):
      nums, values = stack.pop()
      if not nums:
        results += [values]
      for i in range(len(nums)):
        stack.append((nums[:i]+nums[i+1:], values+[nums[i]]))
    return results


print(Solution().permute([1, 2, 3]))
# [[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 2, 1], [3, 1, 2]]

print(Solution().permute2([1, 2, 3]))
# [[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 2, 1], [3, 1, 2]]

print(Solution().permute2Iterative([1, 2, 3]))
# [[3, 2, 1], [3, 1, 2], [2, 3, 1], [2, 1, 3], [1, 3, 2], [1, 2, 3]]
```
