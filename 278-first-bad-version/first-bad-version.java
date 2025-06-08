/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int low = 1; // since version starts from 1
        int high = n;
        
        while (low < high) {
            int mid = low + (high - low) / 2;

            if (isBadVersion(mid)) {
                // mid might be the first bad version
                high = mid;
            } else {
                // first bad version must be after mid
                low = mid + 1;
            }
        }

        // when low == high, we've found the first bad version
        return low;
    }
}
