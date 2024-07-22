package Programmers;

import java.util.*;

class Pro_후보키 {
    private String[][] relationCopy;
    private List<Set<Integer>> candidateKeys = new ArrayList<>();

    public int solution(String[][] relation) {
        relationCopy = relation;
        int colSize = relation[0].length;

        // 1. 후보키 조합 찾기
        for (int i = 1; i <= colSize; i++) {
            combination(new HashSet<>(), 0, colSize, i);
        }

        return candidateKeys.size();
    }


    private void combination(Set<Integer> sel, int start, int n, int r) {
        if (r == 0) {
            if (checkIsCandidateKey(sel))
                candidateKeys.add(new HashSet<>(sel));

            return;
        }

        for (int i = start; i < n; i++) {
            sel.add(i);
            combination(sel, i + 1, n, r - 1);
            sel.remove(i);
        }
    }

    private boolean checkIsCandidateKey(Set<Integer> sel) {
        // 2. 유일성 확인
        Set<String> keys = new HashSet<>();

        for (int i = 0; i < relationCopy.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int attrIndex : sel) {
                sb.append(relationCopy[i][attrIndex]);
            }

            if (keys.contains(sb.toString()))
                return false;

            keys.add(sb.toString());
        }

        // 3. 최소성 확인
        for (Set<Integer> candidateKey : candidateKeys) {
            if (sel.containsAll(candidateKey)) {
                return false;
            }
        }

        return true;
    }
}
