package LeetcodeAndOffer.Leetcode;

public class LC547 {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;

        UnionFind unionFind = new UnionFind(n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    unionFind.union(i, j);
                }
            }
        }
        return unionFind.count;
    }

    class UnionFind {

        int[] roots;
        int count;

        UnionFind(int n) {
            roots = new int[n];
            for (int i = 0; i < n; i++) {
                roots[i] = i;
            }
            count = n;
        }

        private int find(int i) {
            if (roots[i] == i) return i;

            // 压缩树高度
            roots[i] = find(roots[i]);

            return roots[i];
        }

        private void union(int i, int j) {
            int pRoot = find(i);
            int qRoot = find(j);

            if (pRoot != qRoot) {
                roots[pRoot] = qRoot;
                count--;
            }
        }
    }

    public int findCircleNum_2(int[][] isConnected) {
        int length = isConnected.length;

        UnionFind_2 unionFind2 = new UnionFind_2(length);

        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected.length; j++) {

                if (isConnected[i][j] == 1) {
                    unionFind2.union(i, j);
                }
            }
        }
        return unionFind2.count;
    }

    class UnionFind_2 {

        int count;
        int[] array;

        UnionFind_2(int n) {
            count = n;
            array = new int[n];

            for (int i = 0; i < n; i++) {
                array[i] = i;
            }
        }

        void union(int p, int q) {
            int pIndex = find(p);
            int qIndex = find(q);

            if (pIndex != qIndex) {
                array[qIndex] = pIndex;
                count--;
            }
        }

        int find(int index) {

            if (array[index] == index) {
                return index;
            }

            return find(array[index]);
        }
    }
}
