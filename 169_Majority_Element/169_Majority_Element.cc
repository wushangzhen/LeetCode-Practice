unordered_map<int, int> un_map;
        for (int i = 0; i < nums.size(); i++) {
            un_map[nums[i]] += 1;
            if (un_map[nums[i]] > (nums.size() / 2)) {
                return nums[i];
            }
        }
        return 0;
    }
