package sort._56MergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public static int[][] merge(int[][] intervals) {
        // sắp xếp mảng 2 chiều tăng dần với từng cặp phần tử trong mảng
        /*
            int[][] intervals` ban đầu là `[[2,3],[1,4],[8,10],[4,6]]
            sắp xếp thành:
            [[1,4],[2,3],[4,6],[8,10]]

        */
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> output = new ArrayList<>();
        for(int[] interval : intervals) {
            // kiểm tra xem List<int[]> output đã có thêm phần từ nào vào chưa
            // hoặc giá trị thứ 2 trong mảng 1 chiều nằm trong output có nhỏ hơn giá trị thứ nhất trong mảng 1 chiều interval[0] không.
            // nếu thỏa mãn thì add phần tử vào output
            if (output.isEmpty() || output.get(output.size() - 1)[1] < interval[0]) {
                output.add(interval);

                // ngược lại, output đã có phần tử đã được thêm, ta tiến hành so sánh phần tử cuối của mảng 1 trong output với phần tử cuối cùng của mảng 2 interval[1] mà ta đang duyệt qua.
                // để mục đich ta vẫn giữ nguyên mảng trong output và chỉ cần sửa giá trị là xong
            } else {
                output.get(output.size() - 1)[1] = Math.max(output.get(output.size() - 1)[1], interval[1]);
            }
        }

        // tạo ra mảng 2 chiều với số hàng = output.size() và số cột = 2
        int[][] ans = new int[output.size()][2];

        // duyệt từng mảng con của output và đẩy vào mảng 2 chiều vừa tạo
        for(int i = 0; i < output.size(); i++) {
            // đẩy giá trị mảng của output vào mảng ans mới tạo.
            ans[i] = output.get(i);
        }

        return ans;
    }
}

public class _56MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] ans = Solution.merge(intervals);

        System.out.print("[");
        for(int i = 0; i < ans.length; i++) {
            System.out.print("[");
            int check = 0;
            for(int j = 0; j < ans[i].length; j++) {
                if (check == 0) {
                    System.out.print(ans[i][j] + ", ");
                } else {
                    System.out.print(ans[i][j]);
                }
                check = 1;
            }
            if ((i + 1) == ans.length) {
                System.out.print("]");
            } else {
                System.out.print("], ");
            }
        }
        System.out.print("]");
    }
}