import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution1 implements Solution {
    @Override
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            List<List<Integer>> indices = subsetOfK(nums, i);
            if (i == 0) {
                result.addAll(indices);
            } else {
                for (List idx : indices) {
                    List<Integer> tmp = new ArrayList<>();
                    for (int j = 0; j < idx.size(); j++) {
                        tmp.add(nums[(int)idx.get(j)]);
                    }
                    if (!result.contains(tmp)) {
                        result.add(tmp);
                    }
                }
            }
        }
//        result.add(IntStream.of(nums).boxed().collect(Collectors.toList()));
        return result;
    }

    private List<List<Integer>> subsetOfK(int[] nums, int k) {
        if (k == 0) {
            return Arrays.asList(Collections.EMPTY_LIST);
        } else if (k == 1) {
            List<List<Integer>> result = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                if (i == 0 || nums[i] != nums[i - 1]) {
                    result.add(Arrays.asList(i));
                }
            }
            return result;
        } else {
            List<List<Integer>> result = new ArrayList<>();
            List<List<Integer>> prev = subsetOfK(nums, k-1);
            for (List list : prev) {
                for (int i = (int)list.get(list.size()-1)+1; i < nums.length; i++) {
                    if (i == (int)list.get(list.size()-1)+1 || nums[i] != nums[(int)list.get(list.size()-1)]) {
                        List<Integer> copy = new ArrayList<>(list);
                        copy.add(i);
                        result.add(copy);
                    }
                }
            }
            return result;
        }
    }
}
