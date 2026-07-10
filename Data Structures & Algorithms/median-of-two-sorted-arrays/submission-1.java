class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        int n = nums1.length;
        int m = nums2.length;
        int totalSize = n + m;
        int half = (totalSize + 1) / 2;

        int l = 0;
        int r = n;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            int fromOther = half - mid;

            int left1 = mid > 0 ? nums1[mid - 1] : Integer.MIN_VALUE;
            int right1 = mid < n ? nums1[mid] : Integer.MAX_VALUE;

            int left2 = fromOther > 0 ? nums2[fromOther - 1] : Integer.MIN_VALUE;
            int right2 = fromOther < m ? nums2[fromOther] : Integer.MAX_VALUE;

            if (left1 <= right2 && left2 <= right1) {
                if (totalSize % 2 != 0) {
                    return Math.max(left1, left2);
                }

                return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
            } else if (left1 > right2) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return -1;
    }
}