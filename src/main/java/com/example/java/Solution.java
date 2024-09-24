package com.example.java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> timesToDigit = new HashMap<>();
        for (int num : nums) {
            // key是digit  value是times
            timesToDigit.put(num, timesToDigit.getOrDefault(num, 0) + 1);
        }
        int max = timesToDigit.values().stream().max(Integer::compareTo).orElse(0);
        return timesToDigit.entrySet().stream()
                .filter(entry -> entry.getValue() == max)
                .map(Map.Entry::getKey)
                .toList()
                .get(0);
    }
}

class Solution3 {
    public int maxProfit(int[] prices) {
        int max = Arrays.stream(prices).max().orElse(0);
        int min = Arrays.stream(prices).min().orElse(0);
        return max - min;
    }
}

class Solution2 {
    public int removeDuplicates(int[] nums) {
        int[] distinctedNums = Arrays.stream(nums).distinct().toArray();
        for (int i = 0; i < distinctedNums.length; i++) {
            nums[i] = distinctedNums[i];
        }
        return distinctedNums.length;
    }
}

class Solution4 {
    public int maxProfit(int[] prices) {
        // 直接计算最大利润，而非存储下来
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            int price = prices[i];
            if (price < minPrice) minPrice = price;
            int profit = price - minPrice;
            if (maxProfit < profit) maxProfit = profit;
        }
        return maxProfit;
    }
}

class Solution5 {
    public boolean isPalindrome(String s) {
        // 1. remove non-alphanumeric character & to lowercase
        String newS = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        // 2. reverse the string
        String reversedS = new StringBuilder(newS).reverse().toString();
        return newS.equals(reversedS);
    }
}

class Solution6 {
    public boolean isSubsequence(String s, String t) {
        // ahcdb
        // abc
        int sLength = s.length();
        int j = 0;
        for (int i = 0; i < t.length(); i++) {
            if (j == sLength) return true;
            if (t.charAt(i) == s.charAt(j)) {
                j++;
            }
        }
        return j == sLength;
    }
}

class Solution7 {
    public int maxProfit(int[] prices) {
        //today:  7 9 5 3 6 4
        //the next day: 7 9 5 3 6 4
        int i = 0;
        int maxProfit = 0;
        for (int j = 1; j < prices.length; j++) {
            if (prices[j] > prices[i]) {
                i++;
                maxProfit += prices[j] - prices[i];
            }
        }
        return maxProfit;
    }
}

class Solution8 {
    public boolean canJump(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            for (int j = 0; j < nums[i]; j++) {
                i++;
            }
            if (nums[i] == 0 && i != nums.length - 1) return false;
            if (i == nums.length - 1) return true;
        }
        return true;
    }
}

class Solution9 {
    public boolean isValidSudoku(char[][] board) {
        // 先对行遍历，每行不存在重复
        // 再对列遍历，没列不存在重复
        // i = 0-2时遍历j=0-2 然后i+=2

        // HashMap<Integer,Integer> 对map遍历 其实和对数组遍历是一样的

        // 使用HashSet来表示重复,break短路。
        // 用位置+数字的方式，用字符串来表示行/列。

        HashSet<String> set = new HashSet<>();
        int length = 9;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (board[i][j] == '.') continue;
                char digit = board[i][j];

                // digit+i导致字符串拼接！ 51
                if (!set.add(digit + "in row" + i)) return false; // 每行有重复
                if (!set.add(j + "in column" + digit)) return false; // 每列有重复
                if (!set.add(j / 3 + "in column" + digit + "in row" + i / 3)) return false; //每个3*3有重复
            }
        }
        return true;
    }
}

// 这道题的精髓在于，不需要对两个字符串都做成HashMap，只需要对一个做HashMap，然后遍历另一个字符串，看是否存在即可。
class Solution10 {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) return false;
        HashMap<Character, Integer> dictionary = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            Character c = magazine.charAt(i);
            // grammar
            dictionary.put(c, dictionary.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            Character c = ransomNote.charAt(i);
            if (dictionary.get(c) == null) return false;
            dictionary.put(c, dictionary.get(c) - 1);
            if (dictionary.get(c) < 0) return false;
        }
        return true;
    }
}