""" 
Given an array of integers nums and an integer target, return 
indices of the two numbers such that they add up to target.
 
You may assume that each input would have exactly one solution,
and you may not use the same element twice.
 
You can return the answer in any order.

Follow-up: Can you come up with an algorithm that is less than O(n^2) time complexity?
"""

class TwoSum(object):
    
    #O(n^2) solution
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        indexes = [0, 0]
        isDone = False

        for i in range(0, len(nums)):
            for j in range(i, len(nums)):

                if i==j:
                    continue
                
                if nums[i] + nums[j] == target:
                    indexes[0] = i
                    indexes[1] = j
                    isDone = True
                    break
            
            if isDone:
                break
        return indexes