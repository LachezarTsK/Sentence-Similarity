
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {

    public boolean areSentencesSimilar(String[] firstSentence, String[] secondSentence, List<List<String>> similarPairs) {
        if (firstSentence.length != secondSentence.length) {
            return false;
        }

        Map<String, Set<String>> mapSimilarPairs = new HashMap<>();
        for (int i = 0; i < similarPairs.size(); ++i) {
            mapSimilarPairs.putIfAbsent(similarPairs.get(i).get(0), new HashSet<>());
            mapSimilarPairs.get(similarPairs.get(i).get(0)).add(similarPairs.get(i).get(1));
        }

        for (int i = 0; i < firstSentence.length; ++i) {
            if (firstSentence[i].equals(secondSentence[i])) {
                continue;
            }
            if (mapSimilarPairs.containsKey(firstSentence[i])
                    && mapSimilarPairs.get(firstSentence[i]).contains(secondSentence[i])) {
                continue;
            }
            if (mapSimilarPairs.containsKey(secondSentence[i])
                    && mapSimilarPairs.get(secondSentence[i]).contains(firstSentence[i])) {
                continue;
            }
            return false;
        }

        return true;
    }
}
