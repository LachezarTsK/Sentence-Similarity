
using System;

public class Solution
{
    public bool AreSentencesSimilar(string[] firstSentence, string[] secondSentence, IList<IList<string>> similarPairs)
    {
        if (firstSentence.Length != secondSentence.Length)
        {
            return false;
        }

        var mapSimilarPairs = new Dictionary<string, HashSet<string>>();
        for (int i = 0; i < similarPairs.Count; ++i)
        {
            mapSimilarPairs.TryAdd(similarPairs[i][0], new HashSet<string>());
            mapSimilarPairs[similarPairs[i][0]].Add(similarPairs[i][1]);
        }

        for (int i = 0; i < firstSentence.Length; ++i)
        {
            if (firstSentence[i].Equals(secondSentence[i]))
            {
                continue;
            }
            if (mapSimilarPairs.ContainsKey(firstSentence[i])
                    && mapSimilarPairs[firstSentence[i]].Contains(secondSentence[i]))
            {
                continue;
            }
            if (mapSimilarPairs.ContainsKey(secondSentence[i])
                    && mapSimilarPairs[secondSentence[i]].Contains(firstSentence[i]))
            {
                continue;
            }
            return false;
        }

        return true;
    }
}
