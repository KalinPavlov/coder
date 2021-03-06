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

## Lesson 7
Sort an array of 3 unique numbers

Code:
```
def sortNums(nums):
  counts = {}
  for n in nums:
    counts[n] = counts.get(n, 0) + 1
  return ([1] * counts.get(1, 0) +
          [2] * counts.get(2, 0) +
          [3] * counts.get(3, 0))


def sortNums2(nums):
  one_index = 0
  three_index = len(nums) - 1
  index = 0
  while index <= three_index:
    if nums[index] == 1:
      nums[index], nums[one_index] = nums[one_index], nums[index]
      one_index += 1
      index += 1
    elif nums[index] == 2:
      index += 1
    elif nums[index] == 3:
      nums[index], nums[three_index] = nums[three_index], nums[index]
      three_index -= 1
  return nums


print(sortNums2([3, 3, 2, 1, 3, 2, 1]))
# [1, 1, 2, 2, 3, 3, 3]
```

## Lesson 8
Queue Reconstruction By Height

Code:
```
class Solution:
  def reconstructQueue(self, input):
    input.sort(key=lambda x:
               (-x[0], x[1])
               )
    res = []
    for person in input:
      res.insert(person[1], person)
    return res


input = [[7, 0], [4, 4], [7, 1], [5, 0], [6, 1], [5, 2]]
print(Solution().reconstructQueue(input))
# [[5,0], [7, 0], [5, 2], [6, 1], [4, 4], [7, 1]]
```

## Lesson 9
Find the non-duplicate number in an array. 
Only one number is not duplicated

Code:
```
class Solution(object):
  def singleNumber(self, nums):
    occurrence = {}

    for n in nums:
      occurrence[n] = occurrence.get(n, 0) + 1

    for key, value in occurrence.items():
      if value == 1:
        return key

  def singleNumber2(self, nums):
    unique = 0
    for n in nums:
      unique ^= n
    return unique

print(Solution().singleNumber2([4, 3, 2, 4, 1, 3, 2]))
# 1
```

## Lesson 10
Reverse A Linkedlist

Code:
```
class Node(object):
  def __init__(self, val, next=None):
    self.val = val
    self.next = next

  def __repr__(self):
    res = str(self.val)
    if self.next:
      res += str(self.next)
    return res

class Solution(object):
  def reverse(self, node):
    curr = node
    prev = None

    while curr != None:
      tmp = curr.next
      curr.next = prev
      prev = curr
      curr = tmp

    return prev

node = Node(1, Node(2, Node(3, Node(4, Node(5)))))

print(Solution().reverse(node))
# 54321
```

## Lesson 11
Course Schedule
Find if there is a cycle in the directed graph.

Code:
```
class Solution:

  def _hasCycle(self, graph, course, seen, cache):
    if course in cache:
      return cache[course]

    if course in seen:
      return True
    if course not in graph:
      return False

    seen.add(course)
    ret = False
    for neighbors in graph[course]:
      if self._hasCycle(graph, neighbors, seen, cache):
        ret = True
        break
    seen.remove(course)

    cache[course] = ret
    return ret

  def canFinish(self, numCourses, prerequisites):
    graph = {}
    for prereq in prerequisites:
      if prereq[0] in graph:
        graph[prereq[0]].append(prereq[1])
      else:
        graph[prereq[0]] = [prereq[1]]

    for course in range(numCourses):
      if self._hasCycle(graph, course, set(), {}):
        return False

    return True


print(Solution().canFinish(2, [[1, 0]]))
# True

print(Solution().canFinish(2, [[1, 0], [0, 1]]))
# False
```

## Lesson 12
Push Dominoes

Code:
```
class Solution(object):
  def pushDominoes(self, dominoes):
    forces = [0] * len(dominoes)
    max_force = len(dominoes)

    force = 0
    for i, d in enumerate(dominoes):
      if d == 'R':
        force = max_force
      if d == 'L':
        force = 0
      else:
        force = max(0, force - 1)
      forces[i] = force

    for i in range(len(dominoes) - 1, -1, -1):
      d = dominoes[i]
      if d == 'L':
        force = max_force
      if d == 'R':
        force = 0
      else:
        force = max(0, force - 1)
      forces[i] -= force

    result = ''
    for f in forces:
      if f == 0:
        result += '.'
      elif f > 0:
        result += 'R'
      else:
        result += 'L'
    return result

print(Solution().pushDominoes('..R...L..R.'))
# ..RR.LL..RR
```

## Lesson 13
Given a mathematical expression with just single digits, plus signs, negative signs, and brackets, evaluate the expression. Assume the expression is properly formed.

Example:
```
Input: - ( 3 + ( 2 - 1 ) )
Output: -4
```
Here's the function signature:
```
def eval(expression):
  # Fill this in.

print eval('- (3 + ( 2 - 1 ) )')
# -4
```

## Lesson 14
Word Search

Code:
```
class Grid(object):
  def __init__(self, matrix):
    self.matrix = matrix

  def __wordSearchRight(self, index, word):
    for i in range(len(self.matrix[index])):
      if word[i] != self.matrix[index][i]:
        return False
    return True

  def __wordSearchBottom(self, index, word):
    for i in range(len(self.matrix)):
      if word[i] != self.matrix[i][index]:
        return False
    return True

  def wordSearch(self, word):
    for i in range(len(self.matrix)):
      if self.__wordSearchRight(i, word):
        return True
    for i in range(len(self.matrix[0])):
      if self.__wordSearchBottom(i, word):
        return True
    return False

matrix = [
    ['F', 'A', 'C', 'I'],
    ['O', 'B', 'Q', 'P'],
    ['A', 'N', 'O', 'B'],
    ['M', 'A', 'S', 'S']]

print(Grid(matrix).wordSearch('FOAM'))
# True
```