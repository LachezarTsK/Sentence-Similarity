
import kotlin.collections.HashSet
import kotlin.collections.HashMap

class Solution {

    fun areSentencesSimilar(firstSentence: Array<String>, secondSentence: Array<String>, similarPairs: List<List<String>>): Boolean {
        if (firstSentence.size != secondSentence.size) {
            return false;
        }

        val mapSimilarPairs = HashMap<String, HashSet<String>>()
        for (i in similarPairs.indices) {
            mapSimilarPairs.putIfAbsent(similarPairs[i][0], HashSet<String>())
            mapSimilarPairs[similarPairs[i][0]]!!.add(similarPairs[i][1]);
        }

        for (i in firstSentence.indices) {
            if (firstSentence[i] == secondSentence[i]) {
                continue
            }
            if (mapSimilarPairs.containsKey(firstSentence[i])
                && mapSimilarPairs[firstSentence[i]]!!.contains(secondSentence[i])) {
                continue
            }
            if (mapSimilarPairs.containsKey(secondSentence[i])
                && mapSimilarPairs[secondSentence[i]]!!.contains(firstSentence[i])) {
                continue
            }
            return false
        }

        return true
    }
}
