
#include <string>
#include <unordered_map>
#include <unordered_set>
#include <vector>
using namespace std;

class Solution {

public:
    bool areSentencesSimilar(const vector<string>& firstSentence,
                             const vector<string>& secondSentence,
                             const vector<vector<string>>& similarPairs) const {

        if (firstSentence.size() != secondSentence.size()) {
            return false;
        }

        unordered_map<string, unordered_set<string>> mapSimilarPairs;
        for (size_t i = 0; i < similarPairs.size(); ++i) {
            mapSimilarPairs[similarPairs[i][0]].insert(similarPairs[i][1]);
        }

        for (size_t i = 0; i < firstSentence.size(); ++i) {
            if (firstSentence[i] == secondSentence[i]) {
                continue;
            }
            if (mapSimilarPairs.contains(firstSentence[i]) &&
                mapSimilarPairs[firstSentence[i]].contains(secondSentence[i])) {
                continue;
            }
            if (mapSimilarPairs.contains(secondSentence[i]) &&
                mapSimilarPairs[secondSentence[i]].contains(firstSentence[i])) {
                continue;
            }
            return false;
        }

        return true;
    }
};
