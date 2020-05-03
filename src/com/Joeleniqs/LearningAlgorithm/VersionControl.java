package com.Joeleniqs.LearningAlgorithm;

import java.util.HashMap;
import java.util.HashSet;

public class VersionControl {
    public int firstBadVersion(int n) {
        int middle;


        //split array into two , check value if bad
        middle = (n / 2);
        while (true) {
            boolean isBadMiddle = isBadVersion(middle),
                    isBadMiddleLess = isBadVersion(middle - 1);
            if (isBadMiddle && !isBadMiddleLess) {
                //check backwards
                return middle;
            }
            if (isBadMiddle && isBadMiddleLess) {
                n = middle;
                middle /= 2;
            }
            boolean isBadMiddlePlus = isBadVersion(middle + 1);
            if (isBadMiddlePlus && !isBadMiddle) {
                return middle + 1;
            }
            if (!isBadMiddle && !isBadMiddleLess) {
                middle = (n - middle) / 2 + middle;
            }

            if (middle < 1) {
                break;
            } else if (middle == n) {
                break;
            }
        }
        return middle;
    }

    public boolean isBadVersion(int y) {
        return (y == 2) ? true : false;
    }

    public int firstBadVersion2(int n) {
        return helper(1, n);
    }

    //use binary search
    private int helper(int up, int down) {
        int mid = up + (down - up) / 2;
        if (up >= down) {
            return up;
        }
        if (isBadVersion(mid)) {
            return helper(up, mid);
        } else {
            return helper(mid + 1, down);
        }
    }
}

